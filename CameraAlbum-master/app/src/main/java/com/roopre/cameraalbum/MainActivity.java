package com.roopre.cameraalbum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 로그용 TAG 변수
    String TAG = getClass().getSimpleName();

    // Camera 버튼
    Button camera_button;

    // 결과물을 보여줄 ImageView
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯들 초기화
        camera_button = findViewById(R.id.camera_button);
        imageview = findViewById(R.id.imageview);

        // 카메라 버튼에 클릭 이벤트 추가
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ImagePicker 호출
                Intent chooseImageIntent = ImagePicker.getPickImageIntent(MainActivity.this);
                startActivityForResult(chooseImageIntent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {

                //ImagePc
                case 1:
                    Log.d(TAG, "이미지 불러옴");
                    if (requestCode == 1 && resultCode == RESULT_OK) {
                        Log.d(TAG, "이미지 bitmap 에 저장");
                        Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
                        imageview.setImageBitmap(bitmap);
                    } else {
                        Log.d(TAG, "이미지 없음");
                    }
                    break;
                default:
                    super.onActivityResult(requestCode, resultCode, data);
                    break;
            }
        }

    }
}
