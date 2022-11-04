package com.pzc.dpex.data.repository.local;

import static java.util.concurrent.Executors.newFixedThreadPool;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.pzc.dpex.data.entity.LoginResponse;
import com.pzc.dpex.data.entity.RegistResponse;
import com.pzc.dpex.utils.ConstantsUtils;
import com.pzc.dpex.utils.HttpUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

import okhttp3.FormBody;

public class HttpRequestManager implements IDatabaseRequest, ILocalRequest, INetworkRequest {

    //单例模式
    private HttpRequestManager() {
    }

    ExecutorService service = newFixedThreadPool(10);

    private static HttpRequestManager httpRequestManager;

    public static HttpRequestManager getInstance() {
        if (null == httpRequestManager) {
            synchronized (HttpRequestManager.class) {
                if (null == httpRequestManager) {
                    httpRequestManager = new HttpRequestManager();
                }
            }
        }
        return httpRequestManager;
    }

    LoginResponse loginResponse;
    List<LoginResponse> loginList;

    /*
     * 请求服务器 登录实现
     * @param account 账号
     * @param password 密码
     * @param loginsuccessdata 成功的消息
     * @param loginfaildata 失败的消息
     *
     * */
//    @Override
//    public void login(String account, String password, MutableLiveData<LoginResponse> loginsuccessdata, MutableLiveData<String> loginfaildata) {
//        service.execute(()->{
//            try {
//                Thread.sleep(5*1000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                if (ACCOUNT.equals(account) && PASSWORD.equals(password)) {
//                    LoginResponse response = new LoginResponse();
//                    response.setCode(200);
//                    response.setMsg("login success");
//                    response.setAccount(account);
//                    loginsuccessdata.postValue(response);
//                } else {
//                    loginfaildata.postValue("登录失败");
//                }
//            }
//        });
//    }

    @Override
    public void login(String account, String password, MutableLiveData<LoginResponse> loginsuccessdata, MutableLiveData<String> loginfaildata) {
        service.execute(() -> {
//            FormBody formBody = new FormBody.Builder()
//                        .add("username",userName)
//                        .add("password",passWord)
//                    .build();
            try {
                loginResponse = HttpUtils.requestPostHttp(ConstantsUtils.ADDRESS_LOGIN,"{\n" +
                        "    \"name\":\""+account+"\",\n" +
                        "    \"pwd\":\""+password+"\"\n" +
                        "}", false, LoginResponse.class);
                Log.i("RES", "login: "+loginResponse.getCode()+"***********");
                if (loginResponse.getCode() == 200) {
                    loginsuccessdata.postValue(loginResponse);
                } else {
                    loginfaildata.postValue("登录失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    @Override
    public void regist(String account, String password, String phone, String type, MutableLiveData<RegistResponse> registsuccessdata, MutableLiveData<String> registfaildata) {
        service.execute(()->{
            try {
                Thread.sleep(5*1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
//                if (ACCOUNT.equals(account)&&PASSWORD.equals(password)){
//                    RegistResponse response=new RegistResponse();
//                    response.setCode(200);
//                    response.setMsg("login success");
//                    response.setAccount(account);
//                    registsuccessdata.postValue(response);
//                }else {
//                    registfaildata.postValue("登录失败");
//                }
            }
        });
    }
}