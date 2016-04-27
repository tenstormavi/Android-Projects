package com.example.drawerdemo;

import com.example.drawerdemo.NavigationDrawerFragment;
import com.example.drawerdemo.DrawerDemo;
import com.example.drawerdemo.R;
import com.example.drawerdemo.DrawerDemo.ContactFragment;
import com.example.drawerdemo.DrawerDemo.PlaceholderFragment;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class DrawerDemo extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer_demo);
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(
				R.id.navigation_drawer);
		mTitle = getTitle();
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
		
	}
	
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		FragmentManager fragmentManager = getFragmentManager();
		
		if(position==0){
		fragmentManager.beginTransaction().replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
				.commit();
		}
		if(position==1){
			fragmentManager.beginTransaction().replace(R.id.container,ContactFragment.newInstance(position + 1))
					.commit();
			}
		if(position==3){
			finish();
		}
	}
	
	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}
	
	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.drawer_demo, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public static class PlaceholderFragment extends Fragment {
		
		private static final String ARG_SECTION_NUMBER = "section_number";

		
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_drawer_demo, container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((DrawerDemo) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}
	
	public static class ContactFragment extends Fragment {
		
		private static final String ARG_SECTION_NUMBER = "section_number";

		public static ContactFragment newInstance(int sectionNumber) {
			ContactFragment fragment = new ContactFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public ContactFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_drawer_contact, container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((DrawerDemo) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}
}
