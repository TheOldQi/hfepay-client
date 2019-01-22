package com.qixiafei.hfepay.client.core;

import java.util.Random;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/21 14:51</P>
 * <P>UPDATE AT: 2019/1/21 14:51</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class RandomString {

    private static final char[] chars = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    private static final Random random = new Random();

    /**
     * 指定位数随机字符串.
     *
     * @param bits
     * @return
     */
    static String rdmStr(int bits) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits; i++) {

            int indx = random.nextInt(chars.length);
            sb.append(chars[indx]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(rdmStr(8));
        }
    }
}
