package com.example.langeweileade;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "langweileade.db";
	private static final int DATABASE_VERSION = 1;

	public static final String TABLE_ACTIVITY = "activity";
	public static final String ACTIVITY_FIELD_ID = "id";
	public static final String ACTIVITY_TYPE_ID = "INTEGER";
	public static final String ACTIVITY_FIELD_NAME = "name";
	public static final String ACTIVITY_TYPE_NAME = "TEXT";
	public static final String ACTIVITY_FIELD_BESCHREIBUNG = "beschreibung";
	public static final String ACTIVITY_TYPE_BESCHREIBUNG = "TEXT";
	public static final String ACTIVITY_FIELD_KOSTEN = "kosten";
	public static final String ACTIVITY_TYPE_KOSTEN = "REAL";
	public static final String ACTIVITY_FIELD_WOCHENTAG_STATUS = "wochentag_status";
	public static final String ACTIVITY_TYPE_WOCHENTAG_STATUS = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_MO = "wochentag_montag";
	public static final String ACTIVITY_TYPE_WOCHENTAG_MO = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_DI = "wochentag_dienstag";
	public static final String ACTIVITY_TYPE_WOCHENTAG_DI = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_MI = "wochentag_mittwoch";
	public static final String ACTIVITY_TYPE_WOCHENTAG_MI = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_DO = "wochentag_donnerstag";
	public static final String ACTIVITY_TYPE_WOCHENTAG_DO = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_FR = "wochentag_freitag";
	public static final String ACTIVITY_TYPE_WOCHENTAG_FR = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_SA = "wochentag_samstag";
	public static final String ACTIVITY_TYPE_WOCHENTAG_SA = "INTEGER";
	public static final String ACTIVITY_FIELD_WOCHENTAG_SO = "wochentag_sonntag";
	public static final String ACTIVITY_TYPE_WOCHENTAG_SO = "INTEGER";
	public static final String ACTIVITY_FIELD_WETTER_STATUS = "wetter_status";
	public static final String ACTIVITY_TYPE_WETTER_STATUS = "INTEGER";
	public static final String ACTIVITY_FIELD_WETTER_SONNE = "wetter_sonne";
	public static final String ACTIVITY_TYPE_WETTER_SONNE = "INTEGER";
	public static final String ACTIVITY_FIELD_WETTER_WIND = "wetter_wind";
	public static final String ACTIVITY_TYPE_WETTER_WIND = "INTEGER";
	public static final String ACTIVITY_FIELD_WETTER_SCHNEE = "wetter_schnee";
	public static final String ACTIVITY_TYPE_WETTER_SCHNEE = "INTEGER";
	public static final String ACTIVITY_FIELD_WETTER_REGEN = "wetter_regen";
	public static final String ACTIVITY_TYPE_WETTER_REGEN = "INTEGER";
	public static final String ACTIVITY_FIELD_PERSONEN_STATUS = "personen_status";
	public static final String ACTIVITY_TYPE_PERSONEN_STATUS = "INTEGER";
	public static final String ACTIVITY_FIELD_PERSONEN = "personen";
	public static final String ACTIVITY_TYPE_PERSONEN = "INTEGER";
	public static final String ACTIVITY_FIELD_TAGESZEIT_STATUS = "tageszeit_status";
	public static final String ACTIVITY_TYPE_TAGESZEIT_STATUS = "INTEGER";
	public static final String ACTIVITY_FIELD_TAGESZEIT_MORGENS = "tageszeit_morgens";
	public static final String ACTIVITY_TYPE_TAGESZEIT_MORGENS = "INTEGER";
	public static final String ACTIVITY_FIELD_TAGESZEIT_MITTAGS = "tageszeit_mittags";
	public static final String ACTIVITY_TYPE_TAGESZEIT_MITTAGS = "INTEGER";
	public static final String ACTIVITY_FIELD_TAGESZEIT_ABENDS = "tageszeit_abends";
	public static final String ACTIVITY_TYPE_TAGESZEIT_ABENDS = "INTEGER";
	public static final String ACTIVITY_FIELD_TAGESZEIT_NACHTS = "tageszeit_nachts";
	public static final String ACTIVITY_TYPE_TAGESZEIT_NACHTS = "INTEGER";
	public static final String ACTIVITY_FIELD_TEMPERATUR_STATUS = "temperatur_status";
	public static final String ACTIVITY_TYPE_TEMPERATUR_STATUS = "INTEGER";
	public static final String ACTIVITY_FIELD_TEMPERATUR_MIN = "temperatur_min";
	public static final String ACTIVITY_TYPE_TEMPERATUR_MIN = "INTEGER";
	public static final String ACTIVITY_FIELD_TEMPERATUR_MAX = "temperatur_max";
	public static final String ACTIVITY_TYPE_TEMPERATUR_MAX = "INTEGER";	
	
	private static final String CREATE_TABLE_ACTIVITY = "CREATE TABLE " + TABLE_ACTIVITY
	+ "("
		+ ACTIVITY_FIELD_ID                + " " + ACTIVITY_TYPE_ID                + " PRIMARY KEY AUTOINCREMENT" + ", "
		+ ACTIVITY_FIELD_NAME              + " " + ACTIVITY_TYPE_NAME                                             + ", "
		+ ACTIVITY_FIELD_BESCHREIBUNG      + " " + ACTIVITY_TYPE_BESCHREIBUNG                                     + ", "
		+ ACTIVITY_FIELD_KOSTEN            + " " + ACTIVITY_TYPE_KOSTEN                                           + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_STATUS  + " " + ACTIVITY_TYPE_WOCHENTAG_STATUS                                 + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_MO      + " " + ACTIVITY_TYPE_WOCHENTAG_MO                                     + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_DI      + " " + ACTIVITY_TYPE_WOCHENTAG_DI                                     + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_MI      + " " + ACTIVITY_TYPE_WOCHENTAG_MI                                     + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_DO      + " " + ACTIVITY_TYPE_WOCHENTAG_DO                                     + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_FR      + " " + ACTIVITY_TYPE_WOCHENTAG_FR                                     + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_SA      + " " + ACTIVITY_TYPE_WOCHENTAG_SA                                     + ", "
		+ ACTIVITY_FIELD_WOCHENTAG_SO      + " " + ACTIVITY_TYPE_WOCHENTAG_SO                                     + ", "
		+ ACTIVITY_FIELD_WETTER_STATUS     + " " + ACTIVITY_TYPE_WETTER_STATUS                                    + ", "
		+ ACTIVITY_FIELD_WETTER_SONNE      + " " + ACTIVITY_TYPE_WETTER_SONNE                                     + ", "
		+ ACTIVITY_FIELD_WETTER_WIND       + " " + ACTIVITY_TYPE_WETTER_WIND                                      + ", "
		+ ACTIVITY_FIELD_WETTER_SCHNEE     + " " + ACTIVITY_TYPE_WETTER_SCHNEE                                    + ", "
		+ ACTIVITY_FIELD_WETTER_REGEN      + " " + ACTIVITY_TYPE_WETTER_REGEN                                     + ", "
		+ ACTIVITY_FIELD_PERSONEN_STATUS   + " " + ACTIVITY_TYPE_PERSONEN_STATUS                                  + ", "
		+ ACTIVITY_FIELD_PERSONEN          + " " + ACTIVITY_TYPE_PERSONEN                                         + ", "
		+ ACTIVITY_FIELD_TAGESZEIT_STATUS  + " " + ACTIVITY_TYPE_TAGESZEIT_STATUS                                 + ", "
		+ ACTIVITY_FIELD_TAGESZEIT_MORGENS + " " + ACTIVITY_TYPE_TAGESZEIT_MORGENS                                + ", "
		+ ACTIVITY_FIELD_TAGESZEIT_MITTAGS + " " + ACTIVITY_TYPE_TAGESZEIT_MITTAGS                                + ", "
		+ ACTIVITY_FIELD_TAGESZEIT_ABENDS  + " " + ACTIVITY_TYPE_TAGESZEIT_ABENDS                                 + ", "
		+ ACTIVITY_FIELD_TAGESZEIT_NACHTS  + " " + ACTIVITY_TYPE_TAGESZEIT_NACHTS                                 + ", "
		+ ACTIVITY_FIELD_TEMPERATUR_STATUS + " " + ACTIVITY_TYPE_TEMPERATUR_STATUS                                + ", "
		+ ACTIVITY_FIELD_TEMPERATUR_MIN    + " " + ACTIVITY_TYPE_TEMPERATUR_MIN                                   + ", "
		+ ACTIVITY_FIELD_TEMPERATUR_MAX    + " " + ACTIVITY_TYPE_TEMPERATUR_MAX
	+ ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		try {
			db.execSQL(CREATE_TABLE_ACTIVITY);
		} catch (SQLException ex) {
			Log.e("DatabaseHelper", "error creating table", ex);
		}
	}

	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {}

	public void onDowngrade(SQLiteDatabase db, int oldVer, int newVer) {}
}