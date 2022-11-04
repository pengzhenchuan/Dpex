package com.pzc.dpex.request;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pzc.dpex.data.entity.RegistResponse;
import com.pzc.dpex.data.repository.local.HttpRequestManager;

public class RequestRegisterViewModel extends ViewModel {
    //登录成功的状态
    public MutableLiveData<RegistResponse> registSuccessData = new MutableLiveData<>();
    //登录失败的状态
    public MutableLiveData<String> registFailData = new MutableLiveData<>();

    //将要做的事件
    public void requestLogin(String account, String password,String phone,String type) {
        HttpRequestManager.getInstance().regist(account, password,phone,type,registSuccessData, registFailData);
    }
}
