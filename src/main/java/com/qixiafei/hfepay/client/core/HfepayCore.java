package com.qixiafei.hfepay.client.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.qixiafei.hfepay.client.params.*;
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


    /**
     * 进行人证合一验证.
     *
     * @param conditionBo      请求条件bo
     * @param hfepayProperties 配置属性
     * @param vector           加密解密偏移量
     * @param header           请求的header信息
     * @return 外部响应结果实例
     * @throws Exception 各种异常
     */
    static HfepayIdPersonAuthResult idPersonAuth(final BaseConditionBo conditionBo, final HfepayProperties hfepayProperties,
                                                 final String vector, @Valid @NotNull HfepayHeader header) throws Exception {

        if (StringUtils.isBlank(hfepayProperties.getIdPersonAppKey())) {
            log.error("使用人证合一功能，必须配置hfepay.idPersonAppKey属性");
        }
        final HfepayIdPersonAuthResult result = new HfepayIdPersonAuthResult();
        result.setHeader(header);
        final IdPersonRecord record = setCodeAndGetRecord(result, conditionBo, hfepayProperties, vector,
                hfepayProperties.getIdPersonAppKey(), hfepayProperties.getIdPersonUrl());
        if (record == null) {
            result.setResult(false);
            return result;
        }

        result.setScore(StringUtils.isBlank(record.getScore()) ? null : Double.parseDouble(record.getScore()));
        if (HfepayIdPersonAuthRespCodeEnum.PASS.getCode().equals(record.getResCode())) {
            log.info("人脸比对通过");
            result.setResult(true);
        } else {
            log.info("比对未通过");
            result.setResult(false);
        }
        return result;
    }

    /**
     * 身份证ocr.
     *
     * @param conditionBo      请求条件bo
     * @param hfepayProperties 配置属性
     * @param vector           加密解密偏移量
     * @param header           请求的header信息
     * @return 外部响应结果实例
     * @throws Exception 各种异常
     */
    static HfepayIdOcrResult idOcr(final BaseConditionBo conditionBo, final HfepayProperties hfepayProperties,
                                   final String vector, @Valid @NotNull HfepayHeader header) throws Exception {
        if (StringUtils.isBlank(hfepayProperties.getIdOcrAppKey())) {
            log.error("使用身份证ocr功能，必须配置hfepay.idOcrAppKey属性");
        }
        final HfepayIdOcrResult result = new HfepayIdOcrResult();

        result.setHeader(header);
        final IdOcrRecord record = setCodeAndGetRecord(result, conditionBo, hfepayProperties, vector,
                hfepayProperties.getIdOcrAppKey(), hfepayProperties.getIdOcrUrl());
        if (record == null) {
            return result;
        }


        if (HfepayIdPersonAuthRespCodeEnum.PASS.getCode().equals(record.getResCode())) {
            log.info("身份证ocr成功");
            setIdOcrResult(result, record);
        } else {
            log.error("身份证ocr失败");
        }
        return result;
    }


    /**
     * 银行卡ocr.
     *
     * @param conditionBo      请求条件bo
     * @param hfepayProperties 配置属性
     * @param vector           加密解密偏移量
     * @param header           请求的header信息
     * @return 外部响应结果实例
     * @throws Exception 各种异常
     */
    static HfepayBankCardOcrResult bankCardOcr(final BaseConditionBo conditionBo, final HfepayProperties hfepayProperties,
                                               final String vector, @Valid @NotNull HfepayHeader header) throws Exception {
        if (StringUtils.isBlank(hfepayProperties.getBankCardOcrAppKey())) {
            log.error("使用银行卡ocr功能，必须配置hfepay.bankCardOcrAppKey");
        }
        final HfepayBankCardOcrResult result = new HfepayBankCardOcrResult();

        result.setHeader(header);
        final BankCardOcrRecord record = setCodeAndGetRecord(result, conditionBo, hfepayProperties, vector,
                hfepayProperties.getIdOcrAppKey(), hfepayProperties.getIdOcrUrl());
        if (record == null) {
            return result;
        }

        if (HfepayIdPersonAuthRespCodeEnum.PASS.getCode().equals(record.getResCode())) {
            log.info("银行卡ocr成功");
            result.setBankCardNo(record.getBankCardNo());
        } else {
            log.error("银行卡ocr失败");
        }
        return result;
    }


    /**
     * 设置身份证ocr结果业务字段.
     *
     * @param result 外部调用结果对象
     * @param record 华付接口响应业务数据
     */
    private static void setIdOcrResult(final HfepayIdOcrResult result, final IdOcrRecord record) {

        result.setName(record.getName());
        result.setSex(record.getSex());
        result.setNation(record.getNation());
        result.setBirth(record.getBirth());
        result.setAddress(record.getAddress());
        result.setIdCard(record.getIdCard());
        result.setAuthority(record.getAuthority());
        result.setValidDate(record.getValidDate());

    }


    /**
     * 设置外部响应对象的code和codeDesc字段并返回华付接口业务数据（若调用成功），如果接口调用失败（不是异常），返回null.
     *
     * @param result           外部响应结果实例
     * @param conditionBo      查询条件bo
     * @param hfepayProperties 配置属性
     * @param vector           加密偏移量
     * @param appKey           接口appKey
     * @param url              接口url
     * @param <R>              华付接口响应业务数据类型
     * @param <P>              外部响应对象类型
     * @return 华付接口响应业务数据类型
     * @throws Exception 各种可能的异常
     */
    private static <R extends Record, P extends HfepayBaseResult> R
    setCodeAndGetRecord(final P result, final BaseConditionBo conditionBo, final HfepayProperties hfepayProperties,
                        final String vector, final String appKey, final String url) throws Exception {
        final BaseReqBo reqBo = new BaseReqBo();
        final String conditionPlain = JSON.toJSONString(conditionBo);
        log.info("condition加密前={}", conditionPlain);
        final String conditionEncrypt = Chiper3Des.encrypt(conditionPlain, appKey, vector);
        log.info("condition加密后={}", conditionEncrypt);
        String sign = RsaSignCoder.sign(conditionEncrypt, hfepayProperties.getPriKey());
        reqBo.setCondition(conditionEncrypt);
        reqBo.setVector(vector);
        reqBo.setSignature(sign);
        reqBo.setUserCode(hfepayProperties.getUserCode());
        log.info("请求华付参数={}", reqBo);
        String s = PostUtil.postForm(url, BeanUtils.beanToMap(reqBo));
        log.info("华付返回原文={}", s);

        final BaseRespBo respBo = JSON.parseObject(s, BaseRespBo.class);

        if (StringUtils.isNotBlank(respBo.getContents())) {

            if (!RsaSignCoder.verify(respBo.getContents(), hfepayProperties.getHfPubKey(), respBo.getSignature())) {
                log.error("华付响应验签未通过");
                throw new RuntimeException();
            }

            final String resultPlain = Chiper3Des.decrypt(respBo.getContents(), appKey, vector);
            log.info("contents部分解密后={}", resultPlain);
            final BaseContentsBo<ContentsDataBo<R>> contentsBo = JSON.parseObject(resultPlain, new TypeReference<BaseContentsBo<ContentsDataBo<R>>>() {
            }.getType());


            if (contentsBo.getData() != null) {
                log.info("华付人脸比对接口调用成功");
                final List<ContentsDataBo<R>> datas = contentsBo.getData();
                ContentsDataBo<R> rContentsDataBo = datas.get(0);
                final List<R> records = rContentsDataBo.getRecord();
                final R record = records.get(0);
                result.setCode(record.getResCode());
                result.setCodeDesc(record.getResDesc());
                return record;

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
            result.setCode(msg.getCode());
            result.setCodeDesc(msg.getCodeDesc());
            return null;
        }

    }
}
