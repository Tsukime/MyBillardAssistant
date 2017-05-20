package com.incoherentglitch.mybillardassistant;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;

public class PartieDataSource {

	private SQLiteDatabase database;
	private PartieDAO dbDAO;
	private String[] allData = { PartieDAO.PARTIE_KEY,
			PartieDAO.PARTIE_NOM,
			PartieDAO.PARTIE_DATE,
			PartieDAO.PARTIE_TYPE};

	public PartieDataSource(Context context) {
		dbDAO = new PartieDAO(context);
	}

	public void open() throws SQLException {
		database = dbDAO.getWritableDatabase();
	}

	public void close() {
		dbDAO.close();
	}

	public void insert(String nom, String date, String type, String score) {
		open();
		ContentValues values = new ContentValues();
		values.put(PartieDAO.PARTIE_NOM, nom);
		values.put(PartieDAO.PARTIE_DATE, date);
		values.put(PartieDAO.PARTIE_TYPE, type);
		values.put(PartieDAO.PARTIE_SCORES, score);
		database.insert(PartieDAO.PARTIE_TABLE_NAME, null, values);
		close();
	}

	public ArrayList<Partie> load(){
		ArrayList<Partie> result = new ArrayList<>();
		open();

		Cursor cursor = database.query(PartieDAO.PARTIE_TABLE_NAME, null, null, null, null, null, null);
			while(cursor.moveToNext()) {
				Partie partie = new Partie();

				partie.setId(cursor.getLong(0));
				partie.setName(cursor.getString(1));
				partie.setDate(cursor.getString(2));
				partie.setType(cursor.getString(3));
				partie.setScores(cursor.getString(4));

				result.add(partie);
			}

		close();
		return result;
	}

	public void deleteBDD(){
		open();
		database.delete(PartieDAO.PARTIE_TABLE_NAME, "1", null);
		close();
	}

}
