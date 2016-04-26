package com.example.navigationdrawer;

public class DrawerList {
	
	String ItemName;
	int imgResID;

	public DrawerList(String itemName, int imgResID) {
		// TODO Auto-generated constructor stub
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
		
		public void setImgResID(int imgRedID)
		{
			this.imgResID = imgResID;
		}

}
