package com.qixiafei.hfepay.client.core;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <P>Description: 人证合一华付接口响应业务数据. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 21:21</P>
 * <P>UPDATE AT: 2019/1/8 21:21</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
class IdPersonRecord extends Record {

    /**
     * 分数.
     */
    private String score;
}
