package com.example.navigationdrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment2 extends Fragment {
	
	ImageView icIcon;
	TextView tv;
	
	public static final String IMAGE_RESOURCE_ID = "iconResource ID";
	public static final String ITEM_NAME = "itemNAME";
	
	public Fragment2()
	{
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View View = inflater.inflate(R.layout.fragment2,container,false);
		icIcon = (ImageView)View.findViewById(R.id.fragment2);
		tv = (TextView)View.findViewById(R.id.fragment2_text);
		tv.setText(getArguments().getString(ITEM_NAME));
		icIcon.setImageDrawable(View.getResources().getDrawable(getArguments().getInt(IMAGE_RESOURCE_ID)));
		return View;
	}
	
	

}
