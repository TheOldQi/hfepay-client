package com.qixiafei.hfepay.client.core;

import lombok.Data;

import java.util.List;

/**
 * <P>Description: 人证比对响应contents data 数据类型. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 17:36</P>
 * <P>UPDATE AT: 2019/1/8 17:36</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
class ContentsDataBo<R extends Record> {

    /**
     * 接口名称.
     */
    private String name;

    /**
     * 记录数量.
     */
    private String recordNum;

    /**
     * 实际数据承载体.
     */
    private List<R> record;

    public List<R> getRecord() {
        return record;
    }

    public void setRecord(List<R> record) {
        this.record = record;
    }
}
