package bwie.com.mvp.home.model;

import android.util.Log;

import bwie.com.mvp.network.MyTask;

public class HomeListModel implements IHomeListModel {
    ModuleInterface moduleInterface;
    //构造方法
    public HomeListModel(ModuleInterface moduleInterface) {
        this.moduleInterface = moduleInterface;
    }

    @Override
    public void getModelData(final String url) {
        //子线程
        new Runnable(){
            @Override

            public void run() {
                    //调用的mytask
                new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        Log.i("", "result: "+t);
                        if (t!=null){
                            //调用自身接口 去传值
                            moduleInterface.LoadSuccess(t);

                        }else{
                            moduleInterface.LoadFailed();
                        }

                    }
                }).execute();
            }
        }.run();


    }
    //自己的本身接口
    public interface ModuleInterface {
        //获取数据状态回调的接口
        void LoadSuccess(String data);

        void LoadFailed();
    }
}
