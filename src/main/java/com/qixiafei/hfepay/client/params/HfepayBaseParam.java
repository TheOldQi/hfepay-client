package com.qixiafei.hfepay.client.params;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <P>Description: 华付请求基类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 20:20</P>
 * <P>UPDATE AT: 2019/1/8 20:20</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
public class HfepayBaseParam {

    /**
     * 请求头信息.
     */
    @Valid
    @NotNull
    private HfepayHeader header;

    public final HfepayHeader getHeader() {
        return header;
    }

    public final void setHeader(HfepayHeader header) {
        this.header = header;
    }
}
