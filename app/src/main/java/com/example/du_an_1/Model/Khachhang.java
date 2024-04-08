package com.example.du_an_1.Model;

import java.util.Date;

public class Khachhang {
    public int makh;

    public String name;
    public String address;
    public String mk;
    public String phone;
    public int trangthai;
    public Khachhang() {
    }

    public Khachhang(int makh,  String name, String address, String mk,String phone,int trangthai) {
        this.makh = makh;
        this.name = name;
        this.address = address;
        this.mk = mk;
        this.phone = phone;
        this.trangthai=trangthai;
    }

}
