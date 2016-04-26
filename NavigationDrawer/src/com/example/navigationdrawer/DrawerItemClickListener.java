package com.example.navigationdrawer;

import android.view.View;
import android.view.View.OnClickListener;

public class DrawerItemClickListener{

	String ItemName;
	int imgResID;
	
	public DrawerItemClickListener(String itemName, int imgResID)
	{
		super();
		ItemName = itemName;
		this.imgResID = imgResID;
	}
	
	public String getItemName()
	{
	    return ItemName;
	}
	
	public void setItemName(String itemName)
	{
		ItemName = itemName;
	}
	
	public int getImgResID()
	{
	    return imgResID;
	}
	
	public void setImgResID(int imgResID)
	{
	    this.imgResID = imgResID;
	}
	

}
