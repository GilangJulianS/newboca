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

/**
 * Created by yanfa on 9/20/2015.
 */
public class InviteFriendsFragment extends Fragment {

	private TextView inviteButton;
	private Toolbar toolbar;

    public InviteFriendsFragment() {}

    public static InviteFriendsFragment newInstance(){
        InviteFriendsFragment fragment = new InviteFriendsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_invite_friends, container, false);
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.header_logo);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
		inviteButton = (TextView) v.findViewById(R.id.btn_invite);
		inviteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager manager = getActivity().getSupportFragmentManager();
				manager.beginTransaction().replace(R.id.container, ConfirmationFragment
						.newInstance()).addToBackStack(null).commit();
			}
		});
        return v;
    }
}
