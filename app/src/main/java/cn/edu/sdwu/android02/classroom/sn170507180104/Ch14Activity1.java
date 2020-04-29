package cn.edu.sdwu.android02.classroom.sn170507180104;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Ch14Activity1 extends AppCompatActivity {
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch14_1);
        myOpenHelper = new MyOpenHelper(this);
        //以可写方式打开数据库
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();

        //使用完毕，将数据库关闭
        sqLiteDatabase.close();
    }

    public void insert(View view) {
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        try {
            //将插入的数据放置在contentvalues中
            //事务处理
            sqLiteDatabase.beginTransaction();//开启事务
            ContentValues contentValues = new ContentValues();
            contentValues.put("stuname", "tom");
            contentValues.put("stutel", "12343333");

            sqLiteDatabase.insert("student", null, contentValues);

            sqLiteDatabase.setTransactionSuccessful();//所有操作完成后调用此方法，才会将数据真正保存在数据库

        } catch (Exception e) {
            Log.e(Ch14Activity1.class.toString(), e.toString());
        } finally {
            //使用完毕，将数据库关闭
            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }

    }

    public void query(View view) {
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        try {

            Cursor cursor = sqLiteDatabase.rawQuery("select * from student ");
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String stuname = cursor.getString(cursor.getColumnIndex("stuname"));
                String stutel = cursor.getString(cursor.getColumnIndex("stutel"));
                Log.i(Ch14Activity1.class.toString(), "id:" + id+"stuname:" + stuname + ",stutel:" + stutel);

            } cursor.close();

        } catch (Exception e) {
            Log.e(Ch14Activity1.class.toString(), e.toString());
        } finally {
            //使用完毕，将数据库关闭
            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }
    }

    public void delete(View view) {
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        try {
            //将插入的数据放置在contentvalues中
            //事务处理
            sqLiteDatabase.beginTransaction();//开启事务
            sqLiteDatabase.delete("student", "id=?", new String[]{"1"});

            sqLiteDatabase.setTransactionSuccessful();//所有操作完成后调用此方法，才会将数据真正保存在数据库

        } catch (Exception e) {
            Log.e(Ch14Activity1.class.toString(), e.toString());
        } finally {
            //使用完毕，将数据库关闭
            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }
    }
    public void modify(View view){
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        try {
            //将插入的数据放置在contentvalues中
            //事务处理
            sqLiteDatabase.beginTransaction();//开启事务
          ContentValues contentValues=new ContentValues();
            contentValues.put("stutel", "12343333222");
            sqLiteDatabase.update("student",contentValues,"id=?",new String[]{"2"});
            sqLiteDatabase.setTransactionSuccessful();//所有操作完成后调用此方法，才会将数据真正保存在数据库

        } catch (Exception e) {
            Log.e(Ch14Activity1.class.toString(), e.toString());
        } finally {
            //使用完毕，将数据库关闭
            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }
    }
}
