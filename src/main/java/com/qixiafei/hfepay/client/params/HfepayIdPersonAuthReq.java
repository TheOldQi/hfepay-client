package com.qixiafei.hfepay.client.params;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
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
@Data
@ToString(exclude = "img")
public class HfepayIdPersonAuthReq {

    /**
     * 请求头信息.
     */
    @Valid
    @NotNull
    private HfepayHeader header;

    /**
     * 加密算法偏移量，8位随机数或字母.
     */
    @NotNull
    @Length(min = 8, max = 8)
    private String vector;

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
