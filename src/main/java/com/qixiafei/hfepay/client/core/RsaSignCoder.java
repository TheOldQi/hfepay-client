package com.qixiafei.hfepay.client.core;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 22:13</P>
 * <P>UPDATE AT: 2019/1/4 22:13</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
class RsaSignCoder {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final int KEY_SIZE = 512;
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    public RsaSignCoder() {
    }

    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap();
        keyMap.put("RSAPublicKey", publicKey);
        keyMap.put("RSAPrivateKey", privateKey);
        return keyMap;
    }

    public static String sign(String datas, String privates) throws Exception {
        byte[] data = datas.getBytes();
        byte[] privateKey = Base64.getDecoder().decode(privates);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(priKey);
        signature.update(data);
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    public static boolean verify(String datas, String publicKeys, String signs) throws Exception {
        byte[] data = datas.getBytes();
        byte[] publicKey = Base64.getDecoder().decode(publicKeys);
        byte[] sign = Base64.getDecoder().decode(signs);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(pubKey);
        signature.update(data);
        return signature.verify(sign);
    }

    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get("RSAPrivateKey");
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get("RSAPublicKey");
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> keyMap = initKey();
        String publicKey = getPublicKey(keyMap);
        String privateKey = getPrivateKey(keyMap);
        System.out.println("公钥：" + publicKey);
        System.out.println("私钥：" + privateKey);
        System.out.println("================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");
        String str = "测试";
        System.out.println("原文:" + str);
        String sign = sign(str, privateKey);
        System.out.println("产生签名：" + sign);
        boolean status = verify(str, "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJe1nMHoxxUbWJzeAyZENQHkBsJCnf+s+3Q86ibYeVU1paQ9IP3r4T9vrvDXz0bmjBsV8cq7ax3SCSLZzlzMjnMCAwEAAQ==", "jkcyCH1Slwq3QVpls21dut/a4giMUOt51c82o3oX9HB80TXlVlYyjv58PI98Z3r7qZ9qAX6P0IQfCuEpTtnr3A==");
        System.out.println("状态：" + status + "/n/n");
    }
}
