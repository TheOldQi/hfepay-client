package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 请求头信息封装对象. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 17:33</P>
 * <P>UPDATE AT: 2019/1/4 17:33</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class HeaderBo {

    /**
     * 请求批次号.
     */
    private String qryBatchNo;

    /**
     * 商户编号.
     */
    private String userCode;

    /**
     * 应用编号.
     */
    private String sysCode;

    /**
     * 调用原因.
     */
    private String qryReason;

    /**
     * 调用日期yyyyMMdd.
     */
    private String qryDate;

    /**
     * 调用时间HHmmss.
     */
    private String qryTime;

    private final String version = "2.0";

}
