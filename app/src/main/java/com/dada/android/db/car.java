package com.dada.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by asus1 on 2017/11/23.
 */

public class car extends DataSupport {
    private String cname;
    private String cid;
    private int num;
    private int price;
    private String type;
    public void setCname(String cname){
        this.cname=cname;
    }
    public String getCname(){
        return cname;
    }
    public void setCid(String cid){
        this.cid=cid;
    }
    public String getCid(){
        return cid;
    }
    public void setNumperson(int numperson){
        this.num=numperson;
    }
    public int getNumperson(){
        return num;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }

}
