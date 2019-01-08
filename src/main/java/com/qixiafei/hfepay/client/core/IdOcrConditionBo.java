package com.qixiafei.hfepay.client.core;

import lombok.Data;
import lombok.ToString;

/**
 * <P>Description: 身份证ocr codition bo. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/8 21:51</P>
 * <P>UPDATE AT: 2019/1/8 21:51</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Data
@ToString(exclude = "photo")
class IdOcrConditionBo implements ConditionsConditionType {

    /**
     * 身份国徽面或人像面图片的base64字符串.
     */
    private String photo;
}
