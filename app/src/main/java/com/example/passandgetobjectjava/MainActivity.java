package com.example.passandgetobjectjava;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.passandgetobjectjava.model.Member;
import com.example.passandgetobjectjava.model.User;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }
    void initviews(){
        text = findViewById(R.id.text);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(22,"Po'lat");
                openSecondActivity(user);
            }
        });
    }

    ActivityResultLauncher<Intent> secondLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        Member member = data.getParcelableExtra("member");
                        text.setText(member.toString());
                    }
                }
            }
    );

    void openSecondActivity(User user){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", user);
        secondLauncher.launch(intent);
    }
}