package fr.psyk.wourdlle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Woordle";

    private  int coup;
    private  String lettres = "";
    private String nomCoup ,oldtemps,motatrouver;
    private int essai,win,serie;
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script.


        String script = "CREATE TABLE Score (nom STRING PRIMARY KEY, essai INTEGER, win INTEGER, serie INTEGER, coup1 INTEGER, coup2 INTEGER, coup3 INTEGER, coup4 INTEGER, coup5 INTEGER, coup6 INTEGER, coup7 INTEGER, temps STRING);";
        // Execute Script.
        db.execSQL(script);

        String sctipt1 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres4', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt2 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres5', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt3 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres6', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt4 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres7', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt5 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres8', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt6 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres9', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt7 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres10', 0,0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt8 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres11', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt9 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('lettres12', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        String sctipt10 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('mots5', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '00:00');";
        String sctipt11 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('mots10', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '00:00');";
        String sctipt12 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('daily', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '00:00');";

        db.execSQL(sctipt1);
        db.execSQL(sctipt2);
        db.execSQL(sctipt3);
        db.execSQL(sctipt4);
        db.execSQL(sctipt5);
        db.execSQL(sctipt6);
        db.execSQL(sctipt7);
        db.execSQL(sctipt8);
        db.execSQL(sctipt9);
        db.execSQL(sctipt10);
        db.execSQL(sctipt11);
        db.execSQL(sctipt12);

        sctipt1 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres4', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt2 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres5', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt3 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres6', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt4 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres7', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt5 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres8', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt6 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres9', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt7 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres10', 0,0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt8 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres11', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt9 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-lettres12', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL);";
        sctipt10 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-mots5', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '00:00');";
        sctipt11 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-mots10', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '00:00');";
        sctipt12 = "INSERT INTO Score (nom, essai, win, serie, coup1, coup2, coup3, coup4, coup5, coup6, coup7, temps) VALUES ('HM-daily', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '00:00');";

        db.execSQL(sctipt1);
        db.execSQL(sctipt2);
        db.execSQL(sctipt3);
        db.execSQL(sctipt4);
        db.execSQL(sctipt5);
        db.execSQL(sctipt6);
        db.execSQL(sctipt7);
        db.execSQL(sctipt8);
        db.execSQL(sctipt9);
        db.execSQL(sctipt10);
        db.execSQL(sctipt11);
        db.execSQL(sctipt12);



        String scriptVersion = "CREATE TABLE IF NOT EXISTS version (version INTEGER);";
        // Execute Script.
        db.execSQL(scriptVersion);
        String scriptVersion2 = "INSERT INTO version (version) VALUES (0);";
        // Execute Script.
        db.execSQL(scriptVersion2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop table
        Log.i(TAG, "drop table");
        db.execSQL("DROP TABLE IF EXISTS Score");
        db.execSQL("DROP TABLE IF EXISTS version");

        // Recreate
        onCreate(db);
    }




    public Score getScore(String categorie) {
       // Log.i(TAG, "MyDatabaseHelper.getScore ... " + categorie);

        String Query = "SELECT  * FROM Score WHERE nom = " + categorie;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(Query,null);
        if (cursor != null)
            cursor.moveToFirst();

        Score score = new Score(cursor.getString(0), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)), cursor.getString(11));
        // return note
        return score;
    }


    public int updateEssai(int nblettre, boolean hardMode){
        String categorie = quelLettre(nblettre,hardMode);
        Log.i(TAG, "MyDatabaseHelper.updateEssai ... " + categorie + hardMode);
        SQLiteDatabase db = this.getWritableDatabase();

        Score scoreUpdate  = getScore(categorie);
        int nbessaie = scoreUpdate.essai + 1 ;
        int serieencour = scoreUpdate.serie;

        ContentValues cv = new ContentValues();
        cv.put("essai",nbessaie);
        String where = "nom = " + categorie;
        db.update("Score", cv, where,null);


        return serieencour;
    }


    public void updateScore(int nblettre, int nbcoup, int serie, boolean hardMode)  {
        Log.i(TAG, "MyDatabaseHelper.updateScore ... " + nblettre);
        SQLiteDatabase db = this.getWritableDatabase();

       int totalnbcoup = quelCoup(nblettre,nbcoup,hardMode);
        lettres= quelLettre(nblettre, hardMode);

        Score scoreUpdate  = getScore(lettres);
        win = scoreUpdate.win +1;
        int nombrecoups = totalnbcoup +1 ;
        ContentValues cv = new ContentValues();
        cv.put("win",win);
        cv.put("serie",serie);
        cv.put(nomCoup,nombrecoups);
        String where = "nom = " + lettres;
        db.update("Score", cv, where,null);
// https://devstory.net/10433/android-sqlite-database
    }

    public void updateScoreMots(int nbmots, boolean hardMode, String temps)  {
        Log.i(TAG, "MyDatabaseHelper.updateScoreMots ... " + nbmots);
        SQLiteDatabase db = this.getWritableDatabase();
        String categorie ="";
       if (nbmots == 5 && hardMode) {
           categorie = "'HM-mots5'";
        }
        if (nbmots == 5 && !hardMode) {
            categorie = "'mots5'";
        }
        if (nbmots == 10 && hardMode) {
            categorie = "'HM-mots10'";
        }
        if (nbmots == 10 && !hardMode) {
            categorie = "'mots10'";
        }


        Score scoreUpdate  = getScore(categorie);
        win = scoreUpdate.win +1;
       oldtemps = scoreUpdate.temps;
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");

        try {
            Date dateold = dateFormat.parse(oldtemps);
            Date datenew = dateFormat.parse(temps);

            if (dateold.before(datenew) && !oldtemps.equals("00:00")){
                temps = dateFormat.format(dateold);
            }

        } catch (ParseException e) {
        }

        ContentValues cv = new ContentValues();
        cv.put("temps",temps);
        String where = "nom = " + categorie ;
        db.update("Score", cv, where,null);
// https://devstory.net/10433/android-sqlite-database
    }


    public void updateSerie(int categorie, int serie, boolean hardMode){
        Log.i(TAG, "MyDatabaseHelper.updateSerie ... " + categorie);
        SQLiteDatabase db = this.getWritableDatabase();
        lettres= quelLettre(categorie, hardMode);
        ContentValues cv = new ContentValues();
        cv.put("serie",serie);
        String where = "nom = " + lettres;
        db.update("Score", cv, where,null);

    }
    private String quelLettre(int nombre, boolean hardMode){

        if (hardMode) {
            switch (nombre) {
                case (4):
                    lettres = "'HM-lettres4'";
                    break;
                case (5):
                    lettres = "'HM-lettres5'";
                    break;
                case (6):
                    lettres = "'HM-lettres6'";
                    break;
                case (7):
                    lettres = "'HM-lettres7'";
                    break;
                case (8):
                    lettres = "'HM-lettres8'";
                    break;
                case (9):
                    lettres = "'HM-lettres9'";
                    break;
                case (10):
                    lettres = "'HM-lettres10'";
                    break;
                case (11):
                    lettres = "'HM-lettres11'";
                    break;
                case (12):
                    lettres = "'HM-lettres12'";
                    break;

            }
            return lettres;
        }else{
            switch (nombre){
                case(4):
                    lettres = "'lettres4'";
                    break;
                case(5):
                    lettres = "'lettres5'";
                    break;
                case(6):
                    lettres = "'lettres6'";
                    break;
                case(7):
                    lettres = "'lettres7'";
                    break;
                case(8):
                    lettres = "'lettres8'";
                    break;
                case(9):
                    lettres = "'lettres9'";
                    break;
                case(10):
                    lettres = "'lettres10'";
                    break;
                case(11):
                    lettres = "'lettres11'";
                    break;
                case(12):
                    lettres = "'lettres12'";
                    break;

            }return lettres;
        }

    }


    private int quelCoup(int categorie,int nbcoup, boolean hardMode ){
        Score score = getScore(quelLettre(categorie, hardMode));
        switch (nbcoup){
            case(1):
                coup = score.coup1;
                nomCoup = "coup1";
                break;
            case(2):
                coup = score.coup2;
                nomCoup = "coup2";
                break;
            case(3):
                coup = score.coup3;
                nomCoup = "coup3";
                break;
            case(4):
                coup = score.coup4;
                nomCoup = "coup4";
                break;
            case(5):
                coup = score.coup5;
                nomCoup = "coup5";
                break;
            case(6):
                coup = score.coup6;
                nomCoup = "coup6";
                break;
            case(7):
                coup = score.coup7;
                nomCoup = "coup7";
                break;

        }return coup;


    }

    public int insertFromFile(Context context, int resourceId) throws IOException {

        SQLiteDatabase db = this.getWritableDatabase();

        // Reseting Counter
        int version = 0;

        // Open the resource
        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        // Iterate through lines (assuming each insert has its own line and theres no other stuff)
        while (insertReader.ready()) {
            String insertStmt = insertReader.readLine();
            if (insertStmt.length()>2){
                db.execSQL(insertStmt);

            }else
                version = Integer.parseInt(insertStmt);

        }
        insertReader.close();

        // returning number of inserted rows
        return version;
    }

    public int getVersion(){

        String Query = "SELECT  * FROM version";
        SQLiteDatabase db = this.getReadableDatabase();
        Log.i(TAG, "MyDatabaseHelper.getVersion");
        Cursor cursor = db.rawQuery(Query,null);
        if (cursor != null)
            cursor.moveToFirst();

        int version =  Integer.parseInt(cursor.getString(0));
        // return note
        return version;
    }

 public void updateVersion(int version){
        //mettre la version au meme nombre que le premier caractère du ficheri
     Log.i(TAG, "MyDatabaseHelper.updateversion");
     SQLiteDatabase db = this.getWritableDatabase();
     ContentValues cv = new ContentValues();
     cv.put("version",version);
     String where = "rowid=1";
     db.update("version", cv, where,null);
        }

        public String getmot(int nblettre){
            Log.i(TAG, "MyDatabaseHelper.getmot de " + nblettre + " lettres");
            String Query = " SELECT * FROM l"+nblettre+" ORDER BY RANDOM() LIMIT 1;";
            SQLiteDatabase db = this.getReadableDatabase();
            Log.i(TAG, "MyDatabaseHelper.getVersion");
            Cursor cursor = db.rawQuery(Query,null);
            if (cursor != null)
                cursor.moveToFirst();

            motatrouver =  cursor.getString(0);

        return motatrouver ;
        }

        public boolean motEstPresent(String motATester){
            String nomTable = "l" + motATester.length();
            String sql = "SELECT  count(*) FROM " +nomTable+ " WHERE mots = '" +motATester + "';";
            SQLiteDatabase db = this.getReadableDatabase();
            Log.i(TAG, "MyDatabaseHelper.getMotExiste");
            SQLiteStatement statement = db.compileStatement(sql);

            try {
                return statement.simpleQueryForLong() > 0;
            } finally {
                statement.close();
            }
        }

}









