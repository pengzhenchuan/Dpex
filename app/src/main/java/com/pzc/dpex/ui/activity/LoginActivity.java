package com.pzc.dpex.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.pzc.dpex.R;
import com.pzc.dpex.base.BaseActivity;
import com.pzc.dpex.data.entity.LoginResponse;
import com.pzc.dpex.databinding.ActivityLoginBinding;
import com.pzc.dpex.request.RequestLoginViewModel;
import com.pzc.dpex.state.LoginViewModel;

import java.util.Objects;


public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;
    LoginViewModel stateViewModel;
    RequestLoginViewModel requestViewModel;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        stateViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(LoginViewModel.class);
        requestViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(RequestLoginViewModel.class);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setVm(stateViewModel);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);

        observerDataStateUpdateAction();
    }

    public void observerDataStateUpdateAction(){
        requestViewModel.loginSuccessData.observe(this, loginResponse -> {
            loginSuccessStateUpdate(loginResponse);
            mProgressDialog.dismiss();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        });
        requestViewModel.loginFailData.observe(this, errorMsg -> {
            loginFailStateUpdate(errorMsg);
            mProgressDialog.dismiss();
        });
    }

    private void loginFailStateUpdate(String errorMsg) {
        stateViewModel.loginState.setValue(errorMsg);
    }


    private void loginSuccessStateUpdate(LoginResponse loginResponse) {
        stateViewModel.loginState.setValue("恭喜："+loginResponse.getData()+"，登录成功666");
        Toast.makeText(this, stateViewModel.loginState.getValue(), Toast.LENGTH_SHORT).show();
    }

    ProgressDialog mProgressDialog;

    //点击事件
    public class ClickClass {
        public void loginAction(){
            if (stateViewModel.account.getValue()==null||stateViewModel.password.getValue()==null){
                stateViewModel.loginState.setValue("账号或者密码不能为空");
                return;
            }
            mProgressDialog=new ProgressDialog(LoginActivity.this);
            mProgressDialog.setTitle(stateViewModel.account.getValue()+"用户....正在登录中......");
            mProgressDialog.show();

            requestViewModel.requestLogin(stateViewModel.account.getValue(),stateViewModel.password.getValue());
        }
        public void registerAction(){
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
    }
}