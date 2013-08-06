package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedStaffMember extends Activity {
	
	// XML node keys
		static final String KEY_ROLE = "role";
		static final String KEY_LOCATION = "location";
		static final String KEY_NAME = "name";
		static final String KEY_PHONE = "phone";
		static final String KEY_EMAIL = "email";
		
		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.staff_member);
	        
	        // getting intent data
	        Intent in = getIntent();
	        
	        // Get XML values from previous intent
	        String name = in.getStringExtra(KEY_NAME);
	        String role = in.getStringExtra(KEY_ROLE);
	        String location = in.getStringExtra(KEY_LOCATION);
	        String phone = in.getStringExtra(KEY_PHONE);
	        String email = in.getStringExtra(KEY_EMAIL);
	        
	        // Displaying all values on the screen
	        TextView lblname = (TextView) findViewById(R.id.name_label);
	        TextView lblroll= (TextView) findViewById(R.id.person_name);
	        TextView lbllocation = (TextView) findViewById(R.id.location_label);
	        TextView lblemail = (TextView) findViewById(R.id.email_label);
	        TextView lblphone= (TextView) findViewById(R.id.phone_label);
	        
	        lblname.setText(role);
	        lblroll.setText(name);
	        lbllocation.setText("Office:" + location);
	        lblemail.setText(email);
	        lblphone.setText(phone);
	    }
	}



