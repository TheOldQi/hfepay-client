package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <P>Description: 可以构建condition部分的工厂类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 20:28</P>
 * <P>UPDATE AT: 2019/1/8 20:28</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class ConditionBuilderFactory {

    private static final ConcurrentHashMap<Class<? extends HfepayBaseParam>, ConditionBuilder<? extends HfepayBaseParam, ? extends ConditionsConditionType>> POOL = new ConcurrentHashMap<>();

    static {
        init();
    }

    /**
     * 从工厂获取builder.
     *
     * @param req 外部请求入参
     * @param <T> 外部请求入参类型
     * @return builder
     */
    static <T extends HfepayBaseParam, R extends ConditionsConditionType> ConditionBuilder<T, R> getBuilder(T req) {
        @SuppressWarnings("unchecked") ConditionBuilder<T, R> conditionBuilder = (ConditionBuilder<T, R>) POOL.get(req.getClass());
        return conditionBuilder;
    }

    /**
     * 注册builder到工厂.
     */
    private static void init() {
        // 人证合一
        POOL.put(HfepayIdPersonAuthParam.class, new IdPersonConditionBuilder());
        // 身份证ocr
        POOL.put(HfepayIdOcrParam.class, new IdOcrConditionBuilder());
        // 银行卡ocr
        POOL.put(HfepayBankCardOcrParam.class, new BankCardOcrConditionBuilder());
        // 姓名、身份证号验证
        POOL.put(HfepayIdNameAuthParam.class, new IdNameConditionBuilder());
        // 银行卡2要素验证
        POOL.put(HfepayBankCardElement2Param.class,new BankCardElement2ConditionBuilder());
        // 银行卡3要素验证
        POOL.put(HfepayBankCardElement3Param.class,new BankCardElement3ConditionBuilder());
        // 银行卡4要素验证
        POOL.put(HfepayBankCardElement4Param.class,new BankCardElement4ConditionBuilder());

    }
}
