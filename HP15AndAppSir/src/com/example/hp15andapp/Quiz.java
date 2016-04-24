package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends Activity implements OnClickListener 
{
    int marks = 0;
	RadioGroup ansgrp;
	RadioButton r1,r2;
	TextView ques;
	Button b1;
	int qc = 0;
	int tq = QuestionDB.quest.length;
	
	RelativeLayout rl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		ansgrp = (RadioGroup)findViewById(R.id.ansgrb);
		r1 = (RadioButton)findViewById(R.id.op1);
		r2 = (RadioButton)findViewById(R.id.op2);
		b1 = (Button)findViewById(R.id.next);
		ques = (TextView)findViewById(R.id.question);
		rl = (RelativeLayout)findViewById(R.id.quizlayout);
		
		
		ques.setText(QuestionDB.quest[qc]);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//CHECK ANSWER
		if(qc<tq){
		boolean correctanswer = QuestionDB.ans[qc];
				
		if(correctanswer)
		{
		 if(r1.isChecked())
		   marks++;
		}
		else
		{
		 if(r2.isChecked())
			 marks++;
		}
		
		}
		qc++;
		if(qc<tq){
			ques.setText(QuestionDB.quest[qc]);
			ansgrp.clearCheck();
			if(qc==tq-1)
				b1.setText("SUBMIT");
		}		
		else{
			
			//Toast.makeText(this,"TOTAL MARKS : "+marks,Toast.LENGTH_LONG).show();
			float per = (marks*100)/tq;
			String grade="";
			if(per>=70)
				grade = "A";
			else if(per>60)
				grade = "B";
			else if(per>50)
				grade = "C";
			else
				grade = "FAIL";
			
			Intent i = new Intent(this,Result.class);
			i.putExtra("mm",tq);
			i.putExtra("mo",marks);
			i.putExtra("grade",grade);
			startActivity(i);		
			
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(this);
		String bg = setting.getString("bgcolor","WHITE");
		if(bg.equals("RED")){
		  rl.setBackgroundColor(Color.RED);	
		}
		else if(bg.equals("BLUE")){
			  rl.setBackgroundColor(Color.BLUE);	
	    }
		else if(bg.equals("GREEN")){
			  rl.setBackgroundColor(Color.GREEN);	
		}
		else if(bg.equals("CYAN")){
			  rl.setBackgroundColor(Color.CYAN);	
	    }
		else if(bg.equals("BLACK")){
			  rl.setBackgroundColor(Color.BLACK);	
	    }
		else if(bg.equals("WHITE")){
			  rl.setBackgroundColor(Color.WHITE);	
	    }
		else if(bg.equals("ORANGE")){
			  rl.setBackgroundColor(Color.rgb(0xFF,0xAA,0x00));	
	    }
	}

	
}
