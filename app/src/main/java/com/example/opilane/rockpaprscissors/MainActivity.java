package com.example.opilane.rockpaprscissors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.opilane.rockpaprscissors.R.id.human;
import static com.example.opilane.rockpaprscissors.R.id.paper;
import static com.example.opilane.rockpaprscissors.R.id.scissors;

public class MainActivity extends AppCompatActivity {

    Button Rock,Paper,Scissors,end;
    ImageView humanView,computerView;
    TextView score;
    String humanChoice,computerChoice,result;
    Random r;
    int HumanScore,ComputerScore=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rock= findViewById(R.id.rock);
        Paper=findViewById(R.id.paper);
        Scissors= findViewById(R.id.scissors);
        end=findViewById(R.id.end);
        score= findViewById(R.id.score);
        humanView=findViewById(R.id.human);
        computerView=findViewById(R.id.cpu);
        r=new Random();

        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice="rock";
                calculate();
                humanView.setImageResource(R.drawable.rock);
                score.setText("Human:"+ Integer.toString(HumanScore) +"vs. Computer:"+Integer.toString(ComputerScore));
            }
        });
        Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice="rock";
                calculate();
                humanView.setImageResource(R.drawable.paper);
                score.setText("Human:"+ Integer.toString(HumanScore) +"vs. Computer:"+Integer.toString(ComputerScore));
            }
        });

        Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice="rock";
                calculate();
                humanView.setImageResource(R.drawable.scissors);
                score.setText("Human:"+ Integer.toString(HumanScore) +"vs. Computer:"+Integer.toString(ComputerScore));

            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SharedPreferences preferences= getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putInt("lastScore",HumanScore);
                editor.apply();

                Intent intent=new Intent(getApplicationContext(),ScoreActivity.class);
                startActivity(intent);
                finish();

        }

        public void calculate (){
            int computer= r.nextInt(3);
            if (computer==0) {
                computerChoice="rock";
                computerView.setImageResource(R.drawable.rock);
            }
            else if (computer == 1) {
                computerChoice= "paper";
                computerView.setImageResource(R.drawable.paper);
            }
            else if (computer == 2 ){
                computerChoice= "scissors";
                computerView.setImageResource(R.drawable.scissors);
            }
            if (humanChoice.equals("rock")&& computerChoice.equals("paper")) {
                result="You lose!";
                ComputerScore++;
                }
                else if (humanChoice.equals("rock")&&computerChoice.equals("scissors")){
                    result= "You win!";
                    HumanScore++;
                }

            else if (humanChoice.equals("rock")&&computerChoice.equals("rock")){
                result= "It is a tie!";
            }
            else if (humanChoice.equals("scissors")&&computerChoice.equals("scissors")){
                result= "It is a tie";

            }

            else if (humanChoice.equals("paper")&& computerChoice.equals("paper")){
                result= "It is a tie!";


            }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }
});
    }


}

