package com.boca.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gilang on 19/09/2015.
 */
public class NotificationFragment extends Fragment {

	private Toolbar toolbar;

	public NotificationFragment(){}

	public static NotificationFragment newInstance(){
		NotificationFragment fragment = new NotificationFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_notification, parent, false);

		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.header_logo);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
		((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		ViewGroup invitationContainer = (ViewGroup) v.findViewById(R.id.invitation_container);
		ViewGroup updatesContainer = (ViewGroup) v.findViewById(R.id.updates_container);

		for(int i=0; i<3; i++){
			View inviteItem = inflater.inflate(R.layout.item_invitation, parent, false);
			View updateItem = inflater.inflate(R.layout.item_updates, parent, false);
			ViewGroup hideView, hideView2, showView, showView2;
			if(i%2 == 0){
				hideView = (ViewGroup) inviteItem.findViewById(R.id.info_accepted);
				hideView2 = (ViewGroup) inviteItem.findViewById(R.id.group_accepted);
				showView = (ViewGroup) inviteItem.findViewById(R.id.info_unaccepted);
				showView2 = (ViewGroup) inviteItem.findViewById(R.id.group_unaccepted);
			}else{
				showView = (ViewGroup) inviteItem.findViewById(R.id.info_accepted);
				showView2 = (ViewGroup) inviteItem.findViewById(R.id.group_accepted);
				hideView = (ViewGroup) inviteItem.findViewById(R.id.info_unaccepted);
				hideView2 = (ViewGroup) inviteItem.findViewById(R.id.group_unaccepted);
			}
			hideView.setVisibility(View.GONE);
			hideView2.setVisibility(View.GONE);
			showView.setVisibility(View.VISIBLE);
			showView2.setVisibility(View.VISIBLE);
			invitationContainer.addView(inviteItem);
			updatesContainer.addView(updateItem);
		}

		return v;
	}
}
