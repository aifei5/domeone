package bwie.com.mvp.login.modle;

import android.util.Log;

import bwie.com.mvp.network.MyTaskOne;

public class LoginModelImpl implements ILoginModel{
    @Override
    public void login(final String url, final String username, final String pwd, final ILoginCallBack loginCallBack) {
        new Runnable(){
            @Override
            public void run() {
                new MyTaskOne<String>(url,username,pwd).setTaskListener(new MyTaskOne.TaskListeners() {
                    @Override
                    public void result(String t) {
                        Log.i("", "result:=== "+t);
                        //接口实现
                        if(t!=null){
                            //类实现的接口中的方法时
                            loginCallBack.onStatus(t);
                        }else {
                            loginCallBack.onFailed();
                        }
                    }
                }).execute();
            }
        }.run();
    }
}
