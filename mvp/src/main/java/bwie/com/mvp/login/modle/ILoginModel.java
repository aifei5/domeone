package bwie.com.mvp.login.modle;

public interface ILoginModel {

    public void login(String url,String username,String pwd,ILoginCallBack loginCallBack);
    interface ILoginCallBack {
        public void onStatus(String data);
        public void onFailed();
    }
}
