package com.example.passandgetobjectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.passandgetobjectjava.model.Member;
import com.example.passandgetobjectjava.model.User;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initviews();
    }
    void initviews(){
        TextView text = findViewById(R.id.text);
        User user = getIntent().getParcelableExtra("user");
        text.setText(user.toString());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member("Click","junior");
                backToMainActivity(member);
            }
        });
    }
    void backToMainActivity(Member member){
        Intent intent = new Intent();
        intent.putExtra("member",member);
        setResult(RESULT_OK,intent);
        finish();
    }
}