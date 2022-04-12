package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    Score score4 ;
    Score score5;
    Score score6 ;
    Score score7;
    Score score8 ;
    Score score9;
    Score score10;
    Score score11;
    Score score12;
    Score scoreDaily;
    Score scoreMots5 ;
    Score scoreMots10;
    private static final String TAG = "SQLite";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        MyDatabaseHelper db = new MyDatabaseHelper(this);
        score4 = db.getScore("'lettres4'");
        score5 = db.getScore("'lettres5'");
        score6 = db.getScore("'lettres6'");
        score7 = db.getScore("'lettres7'");
        score8 = db.getScore("'lettres8'");
        score9 = db.getScore("'lettres9'");
        score10 = db.getScore("'lettres10'");
        score11= db.getScore("'lettres11'");
        score12= db.getScore("'lettres12'");
        scoreDaily= db.getScore("'daily'");
        scoreMots5 = db.getScore("'mots5'");
        scoreMots10 = db.getScore("'mots10'");


        Context context =this;

        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        String quelButton4E = "textView4E";
        String quelButton4W = "textView4W";
        String quelButton4S = "textView4S";
        int quelTextView4E = getResources().getIdentifier(quelButton4E, "id", context.getPackageName());
        TextView textView4E = findViewById(quelTextView4E);

        int quelTextView4W = getResources().getIdentifier(quelButton4W, "id", context.getPackageName());
        TextView textView4W = findViewById(quelTextView4W);
        int quelTextView4S = getResources().getIdentifier(quelButton4S, "id", context.getPackageName());
        TextView textView4S = findViewById(quelTextView4S);



        textView4W.setText(String.valueOf(score4.win));
        textView4E.setText(String.valueOf(score4.essai));
        textView4S.setText(String.valueOf(score4.serie));

        int quelTextView5E = getResources().getIdentifier("textView5E", "id", context.getPackageName());
        TextView textView5E = findViewById(quelTextView5E);
        int quelTextView5W = getResources().getIdentifier("textView5W", "id", context.getPackageName());
        TextView textView5W = findViewById(quelTextView5W);
        int quelTextView5S = getResources().getIdentifier("textView5S", "id", context.getPackageName());
        TextView textView5S = findViewById(quelTextView5S);
        textView5E.setText(String.valueOf(score5.essai));
        textView5W.setText(String.valueOf(score5.win));
        textView5S.setText(String.valueOf(score5.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView6E = getResources().getIdentifier("textView6E", "id", context.getPackageName());
        TextView textView6E = findViewById(quelTextView6E);
        int quelTextView6W = getResources().getIdentifier("textView6W", "id", context.getPackageName());
        TextView textView6W = findViewById(quelTextView6W);
        int quelTextView6S = getResources().getIdentifier("textView6S", "id", context.getPackageName());
        TextView textView6S = findViewById(quelTextView6S);
        textView6E.setText(String.valueOf(score6.essai));
        textView6W.setText(String.valueOf(score6.win));
        textView6S.setText(String.valueOf(score6.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView7E = getResources().getIdentifier("textView7E", "id", context.getPackageName());
        TextView textView7E = findViewById(quelTextView7E);
        int quelTextView7W = getResources().getIdentifier("textView7W", "id", context.getPackageName());
        TextView textView7W = findViewById(quelTextView7W);
        int quelTextView7S = getResources().getIdentifier("textView7S", "id", context.getPackageName());
        TextView textView7S = findViewById(quelTextView7S);
        textView7E.setText(String.valueOf(score7.essai));
        textView7W.setText(String.valueOf(score7.win));
        textView7S.setText(String.valueOf(score7.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView8E = getResources().getIdentifier("textView8E", "id", context.getPackageName());
        TextView textView8E = findViewById(quelTextView8E);
        int quelTextView8W = getResources().getIdentifier("textView8W", "id", context.getPackageName());
        TextView textView8W = findViewById(quelTextView8W);
        int quelTextView8S = getResources().getIdentifier("textView8S", "id", context.getPackageName());
        TextView textView8S = findViewById(quelTextView8S);
        textView8E.setText(String.valueOf(score8.essai));
        textView8W.setText(String.valueOf(score8.win));
        textView8S.setText(String.valueOf(score8.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView9E = getResources().getIdentifier("textView9E", "id", context.getPackageName());
        TextView textView9E = findViewById(quelTextView9E);
        int quelTextView9W = getResources().getIdentifier("textView9W", "id", context.getPackageName());
        TextView textView9W = findViewById(quelTextView9W);
        int quelTextView9S = getResources().getIdentifier("textView9S", "id", context.getPackageName());
        TextView textView9S = findViewById(quelTextView9S);
        textView9E.setText(String.valueOf(score9.essai));
        textView9W.setText(String.valueOf(score9.win));
        textView9S.setText(String.valueOf(score9.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView10E = getResources().getIdentifier("textView10E", "id", context.getPackageName());
        TextView textView10E = findViewById(quelTextView10E);
        int quelTextView10W = getResources().getIdentifier("textView10W", "id", context.getPackageName());
        TextView textView10W = findViewById(quelTextView10W);
        int quelTextView10S = getResources().getIdentifier("textView10S", "id", context.getPackageName());
        TextView textView10S = findViewById(quelTextView10S);
        textView10E.setText(String.valueOf(score10.essai));
        textView10W.setText(String.valueOf(score10.win));
        textView10S.setText(String.valueOf(score10.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView11E = getResources().getIdentifier("textView11E", "id", context.getPackageName());
        TextView textView11E = findViewById(quelTextView11E);
        int quelTextView11W = getResources().getIdentifier("textView11W", "id", context.getPackageName());
        TextView textView11W = findViewById(quelTextView11W);
        int quelTextView11S = getResources().getIdentifier("textView11S", "id", context.getPackageName());
        TextView textView11S = findViewById(quelTextView11S);
        textView11E.setText(String.valueOf(score11.essai));
        textView11W.setText(String.valueOf(score11.win));
        textView11S.setText(String.valueOf(score11.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextView12E = getResources().getIdentifier("textView12E", "id", context.getPackageName());
        TextView textView12E = findViewById(quelTextView12E);
        int quelTextView12W = getResources().getIdentifier("textView12W", "id", context.getPackageName());
        TextView textView12W = findViewById(quelTextView12W);
        int quelTextView12S = getResources().getIdentifier("textView12S", "id", context.getPackageName());
        TextView textView12S = findViewById(quelTextView12S);
        textView12E.setText(String.valueOf(score12.essai));
        textView12W.setText(String.valueOf(score12.win));
        textView12S.setText(String.valueOf(score12.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextViewdailyE = getResources().getIdentifier("textViewDE", "id", context.getPackageName());
        TextView textViewdailyE = findViewById(quelTextViewdailyE);
        int quelTextViewdailyW = getResources().getIdentifier("textViewDW", "id", context.getPackageName());
        TextView textViewdailyW = findViewById(quelTextViewdailyW);
        int quelTextViewdailyS = getResources().getIdentifier("textViewDS", "id", context.getPackageName());
        TextView textViewdailyS = findViewById(quelTextViewdailyS);
        int quelTextViewdailyT = getResources().getIdentifier("textViewDTime", "id", context.getPackageName());
        TextView textViewdailyT = findViewById(quelTextViewdailyT);
        textViewdailyT.setText(String.valueOf(scoreDaily.temps));
        textViewdailyE.setText(String.valueOf(scoreDaily.essai));
        textViewdailyW.setText(String.valueOf(scoreDaily.win));
        textViewdailyS.setText(String.valueOf(scoreDaily.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextViewmots5E = getResources().getIdentifier("textViewM5E", "id", context.getPackageName());
        TextView textViewmots5E = findViewById(quelTextViewmots5E);
        int quelTextViewmots5W = getResources().getIdentifier("textViewM5W", "id", context.getPackageName());
        TextView textViewmots5W = findViewById(quelTextViewmots5W);
        int quelTextViewmots5S = getResources().getIdentifier("textViewM5S", "id", context.getPackageName());
        TextView textViewmots5S = findViewById(quelTextViewmots5S);
        int queltextViewmots5T = getResources().getIdentifier("textViewM5Time", "id", context.getPackageName());
        TextView textViewmots5T = findViewById(queltextViewmots5T);
        textViewmots5T.setText(String.valueOf(scoreMots5.temps));
        textViewmots5E.setText(String.valueOf(scoreMots5.essai));
        textViewmots5W.setText(String.valueOf(scoreMots5.win));
        textViewmots5S.setText(String.valueOf(scoreMots5.serie));
        Log.i(TAG, "MyDatabaseHelper.getscore ... " + 4);
        int quelTextViewmots10E = getResources().getIdentifier("textViewM10E", "id", context.getPackageName());
        TextView textViewmots10E = findViewById(quelTextViewmots10E);
        int quelTextViewmots10W = getResources().getIdentifier("textViewM10W", "id", context.getPackageName());
        TextView textViewmots10W = findViewById(quelTextViewmots10W);
        int quelTextViewmots10S = getResources().getIdentifier("textViewM10S", "id", context.getPackageName());
        TextView textViewmots10S = findViewById(quelTextViewmots10S);
        int queltextViewmots10T = getResources().getIdentifier("textViewM10Time", "id", context.getPackageName());
        TextView textViewmots10T = findViewById(queltextViewmots10T);
        textViewmots10T.setText(String.valueOf(scoreMots10.temps));
        textViewmots10E.setText(String.valueOf(scoreMots10.essai));
        textViewmots10W.setText(String.valueOf(scoreMots10.win));
        textViewmots10S.setText(String.valueOf(scoreMots10.serie));











    }
}