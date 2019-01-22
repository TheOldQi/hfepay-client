package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.HfepayProperties;
import com.qixiafei.hfepay.client.params.*;
import lombok.extern.slf4j.Slf4j;

/**
 * <P>Description: 华付客户端工具类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/3 16:19</P>
 * <P>UPDATE AT: 2019/1/3 16:19</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Slf4j
public final class HfepayClient {

    private HfepayProperties properties;


    public HfepayClient(final HfepayProperties properties) {
        this.properties = properties;
    }

    /**
     * 人证合一验证.
     */
    public HfepayIdPersonAuthResult idPersonAuth(final HfepayIdPersonAuthParam param) throws Exception {
        log.info("华付人证合一验证,param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.idPersonAuth(buildConditionBo(param), properties, param.getHeader());
    }

    /**
     * 身份证ocr.
     *
     * @param param 外部请求参数
     * @return ocr结果
     */
    public HfepayIdOcrResult idOcr(final HfepayIdOcrParam param) throws Exception {
        log.info("华付身份证ocr，param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.idOcr(buildConditionBo(param), properties, param.getHeader());
    }

    /**
     * 银行卡ocr.
     *
     * @param param 外部请求参数
     * @return ocr结果
     */
    public HfepayBankCardOcrResult bankCardOcr(final HfepayBankCardOcrParam param) throws Exception {
        log.info("华付银行卡ocr，param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.bankCardOcr(buildConditionBo(param), properties, param.getHeader());
    }

    /**
     * 姓名、身份证号匹配验证.
     *
     * @param param 外部请求参数
     * @return 根据code判断是否验证通过
     */
    public HfepayBaseResult idNameAuth(final HfepayIdNameAuthParam param) throws Exception {
        log.info("华付身份证号、姓名匹配验证，param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.idNameAuth(buildConditionBo(param), properties, param.getHeader());
    }

    /**
     * 银行卡2要素验证.
     *
     * @param param 外部请求参数
     * @return 根据code判断是否验证通过
     */
    public HfepayBaseResult bankCardElement2(final HfepayBankCardElement2Param param) throws Exception {
        log.info("华付银行卡2要素验证,param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.bankCardElement2(buildConditionBo(param), properties,  param.getHeader());
    }

    /**
     * 银行卡3要素验证.
     *
     * @param param 外部请求参数
     * @return 根据code判断是否验证通过
     */
    public HfepayBaseResult bankCardElement3(final HfepayBankCardElement2Param param) throws Exception {
        log.info("华付银行卡3要素验证,param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.bankCardElement3(buildConditionBo(param), properties, param.getHeader());
    }

    /**
     * 银行卡4要素验证.
     *
     * @param param 外部请求参数
     * @return 根据code判断是否验证通过
     */
    public HfepayBaseResult bankCardElement4(final HfepayBankCardElement2Param param) throws Exception {
        log.info("华付银行卡4要素验证,param={}", param);
        ValidateUtils.validate(param);
        return HfepayCore.bankCardElement4(buildConditionBo(param), properties, param.getHeader());
    }

    /**
     * 构建请求华付condition bo.
     *
     * @param param 外部请求参数
     * @param <T>   外部请求参数类型
     * @return 请求华付condition bo
     * @throws Exception 各种异常
     */
    private <T extends HfepayBaseParam> BaseConditionBo buildConditionBo(T param) throws Exception {
        // 组装实际请求header信息
        final HeaderBo headerBo = Converter.buildHeaderBo(param.getHeader(), properties.getUserCode(), properties.getSysCode());
        // 组装实际请求数据部分condition信息
        final ConditionsConditionType conditionBo = ConditionBuilderFactory.getBuilder(param).build(param);
        // 组装实际请求顶级部分condition信息
        final BaseConditionBo baseConditionBo = new BaseConditionBo();
        baseConditionBo.setHeader(headerBo);
        baseConditionBo.setCondition(conditionBo);
        return baseConditionBo;
    }

}
