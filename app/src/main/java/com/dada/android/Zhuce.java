package com.dada.android;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dada.android.db.Person;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static android.widget.RadioGroup.*;

public class Zhuce extends AppCompatActivity {
    private Person person;
    private EditText et_name, et_phone, et_id, et_getPassword1, et_getPassword2;
    private RadioGroup sex;
    private RadioButton man,woman;
    private Button button_send;
    String sex1 = "男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "daca4eedf8c0f12bbdb2143fbb64605b");
        setContentView(R.layout.activity_zhuce);
        initNews();
        person = new Person();
        button_send = (Button) findViewById(R.id.button_send);

        sex = (RadioGroup) findViewById(R.id.rg_sex);
        man=(RadioButton)findViewById(R.id.rb_man);
        woman=(RadioButton)findViewById(R.id.rb_woman);
        sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                                           @Override
                                           public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                                               switch (i) {
                                                   case R.id.rb_man:
                                                       sex1 = "男";
                                                       break;
                                                   case R.id.rb_woman:
                                                       sex1 = "女";
                                                       break;

                                               }
                                           }
                                       });
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_getPassword1.getText().toString().equals(et_getPassword2.getText().toString())) {
                    if (et_name.getText().toString() != null && et_id.getText().toString() != null && et_phone
                            .getText().toString() != null && sex1 != null) {
                        person.setName(et_name.getText().toString());
                        person.setId(et_id.getText().toString());
                        person.setPhone(et_phone.getText().toString());
                        person.setSex(sex1);
                        person.setPassword(et_getPassword1.getText().toString());
                        person.save(new SaveListener<String>() {
                                        @Override
                                        public void done(String s, BmobException e) {
                                            if (e == null) {
                                                Toast.makeText(Zhuce.this, "创建数据成功", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                                            }
                                        }
                                    }
                        );
                    } else {
                        Toast.makeText(Zhuce.this, "有重要信息未填，请输入重试", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Zhuce.this, "前后密码不一致。请重新输入", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public void initNews() {
        et_id = (EditText) findViewById(R.id.et_id);
        et_name = (EditText) findViewById(R.id.et_getName);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_getPassword1 = (EditText) findViewById(R.id.et_getPassword1);
        et_getPassword2 = (EditText) findViewById(R.id.et_getPassword2);
    }
}

