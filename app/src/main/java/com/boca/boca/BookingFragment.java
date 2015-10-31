package com.boca.boca;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.boca.custom.Venue;
import com.boca.custom.VenueAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfa on 9/20/2015.
 */
public class BookingFragment extends Fragment {

    private AutoCompleteTextView formVenue;
    private List<Venue> allvenues;
	private Toolbar toolbar;
	private ViewGroup venueInfo;
	private ViewGroup hoursInfo;
	private Spinner spinner;
	private TextView bookButton;

    public BookingFragment() {}

    public static BookingFragment newInstance(){
        BookingFragment fragment = new BookingFragment();
        fragment.allvenues = new ArrayList<>();
        fragment.debugMode();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        final View v = inflater.inflate(R.layout.fragment_booking, container, false);
		spinner = (Spinner) v.findViewById(R.id.spinner_fields);
		String[] dummy = {"Select field"};
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout
				.item_spinner, R.id.spinner_text, dummy);
		spinner.setAdapter(spinnerAdapter);
		venueInfo = (ViewGroup) v.findViewById(R.id.venue_info);
		hoursInfo = (ViewGroup) v.findViewById(R.id.hours_info);
        formVenue = (AutoCompleteTextView) v.findViewById(R.id.form_venue);
		final VenueAdapter adapter = new VenueAdapter(getActivity(), R.layout.autocomplete_item,
                allvenues);
        formVenue.setAdapter(adapter);
		formVenue.setThreshold(1);
		formVenue.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				formVenue.showDropDown();
				return false;
			}
		});
		formVenue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				List<Venue> venues = adapter.getVenues();
				Venue selectedVenue = venues.get((int) id);
				formVenue.setText(selectedVenue.name);
				venueInfo.setVisibility(View.VISIBLE);
				hoursInfo.setVisibility(View.VISIBLE);
				TextView phone = (TextView) v.findViewById(R.id.text_phone);
				TextView address = (TextView) v.findViewById(R.id.text_address);
				TextView info = (TextView) v.findViewById(R.id.text_info);
				phone.setText(selectedVenue.phone);
				address.setText(selectedVenue.address);
				info.setText(selectedVenue.info);
				String[] spinnerItems = {"Lapangan I", "Lapangan II", "Lapangan III"};
				ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(getActivity(),
						R.layout.item_spinner, R.id.spinner_text, spinnerItems);
				spinner.setAdapter(spinnerAdapter2);
				InputMethodManager imm = (InputMethodManager) getActivity().getSystemService
						(Activity.INPUT_METHOD_SERVICE);
				imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
			}
		});
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.header_logo);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

		bookButton = (TextView) v.findViewById(R.id.btn_book);
		bookButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentManager manager = getActivity().getSupportFragmentManager();
				manager.beginTransaction().replace(R.id.container, PaymentFragment.newInstance())
						.addToBackStack(null).commit();
			}
		});
        return v;
    }


    public void debugMode(){
        allvenues.add(new Venue("Tubagus Futsal", "Jl. Tubagus Ismail XIX No.1, Sekeloa Bandung", "3" +
                " futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 7216081"));
        allvenues.add(new Venue("Ganesha Futsal", "Jl. Ganesha XIX No.1, Bandung", "2" +
                " futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 1312451"));
        allvenues.add(new Venue("Dago Futsal", "Jl. Ir. H. Djuanda No 143, Bandung", "4" +
                " futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 1573189"));
        allvenues.add(new Venue("Cisitu Futsal", "Jl. Cisitu baru III No. 4, Coblong Bandung", "3" +
                " futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 8954354"));
        allvenues.add(new Venue("Plesiran Futsal", "Jl. Plesiran No. 23, Bandung",
                "3 futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 6574582"));
		allvenues.add(new Venue("New Futsal 1", "Jl. Plesiran No. 23, Bandung",
				"3 futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 6583298"));
		allvenues.add(new Venue("New Futsal 2", "Jl. Plesiran No. 23, Bandung",
				"3 futsal fields\nRp 100.000 - Rp 150.000 per hour", "+62 22 0325723"));
    }
}
