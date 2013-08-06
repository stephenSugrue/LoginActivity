package com.squareup.timessquare.sample;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.squareup.timessquare.sample.R;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Papers extends ListActivity  {

	static final String URL = "http://kate.ict.op.ac.nz/~careyhl1/papers.xml";
	static final String KEY_PAPER = "paper";
	static final String KEY_PAPERCODE = "paperCode";
	static final String KEY_PAPERNAME = "paperName";
	static final String KEY_DESCRIPTION = "description";
	static final String KEY_SHORTDESCRIPTION = "shortDescription";
	static final String KEY_LECTURER = "lecturer";


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xml_reader);
	
		
		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
		
		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL);
		Document doc = parser.getDomElement(xml);
		
		NodeList nl = doc.getElementsByTagName(KEY_PAPER);
		
		for (int i = 0; i < nl.getLength(); i++){
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			
			map.put(KEY_PAPERCODE, parser.getValue(e, KEY_PAPERCODE));
			map.put(KEY_PAPERNAME, parser.getValue(e, KEY_PAPERNAME));
			map.put(KEY_DESCRIPTION, parser.getValue(e, KEY_DESCRIPTION));
			map.put(KEY_SHORTDESCRIPTION, parser.getValue(e,  KEY_SHORTDESCRIPTION));
			map.put(KEY_LECTURER, parser.getValue(e, KEY_LECTURER));
			
			menuItems.add(map);
		}
		
		ListAdapter adapter = new SimpleAdapter(this, menuItems, R.layout.papers, new String[] 
				{KEY_PAPERCODE, KEY_PAPERNAME, KEY_DESCRIPTION, KEY_SHORTDESCRIPTION, KEY_LECTURER},new int[] {
				R.id.paperCode, R.id.paperName, R.id.description, R.id.shortDescription, R.id.lecturer});
		
		setListAdapter(adapter);
		
		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				String paperCode = ((TextView) view.findViewById(R.id.paperCode)).getText().toString();
				String paperName = ((TextView) view.findViewById(R.id.paperName)).getText().toString();
				String description = ((TextView) view.findViewById(R.id.description)).getText().toString();
				String shortDescription = ((TextView) view.findViewById(R.id.shortDescription)).getText().toString();
				String lecturer = ((TextView) view.findViewById(R.id.lecturer)).getText().toString();
				
				Intent i = new Intent(getApplicationContext(), PapersListItems.class);
				i.putExtra(KEY_PAPERCODE, paperCode);
				i.putExtra(KEY_PAPERNAME, paperName);
				i.putExtra(KEY_DESCRIPTION, description);
				i.putExtra(KEY_SHORTDESCRIPTION, shortDescription);
				i.putExtra(KEY_LECTURER, lecturer);
				
				startActivity(i);
			}			
		});
	
		
		
	}
	
	
}
	
	


		
	