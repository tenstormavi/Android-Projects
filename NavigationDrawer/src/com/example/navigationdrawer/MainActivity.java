package com.example.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	private DrawerLayout layout;
	private ListView List;
	private ActionBarDrawerToggle toggle;
	private DrawerAdapter adp;
	private CharSequence Title;
	private CharSequence mtitle;
	List<DrawerList> datalist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datalist = new ArrayList<DrawerList>();
		
		mtitle = Title = getTitle();
		
		layout = (DrawerLayout)findViewById(R.id.itemlayout);
		
		List = (ListView)findViewById(R.id.left_drawer);
		
		try
		{
			layout.setDrawerShadow(R.drawable.duck, GravityCompat.START);
		}catch(Exception e)
		{
			
		}
		
		datalist.add(new DrawerList("Message",R.drawable.duck));
		datalist.add(new DrawerList("Likes",R.drawable.duck));
		datalist.add(new DrawerList("Games",R.drawable.duck));
		datalist.add(new DrawerList("Search",R.drawable.duck));
		datalist.add(new DrawerList("Labels",R.drawable.duck));
		datalist.add(new DrawerList("Camera",R.drawable.duck));
		datalist.add(new DrawerList("Video",R.drawable.duck));
		datalist.add(new DrawerList("Logout",R.drawable.duck));
		
		adp = new DrawerAdapter(this, R.layout.custom_draweritem, datalist);
		
		List.setAdapter(adp);
		
		List.setOnItemClickListener(new DrawerItemClickListener());
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		toggle = new ActionBarDrawerToggle(this, layout, 
				R.drawable.duck, R.string.drawer_open, 
				R.string.drawer_close){
	
	
		public void OnDrawerOpened(View view)
		{
			getActionBar().setTitle(mtitle);
			invalidateOptionsMenu();
		}
		
		public void OnDrawerOpen(View drawerview)
		{
			getActionBar().setTitle(mtitle);
			invalidateOptionsMenu();
		}
	};
		
	try
	{
		layout.setDrawerListener(toggle);
	}catch(Exception e)
	{
		
	}
	if(savedInstanceState==null)
	{
		try{
			SelectItem(0);
		}catch(Exception e){
			
		}
	}
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void SelectItem(int pos)
	{
		Fragment fragment = null;
		Bundle args = new Bundle();
		
		switch(pos)
		{
		case 0:
			fragment = new Fragment1();
			
			args.putString(Fragment1.ITEM_NAME, datalist.get(pos).getItemName());
			args.putInt(Fragment1.IMAGE_RESOURCE_ID, datalist.get(pos).getImgResID());
			break;
			
		case 1:
			fragment = new Fragment2();
			
			args.putString(Fragment2.ITEM_NAME, datalist.get(pos).getItemName());
			args.putInt(Fragment2.IMAGE_RESOURCE_ID, datalist.get(pos).getImgResID());
			break;
			
		case 2:
			fragment = new Fragment3();
			
			args.putString(Fragment3.ITEM_NAME, datalist.get(pos).getItemName());
			args.putInt(Fragment3.IMAGE_RESOURCE_ID, datalist.get(pos).getImgResID());
			break;
		
		default:
			break;
		}
		
		fragment.setArguments(args);
		FragmentManager fm = getFragmentManager();
		fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
		List.setItemChecked(pos, true);
		setTitle(datalist.get(pos).getItemName());
		layout.closeDrawer(pos);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		try{
			toggle.syncState();
		}catch(Exception e){
			
		}
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		toggle.onConfigurationChanged(newConfig);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(toggle.onOptionsItemSelected(item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		mtitle = title;
		getActionBar().setTitle(mtitle);
	}
	
	public class DrawerItemClickListener implements ListView.OnItemClickListener
	{
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long args3)
		{
			SelectItem(position);
		}
	}	
}


