package com.pzc.dpex.data.repository.local;

import android.view.textclassifier.TextClassification;

import androidx.lifecycle.MutableLiveData;

import com.pzc.dpex.data.entity.LoginResponse;
import com.pzc.dpex.data.entity.RegistResponse;

public interface INetworkRequest {
    /**
     * 网络请求
     * @account 账号
     * @password 密码
     * @loginsuccessdata 登录成功的消息
     * @loginfaildata 登录失败的消息
     *
     */
    void login(String account, String password, MutableLiveData<LoginResponse> loginsuccessdata, MutableLiveData<String> loginfaildata);
    void regist(String account, String password, String phone, String type, MutableLiveData<RegistResponse> loginsuccessdata, MutableLiveData<String> loginfaildata);
}
