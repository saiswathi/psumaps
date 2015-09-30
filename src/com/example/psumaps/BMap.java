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
 *
 *  ******************************************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.psumaps.R;
import com.theappguruz.imagezoom.ImageViewTouch;

public class BMap extends Activity {
	
	ImageView image;
	private ImageViewTouch ivLargeImage;
    private Bitmap myBitmap;

	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmap);
        ivLargeImage = (ImageViewTouch) findViewById(R.id.imageView1);
        Intent intent = getIntent();
        int pos= intent.getIntExtra("pos",-1);

 
        // if image size is too large.Then scale image.
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
 
		Toast.makeText(BMap.this, "Item with id ["+pos+"]", Toast.LENGTH_SHORT).show();

                // provide image path for create Bitmap from image.
       // myBitmap = BitmapFactory.decodeFile(psuimg.getAbsolutePath());
        //Or
       
        	
        	
        	int[] drawables={R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,
        					 R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,
        					 R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,
        					 R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,
        					 R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,
        					 R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,R.drawable.psusign,
        					 R.drawable.psusign,R.drawable.psusign,R.drawable.lib1st   
        					};
        	
            myBitmap = BitmapFactory.decodeResource(getResources(),drawables[pos],options);

 
        	if (options.outWidth > 3000 || options.outHeight > 2000) {
        		options.inSampleSize = 4;
        	} else if (options.outWidth > 2000 || options.outHeight > 1500) {
        		options.inSampleSize = 3;
        	} else if (options.outWidth > 1000 || options.outHeight > 1000) {
        		options.inSampleSize = 2;
        	}
        	options.inJustDecodeBounds = false;
 
        	
        myBitmap = BitmapFactory.decodeResource(getResources(),drawables[pos],options);
   
        
        ivLargeImage.setImageBitmapReset(myBitmap, 0, true);
        
        
 
    }
	
	
}
