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
class IdPersonAuthConditionDataBo {

    /**
     * 接口名称.
     */
    private String name;

    /**
     * 记录数量.
     */
    private String recordNum;

    /**
     * 生活照base64字符串.
     */
    private List<Record> record;

    @Data
    static class Record {
        /**
         * 分数.
         */
        private String score;
        /**
         * 接口调用成功（不代表业务成功）返回码.
         *
         * @see com.qixiafei.hfepay.client.params.enums.HfepayIdPersonAuthRespCodeEnum
         */
        private String resCode;

        /**
         * 返回码描述.
         */
        private String resDesc;
    }

}
