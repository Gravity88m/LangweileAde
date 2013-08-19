package com.example.langeweileade;

import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.langeweileade.R.id;
import com.langweileade.wetter.Globals;
import com.langweileade.wetter.JSONWeatherParser;
import com.langweileade.wetter.Weather;
import com.langweileade.wetter.WeatherHttpClient;

public class MainActivity extends Activity {

	private ImageView img_weather;
	private TextView txt_temp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("**", "on create");
		
		
		
		img_weather = (ImageView) findViewById(R.id.img_weather);
		txt_temp = (TextView) findViewById(R.id.txt_temp);
		
		String city = "Saarbrucken,DE";
		
		JSONWeatherTask task = new JSONWeatherTask();
		task.execute(new String[] { city });
		
		Button btnAddActivity = (Button)this.findViewById(id.addActivity);
		btnAddActivity.setOnClickListener(new OnClickListener()
        { 
        	public void onClick(View arg0) 
        	{
				Intent addActivity = new Intent(MainActivity.this, CreateActivity.class);
				startActivity(addActivity);
        	}
		});

		Button btnMade = (Button)this.findViewById(id.btn_made);
		btnMade.setOnClickListener(new OnClickListener()
		
        { 
        	public void onClick(View arg0) 
        	{
        		
        		
				
        	}
		});
		
		
		Button btnList = (Button)this.findViewById(id.btn_showActivity);
		btnList.setOnClickListener(new OnClickListener()
		
        { 
        	public void onClick(View arg0) 
        	{
        		try {
					Intent makeActivity = new Intent(MainActivity.this, ListAllActivitys.class);
					startActivity(makeActivity);
				} catch (Exception e) {
					Log.i("*E*", e.toString());
				}
        	}
		});		
		
		
		

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

		@Override
		protected Weather doInBackground(String... params) {
			Weather weather = new Weather();
			String data = ((new WeatherHttpClient()).getWeatherData(params[0]));
			
			try {
				weather = JSONWeatherParser.getWeather(data);
				
				// Let's retrieve the icon
				weather.iconData = ((new WeatherHttpClient())
						.getImage(weather.currentCondition.getIcon()));
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return weather;

		}

		@Override
		protected void onPostExecute(Weather weather) {
			super.onPostExecute(weather);
			
			if (weather.iconData != null && weather.iconData.length > 0) {
				Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0,
						weather.iconData.length);
				
				img_weather.setImageBitmap(img);
			}
			txt_temp.setText(""
					+ Math.round((weather.temperature.getTemp() - 275.15))
					+ "°C");
			Globals.CURRENT_TEMP = Math.round((weather.temperature.getTemp() - 275.15));
			Globals.CURRENT_WEATHER = weather.currentCondition.getCondition();
		}

	}
}