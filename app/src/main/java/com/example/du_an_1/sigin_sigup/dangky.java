package com.example.du_an_1.sigin_sigup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_1.Dao.KhachhangDao;
import com.example.du_an_1.Model.Khachhang;
import com.example.du_an_1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;

public class dangky extends AppCompatActivity {
TextInputEditText eduser,edmk,edmk2,edname,eddiachi,edsdt;
Button btok;
TextView textView;
ImageView imageView;
KhachhangDao khachhangdao;
int o=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        eduser=findViewById(R.id.user);
        edmk=findViewById(R.id.edmk);
        edmk2=findViewById(R.id.edmk2);
        edname=findViewById(R.id.edname);
        textView=findViewById(R.id.dangnhap);
        imageView=findViewById(R.id.imageView11);
        eddiachi=findViewById(R.id.ediachi);

        btok=findViewById(R.id.button3);

        khachhangdao=new KhachhangDao(dangky.this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangky.this, login.class);
                startActivity(intent);
                finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangky.this, login.class);
                startActivity(intent);
                finish();
            }
        });
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edname.getText().length()==0||eddiachi.getText().length()==0||edmk.getText().length()==0||edmk2.getText().length()==0||eduser.getText().length()==0){
                    Toast.makeText(dangky.this, "bạn bắt buộc phải nhập đủ tất cả trường dữ liệu", Toast.LENGTH_SHORT).show();
                }else{
                    if(!edmk.getText().toString().equals(edmk2.getText().toString())){
                        Toast.makeText(dangky.this, "mật khẩu nhập lại không trùng khớp", Toast.LENGTH_SHORT).show();
                    }else{
                        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
                        Khachhang khachhang=new Khachhang();
                        khachhang.name=edname.getText().toString();
                        khachhang.mk=edmk.getText().toString();
                        khachhang.phone=eduser.getText().toString();
                        khachhang.address=eddiachi.getText().toString();
                        khachhangdao.insert(khachhang);
                        o++;
                        Toast.makeText(dangky.this, "gia tri la "+o, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}