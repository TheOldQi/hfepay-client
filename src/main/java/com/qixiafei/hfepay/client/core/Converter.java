package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayHeader;
import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthReq;
import org.apache.commons.lang3.time.FastDateFormat;

import java.io.IOException;
import java.util.Base64;

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

    /**
     * 构建人证合一请求条件bo.
     *
     * @param req 公共请求参数入参
     * @return
     * @throws IOException
     */
    public static IdPersonAuthConditionBo buildIdPersonAuthConditionBo(HfepayIdPersonAuthReq req) throws IOException {
        final IdPersonAuthConditionBo conditionBo = new IdPersonAuthConditionBo();
        conditionBo.setIdCard(req.getIdCard());
        conditionBo.setRealName(req.getRealName());

        byte[] bytes = ImgUtils.limitSize(req.getImg(), 30, 0.8f);
        conditionBo.setPhoto(Base64.getEncoder().encodeToString(bytes));
        return conditionBo;
    }
}
