package bwie.com.mvp.login.presenter;

import android.util.Log;

import bwie.com.mvp.api.Api;
import bwie.com.mvp.login.LoginActivity;
import bwie.com.mvp.login.modle.ILoginModel;
import bwie.com.mvp.login.modle.LoginModelImpl;

public class LoginPresenterImpl  implements ILoginPresenter{

    private final LoginModelImpl loginModel;
    LoginActivity loginActivity;
    public LoginPresenterImpl(LoginActivity loginActivity) {
        this.loginActivity=loginActivity;
        //初始化model
        loginModel = new LoginModelImpl();
    }

    @Override
    public void loginPre(String name, String pswd) {
        loginModel.login(Api.LOGIN, name, pswd, new ILoginModel.ILoginCallBack() {
            @Override
            public void onStatus(String data) {
                Log.i("", "onStatus: "+data);
                loginActivity.jumpActivity();
            }

            @Override
            public void onFailed() {

            }
        });
    }
}
