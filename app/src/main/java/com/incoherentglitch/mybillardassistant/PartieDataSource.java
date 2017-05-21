package com.incoherentglitch.mybillardassistant;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;

/**
 * Gestion de la base de données
 */
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

	/**
	 * Ouvre la base de données
	 * @throws SQLException
     */
	public void open() throws SQLException {
		database = dbDAO.getWritableDatabase();
	}

	/**
	 * Ferme la base de données
	 */
	public void close() {
		dbDAO.close();
	}

	/**
	 * Insère une ligne dans la base de données
	 * @param nom : nom de la partie
	 * @param date : date de la partie
	 * @param type : type de la partie
     * @param score : score de la partie
     */
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

	/**
	 * Charge les lignes de la base de données dans une ArrayList<Partie>
	 * @return une ArrayList<Partie> contenant toutes les ligne de la base de données
     */
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

	/**
	 * Drop la base de données
	 */
	public void deleteBDD(){
		open();
		database.delete(PartieDAO.PARTIE_TABLE_NAME, "1", null);
		close();
	}

}
