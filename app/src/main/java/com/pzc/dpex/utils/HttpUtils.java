package com.pzc.dpex.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author pzc
 * requestHttp 网络请求
 * address 请求地址后缀
 * jsonData 请求参数
 * isToken 是否携带Token
 * tClass 实体类
 */
public class HttpUtils {

    static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            //设置连接超时时间
            .callTimeout(5, TimeUnit.SECONDS)
            //设置读取超时时间
            .readTimeout(5, TimeUnit.SECONDS)
            //错误重连
            .retryOnConnectionFailure(true)
            .build();

    public static <T> T requestGetHttp(String address, Class<T> tClass) throws IOException {
        synchronized (CLIENT) {
            Request request = new Request.Builder()
                    .url(ConstantsUtils.SERVER_URL_USER + address)
                    .build();

            return new Gson().fromJson(Objects.requireNonNull(CLIENT.newCall(request).execute().body()).string(), tClass);
        }
    }
    //synchronized 同步控流
    public static <T> T requestPostHttp(String address, String jsonData, boolean isToken, Class<T> tClass) throws IOException {
        synchronized (CLIENT) {
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonData);
            Request request = new Request.Builder()
                    .post(body)
                    .url(ConstantsUtils.SERVER_URL_USER + address)
                    .build();
            if (isToken) {
                request.newBuilder().addHeader("Authorization", ConstantsUtils.TOKEN);
            }
            return new Gson().fromJson(Objects.requireNonNull(CLIENT.newCall(request).execute().body()).string(), tClass);
        }
    }

    public static <T> T requestPutHttp(String address, String jsonData, boolean isToken, Class<T> tClass) throws IOException {
        synchronized (CLIENT) {
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonData);
            Request request = new Request.Builder()
                    .put(body)
                    .url(ConstantsUtils.SERVER_URL_USER + address)
                    .build();
            if (isToken) {
                request.newBuilder().addHeader("Authorization", ConstantsUtils.TOKEN);
            }
            return new Gson().fromJson(Objects.requireNonNull(CLIENT.newCall(request).execute().body()).string(), tClass);
        }
    }
}
