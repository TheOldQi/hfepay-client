package com.qixiafei.hfepay.client.core;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 19:16</P>
 * <P>UPDATE AT: 2019/1/4 19:16</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class Chiper3Des {

    private static final String Algorithm_DES = "DESede";
    private static final String AlgorithmMode_DES = "/CBC/PKCS5Padding";

    public Chiper3Des() {
    }

    /**
     * 加密.
     *
     * @param plain  明文
     * @param key    密钥
     * @param vector 偏移量
     * @return
     * @throws Exception
     */
    public static String encrypt(String plain, String key, String vector) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        DESedeKeySpec dks = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey securekey = keyFactory.generateSecret(dks);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(), 0, cipher.getBlockSize());
        cipher.init(1, securekey, iv);
        byte[] encoded = cipher.doFinal(plain.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encoded);
    }

    /**
     * 解密.
     *
     * @param encrypt 密文
     * @param key     密钥
     * @param vector  偏移量
     * @return
     * @throws Exception
     */
    public static String decrypt(String encrypt, String key, String vector) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        DESedeKeySpec dks = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey securekey = keyFactory.generateSecret(dks);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(), 0, cipher.getBlockSize());
        cipher.init(2, securekey, iv);
        byte[] todecodeBytes = Base64.getDecoder().decode(encrypt);
        return new String(cipher.doFinal(todecodeBytes), "utf-8");
    }
}
