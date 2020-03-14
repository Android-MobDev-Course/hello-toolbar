package com.mobdev.hellotoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 *
 * Main Application's Activity. The aim of this demo Android app is to show how to use the Toolbar
 * component
 */
public class MainActivity extends AppCompatActivity {

    public static final String RANDOM_NUMBER_EXTRA = "randomNumber";
    public static String TAG = "HelloActionBar";
	private RandomNumberFragment randomFragment = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_activity);

        //Fragment Loading
        if (savedInstanceState == null) {
        	randomFragment  = new RandomNumberFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, randomFragment).commit();
        }

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){

            //Enable or disable the "home" button in the corner of the action bar. (Note that this
            //is the application home/up affordance on the action bar, not the system wide home
            //button.)
            actionBar.setHomeButtonEnabled(false);

            //Set this to true if selecting "home" returns up by a single level in your UI
            //rather than back to the top level or front page.
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
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
        if (id == R.id.action_info) {
        	openInfoActivity();
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void openInfoActivity(){
    	Log.d(MainActivity.TAG,"openInfoActivity() called !");

        int currentRandomNum = 0;
    	
    	if(randomFragment != null)
    		currentRandomNum = randomFragment.getCurrentRandomNumber();
    	
    	Bundle bundle = new Bundle();
		bundle.putInt(RANDOM_NUMBER_EXTRA, currentRandomNum);

		Intent newIntent = new Intent(new Intent(this,InfoActivity.class));
		newIntent.putExtras(bundle);
		startActivity(newIntent);
    }
    
}
