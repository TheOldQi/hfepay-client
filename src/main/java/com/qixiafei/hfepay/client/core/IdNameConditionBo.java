package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 姓名、身份证号匹配验证华付请求condition bo. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 11:41</P>
 * <P>UPDATE AT: 2019/1/9 11:41</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class IdNameConditionBo implements ConditionsConditionType {

    /**
     * 姓名.
     */
    private String realName;

    /**
     * 身份证号.
     */
    private String idCard;
}
