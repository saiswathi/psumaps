package com.example.psumaps;
 
import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
 
import org.json.JSONObject;
 
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
 
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapView extends FragmentActivity implements OnMarkerClickListener{
 
    GoogleMap map;
    ArrayList<LatLng> markerPoints;
    
    int btnclick = 0;
    static final LatLng PSU = new LatLng(45.512428, -122.683855);

    static final LatLng HGCD = new LatLng(45.514495, -122.688121);

    static final LatLng	PS3  = new LatLng(45.513829, -122.688378);

    static final LatLng UHP = new LatLng(45.513980, -122.687413);

    static final LatLng SB1 = new LatLng(45.513614, -122.685887);

    static final LatLng STFD = new LatLng(45.513825, -122.685860);

    static final LatLng JCB = new LatLng(45.513516, -122.687078);

    static final LatLng STHL = new LatLng(45.513351, -122.687759);

    static final LatLng SRTC = new LatLng(45.513171, -122.686322);

    static final LatLng NGH = new LatLng(45.512381, -122.686606);

    static final LatLng SGH = new LatLng(45.512257, -122.686665);

    static final LatLng HSB = new LatLng(45.512317, -122.686949);

    static final LatLng HH = new LatLng(45.513791, -122.685125);

    static final LatLng PKWY = new LatLng(45.513678, -122.684600);

    static final LatLng XSB = new LatLng(45.513329, -122.684728);

    static final LatLng MONT = new LatLng(45.512479, -122.685850);

    static final LatLng SBH = new LatLng(45.512314, -122.685372);

    static final LatLng BLKS = new LatLng(45.511964, -122.685689);

    static final LatLng SEH = new LatLng(45.512949, -122.688022);

    static final LatLng KNGA = new LatLng(45.512923, -122.687513);

    static final LatLng HOFF = new LatLng(45.512396, -122.687926);

    static final LatLng PLFD = new LatLng(45.511994, -122.687513);

    static final LatLng ML = new LatLng(45.511702, -122.685797);

    static final LatLng WHP = new LatLng(45.511494, -122.687936);

    static final LatLng PSC = new LatLng(45.510964, -122.686638);

    static final LatLng RGH = new LatLng(45.510584, -122.687078);

    static final LatLng UP = new LatLng(45.507413, -122.680866);

    static final LatLng CB = new LatLng(45.502517, -122.675044);

    static final LatLng CLSB = new LatLng(45.503525, -122.671948);

    static final LatLng NASC = new LatLng(45.509444, -122.685580);

    static final LatLng SH = new LatLng(45.510384, -122.685151);

    static final LatLng NH = new LatLng(45.511158, -122.684797);

    static final LatLng SMSU = new LatLng(45.511858, -122.684304);

    static final LatLng CH = new LatLng(45.512354, -122.684207);

    static final LatLng LH = new LatLng(45.513151, -122.683617);

    static final LatLng PS2 = new LatLng(45.512354, -122.682866);

    static final LatLng KHSE = new LatLng(45.512106, -122.683290);

    static final LatLng USB = new LatLng(45.511993, -122.682684);

    static final LatLng ED = new LatLng(45.511504, -122.683510);

    static final LatLng BA = new LatLng(45.511346, -122.683113);

    static final LatLng PS1 = new LatLng(45.510963, -122.683569);

    static final LatLng EH = new LatLng(45.510346, -122.684159);

    static final LatLng BHB = new LatLng(45.509440, -122.684605);

    static final LatLng PNT = new LatLng(45.509589, -122.683445);

    static final LatLng OND = new LatLng(45.510017, -122.683236);

    static final LatLng CIN = new LatLng(45.510085, -122.682700);

    static final LatLng UCB = new LatLng(45.510518, -122.682780);

    static final LatLng ASRC = new LatLng(45.511406, -122.682108);

    static final LatLng URBN = new LatLng(45.512197, -122.681598);

    static final LatLng MCB = new LatLng(45.512108, -122.679484);

    static final LatLng FAB = new LatLng(45.510228, -122.680467);

    static final LatLng EB = new LatLng(45.509164, -122.681063);

    static final LatLng AB = new LatLng(45.508705, -122.682621);

    static final LatLng SEC = new LatLng(45.507739, -122.682759);

    static final LatLng UTS = new LatLng(45.507811, -122.682267);


    Map<String,Integer> mlevels = new HashMap<String,Integer>();
    Map<String,Integer> mstarts = new HashMap<String,Integer>();




    
	Map<String, LatLng> buildingsList = new HashMap<String,LatLng>();

    //static final LatLng  = new LatLng();
    //static final LatLng  = new LatLng();


    SharedPreferences sharedPreferences;
    int locationCount = 0;

    private Spinner spinner1, spinner2;
    private Button btnSubmit,btnClear;

    private HashMap<String, LatLng> createBuilding(String key, LatLng pnt) {
	    HashMap<String, LatLng> building = new HashMap<String, LatLng>();
	    building.put(key, pnt);

	    return building;
	}
    
    private void initList() {
	    // We populate the Buildings
	    //buildingsList.put("PSU Library",new LatLng(45.511702, -122.685797));
	    //buildingsList.put("Neuberger Hall",new LatLng(45.511221, -122.684692));
	    

	    buildingsList.put("Art Building",AB );
	    buildingsList.put("Academic and Student Recreation Center",ASRC );
	    buildingsList.put("School of Business Administration",BA );
	    buildingsList.put("The Broadway Housing Building",BHB );
	    buildingsList.put("Blackstone",BLKS );
	    buildingsList.put("Corbett Building",CB);
	    buildingsList.put("Cramer Hall",CH );
	    buildingsList.put("Ondine Annex (Cinema)",CIN );
	    buildingsList.put("Collaborative Life Sciences Building",CLSB );
	    buildingsList.put("Engineering Building",EB );
	    buildingsList.put("School of Education",ED );
	    buildingsList.put("East Hall",EH );
	    buildingsList.put("Fourth Avenue Building",FAB );
	    buildingsList.put("Helen Gordon Child Development Center",HGCD );
	    buildingsList.put("Harder House",HH );
	    buildingsList.put("George C. Hoffmann Hall",HOFF );
	    buildingsList.put("Harrison Street Building",HSB );
	    buildingsList.put("Joseph C. Blumel Residence Hall",JCB );
	    buildingsList.put("Koinonia House",KHSE );
	    buildingsList.put("King Albert Building",KNGA );
	    buildingsList.put("Lincoln Hall",LH );
	    buildingsList.put("Market Center Building",MCB );
	    buildingsList.put("Branford Price Millar Library",ML );
	    buildingsList.put("Montgomery Court",MONT );
	    buildingsList.put("Native American Student and Community Center",NASC );
	    buildingsList.put("North Greenhouse",NGH );
	    buildingsList.put("Neuberger Hall",NH );
	    buildingsList.put("Ondine Residence",OND );
	    buildingsList.put("Parkway Building",PKWY );
	    buildingsList.put("University Pointe",PNT );
	    buildingsList.put("Parking Structure 1",PS1 );
	    buildingsList.put("Parking Structure 2",PS2 );
	    buildingsList.put("Parking Structure 3",PS3  );
	    buildingsList.put("Peter W. Stott Center",PSC );
	    buildingsList.put("Research Greenhouse",RGH );
	    buildingsList.put("Science Building One",SB1 );
	    buildingsList.put("Simon Benson House",SBH );
	    buildingsList.put("Science and Education Center",SEC );
	    buildingsList.put("Stephen E. Epler Hall",SEH );
	    buildingsList.put("South Greenhouse",SGH );
	    buildingsList.put("Shattuck Hall",SH );
	    buildingsList.put("Smith Memorial Student Union",SMSU);
	    buildingsList.put("Science Research and Teaching Center",SRTC );
	    buildingsList.put("Stratford Building",STFD );
	    buildingsList.put("Saint Helens Building",STHL );
	    buildingsList.put("University Center Building",UCB );
	    buildingsList.put("University Honors Program",UHP );
	    buildingsList.put("University Place",UP );
	    buildingsList.put("Urban Center",URBN );
	    buildingsList.put("University Services Building",USB );
	    buildingsList.put("University Technology Services",UTS);
	    buildingsList.put("West Heating Plant",WHP );
	    buildingsList.put("XSB",XSB);
	    
	    mstarts.put("ab",0);
	    mstarts.put("asrc",0);
	    mstarts.put("ba",1);
	    mstarts.put("bhb",1);
	    mstarts.put("blks",1);
	    mstarts.put("cb",0);
	    mstarts.put("ch",-1);
	    mstarts.put("cin",0);
	    mstarts.put("clsb",-1);
	    mstarts.put("eb",1);
	    mstarts.put("ed",1);
	    mstarts.put("eh",1);
	    mstarts.put("fab",-1);
	    mstarts.put("hgcd",0);
	    mstarts.put("hh",0);
	    mstarts.put("hoff",1);
	    mstarts.put("hsb",1);
	    mstarts.put("jcb",5);
	    mstarts.put("khse",0);
	    mstarts.put("knga",0);
	    mstarts.put("lh",-1);
	    mstarts.put("mcb",-1);
	    mstarts.put("ml",-1);
	    mstarts.put("mont",0);
	    mstarts.put("nasc",1);
	    mstarts.put("ngh",0);
	    mstarts.put("nh",0);
	    mstarts.put("ond",-1);
	    mstarts.put("pkwy",1);
	    mstarts.put("pnt",1);
	    mstarts.put("ps1",1);
	    mstarts.put("ps2 ",1);
	    mstarts.put("ps3",0);
	    mstarts.put("psc",0);
	    mstarts.put("rgh",1);
	    mstarts.put("sb1",-1);
	    mstarts.put("sbh",1);
	    mstarts.put("sec",0);
	    mstarts.put("seh",1);
	    mstarts.put("sgh",1);
	    mstarts.put("sh",0);
	    mstarts.put("smsu",-1);
	    mstarts.put("srtc",0);
	    mstarts.put("stfd",1);
	    mstarts.put("sthl",1);
	    mstarts.put("ucb",0);
	    mstarts.put("uhp",0);
	    mstarts.put("up",1);
	    mstarts.put("urbn",0);
	    mstarts.put("usb",0);
	    mstarts.put("uts",1);
	    mstarts.put("whp",1);
	    mstarts.put("xsb",0);
	    
	    
	    mlevels.put("ab",4);
	    mlevels.put("asrc",4);
	    mlevels.put("ba",5);
	    mlevels.put("bhb",5);
	    mlevels.put("blks",5);
	    mlevels.put("cb",3);
	    mlevels.put("ch",5);
	    mlevels.put("cin",0);
	    mlevels.put("clsb",5);
	    mlevels.put("eb",5);
	    mlevels.put("ed",5);
	    mlevels.put("eh",3);
	    mlevels.put("fab",3);
	    mlevels.put("hgcd",4);
	    mlevels.put("hh",3);
	    mlevels.put("hoff",1);
	    mlevels.put("hsb",1);
	    mlevels.put("jcb",5);
	    mlevels.put("khse",3);
	    mlevels.put("knga",5);
	    mlevels.put("lh",5);
	    mlevels.put("mcb",4);
	    mlevels.put("ml",5);
	    mlevels.put("mont",4);
	    mlevels.put("nasc",2);
	    mlevels.put("ngh",0);
	    mlevels.put("nh",4);
	    mlevels.put("ond",5);
	    mlevels.put("pkwy",5);
	    mlevels.put("pnt",2);
	    mlevels.put("ps1",5);
	    mlevels.put("ps2",5);
	    mlevels.put("ps3",5);
	    mlevels.put("psc",3);
	    mlevels.put("rgh",1);
	    mlevels.put("sb1",4);
	    mlevels.put("sbh",3);
	    mlevels.put("sec",3);
	    mlevels.put("seh",5);
	    mlevels.put("sgh",1);
	    mlevels.put("sh",4);
	    mlevels.put("smsu",5);
	    mlevels.put("srtc",0);
	    mlevels.put("stfd",3);
	    mlevels.put("sthl",5);
	    mlevels.put("ucb",5);
	    mlevels.put("uhp",5);
	    mlevels.put("up",1);
	    mlevels.put("urbn",4);
	    mlevels.put("usb",3);
	    mlevels.put("uts",5);
	    mlevels.put("whp",1);
	    mlevels.put("xsb",3);

    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        
        initList();
        
        addItemsOnSpinner();
    	addListenerOnButton();
    	addListenerOnSpinnerItemSelection();
 
        // Initializing
        markerPoints = new ArrayList<LatLng>();
 
        // Getting reference to SupportMapFragment of the activity_main
        SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
 
        // Getting Map for the SupportMapFragment
        map = fm.getMap();
        
     // Move the camera instantly to hamburg with a zoom of 15.

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(NH, 16));


        // Zoom in, animating the camera.

        map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
        
        /*pref(FAB,"fab");
        pref(SMSU,"smsu");
        pref(NH,"nh");
        pref(SH,"sh");
        pref(HGCD,"hgcd");
        pref(ML,"ml");*/

        pref(AB,"ab");
        pref(ASRC ,"asrc");
        pref(BA ,"ba");
        pref(BHB ,"bhb");
        pref(BLKS ,"blks");
        pref(CB,"cb");
        pref(CH ,"ch");
        pref(CIN ,"cin");
        pref(CLSB ,"clsb");
        pref(EB ,"eb");
        pref(ED ,"ed");
        pref(EH ,"eh");
        pref(FAB ,"fab");
        pref(HGCD ,"hgcd");
        pref(HH ,"hh");
        pref(HOFF ,"hoff");
        pref(HSB ,"hsb");
        pref(JCB ,"jcb");
        pref(KHSE ,"khse");
        pref(KNGA ,"knga");
        pref(LH ,"lh");
        pref(MCB ,"mcb");
        pref(MONT ,"mont");
        pref(NASC ,"nasc");
        pref(NGH ,"ngh");
        pref(NH ,"nh");
        pref(OND ,"ond");
        pref(PKWY ,"pkwy");
        pref(PLFD ,"plfd");
        pref(PNT ,"pnt");
        pref(PS1 ,"ps1");
        pref(PS2 ,"ps2");
        pref(PS3  ,"ps3");
        pref(PSC ,"psc");
        pref(ML ,"ml");
        pref(RGH ,"rgh");
        pref(SB1 ,"sb1");
        pref(SBH ,"sbh");
        pref(SEC ,"sec");
        pref(SEH ,"seh");
        pref(SGH ,"sgh");
        pref(SH ,"sh");
        pref(SMSU ,"smsu");
        pref(SRTC ,"srtc");
        pref(STFD ,"stfd");
        pref(STHL ,"sthl");
        pref(UCB ,"ucb");
        pref(UHP ,"uhp");
        pref(UP ,"up");
        pref(URBN ,"urbn");
        pref(USB ,"usb");
        pref(UTS,"uts");
        pref(WHP ,"whp");
        pref(XSB ,"xsb");

 
        if(map!=null){
 
            // Enable MyLocation Button in the Map
            map.setMyLocationEnabled(true);
            
           markersInit();
 
 
            // Setting onclick event listener for the map
            map.setOnMapClickListener(new OnMapClickListener() {
 
                @Override
                public void onMapClick(LatLng point) {
 
                    // Already two locations
                    if(markerPoints.size()>1){
                        markerPoints.clear();
                        map.clear();
                    }
 
                    // Adding new item to the ArrayList
                    markerPoints.add(point);
 
                    // Creating MarkerOptions
                    MarkerOptions options = new MarkerOptions();
 
                    // Setting the position of the marker
                    options.position(point);
 
                    /**
                    * For the start location, the color of marker is GREEN and
                    * for the end location, the color of marker is RED.
                    */
                    if(markerPoints.size()==1){
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                    }else if(markerPoints.size()==2){
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    }
 
                    // Add new marker to the Google Map Android API V2
                    map.addMarker(options);
 
                    // Checks, whether start and end locations are captured
                    if(markerPoints.size() >= 2){
                        LatLng origin = markerPoints.get(0);
                        LatLng dest = markerPoints.get(1);
 
                        // Getting URL to the Google Directions API
                        String url = getDirectionsUrl(origin, dest);
 
                        DownloadTask downloadTask = new DownloadTask();
 
                        // Start downloading json data from Google Directions API
                        downloadTask.execute(url);
                    }
                }
            });
        }
    }
    
 // add items into spinner dynamically
 	  public void addItemsOnSpinner() {
 	 
 		spinner1 = (Spinner) findViewById(R.id.spinner1);
 		spinner2 = (Spinner) findViewById(R.id.spinner2);
 		
 		List<String> list = new ArrayList<String>();
 		list.add("Art Building");
 		list.add("Academic and Student Recreation Center");
 		list.add("School of Business Administration");
 		list.add("The Broadway Housing Building");
 		list.add("Blackstone");
 		list.add("Corbett Building");
 		list.add("Cramer Hall");
 		list.add("Ondine Annex (Cinema)");
 		list.add("Collaborative Life Sciences Building");
 		list.add("Engineering Building");
 		list.add("School of Education");
 		list.add("East Hall");
 		list.add("Fourth Avenue Building");
 		list.add("Helen Gordon Child Development Center");
 		list.add("Harder House");
 		list.add("George C. Hoffmann Hall");
 		list.add("Harrison Street Building");
 		list.add("Joseph C. Blumel Residence Hall");
 		list.add("Koinonia House");
 		list.add("King Albert Building");
 		list.add("Lincoln Hall");
 		list.add("Market Center Building");
 		list.add("Branford Price Millar Library");
 		list.add("Montgomery Court");
 		list.add("Native American Student and Community Center");
 		list.add("North Greenhouse");
 		list.add("Neuberger Hall");
 		list.add("Ondine Residence");
 		list.add("Parkway Building");
 		list.add("University Pointe");
 		list.add("Parking Structure 1");
 		list.add("Parking Structure 2");
 		list.add("Parking Structure 3");
 		list.add("Peter W. Stott Center");
 		list.add("Research Greenhouse");
 		list.add("Science Building One");
 		list.add("Simon Benson House");
 		list.add("Science and Education Center");
 		list.add("Stephen E. Epler Hall");
 		list.add("South Greenhouse");
 		list.add("Shattuck Hall");
 		list.add("Smith Memorial Student Union");
 		list.add("Science Research and Teaching Center");
 		list.add("Stratford Building");
 		list.add("Saint Helens Building");
 		list.add("University Center Building");
 		list.add("University Honors Program");
 		list.add("University Place");
 		list.add("Urban Center");
 		list.add("University Services Building");
 		list.add("University Technology Services");
 		list.add("West Heating Plant");
 		list.add("XSB");


 		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
 			android.R.layout.simple_spinner_item, list);
 		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		spinner2.setAdapter(dataAdapter1);
 		
 		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
 				android.R.layout.simple_spinner_item, list);
 			dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 			spinner1.setAdapter(dataAdapter2);
 		
 	  }
 	  
 	  public void markersInit(){
 		  
 		// Opening the sharedPreferences object
          sharedPreferences = getSharedPreferences("location", 0);

          // Getting number of locations already stored
          locationCount = sharedPreferences.getInt("locationCount", 0);

       // Getting stored zoom level if exists else return 0
          String zoom = sharedPreferences.getString("zoom", "0");

          // If locations are already saved
          if(locationCount!=0){

              String lat = "";
              String lng = "";
              String title = "";

              // Iterating through all the locations stored
              for(int i=0;i<locationCount;i++){

                  // Getting the latitude of the i-th location
                  lat = sharedPreferences.getString("lat"+i,"0");

                  // Getting the longitude of the i-th location
                  lng = sharedPreferences.getString("lng"+i,"0");
                  
                  // Getting title of i-th location
                  title = sharedPreferences.getString("title"+i,"");

                  // Drawing marker on the map
                  drawMarker(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)),title);
                  
                  map.setOnMarkerClickListener(this);
                  
                  
              }
              
           // Moving CameraPosition to last clicked position
            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng))));

              // Setting the zoom level in the map on last position  is clicked
              map.animateCamera(CameraUpdateFactory.zoomTo(Float.parseFloat(zoom)));
          }
 		  
 	  };
 	 
 	  public void addListenerOnSpinnerItemSelection() {
 		spinner1 = (Spinner) findViewById(R.id.spinner1);
 		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
 	  }
 	 
 	  // get the selected dropdown list value
 	  public void addListenerOnButton() {
 	 
 		spinner1 = (Spinner) findViewById(R.id.spinner1);
 		spinner2 = (Spinner) findViewById(R.id.spinner2);
 		btnSubmit = (Button) findViewById(R.id.btnSubmit);
 		btnClear = (Button) findViewById(R.id.btnClear);
 		
 		btnClear.setOnClickListener(new OnClickListener(){
 			
 			@Override
 	 		  public void onClick(View v) {
 				
 				if(btnclick == 0)
 				{
 				
 					map.clear();
 					btnclick++;
 				}
 				else
 					
 				{	
 					markersInit();
 					btnclick--;
 				}
 				

 			}
 			
 		});
 	 
 		btnSubmit.setOnClickListener(new OnClickListener() {
 	 
 		  @Override
 		  public void onClick(View v) {
 	 
 		    Toast.makeText(MapView.this,
 			"OnClickListener : " + 
 	                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) + 
 	                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
 				Toast.LENGTH_SHORT).show();
 		    
 		    map.clear();
 		    markersInit();
 		    LatLng origin = buildingsList.get(String.valueOf(spinner1.getSelectedItem()));
 		    LatLng dest = buildingsList.get(String.valueOf(spinner2.getSelectedItem()));
 		    
 		// Getting URL to the Google Directions API
            String url = getDirectionsUrl(origin,dest);

            DownloadTask downloadTask = new DownloadTask();

            // Start downloading json data from Google Directions API
            downloadTask.execute(url);
            
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(origin, 15));


            // Zoom in, animating the camera.

            map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
 		  }
 	 
 		});
 	  }
    
    
    
    
    private String getDirectionsUrl(LatLng origin,LatLng dest){
 
        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;
 
        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;
 
        // Sensor enabled
        String sensor = "sensor=false";
 
        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+"mode=walking"+"&"+sensor;
 
        // Output format
        String output = "json";
 
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;
 
        return url;
    }
    /** A method to download json data from url */
    private String downloadUrl(String strUrl) throws IOException{
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);
 
            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();
 
            // Connecting to url
            urlConnection.connect();
 
            // Reading data from url
            iStream = urlConnection.getInputStream();
 
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
 
            StringBuffer sb = new StringBuffer();
 
            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }
 
            data = sb.toString();
 
            br.close();
 
        }catch(Exception e){
            Log.d("Exception while downloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
 
    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String>{
 
        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {
 
            // For storing data from web service
            String data = "";
 
            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }
 
        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
 
            ParserTask parserTask = new ParserTask();
 
            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }
 
    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{
 
        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
 
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
 
            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();
 
                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }
 
        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();
 
            // Traversing through all the routes
            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();
 
                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);
 
                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);
 
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
 
                    points.add(position);
                }
 
                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(4);
                lineOptions.color(Color.RED);
            }
 
            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);
        }
    }
    
    private void drawMarker(LatLng point, String str){
        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();
        
        //IconGenerator tc = new IconGenerator(this);
        //Bitmap bmp = tc.makeIcon("hello");
        
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.bubble_white);// get the image same as your EditText
        
        int h = bitmap.getHeight()*2;
        int w = bitmap.getWidth() *2;

        bitmap = convertToMutable(bitmap);// converting the bitmap to mutable
        Bitmap incrsize = Bitmap.createScaledBitmap(bitmap, w, h, false);


       
        
        Canvas cs = new Canvas(incrsize);
        Paint pt = new Paint();
        pt.setColor(Color.BLACK);
        //Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
        pt.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        
        String iam = str.toUpperCase(Locale.getDefault());
        
        pt.setTextSize(25);
        cs.drawText(iam, 0, iam.length(), (h / 2) + 10, (w / 2) / 2, pt);
        //pt.setColor(Color.RED);
        //cs.drawText("this is praki", 0, 13, h / 2, w / 3, pt);
 
        // Setting latitude and longitude for the marker
        markerOptions.position(point).title(str).icon(BitmapDescriptorFactory.fromBitmap(incrsize));        
 
        // Adding marker on the Google Map
        map.addMarker(markerOptions);
    }
    
    public void pref(LatLng point, String str)
    {
    	locationCount++;
    	
    	// Opening the sharedPreferences object
        sharedPreferences = getSharedPreferences("location", 0);
    	 
                /** Opening the editor object to write data to sharedPreferences */
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Storing the latitude for the i-th location
        editor.putString("lat"+ Integer.toString((locationCount-1)), Double.toString(point.latitude));

        // Storing the longitude for the i-th location
        editor.putString("lng"+ Integer.toString((locationCount-1)), Double.toString(point.longitude));
        
        // Storing the title for the i-th location
        editor.putString("title"+ Integer.toString((locationCount-1)), str);


        // Storing the count of locations or marker count
        editor.putInt("locationCount", locationCount);

        /** Storing the zoom level to the shared preferences */
        editor.putString("zoom", Float.toString(map.getCameraPosition().zoom));

        /** Saving the values stored in the shared preferences */
        editor.commit();

       // Toast.makeText(getBaseContext(), "Marker is added to the Map", Toast.LENGTH_SHORT).show();

    }
 
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onMarkerClick(Marker arg0) {
		// TODO Auto-generated method stub
		
		 /*Toast.makeText(MapView.this,
		 			"OnClickListener : " + 
		 	                "\nSpinner 1 : "+  mstarts.get(arg0.getTitle().toString())+
		 	                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
		 				Toast.LENGTH_SHORT).show();*/
		Intent cmap = new Intent(MapView.this,Bmaps.class);
    	cmap.putExtra("levels",mlevels.get(arg0.getTitle()));
    	cmap.putExtra("starts",mstarts.get(arg0.getTitle()));
    	cmap.putExtra("bname", arg0.getTitle());
    	startActivity(cmap);

		/*if(arg0.getTitle().equals("ml")) // if marker source is clicked
		{	
        	Intent cmap = new Intent(MapView.this,Bmaps.class);
        	cmap.putExtra("levels", 5);
        	cmap.putExtra("starts", -1);
        	cmap.putExtra("bname", arg0.getTitle());
        	startActivity(cmap);
		}
		else if(arg0.getTitle().equals("nh")) // if marker source is clicked
		{	
        	Intent cmap = new Intent(MapView.this,Bmaps.class);
        	cmap.putExtra("levels", 4);
        	cmap.putExtra("starts", 0);
        	cmap.putExtra("bname", arg0.getTitle());
        	startActivity(cmap);
		}*/
		
		return true;
	}
	
	
	public static Bitmap convertToMutable(Bitmap imgIn) {
	    try {
	        // this is the file going to use temporally to save the bytes.
	        // This file will not be a image, it will store the raw image data.
	        File file = new File(Environment.getExternalStorageDirectory()
	                + File.separator + "temp.tmp");

	        // Open an RandomAccessFile
	        // Make sure you have added uses-permission
	        // android:name="android.permission.WRITE_EXTERNAL_STORAGE"
	        // into AndroidManifest.xml file
	        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

	        // get the width and height of the source bitmap.
	        int width = imgIn.getWidth();
	        int height = imgIn.getHeight();
	        Bitmap.Config type = imgIn.getConfig();

	        // Copy the byte to the file
	        // Assume source bitmap loaded using options.inPreferredConfig =
	        // Config.ARGB_8888;
	        FileChannel channel = randomAccessFile.getChannel();
	        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE,
	                0, imgIn.getRowBytes() * height);
	        imgIn.copyPixelsToBuffer(map);
	        // recycle the source bitmap, this will be no longer used.
	        imgIn.recycle();
	        System.gc();// try to force the bytes from the imgIn to be released

	        // Create a new bitmap to load the bitmap again. Probably the memory
	        // will be available.
	        imgIn = Bitmap.createBitmap(width, height, type);
	        map.position(0);
	        // load it back from temporary
	        imgIn.copyPixelsFromBuffer(map);
	        // close the temporary file and channel , then delete that also
	        channel.close();
	        randomAccessFile.close();

	        // delete the temp file
	        file.delete();

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return imgIn;
	}
}
