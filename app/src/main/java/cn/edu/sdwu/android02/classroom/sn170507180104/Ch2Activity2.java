package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ch2Activity2 extends AppCompatActivity {
private ServiceConnection serviceConnection;
    private  boolean bound;
    private MedliaService medliaService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch12_2);
        bound=false;
        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                bound=true;
                MedliaService.MyBinder myBinder=(MedliaService.MyBinder)iBinder;
                medliaService =myBinder.getMediaService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

                bound=false;
            }
        };

    }
    public void ch12_2_start(View view){
        startServiceClick(view);
    }
    public void ch12_2_pause(View view){
        startServiceClick(view);
    }
    public void ch12_2_stop(View view){
        startServiceClick(view);
    }
    public void ch12_2_stopservice(View view){
        startServiceClick(view);
    }
    public void startServiceClick(View view){
        //使用本方法 统一处理用户的点击（启动方式的按键）
        int id=view.getId();
        Intent intent=new Intent(this,MedliaService.class);
        switch (id){
            case R.id.ch12_2_start:

                intent.putExtra("PlayState","START");
                startActivity(intent);
                break;
            case R.id.ch12_2_pause:
                intent.putExtra("PlayState","PAUSE");
                 break;
            case R.id.ch12_2_stop:
                intent.putExtra("PlayState","STOP");
                break;
            case R.id.ch12_2_stopservice:
                intent.putExtra("PlayState","STOPSERVICE");
                break;
        }
        startActivity(intent);
    }
    public void  bindClick(View view){
        int id=view.getId();
        switch(id){
            case R.id.ch12_2_bind:
                Intent intent=new Intent(this,MedliaService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.ch12_2_unbind:
                unbindService(serviceConnection);
                bound=false;
                break;
            case R.id.ch12_2_bindstart:
                if(bound){
                    medliaService.start();;
                }
                break;
            case R.id.ch12_2_bindpause:
                if(bound){
                    medliaService.pause();
                }
                break;
            case R.id.ch12_2_bindstop:
                if(bound){
                    medliaService.stop();
                }
                break;
            case R.id.ch12_2_bindstopservice:
                break;
        }
    }

}
