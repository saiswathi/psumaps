package com.example.psumaps;

import java.util.*;

import com.google.android.gms.maps.model.LatLng;

import android.app.*;
import android.content.Intent;
import android.text.*;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.view.*;
import android.view.ContextMenu.ContextMenuInfo;


public class BList extends Activity {
	
	// The data to show
	
		List<Map<String, String>> buildingsList = new ArrayList<Map<String,String>>();
		private ArrayList<Map<String, String>> arraylist = new ArrayList<Map<String,String>>();
		SimpleAdapter simpleAdpt;
	    EditText editsearch;
		
	    Map<String,String> mname = new HashMap<String,String>();
	    Map<String,Integer> mlevels = new HashMap<String,Integer>();
	    Map<String,Integer> mstarts = new HashMap<String,Integer>();


		private void initList() {
		    // We populate the Buildings
		    buildingsList.add(createBuilding("building", "Art Building"));
		    buildingsList.add(createBuilding("building", "Academic and Student Recreation Center"));
		    buildingsList.add(createBuilding("building", "School of Business Administration"));
		   // buildingsList.add(createBuilding("building", "Blumel Bike Garage (South of Blumel Residence Hall)"));
		    buildingsList.add(createBuilding("building", "The Broadway Housing Building"));
		    buildingsList.add(createBuilding("building", "Blackstone"));
		    buildingsList.add(createBuilding("building", "Corbett Building"));
		   // buildingsList.add(createBuilding("building", "Campus and Grounds Trailer"));
			buildingsList.add(createBuilding("building", "Cramer Hall"));
			buildingsList.add(createBuilding("building", "Ondine Annex (Cinema)"));
			buildingsList.add(createBuilding("building", "Collaborative Life Sciences Building"));
			//buildingsList.add(createBuilding("building", "Crown Plaza Building"));
			//buildingsList.add(createBuilding("building", "Fifth Avenue Lot"));
			buildingsList.add(createBuilding("building", "Engineering Building"));
			buildingsList.add(createBuilding("building", "School of Education"));
			buildingsList.add(createBuilding("building", "East Hall"));
			buildingsList.add(createBuilding("building", "Fourth Avenue Building"));
			buildingsList.add(createBuilding("building", "Helen Gordon Child Development Center"));
			buildingsList.add(createBuilding("building", "Harder House"));
			buildingsList.add(createBuilding("building", "George C. Hoffmann Hall"));
			buildingsList.add(createBuilding("building", "Harrison Street Building"));
			buildingsList.add(createBuilding("building", "Joseph C. Blumel Residence Hall"));
			buildingsList.add(createBuilding("building", "Koinonia House"));
			buildingsList.add(createBuilding("building", "King Albert Building"));
			buildingsList.add(createBuilding("building", "Lincoln Hall"));
			buildingsList.add(createBuilding("building", "Market Center Building"));
			buildingsList.add(createBuilding("building", "Branford Price Millar Library"));
			buildingsList.add(createBuilding("building", "Montgomery Court"));
			buildingsList.add(createBuilding("building", "Native American Student and Community Center"));
			buildingsList.add(createBuilding("building", "North Greenhouse"));
			buildingsList.add(createBuilding("building", "Neuberger Hall"));
			buildingsList.add(createBuilding("building", "Ondine Residence"));
			buildingsList.add(createBuilding("building", "Parkway Building"));
			buildingsList.add(createBuilding("building", "University Pointe"));
			buildingsList.add(createBuilding("building", "Parking Structure 1"));
			buildingsList.add(createBuilding("building", "Parking Structure 2"));
			buildingsList.add(createBuilding("building", "Parking Structure 3"));
			buildingsList.add(createBuilding("building", "Peter W. Stott Center"));
			buildingsList.add(createBuilding("building", "Research Greenhouse"));
			buildingsList.add(createBuilding("building", "Science Building One"));
			buildingsList.add(createBuilding("building", "Simon Benson House"));
			buildingsList.add(createBuilding("building", "Science and Education Center"));
			buildingsList.add(createBuilding("building", "Stephen E. Epler Hall"));
			buildingsList.add(createBuilding("building", "South Greenhouse"));
			buildingsList.add(createBuilding("building", "Shattuck Hall"));
			buildingsList.add(createBuilding("building", "Smith Memorial Student Union"));
			buildingsList.add(createBuilding("building", "Science Research and Teaching Center"));
			buildingsList.add(createBuilding("building", "Stratford Building"));
			buildingsList.add(createBuilding("building", "Saint Helens Building"));
			buildingsList.add(createBuilding("building", "University Center Building"));
			buildingsList.add(createBuilding("building", "University Honors Program"));
			buildingsList.add(createBuilding("building", "University Place"));
			buildingsList.add(createBuilding("building", "Urban Center"));
			buildingsList.add(createBuilding("building", "University Services Building"));
			buildingsList.add(createBuilding("building", "University Technology Services"));
			buildingsList.add(createBuilding("building", "West Heating Plant"));
			buildingsList.add(createBuilding("building", "XSB"));
			
			
			/*mname.put("Branford Price Millar Library","ml");			
			mlevels.put("Branford Price Millar Library",5);
			mstarts.put("Branford Price Millar Library",-1);
			
			mname.put("Neuberger Hall","nh");			
			mlevels.put("Neuberger Hall",4);
			mstarts.put("Neuberger Hall",0);*/
			
			mname.put("Art Building","ab");
			mname.put("Academic and Student Recreation Center","asrc");
			mname.put("School of Business Administration","ba");
			mname.put("The Broadway Housing Building","bhb");
			mname.put("Blackstone","blks");
			mname.put("Corbett Building","cb");
			mname.put("Cramer Hall","ch");
			mname.put("Ondine Annex (Cinema)","cin");
			mname.put("Collaborative Life Sciences Building","clsb");
			mname.put("Engineering Building","eb");
			mname.put("School of Education","ed");
			mname.put("East Hall","eh");
			mname.put("Fourth Avenue Building","fab");
			mname.put("Helen Gordon Child Development Center","hgcd");
			mname.put("Harder House","hh");
			mname.put("George C. Hoffmann Hall","hoff");
			mname.put("Harrison Street Building","hsb");
			mname.put("Joseph C. Blumel Residence Hall","jcb");
			mname.put("Koinonia House","khse");
			mname.put("King Albert Building","knga");
			mname.put("Lincoln Hall","lh");
			mname.put("Market Center Building","mcb");
			mname.put("Branford Price Millar Library","ml");
			mname.put("Montgomery Court","mont");
			mname.put("Native American Student and Community Center","nasc");
			mname.put("North Greenhouse","ngh");
			mname.put("Neuberger Hall","nh");
			mname.put("Ondine Residence","ond");
			mname.put("Parkway Building","pkwy");
			mname.put("University Pointe","pnt");
			mname.put("Parking Structure 1","ps1");
			mname.put("Parking Structure 2","ps2");
			mname.put("Parking Structure 3","ps3");
			mname.put("Peter W. Stott Center","psc");
			mname.put("Research Greenhouse","rgh");
			mname.put("Science Building One","sb1");
			mname.put("Simon Benson House","sbh");
			mname.put("Science and Education Center","sec");
			mname.put("Stephen E. Epler Hall","seh");
			mname.put("South Greenhouse","sgh");
			mname.put("Shattuck Hall","sh");
			mname.put("Smith Memorial Student Union","smsu");
			mname.put("Science Research and Teaching Center","srtc");
			mname.put("Stratford Building","stfd");
			mname.put("Saint Helens Building","sthl");
			mname.put("University Center Building","ucb");
			mname.put("University Honors Program","uhp");
			mname.put("University Place","up");
			mname.put("Urban Center","urbn");
			mname.put("University Services Building","usb");
			mname.put("University Technology Services","uts");
			mname.put("West Heating Plant","whp");
			mname.put("XSB","xsb");

			mlevels.put("Art Building",4);
			mlevels.put("Academic and Student Recreation Center",4);
			mlevels.put("School of Business Administration",5);
			mlevels.put("The Broadway Housing Building",5);
			mlevels.put("Blackstone",5);
			mlevels.put("Corbett Building",3);
			mlevels.put("Cramer Hall",5);
			mlevels.put("Ondine Annex (Cinema)",0);
			mlevels.put("Collaborative Life Sciences Building",5);
			mlevels.put("Engineering Building",5);
			mlevels.put("School of Education",5);
			mlevels.put("East Hall",3);
			mlevels.put("Fourth Avenue Building",3);
			mlevels.put("Helen Gordon Child Development Center",4);
			mlevels.put("Harder House",3);
			mlevels.put("George C. Hoffmann Hall",1);
			mlevels.put("Harrison Street Building",1);
			mlevels.put("Joseph C. Blumel Residence Hall",5);
			mlevels.put("Koinonia House",3);
			mlevels.put("King Albert Building",5);
			mlevels.put("Lincoln Hall",5);
			mlevels.put("Market Center Building",4);
			mlevels.put("Branford Price Millar Library",5);
			mlevels.put("Montgomery Court",4);
			mlevels.put("Native American Student and Community Center",2);
			mlevels.put("North Greenhouse",0);
			mlevels.put("Neuberger Hall",4);
			mlevels.put("Ondine Residence",5);
			mlevels.put("Parkway Building",5);
			mlevels.put("University Pointe",2);
			mlevels.put("Parking Structure 1",5);
			mstarts.put("Parking Structure 2",5);
			mstarts.put("Parking Structure 3",5);
			mstarts.put("Peter W. Stott Center",3);
			mstarts.put("Research Greenhouse",1);
			mstarts.put("Science Building One",4);
			mstarts.put("Simon Benson House",3);
			mstarts.put("Science and Education Center",3);
			mstarts.put("Stephen E. Epler Hall",5);
			mstarts.put("South Greenhouse",1);
			mstarts.put("Shattuck Hall",4);
			mstarts.put("Smith Memorial Student Union",5);
			mstarts.put("Science Research and Teaching Center",0);
			mstarts.put("Stratford Building",3);
			mstarts.put("Saint Helens Building",5);
			mstarts.put("University Center Building",5);
			mstarts.put("University Honors Program",5);
			mstarts.put("University Place",1);
			mstarts.put("Urban Center",4);
			mstarts.put("University Services Building",3);
			mstarts.put("University Technology Services",5);
			mstarts.put("West Heating Plant",1);
			mstarts.put("XSB",3);
			
			
			mstarts.put("Art Building",0);
			mstarts.put("Academic and Student Recreation Center",0);
			mstarts.put("School of Business Administration",1);
			mstarts.put("The Broadway Housing Building",1);
			mstarts.put("Blackstone",1);
			mstarts.put("Corbett Building",0);
			mstarts.put("Cramer Hall",-1);
			mstarts.put("Ondine Annex (Cinema)",0);
			mstarts.put("Collaborative Life Sciences Building",-1);
			mstarts.put("Engineering Building",1);
			mstarts.put("School of Education",1);
			mstarts.put("East Hall",1);
			mstarts.put("Fourth Avenue Building",-1);
			mstarts.put("Helen Gordon Child Development Center",0);
			mstarts.put("Harder House",0);
			mstarts.put("George C. Hoffmann Hall",1);
			mstarts.put("Harrison Street Building",1);
			mstarts.put("Joseph C. Blumel Residence Hall",5);
			mstarts.put("Koinonia House",0);
			mstarts.put("King Albert Building",0);
			mstarts.put("Lincoln Hall",-1);
			mstarts.put("Market Center Building",-1);
			mstarts.put("Branford Price Millar Library",-1);
			mstarts.put("Montgomery Court",0);
			mstarts.put("Native American Student and Community Center",1);
			mstarts.put("North Greenhouse",0);
			mstarts.put("Neuberger Hall",0);
			mstarts.put("Ondine Residence",-1);
			mstarts.put("Parkway Building",1);
			mstarts.put("University Pointe",1);
			mstarts.put("Parking Structure 1",1);
			mstarts.put("Parking Structure 2",1);
			mstarts.put("Parking Structure 3",0);
			mstarts.put("Peter W. Stott Center",0);
			mstarts.put("Research Greenhouse",1);
			mstarts.put("Science Building One",-1);
			mstarts.put("Simon Benson House",1);
			mstarts.put("Science and Education Center",0);
			mstarts.put("Stephen E. Epler Hall",1);
			mstarts.put("South Greenhouse",1);
			mstarts.put("Shattuck Hall",0);
			mstarts.put("Smith Memorial Student Union",-1);
			mstarts.put("Science Research and Teaching Center",0);
			mstarts.put("Stratford Building",1);
			mstarts.put("Saint Helens Building",1);
			mstarts.put("University Center Building",0);
			mstarts.put("University Honors Program",0);
			mstarts.put("University Place",1);
			mstarts.put("Urban Center",0);
			mstarts.put("University Services Building",0);
			mstarts.put("University Technology Services",1);
			mstarts.put("West Heating Plant",1);
			mstarts.put("XSB",0);

			/*mname.put("","");			
			mlevels.put("",);
			mstarts.put("",);*/


			
		}
		
		
		
		private HashMap<String, String> createBuilding(String key, String name) {
		    HashMap<String, String> building = new HashMap<String, String>();
		    building.put(key, name);

		    return building;
		}

		@Override
		public void onCreate(Bundle savedInstanceState) 
		{
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.buildinglist);
			
			initList();
		
			// We get the ListView component from the layout
			
			ListView lv = (ListView) findViewById(R.id.listView);

			// This is a simple adapter that accepts as parameter
			// Context
			// Data list
			// The row layout that is used during the row creation
			// The keys used to retrieve the data
			// The View id used to show the data. The key number and the view id must match
			
			simpleAdpt = new SimpleAdapter(this, buildingsList, android.R.layout.simple_list_item_1, new String[] {"building"}, new int[] {android.R.id.text1});
	
			arraylist.addAll(buildingsList);
			
			lv.setAdapter(simpleAdpt);
			
			// Locate the EditText in blist.xml
	        editsearch = (EditText) findViewById(R.id.search);
	        
	     // Capture Text in EditText
	        editsearch.addTextChangedListener(new TextWatcher() {
	 
	            @Override
	            public void afterTextChanged(Editable arg0) {
	                // TODO Auto-generated method stub
	                
	            }
	 
	            @Override
	            public void beforeTextChanged(CharSequence arg0, int arg1,
	                    int arg2, int arg3) {
	                // TODO Auto-generated method stub
	            }
	 
	            @Override
	            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
	                    int arg3) {
	                // TODO Auto-generated method stub
	            	BList.this.simpleAdpt.getFilter().filter(arg0);
	            	/*String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
	                filter(text);*/
	            }
	        });
	
			//React to user clicks on item
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() 
			{ 
				@Override
				public void onItemClick(AdapterView<?> parentAdapter, View view, int position,long id) 
				{	
					// We know the View is a TextView so we can cast it
					TextView clickedView = (TextView) view;

					//Toast.makeText(BList.this, "Item with id ["+clickedView.getText()+"] - Position ["+simpleAdpt.getItem(position)+"] - Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();
					/*Uri uri = Uri.parse("R.drawable.psusign");
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);*/
				
					//Integer temp=arraylist.get(simpleAdpt.getItem(position));
					
					Intent bmap = new Intent(BList.this,Bmaps.class);
					bmap.putExtra("pos", position);
					bmap.putExtra("bname", mname.get(clickedView.getText()));
					bmap.putExtra("levels",mlevels.get(clickedView.getText()));
					bmap.putExtra("starts",mstarts.get(clickedView.getText()));
					startActivity(bmap);
				}
			});

		//we register for the contextmneu        
		registerForContextMenu(lv);
		
		}
		
		
		public void filter(String charText) {
			// TODO Auto-generated method stub
			
			charText = charText.toLowerCase(Locale.getDefault());
        	buildingsList.clear();
	        
	        if (charText.length() == 0) {
	        	buildingsList.addAll(arraylist);
	        } else {
	        	
	            for (Map<String, String> s : arraylist) {
	                if (s.get("building").toLowerCase(Locale.getDefault())
	                        .contains(charText)) {
	                	buildingsList.add(s);
	        	        //notifyDataSetChanged();
	                }
	            }
	        }
	    }
			
	

		//We want to create a context Menu when the user long click on an item
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
		       ContextMenuInfo menuInfo) {

		   super.onCreateContextMenu(menu, v, menuInfo);
		   AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

		   // We know that each row in the adapter is a Map
		   HashMap map =  (HashMap) simpleAdpt.getItem(aInfo.position);

		   menu.setHeaderTitle("Options for " + map.get("building"));
		   menu.add(1, 1, 1, "Details");
		   menu.add(1, 2, 2, "Delete");

		}
		
		// This method is called when user selects an Item in the Context menu
		@Override
		public boolean onContextItemSelected(MenuItem item) {
		    int itemId = item.getItemId();
		    // Implements our logic
		    //Toast.makeText(this, "Item id ["+itemId+"]", Toast.LENGTH_SHORT).show();
		    return true;
		}




}
