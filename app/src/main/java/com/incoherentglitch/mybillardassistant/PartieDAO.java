package com.incoherentglitch.mybillardassistant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PartieDAO extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;

	public static final String PARTIE_KEY = "id_partie";
	public static final String PARTIE_NOM = "nom_partie";
	public static final String PARTIE_DATE = "date_partie";
	public static final String PARTIE_TYPE = "type_partie";
	public static final String PARTIE_SCORES = "scores_partie";

	public static final String PARTIE_TABLE_NAME = "Partie";
	public static final String PARTIE_TABLE_CREATE =
		"CREATE TABLE " + PARTIE_TABLE_NAME + " (" +
		PARTIE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		PARTIE_NOM + " TEXT, " +
		PARTIE_DATE + " TEXT, " +
		PARTIE_TYPE + " TEXT, " +
	    PARTIE_SCORES + " TEXT);";
		
	public static final String PARTIE_TABLE_DROP = "DROP TABLE IF EXISTS " + PARTIE_TABLE_NAME + ";";

	public PartieDAO(Context context) {
		super(context, PARTIE_TABLE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(PARTIE_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}