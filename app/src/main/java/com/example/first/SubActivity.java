package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //View 정의
        TextView id = findViewById(R.id.text_id);
        TextView pw = findViewById(R.id.text_pw);
        Button btn = findViewById(R.id.nextbtn);
        Button btn_toast = findViewById(R.id.btn_toast);

        //인텐트 값을 받아옴
        Intent intent = getIntent();
        String str = intent.getStringExtra("item1");
        String args[] = str.split(" ");

        //토스트 보기
        btn_toast.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
        });

        //View에 글씨를 변경함.
        id.setText("id : " + args[2]);
        pw.setText("pw : " + args[5]);

        //되돌아가기 버튼 활성화
        btn.setOnClickListener(v->{
            Intent intent2 = new Intent(SubActivity.this, MainActivity.class);
            startActivity(intent2);
        });
    }
}