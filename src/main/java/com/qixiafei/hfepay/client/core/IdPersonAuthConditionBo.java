package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 人证比对请求condition bo. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 17:36</P>
 * <P>UPDATE AT: 2019/1/4 17:36</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class IdPersonAuthConditionBo implements ConditionsConditionType {

    /**
     * 真实姓名.
     */
    private String realName;

    /**
     * 身份证号码.
     */
    private String idCard;

    /**
     * 生活照base64字符串.
     */
    private String photo;

}
