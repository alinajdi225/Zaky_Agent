package com.example.zakyagent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2000; // 2 seconds

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Use a Handler to delay the transition to the main activity
        new Handler().postDelayed(() -> {
            // Start the main activity
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);

            // Close the splash screen activity
            finish();
        }, SPLASH_TIMEOUT);
    }
}