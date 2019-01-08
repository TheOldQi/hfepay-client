package com.qixiafei.hfepay.client.params.enums;

import lombok.Getter;

/**
 * <P>Description: 华付人证比对接口响应状态码枚举. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 14:40</P>
 * <P>UPDATE AT: 2019/1/4 14:40</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Getter
public enum HfepayIdPersonAuthRespCodeEnum {
    // ========================== 接口调用正常响应 ============== //
    PASS("00", "认证通过（score 值45 分及以上为同一人）"),
    NOT_PASS("98", "认证未通过（姓名与身份证号实名认证不匹配）"),
    NAME_FORMAT_ERROR("01", "姓名格式错误"),
    ID_NO_ERROR("02", "身份证号码有误"),
    IMG_TOO_BIG("03", "照片大小不合适（原图大小0~30kb）"),
    NO_DATA("04", "认证信息不存在"),
    IMG_NOT_MATE("05", "照片对比不一致（score 值低于45 分为不同人）"),
    ID_CARD_IMG_NOT_EXIST("06", "证件照不存在(认证信息通过照片比对不一致)"),
    IMG_QUALITY_ERROR("07", "照片质量校验不合格"),
    MORE_THAN_ONE_FACE("08", "多于一张人脸"),
    FEATURE_ERROR("13", "特征提取失败"),
    ANALYSIS_ERROR("14", "图片解析失败"),


    // ======================  接口调用失败响应 ===============================//
    PARAMETER_ILLEGAL("10", "请求条件有缺失，请确认是否遗漏~！"),
    EXPERIENCE_OVERTIMES("20", "您的体验次数已使用完，请完成正式签约~！"),
    OFFICIAL_OVERTIMES("30", "您的签约次数已使用完，请续约购买次数~！"),
    CHANNEL_NOT_BOUNDED("40", "您的应用未绑定该数据通道，请确认应用编号是否正确或完成绑定~！"),
    CHANNEL_CLOSED("44", "渠道已关闭"),
    VERIFY_FAILED("55", "验签失败"),
    CHANNEL_NOT_OPENED("66", "未开通该数据渠道"),
    CHANNEL_DISABLED("77", "数据渠道已被禁用，暂无限权"),
    RSA_NOT_UPLOAD("88", "未上传签名或加解密公钥，请上传相关公钥"),
    FAILED("99", "交易失败（公安返回超时或其他异常导致）");

    private final String code;
    private final String desc;


    HfepayIdPersonAuthRespCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
