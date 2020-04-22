package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.data;
import static android.R.attr.text;

public class Ch10Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_2);

    }
    public void send_broadcast(View view){
        //发送广播
        Intent intent=new Intent("com.inspur.broadcast");//指定频道
        intent.putExtra("key1","message");
        sendBroadcast(intent);//发送
    }
    public  void ch10Activity(View view){
        Intent intent=new Intent(this,Ch10Activity1.class);
        EditText editText=(EditText) findViewById(R.id.ch10_2_et);
        intent.putExtra("text",editText.getText().toString());
        startActivity(intent);//设置传递的数据
    }
        public  void startSubActivity(View view) {
            Intent intent = new Intent(this, Ch10Activity3.class);
            startActivityForResult(intent, 101);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //3.在父Acticity中获取返回值
        //rrequestCode 用来区分从哪一个子Activity返回的结果
        if(requestCode==101){
            if(requestCode==RESULT_OK){
                //用户点击确认，逐步获取数据
                String name=data.getStringExtra("name");
                Toast.makeText(this,name,Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show();
            }

        }
    }
    public  void web(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://baidu.com"));
    }
}
