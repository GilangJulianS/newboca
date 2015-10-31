package com.boca.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.boca.boca.R;

/**
 * Created by yanfa on 9/10/2015.
 */
public class LoginFragment extends Fragment {

    private TextView loginButton;
    private TextView signUpButton;

    public LoginFragment() {}

    public static LoginFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = (TextView) rootView.findViewById(R.id.btn_login);
        signUpButton = (TextView) rootView.findViewById(R.id.btn_signup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = ((AppCompatActivity) getActivity())
                        .getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container, BookingListFragment
                        .newInstance()).commit();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = ((AppCompatActivity) getActivity())
                        .getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container, RegisterFragment
                        .newInstance()).addToBackStack(null).commit();
            }
        });

        return rootView;
    }
}
