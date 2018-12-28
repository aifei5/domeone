package bwie.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import bwie.com.mvp.home.presanter.HomeListPresanter;
import bwie.com.mvp.home.view.IHomeListView;

public class MainActivity extends AppCompatActivity implements IHomeListView {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        textView =findViewById(R.id.text1);
        //强引用 new presenter
        HomeListPresanter homeListPresanter = new HomeListPresanter(this);
        //调用presenter的方法
        homeListPresanter.getPresanterData();
    }

    @Override
    //实现view接口的方法
    public void getViewData(String mViewData) {
    textView.setText(mViewData);
    }
}
