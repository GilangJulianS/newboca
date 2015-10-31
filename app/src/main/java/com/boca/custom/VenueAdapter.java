package com.boca.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.boca.boca.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilang on 25/09/2015.
 */
public class VenueAdapter extends ArrayAdapter<Venue>{

	private List<Venue> allvenues;
	private List<Venue> venues;
	private List<Venue> suggestions;
	private int resId;

	public VenueAdapter(Context context, int resource, List<Venue> objects) {
		super(context, resource, objects);
		venues = objects;
		allvenues = new ArrayList<>();
		allvenues.addAll(venues);
		resId = resource;
		suggestions = new ArrayList<>();
	}

	public List<Venue> getVenues(){
		return allvenues;
	}

	@Override
	public int getCount() {
		return venues.size();
	}

	@Override
	public Venue getItem(int position) {
		return venues.get(position);
	}

	@Override
	public long getItemId(int position) {
		return allvenues.indexOf(venues.get(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context
					.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(resId, null);
		}
		Venue venue = venues.get(position);
		TextView nama = (TextView) v.findViewById(R.id.text_name);
		TextView alamat = (TextView) v.findViewById(R.id.text_address);
		TextView info = (TextView) v.findViewById(R.id.text_info);
		nama.setText(venue.name);
		alamat.setText(venue.address);
		info.setText(venue.info);
		return v;
	}

	@Override
	public Filter getFilter() {
		return nameFilter;
	}

	Filter nameFilter = new Filter() {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			if (constraint != null) {
				suggestions.clear();
				for (Venue venue : allvenues) {
					if (venue.name.toLowerCase()
							.startsWith(constraint.toString().toLowerCase()) || constraint.equals("")) {
						suggestions.add(venue);
					}
				}
				FilterResults filterResults = new FilterResults();
				filterResults.values = suggestions;
				filterResults.count = suggestions.size();
				return filterResults;
			} else {
				FilterResults filterResults = new FilterResults();
				filterResults.values = allvenues;
				filterResults.count = allvenues.size();
				return filterResults;
			}
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			ArrayList<Venue> filteredList = (ArrayList<Venue>) results.values;
			if (results != null && results.count > 0) {
				clear();
				for (Venue c : filteredList) {
					add(c);
				}
				notifyDataSetChanged();
			}else{

			}
		}
	};
}
