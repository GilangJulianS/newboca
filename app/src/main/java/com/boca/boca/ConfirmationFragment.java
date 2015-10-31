package com.boca.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.boca.boca.R;

/**
 * Created by yanfa on 9/20/2015.
 */
public class ConfirmationFragment extends Fragment {

	private Toolbar toolbar;
	private TextView confirmButton;

    public ConfirmationFragment() {}

    public static ConfirmationFragment newInstance(){
        ConfirmationFragment fragment = new ConfirmationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_confirmation, container, false);
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.header_logo);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
		confirmButton = (TextView) v.findViewById(R.id.btn_confirm);
		confirmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Field successfully booked!", Toast.LENGTH_SHORT).show();
				FragmentManager manager = getActivity().getSupportFragmentManager();
				manager.popBackStack("home", FragmentManager.POP_BACK_STACK_INCLUSIVE);
			}
		});
        return v;
    }
}