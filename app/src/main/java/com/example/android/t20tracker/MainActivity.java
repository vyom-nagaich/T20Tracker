package com.example.android.t20tracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0,scoreTeamB=0;
    int ballsA=0,ballsB=0,wA=0,wB=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void displayForTeamA(int score) {
             TextView scoreView = (TextView) findViewById(R.id.team_a_score);
             TextView wicketView = (TextView) findViewById(R.id.team_a_down);
        if (ballsA<30) {
            if (wA != 10) {
                scoreView.setText(String.valueOf(score));
                wicketView.setText(String.valueOf(wA));
            } else
                wicketView.setText("Bowled Out");
        }
        else {
            wicketView.setText("Over Up");
        }
    }



    public void add6A(){
        scoreTeamA+=6;
        ballsA++;
        displayForTeamA(scoreTeamA);
    }

    public void add4A(){
        scoreTeamA+=4; ballsA++;
        displayForTeamA(scoreTeamA);
    }
    public void add3A(){
        scoreTeamA+=3; ballsA++;
        displayForTeamA(scoreTeamA);
    }
    public void add2A(){
        scoreTeamA+=2; ballsA++;
        displayForTeamA(scoreTeamA);
    }

    public void add1A(){
        scoreTeamA+=1; ballsA++;
        displayForTeamA(scoreTeamA);
    }

    public void dotA(){
        ballsA++;
    }
    public void outA(){
        ballsA++;
        wA++;
        displayForTeamA(scoreTeamA);
    }

    public void declareResult()
    {   TextView v=(TextView)findViewById(R.id.result);
        if(scoreTeamA>scoreTeamB)
            v.setText("Team A win!");
        else if(scoreTeamA<scoreTeamB)
            v.setText("Team B win!");
        else
            v.setText("IT\'S A TIE");
    }

    public void resetScore(View v){
      scoreTeamA=0; wA=0; ballsA=0;
        scoreTeamB=0; wB=0; ballsB=0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        TextView wicketView = (TextView) findViewById(R.id.team_b_down);
        if(ballsB<30) {
            if (wB != 10) {
                scoreView.setText(String.valueOf(score));
                wicketView.setText(String.valueOf(wB));
                if (scoreTeamB > scoreTeamA)
                    declareResult();
            }
            else {
                wicketView.setText("Bowled Out");
                declareResult();
            }
        }
        else {
            wicketView.setText("Over Up");
            declareResult();
        }
    }

    public void add6B(){
        scoreTeamB+=6;
        ballsB++;
        displayForTeamB(scoreTeamB);
    }
    public void add4B(){
        scoreTeamB+=4; ballsB++;
        displayForTeamB(scoreTeamB);
    }
    public void add3B(){
        scoreTeamB+=3; ballsB++;
        displayForTeamB(scoreTeamB);
    }
    public void add2B(){
        scoreTeamB+=2; ballsB++;
        displayForTeamB(scoreTeamB);
    }
    public void add1B(){
        scoreTeamB+=1; ballsB++;
        displayForTeamB(scoreTeamB);
    }
    public void dotB(){
        ballsB++;
    }
    public void outB(){
        ballsB++;
        wB++;
        displayForTeamB(scoreTeamB);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
