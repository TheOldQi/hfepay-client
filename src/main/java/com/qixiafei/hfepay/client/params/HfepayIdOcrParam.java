package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * <P>Description: 华付身份证ocr请求对象. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 21:06</P>
 * <P>UPDATE AT: 2019/1/8 21:06</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true, exclude = "photo")
public class HfepayIdOcrParam extends HfepayBaseParam {

    /**
     * 身份证国徽面或人像面照片字节数组.
     */
    @NotNull
    private byte[] photo;

}
