package com.haier.jiuzhidao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daotest.dao.DaoMaster;
import com.daotest.dao.DaoSession;
import com.haier.jiuzhidao.myapplication.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 本地
         */
        Local();

        /**
         * 数据库
         * greendao
         */
        GreenDao();

    }

    private void GreenDao() {
        Student student = new Student();
        student.setAge(1);
        student.setName("1");
        student.setNum("1");
        student.setId(1l);

        DbManager.getInstance(this);
        //增
//        StudentDaoOpe.insertData();
        //删
//        StudentDaoOpe.deleteData();
        //改
//          StudentDaoOpe.updateData();
        //查
//        StudentDaoOpe.queryAll()
    }

    private void Local() {
        SaveLocalUtil<List<String>> listSaveLocalUtil = new SaveLocalUtil<>(this, "1");
        //        save
        ArrayList<String> str = new ArrayList<>();
        listSaveLocalUtil.save("1", str);
//        get
        List<String> strings = listSaveLocalUtil.get("1");

    }
}
