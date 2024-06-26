package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Switch mHardmodeSwitch;

    String modeDeJeux ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHardmodeSwitch = findViewById(R.id.switchHardmode);

        Button mPlayButton = findViewById(R.id.main_button_play);
        Button mDailyButton = findViewById(R.id.main_button_daily);
        Button m10motsButton = findViewById(R.id.main_button_5mots);
        Button m5motsButton = findViewById(R.id.main_button_10mots);
        Button mStatButton = findViewById(R.id.main_button_stats);
        mPlayButton.setOnClickListener(this);
        mDailyButton.setOnClickListener(this);
        m10motsButton.setOnClickListener(this);
        m5motsButton.setOnClickListener(this);
        mStatButton.setOnClickListener(this);

        MyDatabaseHelper db = new MyDatabaseHelper(this);
        int newVersionDbMots = 0;
        int versionDbMots =0;
        versionDbMots = db.getVersion();

        InputStream insertsStream = this.getResources().openRawResource(R.raw.mots1);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));
        try {
            String insertStmt = insertReader.readLine();
            newVersionDbMots = Integer.parseInt(insertStmt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    if (versionDbMots != newVersionDbMots){


        try {
            int versionAUpdate = db.insertFromFile(this,R.raw.mots1);
            System.out.println("la nouvelle version est = "+ versionAUpdate);
            db.updateVersion(versionAUpdate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }else{
        System.out.println("meme version");
    }

    }



    @Override
    public void onClick(View v) {

        if (mHardmodeSwitch.isChecked()) {
            modeDeJeux = "HM";
            System.out.println(mHardmodeSwitch.isChecked());
        }

        switch (v.getId()){
            case R.id.main_button_5mots:
                modeDeJeux = modeDeJeux + "-5mots";
                 break;
            case R.id.main_button_daily:
                modeDeJeux =  modeDeJeux + "-Daily";

                break;
            case R.id.main_button_10mots:
                modeDeJeux =  modeDeJeux + "-10mots";
                break;
            case R.id.main_button_play:
                modeDeJeux =  modeDeJeux + "-Training";
                break;
            case R.id.main_button_stats:
                modeDeJeux = "stat";
                Intent intent = new Intent(MainActivity.this,StatsActivity.class);
                startActivity(intent);
                break;
        }


    if (!modeDeJeux.equals("") && !modeDeJeux.equals("stat")) {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            intent.putExtra("Mode", modeDeJeux);
            startActivity(intent);
            modeDeJeux = "";
        }
    }
}