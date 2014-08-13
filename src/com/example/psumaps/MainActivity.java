package com.example.psumaps;

import android.app.Activity;
import android.content.*;
import android.net.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class MainActivity extends Activity

{

	Button button1;
	Button button2;

/** Called when the activity is first created. */
	
   
@Override

public void onCreate(Bundle savedInstanceState)

{

super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

addListenerOnButton();


}

public void addListenerOnButton() {
	 
	button1 = (Button) findViewById(R.id.button1);
	button2 = (Button) findViewById(R.id.button2);


	button1.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {

		  Intent blist = 
                        new Intent(MainActivity.this,BList.class);
		    startActivity(blist);

		}

	});
	
	button2.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {

		  Intent cmap = 
                        new Intent(MainActivity.this,MapView.class);
                        		//Intent.ACTION_VIEW, Uri.parse("http://www.mkyong.com"));
		    startActivity(cmap);

		}

	});

}



}/* End of Main Activity */