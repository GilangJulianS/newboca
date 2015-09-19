package com.boca.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gilang on 17/09/2015.
 */
public class BookingListFragment extends Fragment {

	private Toolbar toolbar;

	public BookingListFragment(){}

	public static BookingListFragment newInstance(){
		BookingListFragment fragment = new BookingListFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_book_list, parent, false);
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		ViewGroup container = (ViewGroup) v.findViewById(R.id.list_container);
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

		for(int i=0; i<10; i++){
			View item = inflater.inflate(R.layout.item_book_list, container, false);
			CardView card = (CardView) item.findViewById(R.id.card);
			card.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					ViewGroup view = (ViewGroup) v.findViewById(R.id.detail_view);
					if(view.getVisibility() == View.VISIBLE){
						view.setVisibility(View.GONE);
					}else{
						view.setVisibility(View.VISIBLE);
					}
				}
			});
			container.addView(item);
		}
		return v;
	}
}
