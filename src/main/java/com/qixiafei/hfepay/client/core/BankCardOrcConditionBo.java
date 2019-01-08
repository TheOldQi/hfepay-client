package com.qixiafei.hfepay.client.core;

import lombok.Data;
import lombok.ToString;

/**
 * <P>Description: 银行卡ocr codition bo.. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 22:17</P>
 * <P>UPDATE AT: 2019/1/8 22:17</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
@ToString(exclude = "photo")
class BankCardOrcConditionBo implements ConditionsConditionType {

    /**
     * 银行卡正面图片的base64字符串.
     */
    private String photo;
}
