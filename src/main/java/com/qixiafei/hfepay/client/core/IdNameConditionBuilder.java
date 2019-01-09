package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayIdNameAuthParam;

import java.io.IOException;

/**
 * <P>Description: 姓名、身份证号condition 构建类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 11:50</P>
 * <P>UPDATE AT: 2019/1/9 11:50</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class IdNameConditionBuilder implements ConditionBuilder<HfepayIdNameAuthParam, IdNameConditionBo> {

    @Override
    public IdNameConditionBo build(HfepayIdNameAuthParam req) throws IOException {
        final IdNameConditionBo result = new IdNameConditionBo();
        result.setIdCard(req.getIdCard());
        result.setRealName(req.getRealName());
        return result;
    }
}
