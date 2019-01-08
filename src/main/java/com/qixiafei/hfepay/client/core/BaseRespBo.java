package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 华付响应格式bo基类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 17:52</P>
 * <P>UPDATE AT: 2019/1/8 17:52</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class BaseRespBo {

    /**
     * 签名.
     */
    private String signature;

    /**
     * 加密内容，如果接口调用成功,会存在值.
     */
    private String contents;

    /**
     * 如果接口调用失败，会存在值.
     */
    private MsgBo msg;
}
