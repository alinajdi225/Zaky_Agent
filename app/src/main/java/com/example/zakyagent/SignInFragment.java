package com.example.zakyagent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SignInFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_signin, container, false);

        // Find and set click listeners for your buttons
        Button button1 = view.findViewById(R.id.button);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);

        View.OnClickListener onClickListener = v -> {
            // Create an Intent to start the target Activity
            Intent intent = new Intent(getActivity(), Activity2.class);

            // You can also pass data to the Activity if needed
            // intent.putExtra("key", "value");

            // Start the Activity
            startActivity(intent);
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

        return view;
    }

}