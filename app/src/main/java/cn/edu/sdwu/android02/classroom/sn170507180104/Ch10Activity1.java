package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Ch10Activity1 extends AppCompatActivity {
private Integer  count;//计数器


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_1);
        Log.i(Ch10Activity1.class.toString(),"onCreate");
        count=0;

    }
    public void finishClick(View view){
        finish();//关闭界面
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Ch10Activity1.class.toString(),"onStart");

    }
//计数的方法
    public void counter(View view){
        count++;
        Log.i(Ch10Activity1.class.toString(),"counter:"+count);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("counter", count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        //使用本方法保存一些界面的状态信息
        //数据保存

        super.onRestoreInstanceState(saveInstanceState);
        //恢复之前保存的状态信息
       count= saveInstanceState.getInt("counter");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Ch10Activity1.class.toString(),"onDestory");

    }



}
