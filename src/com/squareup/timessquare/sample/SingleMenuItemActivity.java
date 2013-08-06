package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity  extends Activity {
	
	// XML node keys
	static final String KEY_ROLL = "roll";
	static final String KEY_LOCATION = "location";
	static final String KEY_BUILDING = "building";
	static final String KEY_NAME = "name";
	static final String KEY_PHONE = "phone";
	static final String KEY_EMAIL = "email";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_person);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get XML values from previous intent
        String name = in.getStringExtra(KEY_NAME);
        String roll = in.getStringExtra(KEY_ROLL);
        String location = in.getStringExtra(KEY_LOCATION);
        String building = in.getStringExtra(KEY_BUILDING);
        String phone = in.getStringExtra(KEY_PHONE);
        String email = in.getStringExtra(KEY_EMAIL);
        
        // Displaying all values on the screen
        TextView lblname = (TextView) findViewById(R.id.name_label);
        TextView lblroll= (TextView) findViewById(R.id.person_name);
        TextView lbllocation = (TextView) findViewById(R.id.location_label);
        TextView lblbuilding = (TextView) findViewById(R.id.room_label);
        TextView lblemail = (TextView) findViewById(R.id.email_label);
        TextView lblphone= (TextView) findViewById(R.id.phone_label);
        
        lblname.setText(roll);
        lblroll.setText(name);
        lbllocation.setText(location);
        lblbuilding.setText(building);
        lblemail.setText(email);
        lblphone.setText(phone);
    }
}
