package com.example.zakyagent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private static final String ARG_USERNAME = "username";
    private static final String STATE_USERNAME = "state_username";

    private String username;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String username) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);
        return fragment;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check for saved instance state first
        if (savedInstanceState != null) {
            username = savedInstanceState.getString(STATE_USERNAME);
        } else if (getArguments() != null) {
            // If there's no saved instance state, check if there are arguments
            username = getArguments().getString(ARG_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        // Find textView10 and set the username text
        TextView textView10 = view.findViewById(R.id.textView10);
        if (textView10 != null) {
            textView10.setText("Hello   " + username);
        }


        return view;
    }




}