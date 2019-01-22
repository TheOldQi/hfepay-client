package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 华付接口调用成功的数据节点. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 21:21</P>
 * <P>UPDATE AT: 2019/1/8 21:21</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class Record {

    /**
     * 接口调用成功（不代表业务成功）返回码.
     *
     * @see com.qixiafei.hfepay.client.params.enums.HfepayIdPersonAuthRespCodeEnum
     */
    private String resCode;

    /**
     * 返回码描述.
     */
    private String resDesc;

    private String realName;
}
