package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PapersListItems extends Activity {

	static final String KEY_PAPERCODE = "paperCode";
	static final String KEY_PAPERNAME = "paperName";
	static final String KEY_DESCRIPTION = "description";
	static final String KEY_SHORTDESCRIPTION = "shortDescription";
	static final String KEY_LECTURER = "lecturer";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_paper);
		
		Intent i = getIntent();
		
		String paperCode = i.getStringExtra(KEY_PAPERCODE);
		String paperName = i.getStringExtra(KEY_PAPERNAME);
		String description  = i.getStringExtra(KEY_DESCRIPTION);
		String shortDescription  = i.getStringExtra(KEY_SHORTDESCRIPTION);
		String lecturer = i.getStringExtra(KEY_LECTURER);	
	
		TextView lblPaperCode = (TextView) findViewById(R.id.paperCodeLbl);
		TextView lblPaperName = (TextView) findViewById(R.id.paperNameLbl);
		TextView lblDescription = (TextView) findViewById(R.id.descriptionLbl);
		TextView lblShortDescription = (TextView) findViewById(R.id.shortDescriptionLbl);
		TextView lblLecturer = (TextView) findViewById(R.id.lecturerLbl);
		
		lblPaperCode.setText(paperCode);
		lblPaperName.setText(paperName);
		lblDescription.setText(description);
		lblShortDescription.setText(shortDescription);
		lblLecturer.setText(lecturer);
		
		
		Button contactButton;
		contactButton = (Button) findViewById(R.id.contactButton);
		contactButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), StaffContactsXMLParsingActivity.class);
			    startActivity(i);
			}	
		});
	}
	
	

}
