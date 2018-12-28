package bwie.com.mvp.network;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MyTaskOne<T> extends AsyncTask<T,T,String> {
    String mPath;
    Context mContext;
    String pswd,name;
    private TaskListeners taskListener ;
    View mView;
    //获取接口
    public MyTaskOne setTaskListener(TaskListeners taskListener ){
        this.taskListener = taskListener ;
        return this ;
    }
    public MyTaskOne(String mPath, String name,String pswd) {
        this.mPath=mPath;
        this.name=name;
        this.pswd=pswd;
    }
    @Override
    protected String doInBackground(T... ts) {
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("phone", name);
        param.put("pwd", pswd);
        return HttpUrlUtils.post(mPath,param);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null) {
            //实现接口内面方法
            taskListener.result(s);
        }
    }
    //定义接口
    public interface TaskListeners{
        void result(String t);
    }


}

