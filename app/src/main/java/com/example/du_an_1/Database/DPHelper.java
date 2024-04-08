package com.example.du_an_1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DPHelper extends SQLiteOpenHelper {
    public DPHelper(@Nullable Context context) {

        super(context, "bang", null, 37);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String t="CREATE TABLE KHACHHANG(maKH INTEGER PRIMARY KEY AUTOINCREMENT,hoTen TEXT NOT NULL,diaChi TEXT NOT NULL,soDT TEXT NOT NULL, matKhau TEXT NOT NULL,TRANGTHAI INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(t);

        String tt="CREATE TABLE ADMIN(maAD INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT NOT NULL,hoTen TEXT NOT NULL,diaChi TEXT NOT NULL,soDT TEXT NOT NULL,matKhau TEXT NOT NULL ,EMAIL TEXT NOT NULL)";
        sqLiteDatabase.execSQL(tt);
        String tt1="INSERT INTO ADMIN(maAD,USERNAME,hoTen,diaChi,soDT,matKhau,EMAIL) VALUES (1,'admin01','NGUYEN VAN ADMIN','VIETNAM','0912345678','admin1','admin@gmail.com')";
        sqLiteDatabase.execSQL(tt1);

        String ttt="CREATE TABLE LOAISANPHAM(maLoai INTEGER PRIMARY KEY AUTOINCREMENT,tenLoai TEXT NOT NULL,TRANGTHAI INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(ttt);

        String tttt="CREATE TABLE SANPHAM(maSP INTEGER PRIMARY KEY AUTOINCREMENT,tenSP TEXT NOT NULL,giaSP INTEGER NOT NULL,thongTin TEXT NOT NULL,maLoai INTEGER REFERENCES LOAISANPHAM(maLoai),SOLUONG INTEGER NOT NULL,TRANGTHAI INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(tttt);

        String ttttt="CREATE TABLE GIOHANG(maGH INTEGER PRIMARY KEY AUTOINCREMENT ,maKH INTEGER REFERENCES KHACHHANG(maKH),maSP INTEGER REFERENCES SANPHAM(maSP),SOLUONG INTEGER NOT NULL,TRANGTHAI INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(ttttt);

        String tttttt="CREATE TABLE DONHANG(MADH INTEGER PRIMARY KEY AUTOINCREMENT,maGH INTEGER REFERENCES GIOHANG(maGH),TONGGIA INTEGER NOT NULL,NGAY DATE NOT NULL,TRANGTHAI INTEGER NOT NULL,SDT TEXT NOT  NULL,PHUONGTHUC INTEGER NOT NULL,DIACHI TEXT NOT NULL,THANHTOAN INTEGER NOT NULL,TEN TEXT NOT NULL)";
        sqLiteDatabase.execSQL(tttttt);

        String ttttttt="CREATE TABLE DANHGIA(MADG INTEGER PRIMARY KEY AUTOINCREMENT,maSP INTEGER REFERENCES SANPHAM(maSP),maKH INTEGER REFERENCES KHACHHANG(maKH),NOIDUNG TEXT NOT NULL,NGAYTAO DATE NOT NULL)";
        sqLiteDatabase.execSQL(ttttttt);

//        String tttttttt="CREATE TABLE VOCHER(MAVOCHER INTEGER PRIMARY KEY AUTOINCREMENT,NOIDUNG TEXT NOT NULL,NGAYTAO DATE NOT NULL)";
//        sqLiteDatabase.execSQL(tttttttt);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
           if(i!=i1){
              sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHACHHANG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ADMIN");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAISANPHAM");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SANPHAM");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DONHANG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GIOHANG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DANHGIA");
               onCreate(sqLiteDatabase);
           }
    }
}
