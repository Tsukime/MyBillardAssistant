package com.incoherentglitch.mybillardassistant;

import android.content.ContentValues;
import android.content.Context;

import static android.provider.Contacts.SettingsColumns.KEY;

public class PartieDAO extends BaseDAO {
	public static final String PARTIE_KEY = "id_partie";
	public static final String PARTIE_NOM = "nom_partie";
	public static final String PARTIE_DATE = "date_partie";
	public static final String PARTIE_TYPE = "type_partie";

	public static final String PARTIE_TABLE_NAME = "Partie";
	public static final String PARTIE_TABLE_CREATE = 
		"CREATE TABLE" + PARTIE_TABLE_NAME + " (" +
		PARTIE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		PARTIE_NOM + " TEXT, " +
		PARTIE_DATE + " TEXT, " + 
		PARTIE_TYPE + " TEXT);";
		
	public static final String PARTIE_TABLE_DROP = "DROP TABLE IF EXISTS " + PARTIE_TABLE_NAME + ";";

	public PartieDAO(Context pContext) {
		super(pContext);
	}

	public void ajouter_nouvelle_partie() {
		ContentValues value = new ContentValues();
		//value.put(PartieDAO.PARTIE_NOM,/*recup de la valeur de nom_partie*/);                                                                                                                                                         tie*/);
		//value.put(PartieDAO.PARTIE_DATE, /*recup de la date*/);
		//value.put(PartieDAO.PARTIE_TYPE, /*recup type partie*/);
		mDb.insert(PartieDAO.PARTIE_TABLE_NAME, null, value);
		//changer affichage
  	}

	public void supprimer_partie(long id) {
		mDb.delete(PARTIE_TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
		//changer affichage
  	}

	/*public void edit_partie(long id)
	//recuperer valeurs sur page edition
	//changer dans bd
	//changer affichage
	
	public void recherche_partie
	//recup barre recherche
	//requete
	//changer affichage
	
	public void tri_par_ordre_alphabétique()
	//requete
	//changer affichage
	
	public void tri_par_type()
	//requete
	//change affichage

	public void tri_par_date()
	//requete
	//changer affichage
	
	public void afficher
	
	public void afficherplus
	*/	
}