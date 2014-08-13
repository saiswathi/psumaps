package com.example.psumaps;


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
