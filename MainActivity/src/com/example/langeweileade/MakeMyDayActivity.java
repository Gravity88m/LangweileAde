package com.example.langeweileade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.R.drawable;
import android.app.Activity;
import android.database.Cursor;
import android.database.CursorJoiner.Result;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;







/*
 * README
 * 
 * ToDos:
 * Wetter und Temperatur
 * Pruefen ob Wetter abgerufen werden konnte; wenn nicht Wetter bei Suche nicht beruecksichtigen
 * Fehlerbehandlung (Try/catch bloecke, Exceptions ueber Toasts bei falsche eingaben)
 * Feststellung des aktuellen Ortes fuers Wetter -> Permission setzen
 * 
 * @ Cheng & Andy
 * Lˆschen von Aktivitaeten
 * Bearbeiten von Aktivitaeten
 * Ueberpruefung der eingegebenen Werte in CreateActivity/ChangeActivity -> Activity darf nicht 2x mit gleichen Namen angelegt werden
 * 
 * (Formatierung des Quelltextes/Korrektur der Variablennamen)
 * Layout komplett
 * evtl. Defaulteintraege in der Datenbank um leichter testen zu koennen
 * 
 */

public class MakeMyDayActivity extends Activity implements OnItemClickListener {

	protected ListView listView;
	protected List<RowItem> rowItems;
	
	private int[] wochentag = new int[8];
	
	
	// Deklatation der Spaltenindizes
	int name = 0;
	int beschreibung = 0;
	int kosten = 0;
	int checkWochentag = 0;
	int checkTageszeit = 0;
	int checkTemperatur = 0;
	int checkWetter = 0;
	
	int Montag = 0;
	int Dienstag = 0;
	int Mittwoch = 0;
	int Donnerstag = 0;
	int Freitag = 0;
	int Samstag = 0;
	int Sonntag = 0;
	
	int Sonne = 0;
	int Regen = 0;
	int Schnee = 0;
	int Wind = 0;
	
	int Morgends = 0;
	int Abends = 0;
	int Mittags = 0;
	int Nachts = 0;
	
	int Kosten = 0;
	
	int TempMax = 0;
	int TempMin = 0;
	
	//Festlegung der Tageszeiten
	private static final int ANFANG_MORGENDS = 6;
	private static final int ANFANG_MITTAGS = 12;
	private static final int ANFANG_ABENDS = 18;
	private static final int ANFANG_NACHTS = 21;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
	
		DatabaseHelper dbHelper;
		
		Bundle budgetBundle = getIntent().getExtras();
		double budget = budgetBundle.getDouble("Budget");
		
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 

		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		int hour = Integer.parseInt(sdf.format(new Date())); 
		

		
	
		
		

		
		dbHelper = new DatabaseHelper(this);
		
		
		rowItems = new ArrayList<RowItem>();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "SELECT * FROM activity";
		Cursor result = db.rawQuery(sql, null);

		
		

	
	
		
		
		
		
		
		if (result.moveToFirst()) {
			name = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_NAME);
			beschreibung = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_BESCHREIBUNG);
			kosten = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_KOSTEN);
			checkWochentag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_STATUS); 
			checkTageszeit = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_STATUS); 
			checkTemperatur = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_STATUS); 
			checkWetter = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_STATUS); 
			
			
			kosten = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_KOSTEN);
			
			
			Montag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MO);
			Dienstag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DI);
			Mittwoch = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MI);
			Donnerstag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DO);
			Freitag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_FR);
			Samstag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SA);
			Sonntag = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SO);
			
			
			Sonne = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_SONNE);
			Regen = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_REGEN);
			Schnee = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_SCHNEE);
			Wind = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_WIND);
			
			Morgends = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MORGENS);
			Mittags = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MITTAGS);
			Abends = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_ABENDS);
			Nachts = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_NACHTS);

			TempMax = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MAX);
			TempMin = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MIN);
		}
		
		
		
		do {
			Log.i("**", "Kostet " + result.getDouble(kosten));
			wochentag[0] = 0;
			wochentag[1] = result.getInt(Sonntag);	
			wochentag[2] = result.getInt(Montag);
			wochentag[3] = result.getInt(Dienstag);
			wochentag[4] = result.getInt(Mittwoch);
			wochentag[5] = result.getInt(Donnerstag);
			wochentag[6] = result.getInt(Freitag);
			wochentag[7] = result.getInt(Samstag);
			
			
			String nameTodo = result.getString(name);
			String beschreibungTodo = result.getString(beschreibung);
			double kostenTodo = result.getDouble(kosten);
			
			boolean matches = true; //Variable um zu bestimmen ob Datensatz angezeigt werden soll
			
			
			if (result.getInt(checkWochentag) == 1) {
			
				if (result.getInt(wochentag[day]) != 0) {
					matches = false;
				}
			}
			if (result.getInt(checkWetter) != 0 & matches == true) {
				
				
				//TODO
				//Spaltenindex in Variablen Sonne,Regen, Wind, Schnee gespeichert
				
				
			}
			if (result.getInt(checkTemperatur) != 0 & matches == true) {
				
				
				//TODO
				//Spaltenindex in TempMin/TempMax gespeichert
				
				
			}
			if (result.getInt(checkTageszeit) != 0 & matches == true) {
				if (result.getInt(Morgends) == 1 & (hour < ANFANG_MORGENDS | hour >= ANFANG_MITTAGS)) {
					matches = false;
				}
				if (result.getInt(Mittags) == 1 & (hour < ANFANG_MITTAGS | hour >= ANFANG_ABENDS)) {
					matches = false;
				}
				if (result.getInt(Abends) == 1 & (hour < ANFANG_ABENDS | hour >= ANFANG_NACHTS)) {
					matches = false;
				}
				if (result.getInt(Nachts) == 1 & (hour < ANFANG_NACHTS | hour >= ANFANG_MORGENDS)) {
					matches = false;
				}
			}
			
			if (result.getDouble(kosten) > budget) {
				matches = false;
			}
			
			
			if (matches == true) {	//Activity wird der Ausgabeliste hinzugefuegt, wenn sie zu den Parametern passt
				Log.i("**", "add");
				RowItem item = new RowItem(drawable.btn_star, nameTodo, beschreibungTodo, kostenTodo);
			    rowItems.add(item);
			}

			Log.i("**", "next");
		} while (result.moveToNext()); // solange Datens‰tze vorhanden
	
		result.close(); // Cursor schlieﬂen
		db.close(); // Datenbank schlieﬂen
		
	


		listView = (ListView) findViewById(R.id.list);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		registerForContextMenu(listView);
	
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast toast = Toast.makeText(getApplicationContext(),
			"Item " + (position + 1) + ": " + rowItems.get(position),
			Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}
	

	
}