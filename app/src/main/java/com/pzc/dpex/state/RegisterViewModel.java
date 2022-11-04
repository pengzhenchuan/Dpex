package com.pzc.dpex.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {
    public MutableLiveData<String> registState = new MutableLiveData<>();
    public MutableLiveData<String> account = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> phone = new MutableLiveData<>();
    public MutableLiveData<String> type = new MutableLiveData<>();
}
