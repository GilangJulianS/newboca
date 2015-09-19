package com.boca.boca;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.container, BookingListFragment.newInstance())
				.commit();

//		mNavigationDrawerFragment = (NavigationDrawerFragment)
//				getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
//
//		// Set up the drawer.
//		mNavigationDrawerFragment.setUp(
//				R.id.navigation_drawer,
//				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

//	@Override
//	public void onNavigationDrawerItemSelected(int position) {
//		 update the main content by replacing fragments
//		FragmentManager fragmentManager = getSupportFragmentManager();
//		fragmentManager.beginTransaction()
//				.replace(R.id.container, BookingListFragment.newInstance())
//				.commit();
//	}

	public void restoreActionBar() {
//		ActionBar actionBar = getSupportActionBar();
//		actionBar.setDisplayHomeAsUpEnabled(false);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		if (!mNavigationDrawerFragment.isDrawerOpen()) {
//			// Only show items in the action bar relevant to this screen
//			// if the drawer is not showing. Otherwise, let the drawer
//			// decide what to show in the action bar.
//
//			restoreActionBar();
//			return true;
//		}
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
			case R.id.btn_notif:
				FragmentManager manager = getSupportFragmentManager();
				manager.beginTransaction().replace(R.id.container, NotificationFragment
						.newInstance()).commit();
				break;
		}

		return super.onOptionsItemSelected(item);
	}

}
