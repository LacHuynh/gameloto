package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
EditText mET1 , mET2;
Button mBT1 , mBT2, mBT3;
Random mrandom = new Random();
ArrayList<Integer> mMangNumber= new ArrayList<>();
String mRM = "";
TextView mTV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inter();
        mBT2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String S1 = mET1.getText().toString();
                String S2 = mET2.getText().toString();
                String T1 = "Các bạn không được bỏ trống";
                String T3 = "Nhập ĐỦ GIÁ TRỊ";
                if (S1.isEmpty() && S2.isEmpty()){
                    Toast.makeText(MainActivity.this, T1, Toast.LENGTH_SHORT).show();
                }if(S1.isEmpty() || S2.isEmpty()){
                    Toast.makeText(MainActivity.this,T3, Toast.LENGTH_SHORT).show();
                }else {
                    int I1 = Integer.parseInt(S1);
                    int I2 = Integer.parseInt(S2);
                    if(I1 < 100 && I2 <=100){
                        if(I2 <= I1){
                            int N1 = 1;
                            I2 = I1 + N1 ;
                        }
                    }else {
                        I1 = 99;
                        I2 = 100;
                    }
                    mET1.setText(I1 + "");
                    mET2.setText(I2 + "");
                    if (mMangNumber != null){
                        if (mMangNumber.size()>0)
                            mMangNumber.clear();
                        for (int x = I1; x <= I2;x++){
                            mMangNumber.add(x);
                        }
                        Toast.makeText(MainActivity.this, mMangNumber.size()+"", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mBT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                if(mMangNumber.size()>0){
                    String call = mTV1.getText().toString();
                    String call1 = "game over";
                    if(!call.isEmpty()){
                        int x1 = mrandom.nextInt(mMangNumber.size());
                        int x2 = mMangNumber.get(x1);

                        if (mMangNumber.size()==1){
                            mRM += x2;
                        }
                        else {
                            mRM += x2 + "-";
                        }
                        mMangNumber.remove(x1);
                        mTV1.setText(mRM);
                    }
                    else if(call==""){
                        mTV1.setText(call1);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S3 = mTV1.getText().toString();
                if (S3 != null){
                    String S4 = "0";
                    int I3 = S3.length();
                    String S5 = S3.substring(0,I3);
                    String S6 = S3.replaceAll(S5,S4);
                    if (!S6.isEmpty()) {
                        String S7 = "";
                        mTV1.setText(S7);
                        return;
                    }
                }
            }
        }
        );
    }
    private void Inter() {
        mBT1 = findViewById(R.id.BT1);
        mBT2 = findViewById(R.id.BT2);
        mET1 = findViewById(R.id.ET1);
        mET2 = findViewById(R.id.ET2);
        mTV1 = findViewById(R.id.TV1);
        mBT3 = findViewById(R.id.BT3);
    }
}

