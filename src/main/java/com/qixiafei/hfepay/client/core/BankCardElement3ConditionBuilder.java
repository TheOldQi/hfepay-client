package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayBankCardElement3Param;

import java.io.IOException;

/**
 * <P>Description: 银行卡3要素condition builder. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 12:02</P>
 * <P>UPDATE AT: 2019/1/9 12:02</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class BankCardElement3ConditionBuilder implements ConditionBuilder<HfepayBankCardElement3Param, BankCardElement3ConditionBo> {
    @Override
    public BankCardElement3ConditionBo build(HfepayBankCardElement3Param req) throws IOException {
        final BankCardElement3ConditionBo result = new BankCardElement3ConditionBo();
        result.setIdCard(req.getIdCard());
        result.setBankCard(req.getBankCard());
        result.setRealName(req.getRealName());
        return result;
    }
}
