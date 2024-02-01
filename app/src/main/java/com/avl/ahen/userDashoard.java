package com.avl.ahen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userDashoard extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;

    private TextView email;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashoard);

        logoutBtn = findViewById(R.id.logoutBtn);
        email = findViewById(R.id.textView3);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if(user == null){
            Intent intent = new Intent(userDashoard.this, describe_yourself.class);
            startActivity(intent);
        }
        else {
            email.setText(user.getEmail());
        }
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(userDashoard.this, "You've logged out !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(userDashoard.this, describe_yourself.class);
                startActivity(intent);
            }
        });
    }
}