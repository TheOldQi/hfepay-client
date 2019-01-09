package com.qixiafei.hfepay.client.core;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <P>Description: 使用Http-post方式发送数据. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/8/11</P>
 * <P>UPDATE DATE: 2017/8/11</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.7.0
 */
@Slf4j
class PostUtil {

    /**
     * 请求返回json串在返回map中的key值.
     */
    public static final String RESP_JSON_KEY = "respJson";

    /**
     * 请求类型键.
     */
    private static final String CONTENT_TYPE_KEY = "Content-Type";

    /**
     * 请求类型为json的值.
     */
    private static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";

    /**
     * 请求类型为普通form表单的值.
     */
    private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset="
            + "utf-8";

    /**
     * 工具类.
     */
    private PostUtil() {

    }


    static String postForm(final String url, final Map<String, Object> reqMap) {

        final List<BasicNameValuePair> pairList = new ArrayList<>(reqMap.size());
        for (Map.Entry<String, Object> entry : reqMap.entrySet()) {
            pairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }

        try {
            return postAndGetResult(url, new UrlEncodedFormEntity(pairList, "utf-8"),
                    CONTENT_TYPE_FORM);
        } catch (UnsupportedEncodingException e) {
            log.error("postForm(),普通form表单post提交，对参数列表进行url编码时报错", e);
            throw new RuntimeException();
        }
    }


    /**
     * 执行发送post请求并拿到结果的方法.
     *
     * @param url         发送请求地址
     * @param reqEntity   发送请求内容
     * @param contentType 请求头内容编码类型
     * @return 响应Json格式字符串
     */
    private static String postAndGetResult(final String url, final HttpEntity reqEntity, final String contentType) {
        final CloseableHttpClient client = HttpClientPool.getHttpClient();
        // multipart/form-data不能指定请求头，因为我们不知道边界怎么设置，由工具去自动计算及设置
        final HttpPost post = new HttpPost(url);
        post.setEntity(reqEntity);
        if (contentType != null) {
            post.addHeader(CONTENT_TYPE_KEY, contentType);
        }

        try {
            return client.execute(post, new StringResponseHandler());
        } catch (IOException e) {
            log.error("调用http异常", e);
            throw new RuntimeException("调用http异常");
        }

    }


}
