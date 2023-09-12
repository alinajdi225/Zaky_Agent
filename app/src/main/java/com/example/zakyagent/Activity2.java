package com.example.zakyagent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class Activity2 extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView textView9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        signInButton = findViewById(R.id.button3);
        textView9 = findViewById(R.id.textView9);

        // Add TextWatchers to both EditText fields
        usernameEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        // Add an OnClickListener to the Sign In button
        signInButton.setOnClickListener(v -> {
            // Get the username text
            String username = usernameEditText.getText().toString();

            // Create an intent to start Activity3
            Intent intent = new Intent(Activity2.this, Activity3.class);

            // Pass the username as an extra
            intent.putExtra("username", username);

            // Start Activity3
            startActivity(intent);
        });

    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Check if there's text in both username and password fields
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                // Enable the Sign In button and change its background color to enabled state
                signInButton.setEnabled(true);
                signInButton.setTextColor(getResources().getColor(R.color.white));
                signInButton.setBackgroundResource(R.drawable.button_enabled); // Use the enabled background
                textView9.setVisibility(TextView.INVISIBLE); // Make textView9 invisible
            } else {
                // Disable the Sign In button and revert its background color to disabled state
                signInButton.setEnabled(false);
                signInButton.setTextColor(getResources().getColor(R.color.signin));
                signInButton.setBackgroundResource(R.drawable.button_disabled); // Use the disabled background
                textView9.setVisibility(TextView.VISIBLE); // Make textView9 visible
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
