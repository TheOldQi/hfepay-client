package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayHeader;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * <P>Description: 转换类代码收集类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 17:48</P>
 * <P>UPDATE AT: 2019/1/4 17:48</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class Converter {
    private static final FastDateFormat SDF = FastDateFormat.getInstance("yyyyMMddHHmmss");

    /**
     * 根据公共请求参数的header构建实际请求bo的header.
     *
     * @param header   公共请求参数header.
     * @param userCode 商户编号
     * @param sysCode  应用编号
     * @return
     */
    static HeaderBo buildHeaderBo(HfepayHeader header, String userCode, String sysCode) {
        final HeaderBo bo = new HeaderBo();
        bo.setQryBatchNo(header.getQryBatchNo());
        bo.setUserCode(userCode);
        bo.setSysCode(sysCode);
        bo.setQryReason(header.getQryReason());
        if (header.getQryTime() != null) {
            String format = SDF.format(header.getQryTime());
            bo.setQryDate(format.substring(0, 8));
            bo.setQryTime(format.substring(8));
        }

        return bo;
    }

}
