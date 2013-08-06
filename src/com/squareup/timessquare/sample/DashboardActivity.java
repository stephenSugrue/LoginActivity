
package com.squareup.timessquare.sample;

import com.squareup.timessquare.sample.R;

import json_library.UserFunctions;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;



@SuppressWarnings("deprecation")
public class DashboardActivity extends TabActivity {
	UserFunctions userFunctions;
	Button btnLogout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	    /**
         * Dash-board Screen for the application
         * */        
        // Check login status in database
       userFunctions = new UserFunctions();
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
        	setContentView(R.layout.dashboard);
        	btnLogout = (Button) findViewById(R.id.btnLogout);
        	
        	 btnLogout.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View arg0) {
                     // TODO Auto-generated method stub
                     userFunctions.logoutUser(getApplicationContext());
                     Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                     login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                     startActivity(login);
                     // Closing dash-board screen
                     finish();
                 }
             });
        	 
		
		TabHost tabHost = getTabHost();
		
		//Tab for Home
		/*TabSpec homeSpec = tabHost.newTabSpec("Home");
		//set the title and icon for tab
		homeSpec.setIndicator("Home", getResources().getDrawable(R.drawable.icon_home));
		Intent photosIntent = new Intent(this, HomeTab.class);
		homeSpec.setContent(photosIntent);
		*/
		//Tab for Students
		TabSpec studentSpec = tabHost.newTabSpec("Students");
		//set the tile and icon
		studentSpec.setIndicator("Students", getResources().getDrawable(R.drawable.icon_students));
		Intent songsIntent = new Intent(this, StudentsTab.class);
		studentSpec.setContent(songsIntent);
		
		//Tab for Support
		TabSpec supportSpec = tabHost.newTabSpec("Support");
		//set the tile and icon
		supportSpec.setIndicator("Support", getResources().getDrawable(R.drawable.icon_support));
		Intent videosIntent = new Intent(this, SupportTab.class);
		supportSpec.setContent(videosIntent);
		
		//tabHost.addTab(homeSpec);
		tabHost.addTab(studentSpec);
		tabHost.addTab(supportSpec);
		
	}
        
       else{
        	// user is not logged in show login screen
        	Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dash-board screen
        	finish();
        }
	
	}
}