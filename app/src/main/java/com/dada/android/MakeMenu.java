package com.dada.android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import static android.widget.Toast.*;

/**
 * Created by asus1 on 2017/11/27.
 */

public class MakeMenu extends AppCompatActivity {
    private EditText et_get, et_id;
    private Button show;
    private RadioGroup radioGroup;
    private RadioButton man, woman;
    private SeekBar seekBar;
    private String type;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shouye);
        initNews();
        setListener();
    }

    public void initNews() {
        et_get = (EditText) findViewById(R.id.et_get);
        show = (Button) findViewById(R.id.button_show);
        man = (RadioButton) findViewById(R.id.rb_man);
        woman = (RadioButton) findViewById(R.id.rb_woman);
        radioGroup = (RadioGroup) findViewById(R.id.rg_sex);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        et_id = (EditText) findViewById(R.id.et_id);
    }

    public void setListener() {
        ButtonListener buttonListener = new ButtonListener();
        show.setOnClickListener(buttonListener);
        RadioGroupButton radioGroupButton = new RadioGroupButton();
        radioGroup.setOnCheckedChangeListener(radioGroupButton);
        SeekBarListener seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);

    }
}

class ButtonListener implements OnClickListener {

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_show:
                Toast.makeText(MainActivity.mainActivity, "show", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

class RadioGroupButton implements OnCheckedChangeListener {

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.rb_man:
                Toast.makeText(MainActivity.mainActivity, "男性", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_woman:
                Toast.makeText(MainActivity.mainActivity, "女性", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

class SeekBarListener implements OnSeekBarChangeListener {

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d("MakeMenu", seekBar.getProgress() + "2333");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.d("MakeMenu", seekBar.getProgress() + "3444");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        Toast.makeText(MainActivity.mainActivity, seekBar.getProgress() + "", LENGTH_SHORT).show();

    }
}

