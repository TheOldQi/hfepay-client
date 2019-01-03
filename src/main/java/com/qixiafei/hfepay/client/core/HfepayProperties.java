package com.qixiafei.hfepay.client.core;

/**
 * <P>Description: 属性配置类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/3 16:22</P>
 * <P>UPDATE AT: 2019/1/3 16:22</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class HfepayProperties {

    // 身份证号和人脸匹配接口url
    static final String ID_PERSON_COMPARE_URL = "https://api.hfdatas.com/superapi/super/hdphoto/authv2";
    // 身份证ocr接口url
    static final String ID_OCR_URL = "https://api.hfdatas.com/superapi/super/ocr/idcard";
    // 身份证号和姓名匹配接口
    static final String ID_NO_NAME_MATE_URL = "https://api.hfdatas.com/superapi/super/auth/idcard";
    // 银行卡orc接口
    static final String BANK_CARD_ORC_URL = "https://api.hfdatas.com/superapi/super/ocr/bankcard";
    // 银行卡二要素认证，卡号和姓名匹配接口
    static final String BANK_CARD_ELEMENT2 = "https://api.hfdatas.com/superapi/super/auth/smrz2";
    // 银行卡三要素认证，姓名、身份证号、卡号
    static final String BANK_CARD_ELEMENT3 = "https://api.hfdatas.com/superapi/super/auth/smrz3";
    // 银行卡四要素认证，姓名、身份证号、手机号、卡号
    static final String BANK_CARD_ELEMENT4 = "https://api.hfdatas.com/superapi/super/auth/smrz4";

}
