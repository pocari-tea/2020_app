package com.roopre.glideexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView main_iv;
    EditText url_et;
    Button action_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_iv = findViewById(R.id.main_iv);
        url_et = findViewById(R.id.url_et);
        action_btn = findViewById(R.id.action_btn);

        action_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Patterns.WEB_URL.matcher(url_et.getText().toString()).matches()){
                 // 이미지를 불러오고
                    Glide.with(MainActivity.this).load(url_et.getText().toString()).placeholder(R.mipmap.ic_launcher).into(main_iv);

                }else
                {
                    // 에러메시지 출력
                    Toast.makeText(MainActivity.this, "URL이 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
