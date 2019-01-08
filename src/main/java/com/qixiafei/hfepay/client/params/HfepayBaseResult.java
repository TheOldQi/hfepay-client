package com.qixiafei.hfepay.client.params;

import lombok.Data;

/**
 * <P>Description: 华付响应基类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 21:02</P>
 * <P>UPDATE AT: 2019/1/8 21:02</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
public class HfepayBaseResult {

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

    public final String getCode() {
        return code;
    }

    public final void setCode(String code) {
        this.code = code;
    }

    public final String getCodeDesc() {
        return codeDesc;
    }

    public final void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public final HfepayHeader getHeader() {
        return header;
    }

    public final void setHeader(HfepayHeader header) {
        this.header = header;
    }
}
