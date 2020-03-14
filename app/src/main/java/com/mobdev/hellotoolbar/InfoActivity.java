package com.mobdev.hellotoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 *
 * InfoActivity of the Demo App. It is just a container for the InfoFragment
 */
public class InfoActivity extends AppCompatActivity {

	private static final String TAG = "InfoActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_fragment_activity);

		if (savedInstanceState == null) {

			InfoFragment infoFragemnt = null;

			Bundle bundle = this.getIntent().getExtras();
			if(bundle != null)
				infoFragemnt = new InfoFragment(bundle.getInt(MainActivity.RANDOM_NUMBER_EXTRA,0));
			else
				infoFragemnt = new InfoFragment(0);

			getSupportFragmentManager().beginTransaction().add(R.id.container, infoFragemnt).commit();
		}

		Toolbar toolbar = (Toolbar)findViewById(R.id.my_awesome_toolbar);
		toolbar.setTitle(getString(R.string.app_info_title));
		setSupportActionBar(toolbar);

		ActionBar actionBar = getSupportActionBar();

		//If the action bar is available enable the click on the top left button
		//navigate back to the previous activity
		if(actionBar != null){
			actionBar.setHomeButtonEnabled(true);
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	//Uncomment this method to handle the navigation with a custom flow and back activity
	/*
	@Override
	public boolean onOptionsItemSelected(MenuItem item){

		switch (item.getItemId()) {
		// Respond to the action bar's Up/Home button in order to customize the action's response
		case android.R.id.home:


			// Use the native nagivation system reading the configuration from Manifest Activity
			// Parent Configuration
			//Log.d(TAG, "Using NavUtils to handle Activity Navigation with Manifest Configuration ...");
			//NavUtils.navigateUpFromSameTask(this);


			Log.d(TAG, "Navigating to a custom Activity: MainActivity ...");
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivityForResult(intent, 0);

			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
