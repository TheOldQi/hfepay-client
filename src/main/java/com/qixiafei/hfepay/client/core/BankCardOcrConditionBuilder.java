package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayBankCardOcrParam;

import java.io.IOException;
import java.util.Base64;

/**
 * <P>Description: 可以构建人脸识别condition的类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 22:18</P>
 * <P>UPDATE AT: 2019/1/8 22:18</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class BankCardOcrConditionBuilder implements ConditionBuilder<HfepayBankCardOcrParam, BankCardOrcConditionBo> {


    @Override
    public BankCardOrcConditionBo build(HfepayBankCardOcrParam req) throws IOException {
        final BankCardOrcConditionBo result = new BankCardOrcConditionBo();
        byte[] bytes = ImgUtils.limitSize(req.getPhoto(), 300, 0.8f);
        result.setPhoto(Base64.getEncoder().encodeToString(bytes));

        return result;
    }
}
