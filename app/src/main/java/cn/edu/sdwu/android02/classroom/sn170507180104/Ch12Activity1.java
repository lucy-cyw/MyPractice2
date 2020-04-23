package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Ch12Activity1 extends AppCompatActivity {
    private ServiceConnection serviceConnection;
    private MyService2 myService2;
    private boolean bindSucc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch12_1);
        bindSucc = false;
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                //当调用者与服务建立连接后，会自动调用调用本方法
                //第二个参数是service 中onBind方法的返回值
                MyService2.MyBinder myBinder = (MyService2.MyBinder) iBinder;
                myService2 = myBinder.getRandomService();
                bindSucc = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                //d当调用者与服务断开连接后，会自动调用本方法


            }

        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService2.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        //断开连接 解绑
        unbindService(serviceConnection);
    }

    public void start_service(View view) {
        //开启服务
        Intent intent = new Intent(this, MyService.class);

        startActivity(intent);

    }

    public void close_service(View view) {
        //停止服务
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);


    }

    public void getRandom(View view) {
        if (bindSucc) {
            int ran = myService2.genRandom();
            Toast.makeText(this, ran + "", Toast.LENGTH_LONG).show();
        }
    }
}


