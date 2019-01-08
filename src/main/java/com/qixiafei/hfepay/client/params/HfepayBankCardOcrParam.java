package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * <P>Description: 华付银行卡ocr请求参数. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 22:14</P>
 * <P>UPDATE AT: 2019/1/8 22:14</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true, exclude = "photo")
public class HfepayBankCardOcrParam extends HfepayBaseParam {

    /**
     * 银行卡正面图片字节数组.
     */
    @NotNull
    private byte[] photo;
}
