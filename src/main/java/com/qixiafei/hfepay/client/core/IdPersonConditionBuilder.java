package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthParam;

import java.io.IOException;
import java.util.Base64;

/**
 * <P>Description: 可以构建人脸识别condition的类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 20:38</P>
 * <P>UPDATE AT: 2019/1/8 20:38</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class IdPersonConditionBuilder implements ConditionBuilder<HfepayIdPersonAuthParam, IdPersonAuthConditionBo> {

    @Override
    public IdPersonAuthConditionBo build(HfepayIdPersonAuthParam req) throws IOException {
        final IdPersonAuthConditionBo conditionBo = new IdPersonAuthConditionBo();
        conditionBo.setIdCard(req.getIdCard());
        conditionBo.setRealName(req.getRealName());

        byte[] bytes = ImgUtils.limitSize(req.getImg(), 30, 0.8f);
        conditionBo.setPhoto(Base64.getEncoder().encodeToString(bytes));
        return conditionBo;

    }
}
