package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 请求基类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 17:37</P>
 * <P>UPDATE AT: 2019/1/4 17:37</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class BaseReqBo {

    /**
     * 业务数据json串.
     */
    private String condition;

    /**
     * 商户编号.
     */
    private String userCode;

    /**
     * 签名字符串.
     */
    private String signature;

    /**
     * 加密偏移量.
     */
    private String vector;
}
