package com.qixiafei.hfepay.client.params;

import lombok.Data;

import java.io.Serializable;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 14:37</P>
 * <P>UPDATE AT: 2019/1/4 14:37</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
public class HfepayIdPersonAuthResp implements Serializable {

    /**
     * 响应码，00代表验证通过，其他字段才有意义，其他都是不通过.
     *
     * @see com.qixiafei.hfepay.client.params.enums.HfepayIdPersonAuthRespCodeEnum
     */
    private String code;

    /**
     * 响应码对应描述.
     */
    private String codeDesc;

    /**
     * 请求头信息，原样返回.
     */
    private HfepayHeader header;

    /**
     * 相似度，0-100 之间（45 分及以上为同一人，
     * 低于45 分为不同人）.
     */
    private Double score;

    /**
     * 认证结果.
     * true -认证通过，false-认证不通过
     */
    private boolean result;

}
