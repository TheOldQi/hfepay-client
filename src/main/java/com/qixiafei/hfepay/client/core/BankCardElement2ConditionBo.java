package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 银行卡2要素验证 condition bo. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 12:00</P>
 * <P>UPDATE AT: 2019/1/9 12:00</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class BankCardElement2ConditionBo implements ConditionsConditionType {

    /**
     * 姓名.
     */
    private String realName;

    /**
     * 银行卡号.
     */
    private String bankCard;
}
