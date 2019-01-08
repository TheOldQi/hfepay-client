package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <P>Description: 华付人证比对请求对象. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/3 17:26</P>
 * <P>UPDATE AT: 2019/1/3 17:26</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(exclude = "img", callSuper = true)
public class HfepayIdPersonAuthParam extends HfepayBaseParam {

    /**
     * 姓名.
     */
    @NotBlank
    @Length(max = 20)
    private String realName;

    /**
     * 身份证号.
     */
    @NotBlank
    private String idCard;

    /**
     * 图片字节数组.
     */
    @NotNull
    private byte[] img;
}
