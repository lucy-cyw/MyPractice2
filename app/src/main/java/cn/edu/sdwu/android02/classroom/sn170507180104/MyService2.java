package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService2 extends Service {
    private Random random;
    private MyBinder myBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        random=new Random();
        myBinder=new MyBinder();
    }
    public MyService2(){

    }

    public IBinder onBind(Intent intent) {
        //返回值，返回给调用者，以后调用者与服务进行交互时，都会使用此返回值
        // TODO: Return the communication channel to the service.
    }
    public class MyBinder extends Binder{
        public  MyService2 getRandomService(){
            return MyService2 .this;

        }
    }
    //实际
    public int genRandom(){
        return random.nextInt();
    }
}
