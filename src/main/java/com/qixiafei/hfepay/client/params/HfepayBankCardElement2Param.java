package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * <P>Description: 华付银行卡2要素验证请求参数. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 11:55</P>
 * <P>UPDATE AT: 2019/1/9 11:55</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class HfepayBankCardElement2Param extends HfepayBaseParam {

    /**
     * 姓名.
     */
    @NotBlank
    private String realName;

    /**
     * 银行卡号.
     */
    @NotBlank
    private String bankCard;
}
