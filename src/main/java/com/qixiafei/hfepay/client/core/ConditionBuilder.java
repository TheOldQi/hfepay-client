package com.qixiafei.hfepay.client.core;

import com.qixiafei.hfepay.client.params.HfepayBaseParam;

import java.io.IOException;

/**
 * <P>Description: 可以构建condition的类型. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 20:28</P>
 * <P>UPDATE AT: 2019/1/8 20:28</P>
 *
 * @param <T> 外部请求参数类型
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
interface ConditionBuilder<T extends HfepayBaseParam,R extends ConditionsConditionType> {

    /**
     * 构建condition.
     *
     * @param req 外部请求对象
     * @return 请求condition部分
     */
    R build(T req) throws IOException;
}
