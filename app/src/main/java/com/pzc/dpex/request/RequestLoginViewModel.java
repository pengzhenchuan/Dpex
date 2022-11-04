package com.pzc.dpex.request;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pzc.dpex.data.entity.LoginResponse;
import com.pzc.dpex.data.repository.local.HttpRequestManager;

public class RequestLoginViewModel extends ViewModel {
    //登录成功的状态
    public MutableLiveData<LoginResponse> loginSuccessData = new MutableLiveData<>();
    //登录失败的状态
    public MutableLiveData<String> loginFailData = new MutableLiveData<>();

    //将要做的事件
    public void requestLogin(String account, String password) {
        HttpRequestManager.getInstance().login(account, password, loginSuccessData, loginFailData);
    }
}
