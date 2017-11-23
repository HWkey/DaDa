package com.dada.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by asus1 on 2017/11/23.
 */

public class car extends DataSupport {
    private String cname;
    private String cid;
    private int numperson;
    private int price;
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
        this.numperson=numperson;
    }
    public int getNumperson(){
        return numperson;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
}
