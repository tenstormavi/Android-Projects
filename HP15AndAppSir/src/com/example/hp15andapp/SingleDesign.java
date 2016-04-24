package com.example.hp15andapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SingleDesign extends ListActivity
{
 String [] data = {"Item1","Demo Demo","Andriod Quiz"};
 Class [] screen = {MainActivity.class,Second.class,Quiz.class};
 @Override
 protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));;
 }
 
 @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent i = new Intent(this,screen[position]);
		startActivity(i);
	}
}
