package com.example.hp15andapp;

import java.io.File;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MusicPlayer extends Activity implements OnClickListener,OnSeekBarChangeListener 
{

	Button b1,b2;
	static MediaPlayer player;
	TextView cd, td;
	SeekBar mpseek;
	Thread autoseek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_player);
		b1 = (Button)findViewById(R.id.mpb1);
		b2 = (Button)findViewById(R.id.mpb2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		cd = (TextView)findViewById(R.id.mpcd);
		td = (TextView)findViewById(R.id.mptd);
		mpseek = (SeekBar)findViewById(R.id.mpsb1);
		mpseek.setOnSeekBarChangeListener(this);
		File sdcard = Environment.getExternalStorageDirectory();
		if(player==null){
		//player = MediaPlayer.create(this,R.raw.mymusic);
			player = new MediaPlayer();
			String songpath=sdcard.getPath()+"/chandsifarish.mp3";
			try{
			player.setDataSource(songpath);
			player.prepare();
			}catch(Exception e){
			 Toast.makeText(this,"SONG FILE NOT FOUND.",1000).show();
			}
		}
		mpseek.setMax(player.getDuration());
		td.setText(convert(player.getDuration()));
		
		autoseek = new Thread()
		  {
			public void run()
			{
			 while(true)
			 {
			  mpseek.setProgress(player.getCurrentPosition());
			 }
			}
		  };//END OF THREAD
		  autoseek.start();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.mpb1){
		 if(player.isPlaying()==false){
			player.start();
		 }
		}
		else if(v.getId()==R.id.mpb2){
		  if(player.isPlaying()==true){
			player.pause();
		  }
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		if(fromUser){
			player.seekTo(progress);
		}
		cd.setText(convert(progress));
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
     

	//CONVERT DURATION TO DISPLAY
	String convert(long duration){
		String ttd="";
		duration = duration/1000;
		ttd = (duration/60)+" : "+(duration%60);
		return ttd;
	}

}
