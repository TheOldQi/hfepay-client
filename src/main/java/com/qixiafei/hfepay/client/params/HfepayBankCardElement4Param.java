package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * <P>Description: 华付银行卡4要素验证请求参数. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 11:58</P>
 * <P>UPDATE AT: 2019/1/9 11:58</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class HfepayBankCardElement4Param extends HfepayBankCardElement3Param {

    /**
     * 手机号码.
     */
    @NotBlank
    private String mobile;
}
