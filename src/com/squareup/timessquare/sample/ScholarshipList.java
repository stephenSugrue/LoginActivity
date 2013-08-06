package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScholarshipList extends Activity{
	
	static final String KEY_SCHOLARSHIPNAME = "scholarshipName";
	static final String KEY_SCHOLDESCRIPTION = "scholDescription";
	static final String KEY_SCHOLSHORTDESCRIPTION = "shortScholDescription";
	static final String KEY_CLOSEDATE = "closeDate";
	static final String KEY_REQUIREMENTS = "requirements";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scholarship_list);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get XML values from previous intent
        String scholarshipName = in.getStringExtra(KEY_SCHOLARSHIPNAME);
        String scholDescription = in.getStringExtra(KEY_SCHOLDESCRIPTION);
        String scholShortDesc = in.getStringExtra(KEY_SCHOLSHORTDESCRIPTION);
        String closeDate = in.getStringExtra(KEY_CLOSEDATE);
        String requirements = in.getStringExtra(KEY_REQUIREMENTS);
        
        // Displaying all values on the screen
        TextView nameLbl = (TextView) findViewById(R.id.scholNameLbl);
        TextView descLbl= (TextView) findViewById(R.id.scholDescLbl);
        TextView shortDescLbl = (TextView) findViewById(R.id.scholShortDescLbl);
        TextView closeDateLbl = (TextView) findViewById(R.id.closeDateLbl);
        TextView requirementsLbl = (TextView) findViewById(R.id.requirementsLbl);
        
        nameLbl.setText(scholarshipName);
        descLbl.setText(scholDescription);
        shortDescLbl.setText(scholShortDesc);
        closeDateLbl.setText(closeDate);
        requirementsLbl.setText(requirements);
    }
}
