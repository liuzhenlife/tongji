package com.liuzhen.tongji.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HttpClient网络请求工具类
 * Created by liuzhen on 2017/9/11.
 */
public class HttpClientUtils {

    public static String doPost(String url, JSONObject json) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://targethost/login");
        //拼接参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            HttpEntity entity = response.getEntity();

            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
        return null;

    }

    /**
     * * get请求
     *
     * @param url   地址
     * @param clazz 结果对象
     * @param <T>   结果类型
     * @return 请求结果
     * @throws IOException
     */
    public static <T> T doGet(String url, Class<T> clazz) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            T value = JSON.parseObject(result, clazz);
            EntityUtils.consume(entity);
            return value;
        } finally {
            response.close();
        }
    }

}
