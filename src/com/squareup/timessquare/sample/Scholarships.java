package com.squareup.timessquare.sample;


import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.squareup.timessquare.sample.R;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Scholarships extends ListActivity {

	static final String URL = "http://kate.ict.op.ac.nz/~careyhl1/scholarships.xml";
	static final String KEY_SCHOLARSHIP = "scholarship";
	static final String KEY_SCHOLARSHIPNAME = "scholarshipName";
	static final String KEY_SCHOLDESCRIPTION = "scholDescription";
	static final String KEY_SCHOLSHORTDESCRIPTION = "shortScholDescription";
	static final String KEY_CLOSEDATE = "closeDate";
	static final String KEY_REQUIREMENTS = "requirements";
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xml_reader);
	
		
		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
		
		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL);
		Document doc = parser.getDomElement(xml);
		
		NodeList nl = doc.getElementsByTagName(KEY_SCHOLARSHIP);
		
		for (int i = 0; i < nl.getLength(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			
			map.put(KEY_SCHOLARSHIPNAME, parser.getValue(e, KEY_SCHOLARSHIPNAME));
			map.put(KEY_SCHOLDESCRIPTION, parser.getValue(e, KEY_SCHOLDESCRIPTION));
			map.put(KEY_SCHOLSHORTDESCRIPTION, parser.getValue(e, KEY_SCHOLSHORTDESCRIPTION));
			map.put(KEY_CLOSEDATE, parser.getValue(e,  KEY_CLOSEDATE));
			map.put(KEY_REQUIREMENTS, parser.getValue(e, KEY_REQUIREMENTS));
			
			menuItems.add(map);
		}
		
		ListAdapter adapter = new SimpleAdapter(this, menuItems, R.layout.scholarships, new String[] 
				{KEY_SCHOLARSHIPNAME, KEY_SCHOLDESCRIPTION, KEY_SCHOLSHORTDESCRIPTION, KEY_CLOSEDATE, KEY_REQUIREMENTS},
				new int[] {R.id.scholarshipName, R.id.scholDescription, R.id.shortScholDescription, R.id.closeDate, R.id.requirements});
		
		setListAdapter(adapter);
		
		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				String scholarshipName = ((TextView) view.findViewById(R.id.scholarshipName)).getText().toString();
				String scholarshipDescription = ((TextView) view.findViewById(R.id.scholDescription)).getText().toString();
				String shortScholarshipDesc = ((TextView) view.findViewById(R.id.shortScholDescription)).getText().toString();
				String closeDate = ((TextView) view.findViewById(R.id.closeDate)).getText().toString();
				String requirements = ((TextView) view.findViewById(R.id.requirements)).getText().toString();
				
				Intent i = new Intent(getApplicationContext(), ScholarshipList.class);
				i.putExtra(KEY_SCHOLARSHIPNAME, scholarshipName);
				i.putExtra(KEY_SCHOLDESCRIPTION, scholarshipDescription);
				i.putExtra(KEY_SCHOLSHORTDESCRIPTION, shortScholarshipDesc);
				i.putExtra(KEY_CLOSEDATE, closeDate);
				i.putExtra(KEY_REQUIREMENTS, requirements);
				
				startActivity(i);
			}			
		});		
	}
}
