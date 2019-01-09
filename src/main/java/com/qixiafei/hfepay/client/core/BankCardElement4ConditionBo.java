package com.qixiafei.hfepay.client.core;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <P>Description: 银行卡4要素验证 condition bo. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 12:00</P>
 * <P>UPDATE AT: 2019/1/9 12:00</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
class BankCardElement4ConditionBo extends BankCardElement3ConditionBo {

    /**
     * 手机号.
     */
    private String mobile;
}
