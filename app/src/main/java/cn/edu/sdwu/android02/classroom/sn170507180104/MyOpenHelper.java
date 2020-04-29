package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 婉 on 2020/4/29.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    //public SQLiteOpenHelper(android.content.Context 上下文context, String name,数据库名称 android.database.sqlite.SQLiteDatabase.CursorFactory factory,传入null int version 数据库版本)
    private String STUDENT_TB_SQL="create table student (id )";
   public  MyOpenHelper(){
       //
    super(context,"stub.db",null,l);
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//打开数据库时，发现数据库并不存在，此时会自动创建数据库，然后调用oncreate方法
        //在本方法中，完成数据库对象（表，视图，索引等）的创建
        Log.i(MyOpenHelper.class.toString(),"onCreate");

);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
