package com.zaapam.ginaraidee;

import com.squareup.seismic.ShakeDetector;
import com.zaapam.ginaraidee.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements ShakeDetector.Listener {

	private ShakeDetector shakeDetector;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        shakeDetector = new ShakeDetector(this);
        shakeDetector.start((SensorManager) getSystemService(SENSOR_SERVICE));
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


	@Override
	public void hearShake() {
		// TODO Auto-generated method stub
		Intent i = new Intent(getBaseContext(), ResultActivity.class);
		startActivity(i);
	}
}
