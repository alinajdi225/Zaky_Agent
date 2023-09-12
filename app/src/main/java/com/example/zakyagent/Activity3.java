package com.example.zakyagent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import android.widget.FrameLayout;
import android.widget.ImageView;

public class Activity3 extends AppCompatActivity {

    private final int[] unselectedIcons = {
            R.drawable.home,
            R.drawable.wallet,
            R.drawable.activity,
            R.drawable.report,
            R.drawable.profile
    };

    private final int[] selectedIcons = {
            R.drawable.home_selected,
            R.drawable.wallet_selected,
            R.drawable.activity_selected,
            R.drawable.report_selected,
            R.drawable.profile_selected
    };

    private ImageView[] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Retrieve the username from the intent extra
        String username = getIntent().getStringExtra("username");

        // Find the FrameLayouts and ImageViews
        FrameLayout[] frameLayouts = new FrameLayout[]{
                findViewById(R.id.imageViewContainer1),
                findViewById(R.id.imageViewContainer2),
                findViewById(R.id.imageViewContainer3),
                findViewById(R.id.imageViewContainer4),
                findViewById(R.id.imageViewContainer5)
        };

        imageViews = new ImageView[] {
                findViewById(R.id.imageView3),
                findViewById(R.id.imageView4),
                findViewById(R.id.imageView5),
                findViewById(R.id.imageView6),
                findViewById(R.id.imageView7)
        };

        // Check if the HomeFragment is already added
        if (savedInstanceState == null) {
            loadFragment(HomeFragment.newInstance(username), 0);
        }

        // Set click listeners for FrameLayouts
        for (int i = 0; i < frameLayouts.length; i++) {
            final int index = i;
            frameLayouts[i].setOnClickListener(v -> loadFragment(newFragmentInstance(index), index));
        }
    }

    private void loadFragment(Fragment fragment, int selectedIndex) {
        String username = getIntent().getStringExtra("username");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container, fragment);
        if (selectedIndex != 0) {
            transaction.addToBackStack(null);
        }
        transaction.commit();

        updateIcons(selectedIndex);
    }

    private Fragment newFragmentInstance(int index) {
        switch (index) {
            case 0:
                return new HomeFragment();
            case 1:
                return new WalletFragment();
            case 2:
                return new ActivityFragment();
            case 3:
                return new ReportFragment();
            case 4:
                return new ProfileFragment();
            default:
                return null;
        }
    }

    private void updateIcons(int selectedIndex) {
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImageResource(i == selectedIndex ? selectedIcons[i] : unselectedIcons[i]);
        }
    }
}