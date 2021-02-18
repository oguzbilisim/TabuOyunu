package com.example.tabucuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public TextView guess_word_text_view;
    private TextView taboo_word_1_text_view;
    private TextView taboo_word_2_text_view;
    private TextView taboo_word_3_text_view;

    private TextView tv1,teamname,teamname2,teamname12,teamname22;
    private Button startbtn,stop,resume,stop2,resume2;
    private Button correct_button,taboo_button,pass_button;

    private Button startbtn2,firstbtn;
    private Button correct_button2,taboo_button2;

    public static TextView sayac,teamsayac;
    public static int score,teamscore;

    public static TextView sayac2,teamsayac2;
    public static int score2,teamscore2;


    public static TextView cardTitleTextView,tabooWord1TextView,tabooWord2TextView,tabooWord3TextView;





    private boolean isPaused=false;
    private boolean isCanceled=false;
    private long Reminingtime=0;






    ArrayList<ArrayList<String>> cards;



    // card Indexes that have been shown
    private boolean[] cardsShown;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score =0;
        teamscore=0;

        score2 =0;
        teamscore2=0;


        tv1=findViewById(R.id.tv1);
        teamname=findViewById(R.id.teamname);
        teamname2=findViewById(R.id.teamname2);
        teamname12=findViewById(R.id.teamname12);
        teamname22=findViewById(R.id.teamname22);

        Intent intent = getIntent();
        String text = intent.getStringExtra(login.EXTRA_TEXT);
        String text2 = intent.getStringExtra(login.EXTRA_TEXT2);

        teamname.setText(text);
        teamname2.setText(text2);

        teamname12.setText(text);
        teamname22.setText(text2);



        sayac = findViewById(R.id.sayac);
        teamsayac = findViewById(R.id.teamsayac);



        correct_button = findViewById(R.id.correct_button);
        taboo_button = findViewById(R.id.taboo_button);
        pass_button = findViewById(R.id.pass_button);
        startbtn=findViewById(R.id.startbtn);
        stop = findViewById(R.id.stop);
        resume = findViewById(R.id.resume);
        stop2 = findViewById(R.id.stop2);
        resume2 = findViewById(R.id.resume2);

        correct_button2 = findViewById(R.id.correct_button2);
        taboo_button2 = findViewById(R.id.taboo_button2);
        startbtn2 =findViewById(R.id.startbtn2);
        firstbtn = findViewById(R.id.firststartbtn);

        sayac2 = findViewById(R.id.sayac2);
        teamsayac2 = findViewById(R.id.teamsayac2);








        correct_button.setVisibility(View.GONE);
        taboo_button.setVisibility(View.GONE);
        pass_button.setVisibility(View.GONE);
        stop.setVisibility(View.GONE);
        stop2.setVisibility(View.GONE);
        resume.setVisibility(View.GONE);
        resume2.setVisibility(View.GONE);
        startbtn.setVisibility(View.GONE);
        teamsayac.setVisibility(View.GONE);
        teamsayac2.setVisibility(View.GONE);
        sayac2.setVisibility(View.GONE);
        sayac.setVisibility(View.GONE);


        correct_button2.setVisibility(View.GONE);
        taboo_button2.setVisibility(View.GONE);
        startbtn2.setVisibility(View.GONE);


        teamname2.setVisibility(View.GONE);
        teamname12.setVisibility(View.GONE);
        teamname22.setVisibility(View.GONE);





        firstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardTitleTextView.setVisibility(View.VISIBLE);
                tabooWord1TextView.setVisibility(View.VISIBLE);
                tabooWord2TextView.setVisibility(View.VISIBLE);
                tabooWord3TextView.setVisibility(View.VISIBLE);

                correct_button.setVisibility(View.VISIBLE);
                taboo_button.setVisibility(View.VISIBLE);
                pass_button.setVisibility(View.VISIBLE);
                stop.setVisibility(View.VISIBLE);
                firstbtn.setVisibility(View.GONE);

                teamsayac.setVisibility(View.GONE);
                teamsayac2.setVisibility(View.GONE);

                sayac.setVisibility(View.VISIBLE);
                sayac2.setVisibility(View.GONE);

                teamname2.setVisibility(View.GONE);
                teamname.setVisibility(View.VISIBLE);

                teamname12.setVisibility(View.GONE);
                teamname22.setVisibility(View.GONE);





                isPaused = false;
                isCanceled = false;

                long millisInfuture = 100000;
                long countDownInterval = 1000;
                new CountDownTimer(millisInfuture,countDownInterval){
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(isPaused||isCanceled){
                            cancel();
                        }
                        else{
                            tv1.setText(""+millisUntilFinished/1000);
                            Reminingtime = millisUntilFinished;
                        }

                    }

                    @Override
                    public void onFinish() {

                        tv1.setText("");

                        cardTitleTextView.setVisibility(View.GONE);
                        tabooWord1TextView.setVisibility(View.GONE);
                        tabooWord2TextView.setVisibility(View.GONE);
                        tabooWord3TextView.setVisibility(View.GONE);

                        sayac.setVisibility(View.GONE);
                        teamsayac.setVisibility(View.VISIBLE);
                        teamsayac2.setVisibility(View.VISIBLE);


                        correct_button.setVisibility(View.GONE);
                        taboo_button.setVisibility(View.GONE);
                        correct_button2.setVisibility(View.GONE);
                        taboo_button2.setVisibility(View.GONE);
                        pass_button.setVisibility(View.GONE);
                        stop.setVisibility(View.GONE);
                        stop2.setVisibility(View.GONE);
                        startbtn.setVisibility(View.VISIBLE);
                        resume.setVisibility(View.GONE);
                        resume2.setVisibility(View.GONE);
                        teamname2.setVisibility(View.GONE);
                        teamname.setVisibility(View.GONE);

                        teamname12.setVisibility(View.VISIBLE);
                        teamname22.setVisibility(View.VISIBLE);

                        score=0;
                        score2=0;
                        sayac.setText(score + "");
                        sayac2.setText(score2 + "");


                    }


                }.start();

            }
        });




        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardTitleTextView.setVisibility(View.VISIBLE);
                tabooWord1TextView.setVisibility(View.VISIBLE);
                tabooWord2TextView.setVisibility(View.VISIBLE);
                tabooWord3TextView.setVisibility(View.VISIBLE);

                correct_button2.setVisibility(View.VISIBLE);
                taboo_button2.setVisibility(View.VISIBLE);
                pass_button.setVisibility(View.VISIBLE);
                stop2.setVisibility(View.VISIBLE);
                startbtn.setVisibility(View.GONE);
                teamname.setVisibility(View.GONE);
                teamname2.setVisibility(View.VISIBLE);

                teamsayac.setVisibility(View.GONE);
                teamsayac2.setVisibility(View.GONE);

                sayac.setVisibility(View.GONE);
                sayac2.setVisibility(View.VISIBLE);

                teamname12.setVisibility(View.GONE);
                teamname22.setVisibility(View.GONE);





                isPaused = false;
                isCanceled = false;

                long millisInfuture = 100000;
                long countDownInterval = 1000;
                new CountDownTimer(millisInfuture,countDownInterval){
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(isPaused||isCanceled){
                            cancel();
                        }
                        else{
                            tv1.setText(""+millisUntilFinished/1000);
                            Reminingtime = millisUntilFinished;
                        }

                    }

                    @Override
                    public void onFinish() {

                        tv1.setText("");

                        cardTitleTextView.setVisibility(View.GONE);
                        tabooWord1TextView.setVisibility(View.GONE);
                        tabooWord2TextView.setVisibility(View.GONE);
                        tabooWord3TextView.setVisibility(View.GONE);

                        sayac2.setVisibility(View.GONE);
                        teamsayac.setVisibility(View.VISIBLE);
                        teamsayac2.setVisibility(View.VISIBLE);


                        correct_button2.setVisibility(View.GONE);
                        taboo_button2.setVisibility(View.GONE);
                        pass_button.setVisibility(View.GONE);
                        stop.setVisibility(View.GONE);
                        stop2.setVisibility(View.GONE);
                        startbtn.setVisibility(View.GONE);
                        firstbtn.setVisibility(View.VISIBLE);
                        resume.setVisibility(View.GONE);
                        resume2.setVisibility(View.GONE);
                        teamname.setVisibility(View.GONE);
                        teamname2.setVisibility(View.GONE);

                        teamname12.setVisibility(View.VISIBLE);
                        teamname22.setVisibility(View.VISIBLE);

                        score=0;
                        score2=0;
                        sayac.setText(score + "");
                        sayac2.setText(score2 + "");


                    }


                }.start();
            }
        });

        startbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardTitleTextView.setVisibility(View.VISIBLE);
                tabooWord1TextView.setVisibility(View.VISIBLE);
                tabooWord2TextView.setVisibility(View.VISIBLE);
                tabooWord3TextView.setVisibility(View.VISIBLE);

                correct_button2.setVisibility(View.GONE);
                taboo_button2.setVisibility(View.GONE);
                pass_button.setVisibility(View.VISIBLE);
                stop.setVisibility(View.VISIBLE);
                startbtn2.setVisibility(View.GONE);

                correct_button.setVisibility(View.VISIBLE);
                taboo_button.setVisibility(View.VISIBLE);

                teamsayac.setVisibility(View.GONE);
                teamsayac2.setVisibility(View.GONE);

                sayac.setVisibility(View.VISIBLE);
                sayac2.setVisibility(View.GONE);

                teamname2.setVisibility(View.GONE);
                teamname.setVisibility(View.VISIBLE);

                teamname12.setVisibility(View.GONE);
                teamname22.setVisibility(View.GONE);





                isPaused = false;
                isCanceled = false;

                long millisInfuture = 100000;
                long countDownInterval = 1000;
                new CountDownTimer(millisInfuture,countDownInterval){
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(isPaused||isCanceled){
                            cancel();
                        }
                        else{
                            tv1.setText(""+millisUntilFinished/1000);
                            Reminingtime = millisUntilFinished;
                        }

                    }

                    @Override
                    public void onFinish() {

                        tv1.setText("");

                        cardTitleTextView.setVisibility(View.GONE);
                        tabooWord1TextView.setVisibility(View.GONE);
                        tabooWord2TextView.setVisibility(View.GONE);
                        tabooWord3TextView.setVisibility(View.GONE);

                        teamsayac.setVisibility(View.VISIBLE);
                        teamsayac2.setVisibility(View.VISIBLE);


                        teamname.setVisibility(View.GONE);
                        teamname2.setVisibility(View.GONE);
                        correct_button.setVisibility(View.GONE);
                        taboo_button.setVisibility(View.GONE);
                        pass_button.setVisibility(View.GONE);
                        stop.setVisibility(View.GONE);
                        stop2.setVisibility(View.GONE);
                        firstbtn.setVisibility(View.VISIBLE);
                        resume.setVisibility(View.GONE);
                        resume2.setVisibility(View.GONE);
                        teamname2.setVisibility(View.GONE);

                        teamname12.setVisibility(View.VISIBLE);
                        teamname22.setVisibility(View.VISIBLE);

                        score=0;
                        score2=0;
                        sayac.setText(score + "");
                        sayac2.setText(score2 + "");

                    }


                }.start();


            }
        });



        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                correct_button.setVisibility(View.GONE);
                taboo_button.setVisibility(View.GONE);
                pass_button.setVisibility(View.GONE);
                resume.setVisibility(View.VISIBLE);
                stop.setVisibility(View.GONE);

                isPaused = true;


            }
        });

        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                correct_button2.setVisibility(View.GONE);
                taboo_button2.setVisibility(View.GONE);
                pass_button.setVisibility(View.GONE);
                resume2.setVisibility(View.VISIBLE);
                stop2.setVisibility(View.GONE);

                isPaused = true;

            }
        });

        resume2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                correct_button2.setVisibility(View.VISIBLE);
                taboo_button2.setVisibility(View.VISIBLE);
                pass_button.setVisibility(View.VISIBLE);
                stop2.setVisibility(View.VISIBLE);
                resume2.setVisibility(View.GONE);

                isPaused=false;

                long millisInfuture = Reminingtime;
                long countDownInterval = 1000;
                new CountDownTimer(millisInfuture,countDownInterval){
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(isPaused||isCanceled){
                            cancel();
                        }
                        else{
                            tv1.setText(""+millisUntilFinished/1000);
                            Reminingtime = millisUntilFinished;
                        }

                    }

                    @Override
                    public void onFinish() {

                        tv1.setText("");

                        cardTitleTextView.setVisibility(View.GONE);
                        tabooWord1TextView.setVisibility(View.GONE);
                        tabooWord2TextView.setVisibility(View.GONE);
                        tabooWord3TextView.setVisibility(View.GONE);

                        sayac2.setVisibility(View.GONE);
                        teamsayac.setVisibility(View.VISIBLE);
                        teamsayac2.setVisibility(View.VISIBLE);


                        correct_button.setVisibility(View.GONE);
                        taboo_button.setVisibility(View.GONE);
                        correct_button2.setVisibility(View.GONE);
                        taboo_button2.setVisibility(View.GONE);
                        stop.setVisibility(View.GONE);
                        pass_button.setVisibility(View.GONE);
                        stop2.setVisibility(View.GONE);
                        startbtn2.setVisibility(View.VISIBLE);
                        resume.setVisibility(View.GONE);
                        resume2.setVisibility(View.GONE);

                        teamname.setVisibility(View.GONE);
                        teamname2.setVisibility(View.GONE);

                        teamname12.setVisibility(View.VISIBLE);
                        teamname22.setVisibility(View.VISIBLE);

                        score=0;
                        score2=0;
                        sayac.setText(score + "");
                        sayac2.setText(score2 + "");


                    }
                }.start();

            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                correct_button.setVisibility(View.VISIBLE);
                taboo_button.setVisibility(View.VISIBLE);
                pass_button.setVisibility(View.VISIBLE);
                stop.setVisibility(View.VISIBLE);
                resume.setVisibility(View.GONE);

                isPaused=false;

                long millisInfuture = Reminingtime;
                long countDownInterval = 1000;
                new CountDownTimer(millisInfuture,countDownInterval){
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(isPaused||isCanceled){
                            cancel();
                        }
                        else{
                            tv1.setText(""+millisUntilFinished/1000);
                            Reminingtime = millisUntilFinished;
                        }

                    }

                    @Override
                    public void onFinish() {

                        tv1.setText("");


                        cardTitleTextView.setVisibility(View.GONE);
                        tabooWord1TextView.setVisibility(View.GONE);
                        tabooWord2TextView.setVisibility(View.GONE);
                        tabooWord3TextView.setVisibility(View.GONE);

                        sayac.setVisibility(View.GONE);
                        teamsayac.setVisibility(View.VISIBLE);
                        teamsayac2.setVisibility(View.VISIBLE);


                        correct_button.setVisibility(View.GONE);
                        taboo_button.setVisibility(View.GONE);
                        correct_button2.setVisibility(View.GONE);
                        taboo_button2.setVisibility(View.GONE);
                        pass_button.setVisibility(View.GONE);
                        stop.setVisibility(View.GONE);
                        stop2.setVisibility(View.GONE);
                        startbtn.setVisibility(View.VISIBLE);
                        resume.setVisibility(View.GONE);
                        resume2.setVisibility(View.GONE);

                        teamname.setVisibility(View.GONE);
                        teamname2.setVisibility(View.GONE);

                        teamname12.setVisibility(View.VISIBLE);
                        teamname22.setVisibility(View.VISIBLE);

                        score=0;
                        score2=0;
                        sayac.setText(score + "");
                        sayac2.setText(score2 + "");


                    }
                }.start();

            }
        });









        assert correct_button != null;


        correct_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                score++;
                sayac.setText(score + "");



                teamscore++;
                teamsayac.setText(teamscore + "");


                updateCard();



            }
        });

        correct_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2++;
                sayac2.setText(score2 + "");



                teamscore2++;
                teamsayac2.setText(teamscore2 + "");

                updateCard();
            }
        });

        taboo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                score--;
                sayac.setText(score + "");


                teamscore--;
                teamsayac.setText(teamscore + "");


                updateCard();



            }
        });

        taboo_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2--;
                sayac2.setText(score2 + "");


                teamscore2--;
                teamsayac2.setText(teamscore2 + "");

                updateCard();
            }
        });

        pass_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCard();
            }
        });





        try {
            cards = getCards();
        } catch (Exception IOException) {
        }
        cardsShown = new boolean[cards.size()];

        updateCard();

    }

    public void updateCard() {
        boolean doneAllCards = doneAllCards();
        // if done all cards start over
        if (doneAllCards)
            Arrays.fill(cardsShown, Boolean.FALSE);

        // select random cart group
        int randomCardIndex = (int) (Math.random() * cards.size());
        Log.d("abcabc", "" + randomCardIndex);

        // go through the cards to find the first index at which the card group has not been used
        while (cardsShown[randomCardIndex]) {
            randomCardIndex++;
            if (randomCardIndex == cardsShown.length) {
                randomCardIndex -= cardsShown.length;
            }
        }

        cardsShown[randomCardIndex] = false;

        cardTitleTextView = findViewById(R.id.guess_word);
        cardTitleTextView.setText(cards.get(randomCardIndex).get(0));

        tabooWord1TextView = findViewById(R.id.taboo_word1);
        tabooWord1TextView.setText(cards.get(randomCardIndex).get(1));

        tabooWord2TextView = findViewById(R.id.taboo_word2);
        tabooWord2TextView.setText(cards.get(randomCardIndex).get(2));

        tabooWord3TextView = findViewById(R.id.taboo_word3);
        tabooWord3TextView.setText(cards.get(randomCardIndex).get(3));


    }



    public boolean doneAllCards() {
        for (int i = 0; i < cardsShown.length; i++) {
            if (cardsShown[i] == true) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> getCards() throws IOException {
        InputStream is = this.getResources().openRawResource(R.raw.kelimeler);
        BufferedReader s = new BufferedReader(new InputStreamReader(is));

        // Scanner s = new Scanner(file);
        ArrayList<ArrayList<String>> out = new ArrayList<ArrayList<String>>();

        int index = 0;
        while (s.ready()) {
            s.readLine();
            ArrayList<String> textList = new ArrayList<String>();
            out.add(textList);
            for (int i = 0; i < 4; i++) {
                out.get(index).add(s.readLine());
            }
            index++;
        }
        is.close();
        s.close();
        return out;
    }
}




