package com.example.psumaps;

import uk.co.senab.photoview.PhotoViewAttacher;

import com.theappguruz.imagezoom.ImageViewTouch;



import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.*;
import android.graphics.Canvas;

public class Bmaps extends Activity{
	
	private ImageViewTouch ivLargeImage;
	PhotoViewAttacher mAttacher;

    private Bitmap myBitmap;
    Paint p = new Paint();
    
    
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bmaps);
	        
	        
	        
	        Intent intent = getIntent();
	        int lvl= intent.getIntExtra("levels",-1);
	        int strt= intent.getIntExtra("starts",0);
	        final String bname=intent.getStringExtra("bname");
	        
	        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
	        
	        Button button1 = new Button(this);
	        
	        button1 = (Button)findViewById(R.id.btnhis);
	        button1.setOnClickListener(new View.OnClickListener(){
        		
        		@Override
        		public void onClick(View v)
        		{
        	        

            		ivLargeImage = (ImageViewTouch) findViewById(R.id.imageView1);

        	        
           	     // if image size is too large.Then scale image.
           	        BitmapFactory.Options options = new BitmapFactory.Options();
           	        options.inJustDecodeBounds = true;
           	       
           	        String mDrawableName = bname+"_bgt";
           	        
           	        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
           	        myBitmap = BitmapFactory.decodeResource(getResources(),resID,options);

           	        if (options.outWidth > 3000 || options.outHeight > 2000) {
                   		options.inSampleSize = 4;
                   	} else if (options.outWidth > 2000 || options.outHeight > 1500) {
                   		options.inSampleSize = 3;
                   	} else if (options.outWidth > 1000 || options.outHeight > 1000) {
                   		options.inSampleSize = 2;
                   	}
                   	options.inJustDecodeBounds = false;
            
                   	
                   myBitmap = BitmapFactory.decodeResource(getResources(),resID,options);
              
                   //Canvas ca= new Canvas(Bitmap b);
                   
                   ivLargeImage.setImageBitmapReset(myBitmap, 0, true);
                   
           		// Toast.makeText(Bmaps.this, "x ["+mDrawableName+"]", Toast.LENGTH_SHORT).show();
           		 
           		 Display display = getWindowManager().getDefaultDisplay();
           		 Point size = new Point();
           		 display.getSize(size);
           		
           		 int width = size.x;
           		 int height = size.y;
           		 
           		// set maximum scroll amount (based on center of image)
           		    int maxX = (int)((myBitmap.getWidth() / 2) - (width / 2));
           		    int maxY = (int)((myBitmap.getHeight() / 2) - (height / 2));

           		    // set scroll limits
           		    final int maxLeft = (maxX * -1);
           		    final int maxRight = maxX;
           		    final int maxTop = (maxY * -1);
           		    final int maxBottom = maxY;

            	
        	        
        		}
        		        		
        	});
	        
        	{
        		ivLargeImage = (ImageViewTouch) findViewById(R.id.imageView1);

    	        
       	     // if image size is too large.Then scale image.
       	        BitmapFactory.Options options = new BitmapFactory.Options();
       	        options.inJustDecodeBounds = true;
       	       
       	        String mDrawableName = bname+"_bg";
       	        
       	        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
       	        myBitmap = BitmapFactory.decodeResource(getResources(),resID,options);

       	        if (options.outWidth > 3000 || options.outHeight > 2000) {
               		options.inSampleSize = 4;
               	} else if (options.outWidth > 2000 || options.outHeight > 1500) {
               		options.inSampleSize = 3;
               	} else if (options.outWidth > 1000 || options.outHeight > 1000) {
               		options.inSampleSize = 2;
               	}
               	options.inJustDecodeBounds = false;
        
               	
               myBitmap = BitmapFactory.decodeResource(getResources(),resID,options);
          
               //Canvas ca= new Canvas(Bitmap b);
               
               ivLargeImage.setImageBitmapReset(myBitmap, 0, true);
               
       		// Toast.makeText(Bmaps.this, "x ["+mDrawableName+"]", Toast.LENGTH_SHORT).show();
       		 
       		 Display display = getWindowManager().getDefaultDisplay();
       		 Point size = new Point();
       		 display.getSize(size);
       		
       		 int width = size.x;
       		 int height = size.y;
       		 
       		// set maximum scroll amount (based on center of image)
       		    int maxX = (int)((myBitmap.getWidth() / 2) - (width / 2));
       		    int maxY = (int)((myBitmap.getHeight() / 2) - (height / 2));

       		    // set scroll limits
       		    final int maxLeft = (maxX * -1);
       		    final int maxRight = maxX;
       		    final int maxTop = (maxY * -1);
       		    final int maxBottom = maxY;

        	}
	        
	        for(int i=0,j=strt;i<lvl;i++,j++)
	        {
	        	TableRow tableRow = new TableRow(this);
	        	tableRow.setLayoutParams(new TableLayout.LayoutParams(
	        			TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT));
	        	
	        	table.addView(tableRow);
	        	
	        	final Button myButton = new Button(this);
	        	
	        	myButton.setText(Integer.toString(j));
	        	
	        	
	        	myButton.setOnClickListener(new View.OnClickListener(){
	        		
	        		@Override
	        		public void onClick(View v)
	        		{
	        	        
	        			tableButtonClicked((String) myButton.getText(),bname);
	        	        
	        		}
	        		        		
	        	});

	        	tableRow.addView(myButton);

	        }
	 }
	 
	 
	 
	
	 private void tableButtonClicked(String str,String b) {
		 
		 if ( Integer.parseInt(str)== 0)
		 {
			 str = "b";
		 }
		 else if(Integer.parseInt(str) == -1)
		 {
			 str = "sb";
		 }
		 
		 
		 
		 ivLargeImage = (ImageViewTouch) findViewById(R.id.imageView1);

	        
	     // if image size is too large.Then scale image.
	        BitmapFactory.Options options = new BitmapFactory.Options();
	        options.inJustDecodeBounds = true;
	       
	        String mDrawableName = b+"_"+str;
	        
	        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
	        myBitmap = BitmapFactory.decodeResource(getResources(),resID,options);

	        if (options.outWidth > 3000 || options.outHeight > 2000) {
        		options.inSampleSize = 4;
        	} else if (options.outWidth > 2000 || options.outHeight > 1500) {
        		options.inSampleSize = 3;
        	} else if (options.outWidth > 1000 || options.outHeight > 1000) {
        		options.inSampleSize = 2;
        	}
        	options.inJustDecodeBounds = false;
 
        	
        myBitmap = BitmapFactory.decodeResource(getResources(),resID,options);
   
        //Canvas ca= new Canvas(Bitmap b);
        
        ivLargeImage.setImageBitmapReset(myBitmap, 0, true);
        
		// Toast.makeText(Bmaps.this, "x ["+mDrawableName+"]", Toast.LENGTH_SHORT).show();
		 
		 Display display = getWindowManager().getDefaultDisplay();
		 Point size = new Point();
		 display.getSize(size);
		
		/* int width = size.x;
		 int height = size.y;
		 
		// set maximum scroll amount (based on center of image)
		    int maxX = (int)((myBitmap.getWidth() / 2) - (width / 2));
		    int maxY = (int)((myBitmap.getHeight() / 2) - (height / 2));

		    // set scroll limits
		    final int maxLeft = (maxX * -1);
		    final int maxRight = maxX;
		    final int maxTop = (maxY * -1);
		    final int maxBottom = maxY;

        
        ivLargeImage.setOnTouchListener(new OnTouchListener(){
        	
        	float downX, downY;
            int totalX, totalY;
            int scrollByX, scrollByY;
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
        	
                // TODO Auto-generated method stub
        		
        		float currentX, currentY;

        		switch (event.getAction()) {

        		case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    
        			 Toast.makeText(Bmaps.this, "x ["+downX+"] - y ["+downY+"]", Toast.LENGTH_SHORT).show();
        			 
        			 //ca.drawBitmap(myBitmap, new Matrix(), null);
        			 //ca.drawCircle(eventX,eventY,2, null);
        			 //invalidate();
        			 
        		/*case MotionEvent.ACTION_MOVE:
                    currentX = event.getX();
                    currentY = event.getY();
                    scrollByX = (int)(downX - currentX);
                    scrollByY = (int)(downY - currentY);

                    // scrolling to left side of image (pic moving to the right)
                    if (currentX > downX)
                    {
                        if (totalX == maxLeft)
                        {
                            scrollByX = 0;
                        }
                        if (totalX > maxLeft)
                        {
                            totalX = totalX + scrollByX;
                        }
                        if (totalX < maxLeft)
                        {
                            scrollByX = maxLeft - (totalX - scrollByX);
                            totalX = maxLeft;
                        }
                    }

                    // scrolling to right side of image (pic moving to the left)
                    if (currentX < downX)
                    {
                        if (totalX == maxRight)
                        {
                            scrollByX = 0;
                        }
                        if (totalX < maxRight)
                        {
                            totalX = totalX + scrollByX;
                        }
                        if (totalX > maxRight)
                        {
                            scrollByX = maxRight - (totalX - scrollByX);
                            totalX = maxRight;
                        }
                    }

                    // scrolling to top of image (pic moving to the bottom)
                    if (currentY > downY)
                    {
                        if (totalY == maxTop)
                        {
                            scrollByY = 0;
                        }
                        if (totalY > maxTop)
                        {
                            totalY = totalY + scrollByY;
                        }
                        if (totalY < maxTop)
                        {
                            scrollByY = maxTop - (totalY - scrollByY);
                            totalY = maxTop;
                        }
                    }

                    // scrolling to bottom of image (pic moving to the top)
                    if (currentY < downY)
                    {
                        if (totalY == maxBottom)
                        {
                            scrollByY = 0;
                        }
                        if (totalY < maxBottom)
                        {
                            totalY = totalY + scrollByY;
                        }
                        if (totalY > maxBottom)
                        {
                            scrollByY = maxBottom - (totalY - scrollByY);
                            totalY = maxBottom;
                        }
                    }

                    ivLargeImage.scrollBy(scrollByX, scrollByY);
                    downX = currentX;
                    downY = currentY;
                    break;

            }

            return true;
        		 
        	}
        });*/
        	
		 
	 }
}
	    	
			