package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class HomeTab extends Activity{

	private ListView lv;
	String[] homeItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_tab_layout);
		
		lv = (ListView) findViewById(R.id.list);
		
		homeItems = getResources().getStringArray(R.array.homeItems);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, homeItems));
		lv.setTextFilterEnabled(true);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
									
	}
	
	/*
	Button notificationsBtn = (Button) findViewById(R.id.notificationsButton);
	
	//need to code for notifications 
	*/
		});
	}
}
