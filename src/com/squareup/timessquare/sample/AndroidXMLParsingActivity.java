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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class AndroidXMLParsingActivity extends ListActivity {

	
	// All static variables
	static final String URL = "http://kate.ict.op.ac.nz/~sugrusl1/xmlfiles/contacts.xml";
	// XML node keys
	static final String KEY_PERSON= "person"; // parent node
	static final String KEY_NAME = "name";
	static final String KEY_ROLL = "roll";
	static final String KEY_LOCATION = "location";
	static final String KEY_BUILDING = "building";
	static final String KEY_EMAIL = "email";
	static final String KEY_PHONE = "phone";
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xml_reader);

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element

		NodeList nl = doc.getElementsByTagName(KEY_PERSON);
		// looping through all item nodes <item>
		for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_NAME, parser.getValue(e, KEY_NAME));
			map.put(KEY_ROLL, parser.getValue(e, KEY_ROLL));
			map.put(KEY_LOCATION, parser.getValue(e, KEY_LOCATION));
			map.put(KEY_BUILDING, parser.getValue(e, KEY_BUILDING));
			map.put(KEY_EMAIL, parser.getValue(e, KEY_EMAIL));
			map.put(KEY_PHONE, parser.getValue(e, KEY_PHONE));

			// adding HashList to ArrayList
			menuItems.add(map);
		}

		// Adding menuItems to ListView
		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.support_people,
				new String[] {KEY_NAME, KEY_ROLL, KEY_BUILDING, KEY_LOCATION,KEY_EMAIL,KEY_PHONE }, new int[] {
					R.id.name, R.id.roll, R.id.desciption, R.id.cost,R.id.email,R.id.phone });

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();

		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
				String roll = ((TextView) view.findViewById(R.id.roll)).getText().toString();
				String location = ((TextView) view.findViewById(R.id.cost)).getText().toString();
				String description = ((TextView) view.findViewById(R.id.desciption)).getText().toString();
				String email = ((TextView) view.findViewById(R.id.email)).getText().toString();
				String phone = ((TextView) view.findViewById(R.id.phone)).getText().toString();
				
				// Starting new intent
				Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
				in.putExtra(KEY_NAME, name);
				in.putExtra(KEY_ROLL, roll);
				in.putExtra(KEY_LOCATION, location);
				in.putExtra(KEY_BUILDING, description);
				in.putExtra(KEY_PHONE, phone);
				in.putExtra(KEY_EMAIL, email);
				
				startActivity(in);

			}
		});
	}
}