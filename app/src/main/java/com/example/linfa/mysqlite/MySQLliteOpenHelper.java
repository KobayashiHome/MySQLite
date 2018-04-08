package com.example.linfa.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by LinFa on 2018/4/8.
 */

public class MySQLliteOpenHelper extends SQLiteOpenHelper {
    private static final String CREATE_COURSE = "create table Course ("+
            "id integer primary key autoincrement,"+
            "name text" +
            "teacher text"+
            "price real) ";

    private static final String CREATE_TEACHER = "create table Teacher ("+
            "id integer primary key autoincrement,"+
            "name text" +
            "age integer"+
            "desc text) ";

    private Context context;

    public MySQLliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COURSE);
        sqLiteDatabase.execSQL(CREATE_TEACHER);
        Toast.makeText(context,"数据库创建成功",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists Course");
        sqLiteDatabase.execSQL("drop table if exists Teacher");

        onCreate(sqLiteDatabase);

    }
}
