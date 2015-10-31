package com.boca.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.boca.boca.R;

import org.w3c.dom.Text;

/**
 * Created by yanfa on 9/20/2015.
 */
public class RegisterFragment extends Fragment {

    private TextView signUpButton;
    private Toolbar toolbar;

    public RegisterFragment() {}

    public static RegisterFragment newInstance(){
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.header_logo);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        signUpButton = (TextView)v.findViewById(R.id.btn_signup);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kirim data
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.popBackStack();
            }
        });

        return v;
    }
}