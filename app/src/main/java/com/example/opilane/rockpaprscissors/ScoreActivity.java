package com.example.opilane.rockpaprscissors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView Score;
    int lastScore;
    int best1, best2,best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Score=findViewById(R.id.score);
        //load old scores
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore=preferences.getInt("lastScore", 0);
        best1=preferences.getInt("best1", 0);
        best2=preferences.getInt("best2", 0);
        best3=preferences.getInt("best3", 0);
        //replace if there is a high score

        if (lastScore > best3) {
            best3=lastScore;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best3", best3);
            editor.apply();
        }

        if (lastScore > best2) {
            int temp=best2;
            best2=lastScore;
            best3=temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best3", best3);
            editor.apply();
        }

        if (lastScore > best1) {
            int temp=best1;
            best1=lastScore;
            best2=temp;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();


        }

        //display score
        Score.setText("LAST SCORE:" + lastScore+ "\n"+"BEST 1:"+best1+"\n"+"BEST 2"+ best2+"\n"+"BEST 3"+ best3);

    }

    public void again(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
startActivity(intent);
finish();

    }
}