package com.example.du_an_1.Model;

public class Sanpham {
    public int masp;
    public String tensp;
    public int maloai;
    public String mota;
    public int gia;
    public int soluong;
    public int trangthai;

    public Sanpham(int masp, String tensp, int maloai, String mota, int gia, int soluong,int trangthai) {
        this.masp = masp;
        this.tensp = tensp;
        this.maloai = maloai;
        this.mota = mota;
        this.gia = gia;
        this.soluong = soluong;
        this.trangthai=trangthai;
    }

    public Sanpham() {
    }
}
