package com.pzc.dpex.ui.activity;



import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.pzc.dpex.R;
import com.pzc.dpex.base.BaseActivity;
import com.pzc.dpex.databinding.ActivityRegisterBinding;
import com.pzc.dpex.request.RequestLoginViewModel;
import com.pzc.dpex.request.RequestRegisterViewModel;
import com.pzc.dpex.state.LoginViewModel;
import com.pzc.dpex.state.RegisterViewModel;


public class RegisterActivity extends BaseActivity {

    ActivityRegisterBinding binding;
    RegisterViewModel stateViewModel;
    RequestRegisterViewModel requestViewModel;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        stateViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(RegisterViewModel.class);
        requestViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(RequestRegisterViewModel.class);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_register);
        binding.setVm(stateViewModel);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);
    }

    public class ClickClass{
        public void registerAction(){

        }
    }
}