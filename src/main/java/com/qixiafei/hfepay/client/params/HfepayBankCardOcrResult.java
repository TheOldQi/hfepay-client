package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <P>Description: 华付银行卡ocr结果. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 22:15</P>
 * <P>UPDATE AT: 2019/1/8 22:15</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class HfepayBankCardOcrResult extends HfepayBaseResult {

    /**
     * 银行卡号.
     */
    private String bankCardNo;
}
