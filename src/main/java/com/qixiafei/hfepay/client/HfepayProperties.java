package com.qixiafei.hfepay.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
@Data
@ConfigurationProperties(prefix = "hfepay")
public class HfepayProperties {
    /**
     * 身份证号和人脸匹配接口url
     */
    private String idPersonUrl = "https://api.hfdatas.com/superapi/super/hdphoto/auth";

    /**
     * 身份证号和人脸匹配接口密钥.
     */
    private String idPersonAppKey;

    /**
     * 身份证ocr接口url.
     */
    private String idOcrUrl = "https://api.hfdatas.com/superapi/super/ocr/idcard";

    /**
     * 身份证ocr接口密钥.
     */
    private String idOcrAppKey;

    /**
     * 身份证号和姓名匹配接口.
     */
    private String idNameUrl = "https://api.hfdatas.com/superapi/super/auth/idcard";

    /**
     * 身份证号和姓名匹配接口密钥.
     */
    private String idNameAppKey;

    /**
     * 银行卡orc接口.
     */
    private String bankCardOrcUrl = "https://api.hfdatas.com/superapi/super/ocr/bankcard";

    /**
     * 银行卡ocr接口密钥.
     */
    private String bankCardOcrAppKey;

    /**
     * 银行卡二要素认证，卡号和姓名匹配接口.
     */
    private String bankCardElementTwo = "https://api.hfdatas.com/superapi/super/auth/smrz2";

    /**
     * 银行卡二要素认证，卡号和姓名匹配接口密钥.
     */
    private String bankCardElementTwoAppKey;

    /**
     * 银行卡三要素认证，姓名、身份证号、卡号.
     */
    private String bankCardElementThree = "https://api.hfdatas.com/superapi/super/auth/smrz3";

    /**
     * 银行卡三要素认证，姓名、身份证号、卡号.
     */
    private String bankCardElementThreeAppKey;

    /**
     * 银行卡四要素认证，姓名、身份证号、手机号、卡号.
     */
    private String bankCardElementFour = "https://api.hfdatas.com/superapi/super/auth/smrz4";

    /**
     * 银行卡四要素认证，姓名、身份证号、手机号、卡号.
     */
    private String bankCardElementFourAppKey;

    /**
     * 商户编号.
     */
    private String userCode;

    /**
     * 应用编号.
     */
    private String sysCode;

    /**
     * 私钥.
     */
    private String priKey;

    /**
     * 公钥.
     */
    private String pubKey;

    /**
     * 华付公钥.
     */
    private String hfPubKey;
}
