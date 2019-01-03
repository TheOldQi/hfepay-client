package com.qixiafei.hfepay.client.params;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * <P>Description: 华付请求响应中的header结构. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/3 17:17</P>
 * <P>UPDATE AT: 2019/1/3 17:17</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
public class HfepayHeader {

    /**
     * 请求流水号.
     */
    @NotBlank
    @Length(max = 20)
    private String qryBatchNo;

    /**
     * 商户编号（华付分配）.
     */
    @NotBlank
    private String userCode;

    /**
     * 应用编号（华付分配）.
     */
    @NotBlank
    private String sysCode;

    /**
     * 查询原因.
     */
    private String qryReason;

    /**
     * 查询日期，yyyyMMdd.
     */
    private String qryDate;

    /**
     * 查询时间,HHmmss.
     */
    private String qryTime;
}
