package com.example.navigationdrawer;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends ArrayAdapter<DrawerList>{
	
	Context context;
	List<DrawerList> drawerlist;
	int layoutResID;
	
	public DrawerAdapter(Context context, int layoutResourceID,
			List<DrawerList> listItems)
	{
		super(context,layoutResourceID,listItems);
		this.context = context;
		this.drawerlist = listItems;
		this.layoutResID = layoutResourceID;
	}
	
	public View getView(int position,View ConVertView, ViewGroup Parent)
	{
		DrawerItemHolder holder;
		View v = ConVertView;
		
		if(v == null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			holder = new DrawerItemHolder();
			
			v = inflater.inflate(layoutResID, Parent,false);
			holder.ItemName = (TextView)v.findViewById(R.id.image_Name);
			holder.icon = (ImageView)v.findViewById(R.id.drawer_image);
			v.setTag(holder);
		}
		else
		{
			holder = (DrawerItemHolder)v.getTag();
		}
		
		DrawerList dItem = (DrawerList)this.drawerlist.get(position);
		holder.icon.setImageDrawable(v.getResources().getDrawable(dItem.getImgResID()));
		holder.ItemName.setText(dItem.getItemName());
		return v;
	}
	
	private static class DrawerItemHolder {
		
		TextView ItemName;
		ImageView icon;

	}


}
