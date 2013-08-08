package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class StudentsTab extends Activity {
	
	private ListView lv;
	String[] studentItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.students_tab_layout);
	
	    lv = (ListView) findViewById(R.id.list);
	    
	    
		studentItems = getResources().getStringArray(R.array.studentItems);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, studentItems));
		lv.setTextFilterEnabled(true);
		
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
						
				if (lv.getItemAtPosition(position) == studentItems[0])
				{
				 Intent i = new Intent(getApplicationContext(), Papers.class);
				 startActivity(i);
				}
				if (lv.getItemAtPosition(position) == studentItems[1])
				{
				Intent i = new Intent(getApplicationContext(), CalanderActivity.class);
					startActivity(i);
				}
				
				if (lv.getItemAtPosition(position) == studentItems[2])
				{
					Intent i = new Intent(getApplicationContext(), StaffContactsXMLParsingActivity.class);
					startActivity(i);
				}
				if (lv.getItemAtPosition(position) == studentItems[3])
				{
					Intent i = new Intent(getApplicationContext(), RegisterForGCMActivity.class);
					startActivity(i);
				}
			}
		});
			
	}
	

}
