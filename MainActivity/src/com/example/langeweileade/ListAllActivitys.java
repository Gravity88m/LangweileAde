package com.example.langeweileade;

import java.util.ArrayList;
import java.util.List;

import android.R.drawable;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ListAllActivitys extends Activity implements OnItemClickListener {



	public static final Integer[] images = { drawable.btn_star,
	    drawable.btn_star, drawable.btn_star, drawable.btn_star };
	
	ListView listView;
	List<RowItem> rowItems;
	

	

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i("**", "on create");
		DatabaseHelper dbHelper;
		
		
		int name = 0;
		int beschreibung = 0;
		int kosten = 0;
		
		dbHelper = new DatabaseHelper(this);
		
		
		rowItems = new ArrayList<RowItem>();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "SELECT * FROM activity";
		Cursor result = db.rawQuery(sql, null);
		
		if (result.moveToFirst()) {
			name = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_NAME);
			beschreibung = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_BESCHREIBUNG);
			kosten = result.getColumnIndex(DatabaseHelper.ACTIVITY_FIELD_KOSTEN);
		}
		
		
		
		do {
		String nameTodo = result.getString(name);
		String beschreibungTodo = result.getString(beschreibung);
		double kostenTodo = result.getDouble(kosten);
		
		
	    RowItem item = new RowItem(drawable.btn_star, nameTodo, beschreibungTodo, kostenTodo);
	    rowItems.add(item);
	
		} while (result.moveToNext()); 
	
		result.close(); 
		db.close(); 
	


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

	