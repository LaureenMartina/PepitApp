package com.example.laureen.pepitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laureen.pepitapp.model.Quizz;
import com.example.laureen.pepitapp.presenter.QuizzPresenter;
import com.example.laureen.pepitapp.view.ProfilUserView;
import com.example.laureen.pepitapp.view.QuizzView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizzActivity extends AppCompatActivity implements QuizzView, ProfilUserView {
    private static final String TAG = "QuizzActivity";
    private QuizzPresenter quizzPresenter;
    private List<Quizz> quizzList = new ArrayList<>();
    private List<String> questionsList = new ArrayList<>();
    private List<List<String>> incorrectAnswer = new ArrayList<>();
    private List<String> correctAnswer = new ArrayList<>();
    private ArrayList<Integer> idLevels = new ArrayList<>();
    private RadioGroup rg;


    private float xp = 0;
    private int score = 0;
    private int cptQuestion = 0;
    private int NUMBER_QUESTIONS_QUIZZ = 9;
    private int LIMIT_SCORE_FOR_BONUS = 7;
    private int LIMIT_TIME_FOR_BONUS = 60;
    private int ID_TEST_EVALUATE_USER_LEVEL = 1;
    private int ID_NORMAL_TEST = 0;

    private float BONUS_XP_TIME = 200;
    private float BONUS_XP_PERFECT = 350;
    long timeStartQuizz;
    long timeToDoQuizz;


    @BindView(R.id.score_during_questions)
    TextView score_player;
    @BindView(R.id.question_quizz)
    TextView questionQuizz;
    @BindView(R.id.radio_group_answer_questions)
    RadioGroup radio_group;
    @BindView(R.id.answer1_quizz)
    RadioButton answer1;
    @BindView(R.id.answer2_quizz)
    RadioButton answer2;
    @BindView(R.id.answer3_quizz)
    RadioButton answer3;
    @BindView(R.id.answer4_quizz)
    RadioButton answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        ButterKnife.bind(this);

        rg = findViewById(R.id.radio_group_answer_questions);

        timeStartQuizz = System.currentTimeMillis();

        quizzPresenter = new QuizzPresenter((QuizzView) this);
        //add presenter to get profil and get exp
        // add clause to know if exp is null

        quizzPresenter.questionQuizz(this);

        Button buttonAnswerQuizz = findViewById(R.id.btn_answer_quizz);

        buttonAnswerQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("in btn check answer", "");
                checkAnswerQuizz();
            }
        });

    }


    @Override
    public void getQuizz(List<String> questionApi, List<List<String>> incorrectAnswerApi, List<String> correctAnswerApi, ArrayList<Integer> idLevelsList) {
        Log.e("in getQuizz", "test");
        questionsList.clear();
        incorrectAnswer.clear();
        correctAnswer.clear();
        questionsList.addAll(questionApi);
        incorrectAnswer.addAll(incorrectAnswerApi);
        correctAnswer.addAll(correctAnswerApi);
        idLevels.addAll(idLevelsList);
        Log.e("list question", questionsList.toString());
        Log.e("list reponse", incorrectAnswer.toString());
        Log.e("list bonne reponse", correctAnswer.toString());
        Log.e("list id levels", idLevels.toString());

        nextQuestion();
    }




    public void nextQuestion(){
        Log.d(TAG, "question : " + questionsList.get(cptQuestion));
        Log.d(TAG, "reponses 1 : " + incorrectAnswer.get(cptQuestion).get(0));
        Log.d(TAG, "reponses 2 : " + incorrectAnswer.get(cptQuestion).get(1));
        Log.d(TAG, "reponses 3 : " + incorrectAnswer.get(cptQuestion).get(2));
        Log.d(TAG, "reponses 4 : " + incorrectAnswer.get(cptQuestion).get(3));
        Log.d(TAG, "bonne reponses : " + correctAnswer.get(cptQuestion));

        questionQuizz.setText(questionsList.get(cptQuestion));
        answer1.setText(incorrectAnswer.get(cptQuestion).get(0));
        answer2.setText(incorrectAnswer.get(cptQuestion).get(1));
        answer3.setText(incorrectAnswer.get(cptQuestion).get(2));
        answer4.setText(incorrectAnswer.get(cptQuestion).get(3));
    }
/*
    public void setAnswerQuizz(){
        answer1.setText(correctAnswer);
        answer2.setText(String.valueOf(incorrectAnswer.get(0)));
    }
*/




    public void checkAnswerQuizz(){
        Log.e("cptQuestion", String.valueOf(cptQuestion));
        if(cptQuestion == questionsList.size()-1){
            endOfQuizz();
        }
        //Toast.makeText(this, "Response", Toast.LENGTH_SHORT).show();
        int idRadioButtonChecked = rg.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idRadioButtonChecked);
        Log.e("response", radioButton.getText().toString());
        Log.e("correct response", correctAnswer.get(cptQuestion));
        if(radioButton.getText().toString().equals(correctAnswer.get(cptQuestion))){
            score += 1;
            xp += 150;
            Toast.makeText(this, "Bonne reponse", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Mauvaise reponse", Toast.LENGTH_SHORT).show();
        }
        score_player.setText(score + "/" + cptQuestion+1);

        Log.e("cptQuestion", String.valueOf(cptQuestion));
        Log.e("size", String.valueOf(questionsList.size()));
        cptQuestion += 1;
        if(cptQuestion == questionsList.size()-1) {
            nextQuestion();
        }



        //Toast.makeText(this, String.valueOf(timeToDoQuizz), Toast.LENGTH_SHORT).show();


    }

    public void endOfQuizz(){
        timeToDoQuizz = (System.currentTimeMillis() - timeStartQuizz)/1000; //Convert in seconds
        Log.i("time to answer", String.valueOf(timeToDoQuizz));
        if(timeToDoQuizz < LIMIT_SCORE_FOR_BONUS && score >= cptQuestion){
            xp += BONUS_XP_TIME;
        }
        if (score == NUMBER_QUESTIONS_QUIZZ){
            xp += BONUS_XP_PERFECT;
        }

        quizzPresenter.updateExperience((int) xp, this);
        quizzPresenter.updateHistoric(idLevels, (int) xp, this);


        Intent intent = new Intent(this, ResultQuizzActivity.class);
        intent.putExtra("score", String.valueOf(score));

        startActivity(intent);

    }


    @Override
    public void setExpUser(int exp) {

    }

    @Override
    public void setProfilIdUser(int profilIdUser) {

    }
}
