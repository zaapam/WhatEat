package com.zaapam.ginaraidee;

import com.zaapam.ginaraidee.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//ActionBar bar = getActionBar();
		//bar.hide();
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 0);
		setContentView(R.layout.activity_splash);
		
		Thread background = new Thread() {
            public void run() {
                 
                try {
                    // Thread will sleep for 5 seconds
                    sleep(5*1000);
                    
                    /// Load logic part
                    ((GinaRaiDee)getApplication()).getFoodManager().load();
                    
                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                     
                    //Remove activity
                    finish();
                     
                } catch (Exception e) {
                	
                }
            }
        };
         
        // start thread
        background.start();
	}
}
