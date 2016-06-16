package com.example.cloth;

import java.util.concurrent.locks.Condition;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Bitmap bitmap;
	private ImageView iv;
	private Bitmap createBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv1);
		//获取要操作的原图
		bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.pre19);
		
		createBitmap = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), bitmap.getConfig());

		Paint paint = new Paint();

		Canvas canvas = new Canvas(createBitmap);

		canvas.drawBitmap(bitmap, new Matrix(), paint);

		iv.setImageBitmap(createBitmap);

		iv.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {

				case MotionEvent.ACTION_MOVE:
					
					for(int i = -10; i < 10; i++){
						for(int j = -6; j < 6; j++){
							
							if(Math.sqrt(i*i+j*j)<7){
								
								try {
									createBitmap.setPixel((int)event.getX()+i, (int) event.getY()+j, Color.TRANSPARENT);
								} catch (Exception e) {
								
								}
					
							}
								
							
						}
					}
					
					
					iv.setImageBitmap(createBitmap);
					
					
					break;
					
					

				}

				return true;
			}
		});
	}

}
