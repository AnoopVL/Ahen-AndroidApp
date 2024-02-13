package com.avl.ahen;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private TextView email;

    private TextView userName;
    private Button logoutBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment
        logoutBtn = view.findViewById(R.id.logoutBtn);
//        email = view.findViewById(R.id.textView3);
        userName = view.findViewById(R.id.userName);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if(user == null){
            Intent intent = new Intent(getActivity(), describe_yourself.class);
            // If you need to pass data to the activity, use intent extras
            intent.putExtra("key", "value");
            // Start the activity
            startActivity(intent);
//            Intent intent = new Intent(ProfileFragment.this, describe_yourself.class);
//            startActivity(intent);
        }
        else {
//            email.setText(user.getEmail());
//            userName.setText("Hey, "+"user");
            Bundle args = getArguments();
            if (args != null && args.containsKey("userName")) {
                String userNameText = args.getString("userName");
                userName.setText("Hey, " + userNameText);
            }
        }
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
//                Toast.makeText(ProfileFragment.this, "You've logged out !", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "You've logged out !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), describe_yourself.class);
                startActivity(intent);
            }
        });

//        return inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }
}