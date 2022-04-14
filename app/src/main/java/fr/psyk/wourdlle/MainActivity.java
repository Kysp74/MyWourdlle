package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mPlayButton,mDailyButton,m5motsButton,m10motsButton,mStatButton;
    private Switch mHardmodeSwitch;
    private TextView mTextView_Seek;
    String modeDeJeux ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHardmodeSwitch = findViewById(R.id.switchHardmode);

        mPlayButton = findViewById(R.id.main_button_play);
        mDailyButton = findViewById(R.id.main_button_daily);
        m10motsButton = findViewById(R.id.main_button_5mots);
        m5motsButton = findViewById(R.id.main_button_10mots);
        mStatButton = findViewById(R.id.main_button_stats);
        mPlayButton.setOnClickListener(this);
        mDailyButton.setOnClickListener(this);
        m10motsButton.setOnClickListener(this);
        m5motsButton.setOnClickListener(this);
        mStatButton.setOnClickListener(this);


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
               // modeDeJeux =  modeDeJeux + "-Daily";
                Intent intent2 = new Intent(MainActivity.this,test_chart.class);
                startActivity(intent2);
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