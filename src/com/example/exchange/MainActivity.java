package com.example.exchange;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView start_one;
	TextView end_one;
	ImageView change;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start_one = (TextView) findViewById(R.id.start);
		end_one = (TextView) findViewById(R.id.end);
		change = (ImageView) findViewById(R.id.change);
		
		change.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				ObjectAnimator oa = ObjectAnimator.ofFloat(change, "rotation", 0, 360.0f);
				oa.setDuration(500);
				oa.start();
				
				
				
				final String tv1 = start_one.getText().toString();
				
				final String tv2 = end_one.getText().toString();
				
				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_to_right);
				Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_to_left);
				
				start_one.startAnimation(animation);
				end_one.startAnimation(animation1);
				
				new Handler().postAtTime(new Runnable() {

					@Override
					public void run() {
						start_one.setText(tv2);
						end_one.setText(tv1);
					}
				}, 500);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
