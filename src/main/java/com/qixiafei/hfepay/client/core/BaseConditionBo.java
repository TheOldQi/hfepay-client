package com.qixiafei.hfepay.client.core;

import lombok.Data;

/**
 * <P>Description: 请求condition字段bo. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 18:54</P>
 * <P>UPDATE AT: 2019/1/4 18:54</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class BaseConditionBo {

    private HeaderBo header;

    private ConditionsConditionType condition;

}
