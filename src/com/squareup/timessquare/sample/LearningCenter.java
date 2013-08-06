package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LearningCenter extends Activity {

	ListView serviceslv;
	String[] services;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learning_center);
		//ADD IN THE INFO AFTER TESTING. 
		
		serviceslv = (ListView) findViewById(R.id.servicesList);
		
		services = getResources().getStringArray(R.array.services);
		
		serviceslv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, services));
		
		
		serviceslv.setTextFilterEnabled(true);	
		
	}
	
	
}
