package com.example.psumaps;

/******************************************************************************* 
 * psumaps – An open source Android application which is helpful to portland state univeristy students to navigate 
 * and get to know the campus buildings history. Users can also check out the floor plans of each building in order
 * to navigate.
 *
 * Copyright (C) 2014 Sai Swathi Pujari
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. 
 * If not, see http://www.gnu.org/licenses/.
 *
 * Following is the link for the repository: https://github.com/saiswathi/psumaps
 *
 * Please, see the file license in this distribution for license terms. Link is
 * https://github.com/saiswathi/psumaps/blob/master/LICENSE
 *
 * References:
 * https://developers.google.com/maps/documentation/android/start#getting_the_google_maps_android_api_v2
 * https://developers.google.com/maps/documentation/android/
 * http://stackoverflow.com/questions/9605913/how-to-parse-json-in-android
 *
 * Author - Sai Swathi Pujari
 * email: spujari@pdx.edu
 *
 *  ******************************************************************************************/

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
