package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayBankCardElement2Param;

import java.io.IOException;

/**
 * <P>Description: 银行卡2要素condition builder. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 12:02</P>
 * <P>UPDATE AT: 2019/1/9 12:02</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class BankCardElement2ConditionBuilder implements ConditionBuilder<HfepayBankCardElement2Param, BankCardElement2ConditionBo> {
    @Override
    public BankCardElement2ConditionBo build(HfepayBankCardElement2Param req) throws IOException {
        final BankCardElement2ConditionBo result = new BankCardElement2ConditionBo();
        result.setBankCard(req.getBankCard());
        result.setRealName(req.getRealName());
        return result;
    }
}
