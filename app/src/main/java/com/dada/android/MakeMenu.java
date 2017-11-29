package com.dada.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.dada.android.db.Cark;

import java.io.File;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static android.widget.Toast.*;

/**
 * Created by asus1 on 2017/11/27.
 */

public class MakeMenu extends AppCompatActivity{
    private Button show;
    private SeekBar seekBar;
    private String type;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shouye);
        initNews();
        setListener();
        BmobQuery<Cark>query=new BmobQuery();
        query.findObjects(new FindListener<Cark>() {
            @Override
            public void done(List<Cark> list, BmobException e) {
                if (e==null){
                    for (Cark cark:list){
                    }
                }
            }
        });
    }

    public void initNews() {
        show = (Button) findViewById(R.id.button_show);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
    }

    public void setListener() {
        ButtonListener buttonListener = new ButtonListener();
        show.setOnClickListener(buttonListener);
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

