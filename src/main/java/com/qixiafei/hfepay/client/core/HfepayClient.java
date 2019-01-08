package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthReq;
import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthResp;
import lombok.extern.slf4j.Slf4j;

/**
 * <P>Description: 华付客户端工具类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/3 16:19</P>
 * <P>UPDATE AT: 2019/1/3 16:19</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Slf4j
public final class HfepayClient {

    private HfepayProperties properties;


    public HfepayClient(final HfepayProperties properties) {
        this.properties = properties;
    }

    /**
     * 人证合一验证.
     */
    public HfepayIdPersonAuthResp idPersonAuth(final HfepayIdPersonAuthReq req) throws Exception {
        log.info("华付人证合一验证请求,req={}", req);
        ValidateUtils.validate(req);
        // 组装实际请求header信息
        final HeaderBo headerBo = Converter.buildHeaderBo(req.getHeader(), properties.getUserCode(), properties.getSysCode());
        // 组装实际请求数据部分condition信息
        final IdPersonAuthConditionBo conditionBo = Converter.buildIdPersonAuthConditionBo(req);
        // 组装实际请求顶级部分condition信息
        final BaseConditionBo baseConditionBo = new BaseConditionBo();
        baseConditionBo.setHeader(headerBo);
        baseConditionBo.setCondition(conditionBo);
        return HfepayCore.idPersonAuth(baseConditionBo, properties, req.getVector(), req.getHeader());
    }

}
