package com.dada.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dada.android.db.Bmobuser;
import com.dada.android.db.Person;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CountListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity {
    private EditText account;
    private EditText password;
    private Button denglu;
    private Button zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "daca4eedf8c0f12bbdb2143fbb64605b");
        setContentView(R.layout.activity_login);
        account = (EditText) findViewById(R.id.et_account);
        password = (EditText) findViewById(R.id.et_password);
        denglu = (Button) findViewById(R.id.button_denglu);
        zhuce = (Button) findViewById(R.id.button_zhuce);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Zhuce.class);
                startActivity(intent);
            }
        });
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bmobuser denglu=new Bmobuser();
                denglu.setUsername(account.getText().toString());
                denglu.setPassword(password.getText().toString());
                denglu.login(new SaveListener<Person>() {
                    @Override
                    public void done(Person person, BmobException e) {
                        if (e==null){
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            BmobUser use=BmobUser.getCurrentUser();
                            if (use!=null){
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(LoginActivity.this, "不存在该用户，请注册", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Log.d("登录失败",e.getMessage());
                        }
                    }
                });
            }
        });
//        denglu.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View view) {
//                BmobQuery<Person> query = new BmobQuery<>();
//                query.addWhereEqualTo("name", account.getText().toString());
//                query.count(Person.class, new CountListener() {
//                    @Override
//                    public void done(Integer integer, BmobException e) {
//                        if (e == null && integer == 0) {
//                            Toast.makeText(LoginActivity.this, "不存在该用户", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
//                        }
//                    }
//                });
//                query.findObjects(new FindListener<Person>() {
//                    @Override
//                    public void done(List<Person> list, BmobException e) {
//                        if (e == null) {
//                            for (Person person : list) {
//                                if (password.getText().toString().equals(person.getPassword())) {
//                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                } else {
//                                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }
//                    }
//                });
//            }
//        });
//    }
    }
}
