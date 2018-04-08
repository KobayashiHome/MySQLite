package com.example.linfa.mysqlite;
/**
 * @date 2018/4/8
 * @author skylinelin
 */

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mSave;
    private SQLiteOpenHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }

    private void initViews() {
        mSave = findViewById(R.id.btn_save);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //最后的版本号涉及到数据库的升级，
                // 版本号更改则会调用 MySQLliteOpenHelper 里面的 onUpgrade方法；
                mHelper = new MySQLliteOpenHelper(MainActivity.this,"skylinelin",null,2);
                mHelper.getWritableDatabase();
            }
        });
    }
}
