package com.example.ygme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Contacts extends Activity implements OnClickListener{
	
	Button add , clr, view;
	Editable namedb , phonedb;
	
	SQLiteDatabase db;

    private ArrayList<Map<String, String>> mPeopleList;

    private SimpleAdapter mAdapter , mad;
    private AutoCompleteTextView mTxtPhoneNo, mTxtName;
    
     String[] ygmdata ={ "Name", "Phone" , "Type" };
	int[] ygmdata1 = { R.id.ccontName, R.id.ccontNo, R.id.ccontType };

/** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        
        
        
        add = (Button)findViewById(R.id.addygm);
        clr = (Button)findViewById(R.id.clearygm);
        view = (Button)findViewById(R.id.viewygm);
        
     
        
        add.setOnClickListener(this);
        clr.setOnClickListener(this);
        view.setOnClickListener(this);
        
        
        mTxtName = (AutoCompleteTextView) findViewById(R.id.WhoNo);
        mTxtPhoneNo = (AutoCompleteTextView) findViewById(R.id.Phone);
        mPeopleList = new ArrayList<Map<String, String>>();
        PopulatePeopleList();
        mAdapter = new SimpleAdapter(this, mPeopleList, R.layout.custcontview ,ygmdata,ygmdata1);
        mad = new SimpleAdapter(this, mPeopleList, R.layout.custcontview ,ygmdata,ygmdata1);
        mTxtPhoneNo.setAdapter(mAdapter);
        mTxtName.setAdapter(mad);
        
        
        mTxtPhoneNo.setOnItemClickListener(new OnItemClickListener() {
        	 @Override
        	 public void onItemClick(AdapterView<?> av, View arg1, int index, long arg3) {
        	 Map<String, String> map = (Map<String, String>) av.getItemAtPosition(index);
        	 String name = map.get("Name");
        	 String number = map.get("Phone"); 
        		mTxtName.setText(""+name);
        	mTxtPhoneNo.setText(""+number);
        	 InputMethodManager key1 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
     	    key1.hideSoftInputFromWindow( mTxtPhoneNo.getWindowToken(), 0);
        	 }
        	 });
        mTxtName.setOnItemClickListener(new OnItemClickListener() {
       	 @Override
       	 public void onItemClick(AdapterView<?> av, View arg1, int index, long arg3) {
       	 Map<String, String> map = (Map<String, String>) av.getItemAtPosition(index);
       	 String name = map.get("Name");
       	 String number = map.get("Phone"); 
       	mTxtName.setText(""+name);
       	mTxtPhoneNo.setText(""+number);
       	InputMethodManager key = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	    key.hideSoftInputFromWindow( mTxtName.getWindowToken(), 0);
       	 }
       	 }); 
        
        
        db = openOrCreateDatabase("ygmdb", MODE_WORLD_READABLE, null);
		 Log.e("database","error");
		 try{
			 	String q = "create table if not exists contact( name varchar, phone int)";
				db.execSQL(q);
				//Toast.makeText(this, "STUDENT TABLE CREATED", 1000).show();
				//Log.e("database","error");
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
        }

    public void PopulatePeopleList()
    {

    mPeopleList.clear();

    Cursor people = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

    while (people.moveToNext())
    {
    String contactName = people.getString(people.getColumnIndex(
    ContactsContract.Contacts.DISPLAY_NAME));

    String contactId = people.getString(people.getColumnIndex(
    ContactsContract.Contacts._ID));
    String hasPhone = people.getString(people.getColumnIndex(
    ContactsContract.Contacts.HAS_PHONE_NUMBER));

    if ((Integer.parseInt(hasPhone) > 0))
    {

    // You know have the number so now query it like this
    Cursor phones = getContentResolver().query(
    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
    null,
    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ contactId,
    null, null);
    while (phones.moveToNext()) {

    //store numbers and display a dialog letting the user select which.
    String phoneNumber = phones.getString(
    phones.getColumnIndex(
    ContactsContract.CommonDataKinds.Phone.NUMBER));

    String numberType = phones.getString(phones.getColumnIndex(
    ContactsContract.CommonDataKinds.Phone.TYPE));

    Map<String, String> NamePhoneType = new HashMap<String, String>();

    NamePhoneType.put("Name", contactName);
    NamePhoneType.put("Phone", phoneNumber);

    if(numberType.equals("0"))
    NamePhoneType.put("Type", "Work");
    else
    if(numberType.equals("1"))
    NamePhoneType.put("Type", "Home");
    else if(numberType.equals("2"))
    NamePhoneType.put("Type",  "Mobile");
    else
    NamePhoneType.put("Type", "Other");

    //Then add this map to the list.
    mPeopleList.add(NamePhoneType);
    }
    phones.close();
    }
    }
    people.close();

    startManagingCursor(people);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.addygm){
			namedb = mTxtName.getText();
	        phonedb = mTxtPhoneNo.getText();
			try{
			String in = "insert into contact values('"+namedb+"','"+phonedb+"')"; 
				db.execSQL(in);
				mTxtName.setText("");
		     	mTxtPhoneNo.setText("");
				Toast.makeText(getApplicationContext(), namedb+" :"+phonedb, 1000).show();	
				}catch(Exception e){}
		
		}
		else if(v.getId()==R.id.viewygm){
			try{
			String vi = "select * from contact";
			Cursor c = db.rawQuery(vi, null);
			String data="";
			while(c.moveToNext()){
			
				String n = c.getString(c.getColumnIndex("name"));

				String p = c.getString(c.getColumnIndex("phone"));
				data = data+ (n+": "+p)+"\n";
			}
			mTxtName.setText("");
	     	mTxtPhoneNo.setText("");
			Toast.makeText(getApplicationContext(), data, 1000).show();	
		}catch(Exception e){}
		}
		else
		{
			try{
			String de = "delete  from contact";
			db.execSQL(de);
			mTxtName.setText("");
	     	mTxtPhoneNo.setText("");
			Toast.makeText(getApplicationContext(), "Deleted", 1000).show();
			}catch(Exception e){}
		}
		
	    }
	
	
	
    }