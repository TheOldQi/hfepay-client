package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayBankCardElement4Param;

import java.io.IOException;

/**
 * <P>Description: 银行卡4要素condition builder. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/9 12:02</P>
 * <P>UPDATE AT: 2019/1/9 12:02</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class BankCardElement4ConditionBuilder implements ConditionBuilder<HfepayBankCardElement4Param, BankCardElement4ConditionBo> {
    @Override
    public BankCardElement4ConditionBo build(HfepayBankCardElement4Param req) throws IOException {
        final BankCardElement4ConditionBo result = new BankCardElement4ConditionBo();
        result.setIdCard(req.getIdCard());
        result.setMobile(req.getMobile());
        result.setBankCard(req.getBankCard());
        result.setRealName(req.getRealName());

        return result;
    }
}
