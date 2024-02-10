package com.avl.ahen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.avl.ahen.databinding.ActivityUserDashboardBinding;
public class userDashboard extends AppCompatActivity {

    ActivityUserDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_dashboard);
        binding = ActivityUserDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home_nav) {
                // Replace with your home fragment
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.search_nav) {
                // Replace with your search fragment
                replaceFragment(new SearchFragment());
            } else if (itemId == R.id.apply_nav) {
                // Replace with your license fragment
                replaceFragment(new ApplyFragment());
            } else if (itemId == R.id.profile_nav) {
                // Replace with your profile fragment
                replaceFragment(new ProfileFragment());
            }
//            switch (item.getItemId()) {
//                case R.id.home_nav:
//                    // Replace with your home fragment
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.search_nav:
//                    // Replace with your search fragment
//                    replaceFragment(new SearchFragment());
//                    break;
//                case R.id.apply_nav:
//                    // Replace with your license fragment
//                    replaceFragment(new ApplyFragment());
//                    break;
//                case R.id.profile_nav:
//                    // Replace with your profile fragment
//                    replaceFragment(new ProfileFragment());
//                    break;
//            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}