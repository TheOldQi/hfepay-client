package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 响应msg节点对象类型. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 18:10</P>
 * <P>UPDATE AT: 2019/1/8 18:10</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class MsgBo {

    /**
     * 响应码，00代表验证通过，其他字段才有意义，其他都是不通过.
     *
     * @see com.qixiafei.hfepay.client.params.enums.HfepayIdPersonAuthRespCodeEnum
     */
    private String code;

    /**
     * 响应码对应描述.
     */
    private String codeDesc;
}
