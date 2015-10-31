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

import com.boca.boca.R;

import org.w3c.dom.Text;

/**
 * Created by yanfa on 9/20/2015.
 */
public class PaymentFragment extends Fragment {

	private Toolbar toolbar;
	private TextView payMyselfButton;
	private TextView payGroupButton;

    public PaymentFragment() {}

    public static PaymentFragment newInstance(){
        PaymentFragment fragment = new PaymentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_payment, container, false);
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.header_logo);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
		payMyselfButton = (TextView) v.findViewById(R.id.btn_pay_myself);
		payMyselfButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager manager = getActivity().getSupportFragmentManager();
				manager.beginTransaction().replace(R.id.container, ConfirmationFragment
						.newInstance()).addToBackStack(null).commit();
			}
		});
		payGroupButton = (TextView) v.findViewById(R.id.btn_pay_group);
		payGroupButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager manager = getActivity().getSupportFragmentManager();
				manager.beginTransaction().replace(R.id.container, InviteFriendsFragment
						.newInstance()).addToBackStack(null).commit();
			}
		});
        return v;
    }
}
