public class DataBaseHandler extends SQLiteOpenHelper 
{
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
		

	public static final String SCORE_KEY = "id_score";
	public static final String SCORE_ID_JOUEUR = "id_joueur";
	public static final String SCORE_NOM_JOUEUR = "nom_joueur";
	public static final String SCORE_JOUEUR = "score_joueur";

	public static final String SCORE_TABLE_NAME = "Score";
	public static final String SCORE_TABLE_CREATE = 
		"CREATE TABLE" + SCORE_TABLE_NAME + " (" +
		SCORE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		SCORE_ID_JOUEUR + " TEXT, " +
		SCORE_NOM_JOUEUR + " SECONDARY_KEY TEXT, " + 
		SCORE_JOUEUR + " INT);";
		
	public static final String JOUEUR_KEY = "id_joueur";
	public static final String JOUEUR_NOM = "nom_joueur";
	public static final String JOUEUR_PASSWORD = "mdp_joueur";
	
	public static final String JOUEUR_TABLE_NAME = "Joueur";
	public static final String JOUEUR_TABLE_CREATE =
		"CREATE TABLE" + JOUEUR_TABLE_NAME + " (" +
		JOUEUR_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
		JOUEUR_NOM + " TEXT, " +
		JOUEUR_PASSWORD + " TEXT);";
	
	public static final String PARTIE_TABLE_DROP = "DROP TABLE IF EXISTS " + PARTIE_TABLE_NAME + ";";
	public static final String JOUEUR_TABLE_DROP = "DROP TABLE IF EXISTS " + JOUEUR_TABLE_NAME + ";"
	public static final String SCORE_TABLE_DROP = "DROP TABLE IF EXISTS " + SCORE_TABLE_NAME + ";"

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(PARTIE_TABLE_DROP);
		db.execSQL(JOUEUR_TABLE_DROP);
		db.execSQL(SCORE_TABLE_DROP);
		onCreate(db);
	}	
	
	public DataBaseHandler(Context context, String name, CursurFactory factory, int version)
	{
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(PARTIE_TABLE_CREATE);
		db.execSQL(JOUEUR_TABLE_CREATE);
		db.execSQL(SCORE_JOUEUR_CREATE);
	}
	
}
	