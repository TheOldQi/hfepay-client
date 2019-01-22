package com.qixiafei.hfepay.client.core;

import lombok.Data;

import java.util.List;

/**
 * <P>Description: 响应contents内容基类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 18:07</P>
 * <P>UPDATE AT: 2019/1/8 18:07</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class BaseContentsBo<T extends Record> {

    /**
     * 如果是错误结果，该字段有值.
     */
    private MsgBo msg;

    /**
     * 如果是正确结果，该字段有值.
     */
    private List<ContentsDataBo<T>> data;

}
