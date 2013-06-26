package com.example.langeweileade;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spin_Weather = (Spinner)this.findViewById(R.id.spin_weather);
		List<String> weathers = new ArrayList<String>();
		weathers.add("Heiﬂ");
		weathers.add("Kalt");
		
		ArrayAdapter<String> spin_WeatherAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,weathers);
		spin_WeatherAdapter.setDropDownViewResource(R.layout.weatherspin_item);
		
		spin_Weather.setAdapter(spin_WeatherAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
