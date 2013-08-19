package com.example.langeweileade;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CreateActivity extends Activity {
	private int myValue;
	public DatabaseHelper dpHelper;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dpHelper = new DatabaseHelper(this);

		// Layout setzen
		setContentView(R.layout.createactivity_main);

		// Titel setzten
		setTitle("Activity anlegen/bearbeiten/löschen");

		// Layout elemente
		final EditText editTextName = (EditText) this
				.findViewById(R.id.edtName);
		final EditText editTextBeschreibung = (EditText) this
				.findViewById(R.id.edtBeschreibung);
		final EditText editTextKosten = (EditText) this
				.findViewById(R.id.edtKosten);
		final CheckBox checkBoxMontag = (CheckBox) this
				.findViewById(R.id.cbMontag);
		final CheckBox checkBoxDienstag = (CheckBox) this
				.findViewById(R.id.cbDienstag);
		final CheckBox checkBoxMittwoch = (CheckBox) this
				.findViewById(R.id.cbMittwoch);
		final CheckBox checkBoxDonnerstag = (CheckBox) this
				.findViewById(R.id.cbDonnerstag);
		final CheckBox checkBoxFreitag = (CheckBox) this
				.findViewById(R.id.cbFreitag);
		final CheckBox checkBoxSamstag = (CheckBox) this
				.findViewById(R.id.cbSamstag);
		final CheckBox checkBoxSonntag = (CheckBox) this
				.findViewById(R.id.cbSonntag);
		final ToggleButton toggleButtonWochentag = (ToggleButton) this
				.findViewById(R.id.tbtnWochentag);
		final EditText editTextTempMin = (EditText) this
				.findViewById(R.id.edtMin);
		final EditText editTextTempMax = (EditText) this
				.findViewById(R.id.edtMax);
		final ToggleButton toggleButtonTemperatur = (ToggleButton) this
				.findViewById(R.id.tbtnTemperatur);
		final EditText editTextPersonen = (EditText) this
				.findViewById(R.id.edtPersonen);
		final ToggleButton toggleButtonPersonen = (ToggleButton) this
				.findViewById(R.id.tbtnPersonen);
		final CheckBox checkBoxMorgens = (CheckBox) this
				.findViewById(R.id.cbMorgens);
		final CheckBox checkBoxMittags = (CheckBox) this
				.findViewById(R.id.cbMittags);
		final CheckBox checkBoxAbends = (CheckBox) this
				.findViewById(R.id.cbAbends);
		final CheckBox checkBoxNachts = (CheckBox) this
				.findViewById(R.id.cbNachts);
		final ToggleButton toggleButtonTageszeit = (ToggleButton) this
				.findViewById(R.id.tbtnTageszeit);
		final CheckBox checkBoxSonnig = (CheckBox) this
				.findViewById(R.id.cbSonnig);
		final CheckBox checkBoxWindig = (CheckBox) this
				.findViewById(R.id.cbWindig);
		final CheckBox checkBoxSchnee = (CheckBox) this
				.findViewById(R.id.cbSchnee);
		final CheckBox checkBoxRegen = (CheckBox) this
				.findViewById(R.id.cbRegen);
		final ToggleButton toggleButtonWetter = (ToggleButton) this
				.findViewById(R.id.tbtnWetter);

		// übergabe parameter
		// Intent intent = getIntent();
		// final int myValue =
		// Integer.parseInt(intent.getStringExtra("my.key"));
		myValue = -1;

		// Layout elemente füllen, wenn element übergeben wurde
		if (myValue != -1) {
			// Datenbank zum Lesen öffnen
			SQLiteDatabase db = dpHelper.getReadableDatabase();
			// SQL Statement erstellen
			String sql = "SELECT * FROM " + DatabaseHelper.TABLE_ACTIVITY
					+ " WHERE " + DatabaseHelper.ACTIVITY_FIELD_ID + "="
					+ myValue;
			// query ausführen
			Cursor result = db.rawQuery(sql, null);

			if (result.moveToFirst()) { // wenn Cursor nicht leer
				// Spaltenindex vom Datums- und Titel-Feld abrufen
				int name = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_NAME);
				int beschreibung = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_BESCHREIBUNG);
				int kosten = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_KOSTEN);
				int personen = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_PERSONEN);
				int pStatus = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS);
				int checkMo = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MO);
				int checkDi = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DI);
				int checkMi = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MI);
				int checkDo = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DO);
				int checkFr = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_FR);
				int checkSa = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SA);
				int checkSo = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SO);
				int wStatus = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_STATUS);
				int tempMin = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MIN);
				int tempMax = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MAX);
				int tempStatus = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_STATUS);
				int checkMorgens = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MORGENS);
				int checkMittags = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MITTAGS);
				int checkAbends = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_ABENDS);
				int checkNachts = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_NACHTS);
				int tagStatus = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_STATUS);
				int checkSonne = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_SONNE);
				int checkWind = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_WIND);
				int checkSchnee = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_SCHNEE);
				int checkRegen = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_REGEN);
				int wetterStatus = result
						.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_WETTER_STATUS);

				do { // für jeden Datensatz
						// Datum und Titel auslesen
					String nameTodo = result.getString(name);
					String beschreibungTodo = result.getString(beschreibung);
					double kostenTodo = result.getDouble(kosten);
					int togglePersonen = result.getInt(pStatus);
					int personenTodo = result.getInt(personen);
					int toggleWochentag = result.getInt(wStatus);
					int checkMoActivity = result.getInt(checkMo);
					int checkDiActivity = result.getInt(checkDi);
					int checkMiActivity = result.getInt(checkMi);
					int checkDoActivity = result.getInt(checkDo);
					int checkFrActivity = result.getInt(checkFr);
					int checkSaActivity = result.getInt(checkSa);
					int checkSoActivity = result.getInt(checkSo);
					int tempMinTodo = result.getInt(tempMin);
					int tempMaxTodo = result.getInt(tempMax);
					int toggleTemp = result.getInt(tempStatus);
					int toggleTage = result.getInt(tagStatus);
					int checkMorgensActivity = result.getInt(checkMorgens);
					int checkMittagsActivity = result.getInt(checkMittags);
					int checkAbendsActivity = result.getInt(checkAbends);
					int checkNachtsActivity = result.getInt(checkNachts);
					int toggleWetter = result.getInt(wetterStatus);
					int checkSonneActivity = result.getInt(checkSonne);
					int checkWindActivity = result.getInt(checkWind);
					int checkSchneeActivity = result.getInt(checkSchnee);
					int checkRegenActivity = result.getInt(checkRegen);

					editTextName.setText(nameTodo);
					editTextBeschreibung.setText(beschreibungTodo);
					editTextKosten.setText("" + kostenTodo);
					editTextPersonen.setText("" + personenTodo);
					editTextTempMin.setText("" + tempMinTodo);
					editTextTempMax.setText("" + tempMaxTodo);

					if (togglePersonen == 1) {
						toggleButtonPersonen.setChecked(true);
					} else {
						toggleButtonPersonen.setChecked(false);
					}
					if (toggleTemp == 1) {
						toggleButtonTemperatur.setChecked(true);
					} else {
						toggleButtonTemperatur.setChecked(false);
					}
					if (toggleTage == 1) {
						toggleButtonTageszeit.setChecked(true);
					} else {
						toggleButtonTageszeit.setChecked(false);
					}
					if (toggleWochentag == 1) {
						toggleButtonWochentag.setChecked(true);
					} else {
						toggleButtonWochentag.setChecked(false);
					}
					if (toggleWetter == 1) {
						toggleButtonWetter.setChecked(true);
					} else {
						checkBoxMontag.setChecked(false);
					}
					if (checkMoActivity == 1) {
						checkBoxMontag.setChecked(true);
					} else {
						checkBoxMontag.setChecked(false);
					}
					if (checkDiActivity == 1) {
						checkBoxDienstag.setChecked(true);
					} else {
						checkBoxDienstag.setChecked(false);
					}
					if (checkMiActivity == 1) {
						checkBoxMittwoch.setChecked(true);
					} else {
						checkBoxMittwoch.setChecked(false);
					}
					if (checkDoActivity == 1) {
						checkBoxDonnerstag.setChecked(true);
					} else {
						checkBoxDonnerstag.setChecked(false);
					}
					if (checkFrActivity == 1) {
						checkBoxFreitag.setChecked(true);
					} else {
						checkBoxFreitag.setChecked(false);
					}
					if (checkSaActivity == 1) {
						checkBoxSamstag.setChecked(true);
					} else {
						checkBoxSamstag.setChecked(false);
					}
					if (checkSoActivity == 1) {
						checkBoxSonntag.setChecked(true);
					} else {
						checkBoxSonntag.setChecked(false);
					}
					if (checkMorgensActivity == 1) {
						checkBoxMorgens.setChecked(true);
					} else {
						checkBoxMorgens.setChecked(false);
					}
					if (checkMittagsActivity == 1) {
						checkBoxMittags.setChecked(true);
					} else {
						checkBoxMittags.setChecked(false);
					}
					if (checkAbendsActivity == 1) {
						checkBoxAbends.setChecked(true);
					} else {
						checkBoxAbends.setChecked(false);
					}
					if (checkNachtsActivity == 1) {
						checkBoxNachts.setChecked(true);
					} else {
						checkBoxNachts.setChecked(false);
					}
					if (checkSonneActivity == 1) {
						checkBoxSonnig.setChecked(true);
					} else {
						checkBoxSonnig.setChecked(false);
					}
					if (checkWindActivity == 1) {
						checkBoxWindig.setChecked(true);
					} else {
						checkBoxWindig.setChecked(false);
					}
					if (checkSchneeActivity == 1) {
						checkBoxSchnee.setChecked(true);
					} else {
						checkBoxSchnee.setChecked(false);
					}
					if (checkRegenActivity == 1) {
						checkBoxRegen.setChecked(true);
					} else {
						checkBoxRegen.setChecked(false);
					}
				} while (result.moveToNext()); // solange Datensätze vorhanden
			}
			result.close(); // Cursor schließen
			db.close(); // Datenbank schließen
		}

		// Listener für Speicher-Button
		Button btn_save = (Button) this.findViewById(R.id.btnSave);
		btn_save.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if (myValue == -1) {
					// Datenbank zum Schreiben öffnen
					SQLiteDatabase db = dpHelper.getReadableDatabase();

					// Datensatz erstellen
					ContentValues vals = new ContentValues();
					vals.put(DatabaseHelper.ACTIVITY_FIELD_NAME, editTextName
							.getText().toString());
					vals.put(DatabaseHelper.ACTIVITY_FIELD_BESCHREIBUNG,
							editTextBeschreibung.getText().toString());
					vals.put(DatabaseHelper.ACTIVITY_FIELD_KOSTEN,
							editTextKosten.getText().toString());
					vals.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN,
							editTextPersonen.getText().toString());
					vals.put(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MIN,
							editTextTempMin.getText().toString());
					vals.put(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MAX,
							editTextTempMax.getText().toString());

					int y = 1;
					int n = 0;

					if (toggleButtonPersonen.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS,
								y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS,
								n);
					}

					if (checkBoxMontag.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MO, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MO, n);
					}

					if (checkBoxDienstag.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DI, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DI, n);
					}

					if (checkBoxMittwoch.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MI, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MI, n);
					}

					if (checkBoxDonnerstag.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DO, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DO, n);
					}

					if (checkBoxFreitag.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_FR, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_FR, n);
					}

					if (checkBoxSamstag.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SA, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SA, n);
					}

					if (checkBoxSonntag.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SO, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SO, n);
					}

					if (toggleButtonWochentag.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_STATUS,
								y);
					} else {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_STATUS,
								n);
					}

					if (toggleButtonTemperatur.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_STATUS,
								y);
					} else {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_STATUS,
								n);
					}

					if (checkBoxMorgens.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MORGENS,
								y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS,
								n);
					}

					if (checkBoxMittags.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MITTAGS,
								y);
					} else {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MITTAGS,
								n);
					}

					if (checkBoxAbends.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_ABENDS,
								y);
					} else {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_ABENDS,
								n);
					}

					if (checkBoxNachts.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_NACHTS,
								y);
					} else {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_NACHTS,
								n);
					}

					if (toggleButtonTageszeit.isChecked()) {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_STATUS,
								y);
					} else {
						vals.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_STATUS,
								n);
					}

					if (checkBoxSonnig.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SONNE, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SONNE, n);
					}

					if (checkBoxWindig.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_WIND, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_WIND, n);
					}

					if (checkBoxSchnee.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SCHNEE, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SCHNEE, n);
					}

					if (checkBoxRegen.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_REGEN, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_REGEN, n);
					}

					if (toggleButtonWetter.isChecked()) {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_STATUS, y);
					} else {
						vals.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_STATUS, n);
					}

					// Datensatz in die Datenbank einfügen
					db.insert(DatabaseHelper.TABLE_ACTIVITY, null, vals);

					// Datenbank schließen
					db.close();

					Toast.makeText(CreateActivity.this, "Activity gespeichert",
							Toast.LENGTH_SHORT).show();
				} else {
					// Datenbank zum Schreiben öffnen
					SQLiteDatabase db = dpHelper.getWritableDatabase();

					// ContentValues Objekt mit den neuen Daten erzeugen
					ContentValues values = new ContentValues();
					values.put(DatabaseHelper.ACTIVITY_FIELD_NAME, editTextName
							.getText().toString());
					values.put(DatabaseHelper.ACTIVITY_FIELD_BESCHREIBUNG,
							editTextBeschreibung.getText().toString());
					values.put(DatabaseHelper.ACTIVITY_FIELD_KOSTEN,
							editTextKosten.getText().toString());
					values.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN,
							editTextPersonen.getText().toString());
					values.put(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MIN,
							editTextTempMin.getText().toString());
					values.put(DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_MAX,
							editTextTempMax.getText().toString());

					int y = 1;
					int n = 0;

					if (toggleButtonPersonen.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS,
								y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS,
								n);
					}

					if (checkBoxMontag.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MO, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MO, n);
					}

					if (checkBoxDienstag.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DI, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DI, n);
					}

					if (checkBoxMittwoch.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MI, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_MI, n);
					}

					if (checkBoxDonnerstag.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DO, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_DO, n);
					}

					if (checkBoxFreitag.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_FR, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_FR, n);
					}

					if (checkBoxSamstag.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SA, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SA, n);
					}

					if (checkBoxSonntag.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SO, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_SO, n);
					}

					if (toggleButtonWochentag.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_STATUS,
								y);
					} else {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_WOCHENTAG_STATUS,
								n);
					}

					if (toggleButtonTemperatur.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_STATUS,
								y);
					} else {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TEMPERATUR_STATUS,
								n);
					}

					if (checkBoxMorgens.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MORGENS,
								y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_PERSONEN_STATUS,
								n);
					}

					if (checkBoxMittags.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MITTAGS,
								y);
					} else {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_MITTAGS,
								n);
					}

					if (checkBoxAbends.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_ABENDS,
								y);
					} else {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_ABENDS,
								n);
					}

					if (checkBoxNachts.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_NACHTS,
								y);
					} else {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_NACHTS,
								n);
					}

					if (toggleButtonTageszeit.isChecked()) {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_STATUS,
								y);
					} else {
						values.put(
								DatabaseHelper.ACTIVITY_FIELD_TAGESZEIT_STATUS,
								n);
					}

					if (checkBoxSonnig.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SONNE, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SONNE, n);
					}

					if (checkBoxWindig.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_WIND, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_WIND, n);
					}

					if (checkBoxSchnee.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SCHNEE, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_SCHNEE, n);
					}

					if (checkBoxRegen.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_REGEN, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_REGEN, n);
					}

					if (toggleButtonWetter.isChecked()) {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_STATUS, y);
					} else {
						values.put(DatabaseHelper.ACTIVITY_FIELD_WETTER_STATUS, n);
					}

					// Datensätze unter Angabe des Tabellennamens und einer
					// WHERE Bedingung aktualisieren
					db.update(DatabaseHelper.TABLE_ACTIVITY, values,
							DatabaseHelper.ACTIVITY_FIELD_ID + "= '"
									+ myValue + "'", null);

					// Datenbank schließen
					db.close();
					Toast.makeText(CreateActivity.this,
							"Activity geupdated", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// Listener für Loesch-Button
		if (myValue != -1) {
			Button btn_delete = (Button) this.findViewById(R.id.btnRemove);
			btn_delete.setOnClickListener(new OnClickListener() {

				public void onClick(View arg0) {

					// Datenbank zum Schreiben oeffnen
					SQLiteDatabase db = dpHelper.getWritableDatabase();

					// Datensetze unter Angabe einer WHERE Bedingung loeschen
					db.delete(DatabaseHelper.TABLE_ACTIVITY, DatabaseHelper.ACTIVITY_FIELD_ID + "= '" + myValue + "'", null);

					// Datenbank schließen
					db.close();

					Toast.makeText(CreateActivity.this, "Todo geloescht",
							Toast.LENGTH_SHORT).show();
				}
			});
		} else {
			Button btn_delete = (Button) this.findViewById(R.id.btnRemove);
			btn_delete.setClickable(false);
		}
	}
}