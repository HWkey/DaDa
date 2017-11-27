package com.dada.android.db;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;

/**
 * Created by asus1 on 2017/11/26.
 */

public class DingDan extends BmobObject {
    private Integer num;
    private Cark cark;
    private Person person;
    private Integer id;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public void setNum(Integer num) {
        this.num = num;
    }


    public Cark getCark() {
        return cark;
    }

    public void setCark(Cark cark) {
        this.cark = cark;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
