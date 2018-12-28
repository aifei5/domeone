package bwie.com.mvp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bwie.com.mvp.R;
import bwie.com.mvp.login.presenter.LoginPresenterImpl;
import bwie.com.mvp.login.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    EditText mLogin,mRegister;
    Button mLoginBut,mRegisterBut;
    private LoginPresenterImpl loginPresenter;
    String mLoginName,mRegisterPswd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogin = findViewById(R.id.login_name_et);
        mRegister = findViewById(R.id.login_pswd_et);
        mLoginBut= findViewById(R.id.login_lgbt);
        mRegisterBut= findViewById(R.id.login_rebt);
        mLoginName = mLogin.getText().toString();
        mRegisterPswd = mRegister.getText().toString();
        loginPresenter = new LoginPresenterImpl(this);
        mLoginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mLoginName.isEmpty()&&!mRegisterPswd.isEmpty()){
                    loginPresenter.loginPre(mLoginName,mRegisterPswd);
                }
            }
        });
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void jumpActivity() {
        Log.i("", "jumpActivity: ");
    }
}
