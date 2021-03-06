package com.boca.boca;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilang on 17/09/2015.
 */
public class BookingListFragment extends Fragment {

	private Toolbar toolbar;
	private TextView btnBook;
	private TextView btnTopup;

	public BookingListFragment(){}

	public static BookingListFragment newInstance(){
		BookingListFragment fragment = new BookingListFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		setHasOptionsMenu(true);
		View v = inflater.inflate(R.layout.fragment_book_list, parent, false);
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.header_logo);
		ViewGroup container = (ViewGroup) v.findViewById(R.id.list_container);
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
		btnBook = (TextView) v.findViewById(R.id.btn_book);
		btnBook.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager manager = getActivity().getSupportFragmentManager();
				manager.beginTransaction().replace(R.id.container, BookingFragment.newInstance())
						.addToBackStack("home").commit();
			}
		});
		btnTopup = (TextView) v.findViewById(R.id.btn_topup);
		btnTopup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});


		final int size = 10;
		final List<ViewGroup> hiddenLayouts = new ArrayList<>();
		final List<ImageView> expandButtons = new ArrayList<>();
		for(int i=0; i<size; i++){
			View item = inflater.inflate(R.layout.item_book_list, container, false);
			CardView card = (CardView) item.findViewById(R.id.card);
			ViewGroup detailView = (ViewGroup) card.findViewById(R.id.detail_view);
			hiddenLayouts.add(detailView);
			ImageView expandButton = (ImageView) card.findViewById(R.id.icon_indicator);

			expandButtons.add(expandButton);
			final int id = i;
			card.setOnClickListener(new View.OnClickListener() {
				int listenerid = id;
				@Override
				public void onClick(View v) {
					ViewGroup view = (ViewGroup) v.findViewById(R.id.detail_view);
					if(view.getVisibility() == View.VISIBLE){ // visible
						view.setVisibility(View.GONE);
						expandButtons.get(listenerid).setRotation(180);
					}else{ //invisible
						view.setVisibility(View.VISIBLE);
						expandButtons.get(listenerid).setRotation(0);
						for(int j=0; j<size; j++){
							if(j != listenerid){
								hiddenLayouts.get(j).setVisibility(View.GONE);
								expandButtons.get(j).setRotation(180);
							}
						}
					}
				}
			});
			container.addView(item);
		}
		return v;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.main, menu);

		super.onCreateOptionsMenu(menu, inflater);
	}
}
