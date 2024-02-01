package com.avl.ahen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class describe_yourself extends AppCompatActivity {

    private Button usrBtn, dsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe_yourself);

        usrBtn = findViewById(R.id.button2);
        dsBtn = findViewById(R.id.button3);

        usrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(describe_yourself.this, user_login.class);
                startActivity(intent);
            }
        });

        dsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(describe_yourself.this, user_login.class);
                startActivity(intent);
            }
        });
    }
}