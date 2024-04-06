package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 객체를 가져온다.
        Button moveButton = findViewById(R.id.move_button);
        Button rotateButton = findViewById(R.id.rotate_button);
        Button fadeButton = findViewById(R.id.fade_button);
        Button scaleButton = findViewById(R.id.scale_button);
        Button groupButton = findViewById(R.id.group_button);
        Button clickButton = findViewById(R.id.bt1);
        Button nextButton = findViewById(R.id.nextbtn);
        EditText editText = findViewById(R.id.et1);
        TextView title = findViewById(R.id.title);

        clickButton.setOnClickListener(v -> {
            String str = editText.getText().toString();
            title.setText(str);
        });

        nextButton.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("item1","id : shchae822 pw : 1234");
            startActivity(intent);
        });

        // 클릭 리스너를 설정한다.
        moveButton.setOnClickListener(v -> animateButton(v, R.anim.move_animation));
        rotateButton.setOnClickListener(v -> animateButton(v, R.anim.rotate_animation));
        fadeButton.setOnClickListener(v -> animateButton(v, R.anim.fade_animation));
        scaleButton.setOnClickListener(v -> animateButton(v, R.anim.scale_animation));
        groupButton.setOnClickListener(v -> animateButton(v, R.anim.group_animation));
    }

    private void animateButton(View v, int animationResId) {
        Animation animation = AnimationUtils.loadAnimation(this, animationResId);
        v.startAnimation(animation);
    }
}
