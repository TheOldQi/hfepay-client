package com.qixiafei.hfepay.client.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.qixiafei.hfepay.client.params.HfepayHeader;
import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthResp;
import com.qixiafei.hfepay.client.params.enums.HfepayIdPersonAuthRespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <P>Description: 华付核心功能代码. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 17:42</P>
 * <P>UPDATE AT: 2019/1/4 17:42</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Slf4j
class HfepayCore {


    static HfepayIdPersonAuthResp idPersonAuth(final BaseConditionBo conditionBo, final HfepayProperties hfepayProperties,
                                               final String vector, @Valid @NotNull HfepayHeader header) throws Exception {

        if (StringUtils.isBlank(hfepayProperties.getIdPersonAppKey())) {
            log.error("使用认证合一功能，必须配置hfepay.idPersonAppKey属性");
        }
        final BaseReqBo reqBo = new BaseReqBo();
        final String conditionPlain = JSON.toJSONString(conditionBo);
        log.info("condition加密前={}", conditionPlain);
        final String conditionEncrypt = Chiper3Des.encrypt(conditionPlain, hfepayProperties.getIdPersonAppKey(), vector);
        log.info("condition加密后={}", conditionEncrypt);
        String sign = RsaSignCoder.sign(conditionEncrypt, hfepayProperties.getPriKey());
        reqBo.setCondition(conditionEncrypt);
        reqBo.setVector(vector);
        reqBo.setSignature(sign);
        reqBo.setUserCode(hfepayProperties.getUserCode());
        log.info("请求华付参数={}", reqBo);
        String s = PostUtil.postForm(hfepayProperties.getIdPersonUrl(), BeanUtils.beanToMap(reqBo));
        log.info("华付返回原文={}", s);

        final BaseRespBo respBo = JSON.parseObject(s, BaseRespBo.class);
        final HfepayIdPersonAuthResp result = new HfepayIdPersonAuthResp();
        result.setHeader(header);
        if (StringUtils.isNotBlank(respBo.getContents())) {

            if (!RsaSignCoder.verify(respBo.getContents(), hfepayProperties.getHfPubKey(), respBo.getSignature())) {
                log.error("华付响应验签未通过");
                throw new RuntimeException();
            }

            final String resultPlain = Chiper3Des.decrypt(respBo.getContents(), hfepayProperties.getIdPersonAppKey(), vector);
            log.info("contents部分解密后={}", resultPlain);
            final BaseContentsBo<IdPersonAuthConditionDataBo> contentsBo = JSON.parseObject(resultPlain, new TypeReference<BaseContentsBo<IdPersonAuthConditionDataBo>>() {
            }.getType());


            if (contentsBo.getData() != null) {
                log.info("华付人脸比对接口调用成功");
                final List<IdPersonAuthConditionDataBo> datas = contentsBo.getData();
                final IdPersonAuthConditionDataBo idPersonAuthConditionDataBo = datas.get(0);
                final List<IdPersonAuthConditionDataBo.Record> records = idPersonAuthConditionDataBo.getRecord();
                final IdPersonAuthConditionDataBo.Record record = records.get(0);

                result.setCode(record.getResCode());
                result.setCodeDesc(record.getResDesc());
                result.setScore(StringUtils.isBlank(record.getScore()) ? null : Double.parseDouble(record.getScore()));
                if (HfepayIdPersonAuthRespCodeEnum.PASS.getCode().equals(record.getResCode())) {
                    log.info("人脸比对通过");
                    result.setResult(true);
                } else {
                    log.info("比对未通过");
                    result.setResult(false);
                }

            } else {
                log.error("华付响应数据结构错误");
                throw new RuntimeException();
            }

        } else {
            MsgBo msg = respBo.getMsg();
            if (msg == null) {
                log.error("华付响应数据结构错误");
                throw new RuntimeException();
            }
            result.setHeader(header);
            result.setResult(false);
            result.setCode(msg.getCode());
            result.setCodeDesc(msg.getCodeDesc());
        }


        return result;
    }
}
