package com.avl.ahen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class user_signUp extends AppCompatActivity {
    private Button signup;
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        signup = findViewById(R.id.userSignUpBtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_signUp.this, user_login.class);
                Toast.makeText(user_signUp.this, "Account Created !", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        login = findViewById(R.id.alrdLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_signUp.this, user_login.class);
                startActivity(intent);
            }
        });
    }

}