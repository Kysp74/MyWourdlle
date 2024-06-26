package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;



public class StatsActivity extends AppCompatActivity implements  View.OnClickListener {

    Score score4;
    Score score5;
    Score score6;
    Score score7;
    Score score8;
    Score score9;
    Score score10;
    Score score11;
    Score score12;
    Score scoreDaily;
    Score scoreMots5;
    Score scoreMots10;
    private static final String TAG = "SQLite";
    private Switch HardmodeSwitch;
    TextView textviewHardmode;
    ImageView image4,image5,image6,image7,image8,image9,image10,image11,image12;
    String categorie;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        HardmodeSwitch = findViewById(R.id.switchHardmodeStats);
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        score4 = db.getScore("'lettres4'");
        score5 = db.getScore("'lettres5'");
        score6 = db.getScore("'lettres6'");
        score7 = db.getScore("'lettres7'");
        score8 = db.getScore("'lettres8'");
        score9 = db.getScore("'lettres9'");
        score10 = db.getScore("'lettres10'");
        score11 = db.getScore("'lettres11'");
        score12 = db.getScore("'lettres12'");
        scoreDaily = db.getScore("'daily'");
        scoreMots5 = db.getScore("'mots5'");
        scoreMots10 = db.getScore("'mots10'");
        updateStats();
        HardmodeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                boolean checked = ((Switch) v).isChecked();
                if (checked) {

                    textviewHardmode = findViewById(R.id.textView_stats_hm);
                    textviewHardmode.setVisibility(View.VISIBLE);
                    textviewHardmode = findViewById(R.id.textView_stats_hm1);
                    textviewHardmode.setVisibility(View.VISIBLE);
                    textviewHardmode = findViewById(R.id.textView_stats_hm2);
                    textviewHardmode.setVisibility(View.VISIBLE);

                    score4 = db.getScore("'HM-lettres4'");
                    score5 = db.getScore("'HM-lettres5'");
                    score6 = db.getScore("'HM-lettres6'");
                    score7 = db.getScore("'HM-lettres7'");
                    score8 = db.getScore("'HM-lettres8'");
                    score9 = db.getScore("'HM-lettres9'");
                    score10 = db.getScore("'HM-lettres10'");
                    score11 = db.getScore("'HM-lettres11'");
                    score12 = db.getScore("'HM-lettres12'");
                    scoreDaily = db.getScore("'HM-daily'");
                    scoreMots5 = db.getScore("'HM-mots5'");
                    scoreMots10 = db.getScore("'HM-mots10'");
                    updateStats();

                } else {
                    textviewHardmode = findViewById(R.id.textView_stats_hm);
                    textviewHardmode.setVisibility(View.INVISIBLE);
                    textviewHardmode = findViewById(R.id.textView_stats_hm1);
                    textviewHardmode.setVisibility(View.INVISIBLE);
                    textviewHardmode = findViewById(R.id.textView_stats_hm2);
                    textviewHardmode.setVisibility(View.INVISIBLE);

                    score4 = db.getScore("'lettres4'");
                    score5 = db.getScore("'lettres5'");
                    score6 = db.getScore("'lettres6'");
                    score7 = db.getScore("'lettres7'");
                    score8 = db.getScore("'lettres8'");
                    score9 = db.getScore("'lettres9'");
                    score10 = db.getScore("'lettres10'");
                    score11 = db.getScore("'lettres11'");
                    score12 = db.getScore("'lettres12'");
                    scoreDaily = db.getScore("'daily'");
                    scoreMots5 = db.getScore("'mots5'");
                    scoreMots10 = db.getScore("'mots10'");
                    updateStats();

                }
            }
        });

        image4 = findViewById(R.id.main_stats_4);
        image4.setOnClickListener(this);
        image5 = findViewById(R.id.main_stats_5);
        image5.setOnClickListener(this);
        image6 = findViewById(R.id.main_stats_6);
        image6.setOnClickListener(this);
        image7 = findViewById(R.id.main_stats_7);
        image7.setOnClickListener(this);
        image8 = findViewById(R.id.main_stats_8);
        image8.setOnClickListener(this);
        image9 = findViewById(R.id.main_stats_9);
        image9.setOnClickListener(this);
        image10 = findViewById(R.id.main_stats_10);
        image10.setOnClickListener(this);
        image11 = findViewById(R.id.main_stats_11);
        image11.setOnClickListener(this);
        image12 = findViewById(R.id.main_stats_12);
        image12.setOnClickListener(this);



    }

    private void updateStats() {
        Context context = this;

        Log.i(TAG, "MyDatabaseHelper.getscore ... ");
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

        int quelTextView6E = getResources().getIdentifier("textView6E", "id", context.getPackageName());
        TextView textView6E = findViewById(quelTextView6E);
        int quelTextView6W = getResources().getIdentifier("textView6W", "id", context.getPackageName());
        TextView textView6W = findViewById(quelTextView6W);
        int quelTextView6S = getResources().getIdentifier("textView6S", "id", context.getPackageName());
        TextView textView6S = findViewById(quelTextView6S);
        textView6E.setText(String.valueOf(score6.essai));
        textView6W.setText(String.valueOf(score6.win));
        textView6S.setText(String.valueOf(score6.serie));

        int quelTextView7E = getResources().getIdentifier("textView7E", "id", context.getPackageName());
        TextView textView7E = findViewById(quelTextView7E);
        int quelTextView7W = getResources().getIdentifier("textView7W", "id", context.getPackageName());
        TextView textView7W = findViewById(quelTextView7W);
        int quelTextView7S = getResources().getIdentifier("textView7S", "id", context.getPackageName());
        TextView textView7S = findViewById(quelTextView7S);
        textView7E.setText(String.valueOf(score7.essai));
        textView7W.setText(String.valueOf(score7.win));
        textView7S.setText(String.valueOf(score7.serie));

        int quelTextView8E = getResources().getIdentifier("textView8E", "id", context.getPackageName());
        TextView textView8E = findViewById(quelTextView8E);
        int quelTextView8W = getResources().getIdentifier("textView8W", "id", context.getPackageName());
        TextView textView8W = findViewById(quelTextView8W);
        int quelTextView8S = getResources().getIdentifier("textView8S", "id", context.getPackageName());
        TextView textView8S = findViewById(quelTextView8S);
        textView8E.setText(String.valueOf(score8.essai));
        textView8W.setText(String.valueOf(score8.win));
        textView8S.setText(String.valueOf(score8.serie));
        int quelTextView9E = getResources().getIdentifier("textView9E", "id", context.getPackageName());
        TextView textView9E = findViewById(quelTextView9E);
        int quelTextView9W = getResources().getIdentifier("textView9W", "id", context.getPackageName());
        TextView textView9W = findViewById(quelTextView9W);
        int quelTextView9S = getResources().getIdentifier("textView9S", "id", context.getPackageName());
        TextView textView9S = findViewById(quelTextView9S);
        textView9E.setText(String.valueOf(score9.essai));
        textView9W.setText(String.valueOf(score9.win));
        textView9S.setText(String.valueOf(score9.serie));

        int quelTextView10E = getResources().getIdentifier("textView10E", "id", context.getPackageName());
        TextView textView10E = findViewById(quelTextView10E);
        int quelTextView10W = getResources().getIdentifier("textView10W", "id", context.getPackageName());
        TextView textView10W = findViewById(quelTextView10W);
        int quelTextView10S = getResources().getIdentifier("textView10S", "id", context.getPackageName());
        TextView textView10S = findViewById(quelTextView10S);
        textView10E.setText(String.valueOf(score10.essai));
        textView10W.setText(String.valueOf(score10.win));
        textView10S.setText(String.valueOf(score10.serie));

        int quelTextView11E = getResources().getIdentifier("textView11E", "id", context.getPackageName());
        TextView textView11E = findViewById(quelTextView11E);
        int quelTextView11W = getResources().getIdentifier("textView11W", "id", context.getPackageName());
        TextView textView11W = findViewById(quelTextView11W);
        int quelTextView11S = getResources().getIdentifier("textView11S", "id", context.getPackageName());
        TextView textView11S = findViewById(quelTextView11S);
        textView11E.setText(String.valueOf(score11.essai));
        textView11W.setText(String.valueOf(score11.win));
        textView11S.setText(String.valueOf(score11.serie));

        int quelTextView12E = getResources().getIdentifier("textView12E", "id", context.getPackageName());
        TextView textView12E = findViewById(quelTextView12E);
        int quelTextView12W = getResources().getIdentifier("textView12W", "id", context.getPackageName());
        TextView textView12W = findViewById(quelTextView12W);
        int quelTextView12S = getResources().getIdentifier("textView12S", "id", context.getPackageName());
        TextView textView12S = findViewById(quelTextView12S);
        textView12E.setText(String.valueOf(score12.essai));
        textView12W.setText(String.valueOf(score12.win));
        textView12S.setText(String.valueOf(score12.serie));

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


        int queltextViewmots5T = getResources().getIdentifier("textViewM5Time", "id", context.getPackageName());
        TextView textViewmots5T = findViewById(queltextViewmots5T);
        textViewmots5T.setText(String.valueOf(scoreMots5.temps));


        int queltextViewmots10T = getResources().getIdentifier("textViewM10Time", "id", context.getPackageName());
        TextView textViewmots10T = findViewById(queltextViewmots10T);
        textViewmots10T.setText(String.valueOf(scoreMots10.temps));

    }

    @Override
    public void onClick(View v) {

        if (HardmodeSwitch.isChecked()) {
            switch (v.getId()) {
                case R.id.main_stats_4:
                    categorie = "HM-lettres4";
                    break;
                case R.id.main_stats_5:
                    categorie = "HM-lettres5";
                    break;
                case R.id.main_stats_6:
                    categorie = "HM-lettres6";
                    break;
                case R.id.main_stats_7:
                    categorie = "HM-lettres7";
                    break;
                case R.id.main_stats_8:
                    categorie = "HM-lettres8";
                    break;
                case R.id.main_stats_9:
                    categorie = "HM-lettres9";
                    break;
                case R.id.main_stats_10:
                    categorie = "HM-lettres10";
                    break;
                case R.id.main_stats_11:
                    categorie = "HM-lettres11";
                    break;
                case R.id.main_stats_12:
                    categorie = "HM-lettres12";
                    break;

            }
        } else {
            switch (v.getId()) {
                case R.id.main_stats_4:
                    categorie = "lettres4";
                    break;
                case R.id.main_stats_5:
                    categorie = "lettres5";
                    break;
                case R.id.main_stats_6:
                    categorie = "lettres6";
                    break;
                case R.id.main_stats_7:
                    categorie = "lettres7";
                    break;
                case R.id.main_stats_8:
                    categorie = "lettres8";
                    break;
                case R.id.main_stats_9:
                    categorie = "lettres9";
                    break;
                case R.id.main_stats_10:
                    categorie = "lettres10";
                    break;
                case R.id.main_stats_11:
                    categorie = "lettres11";
                    break;
                case R.id.main_stats_12:
                    categorie = "lettres12";
                    break;

            }

        }



        System.out.println("Graph pour la categorie: " + categorie);
        Intent intent = new Intent(StatsActivity.this, Pop.class);
        intent.putExtra("Categorie", categorie);
        startActivity(intent);
    }


}