package com.qixiafei.hfepay.client.core;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <P>Description: 身份证ocr华付接口响应业务数据. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 21:39</P>
 * <P>UPDATE AT: 2019/1/8 21:39</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
class IdOcrRecord extends Record {

    /**
     * 姓名.
     */
    private String name;

    /**
     * 性别（男/女）.
     */
    private String sex;

    /**
     * 民族（汉字）.
     */
    private String nation;

    /**
     * 生日，格式为YYYY-MM-DD.
     */
    private String birth;

    /**
     * 住址.
     */
    private String address;

    /**
     * 身份证号.
     */
    private String idCard;

    /**
     * 所属公安局.
     */
    private String authority;

    /**
     * 有效日期，返回值有两种格式：
     * 一个16 位长度的字符串：
     * YYYY.MM.DD-YYYY.MM.DD
     * 或是：YYYY.MM.DD-长期.
     */
    private String validDate;
}
