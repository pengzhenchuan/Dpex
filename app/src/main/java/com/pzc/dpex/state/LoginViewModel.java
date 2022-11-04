package com.pzc.dpex.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    //所有的状态数据
    public MutableLiveData<String> loginState = new MutableLiveData<>();
    public MutableLiveData<String> account = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

}
