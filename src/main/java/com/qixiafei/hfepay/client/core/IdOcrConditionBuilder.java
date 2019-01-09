package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayIdOcrParam;

import java.io.IOException;
import java.util.Base64;

/**
 * <P>Description: 身份中ocr请求condition 构建类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 22:06</P>
 * <P>UPDATE AT: 2019/1/8 22:06</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class IdOcrConditionBuilder implements ConditionBuilder<HfepayIdOcrParam, IdOcrConditionBo> {

    @Override
    public IdOcrConditionBo build(HfepayIdOcrParam req) throws IOException {
        final IdOcrConditionBo result = new IdOcrConditionBo();
        byte[] bytes = ImgUtils.limitSize(req.getPhoto(), 300, 0.8f);
        result.setPhoto(Base64.getEncoder().encodeToString(bytes));
        return result;
    }
}
