package com.example.laureen.pepitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laureen.pepitapp.presenter.TestPersonalityUserPresenter;
import com.example.laureen.pepitapp.view.TestPersonalityUserView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestPersonalityUserActivity extends AppCompatActivity implements TestPersonalityUserView {
    private static final String TAG = "PersonalityUserActivity";

    @BindView(R.id.question_personality_quizz)
    TextView questionPersonalityQuizzTV;
    @BindView(R.id.radio_group_answer_personality_questions)
    RadioGroup radio_group_personalityRG;
    @BindView(R.id.answer1_personality_quizz)
    RadioButton answer1PersonalityRB;
    @BindView(R.id.answer2_personality_quizz)
    RadioButton answer2PersonalityRB;
    @BindView(R.id.answer3_personality_quizz)
    RadioButton answer3PersonalityRB;

    private ArrayList<String> arrQuestionsPersonality = new ArrayList<>();
    private ArrayList<ArrayList<String>> arrAnswerPersonality = new ArrayList<>();
    private ArrayList<Integer> arrIdUserAnswer = new ArrayList<>();
    private int cptQuestion = 0;
    private int cptReponse1 = 0;
    private int cptReponse2 = 0;
    private int cptReponse3 = 0;

    private TestPersonalityUserPresenter testPersonalityUserPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_personality_user);

        ButterKnife.bind(this);

        testPersonalityUserPresenter = new TestPersonalityUserPresenter((TestPersonalityUserView) this);
        testPersonalityUserPresenter.getTestPersonality(this);
    }


    @Override
    public void getPersonalityTest(ArrayList<String> questionsPersonality, ArrayList<ArrayList<String>> answerPersonality) {
        questionsPersonality.clear();
        answerPersonality.clear();
        this.arrQuestionsPersonality.addAll(questionsPersonality);
        this.arrAnswerPersonality.addAll(answerPersonality);

        Log.d("questions personality", questionsPersonality.toString());
        Log.d("answers personality", answerPersonality.toString());

    }

    public void nextQuestion(){
        Log.d(TAG, "question : " + arrQuestionsPersonality.get(cptQuestion));
        Log.d(TAG, "reponses 1 : " + arrAnswerPersonality.get(cptQuestion).get(0));
        Log.d(TAG, "reponses 2 : " + arrAnswerPersonality.get(cptQuestion).get(1));
        Log.d(TAG, "reponses 3 : " + arrAnswerPersonality.get(cptQuestion).get(2));

        questionPersonalityQuizzTV.setText(arrQuestionsPersonality.get(cptQuestion));
        answer1PersonalityRB.setText(arrAnswerPersonality.get(cptQuestion).get(0));
        answer2PersonalityRB.setText(arrAnswerPersonality.get(cptQuestion).get(1));
        answer3PersonalityRB.setText(arrAnswerPersonality.get(cptQuestion).get(2));
    }


    public void checkAnswerQuizz(){
        Log.e("cptQuestion", String.valueOf(cptQuestion));
        if(cptQuestion == arrQuestionsPersonality.size()){
            int idPersonality = endPersonalityTest();
            testPersonalityUserPresenter.updateTypeProfil(this, idPersonality);

        }

        int idRadioButtonChecked = radio_group_personalityRG.getCheckedRadioButtonId();
        //RadioButton radioButton = findViewById(idRadioButtonChecked);

        arrIdUserAnswer.add(cptQuestion, idRadioButtonChecked);


        Log.d("id checked", String.valueOf(idRadioButtonChecked));
        cptQuestion += 1;
        nextQuestion();

        //Toast.makeText(this, String.valueOf(timeToDoQuizz), Toast.LENGTH_SHORT).show();
    }

    public int endPersonalityTest(){
        for (int idAnswer : arrIdUserAnswer){
            switch (idAnswer){
                case 1:
                    cptReponse1 += 1;
                    break;
                case 2:
                    cptReponse2 +=1;
                    break;
                case 3:
                    cptReponse3 += 1;
                    break;
                default:
                    break;
            }
        }


        return cptReponse1 < cptReponse2 ? cptReponse1 < cptReponse3 ? cptReponse1 : cptReponse3 : cptReponse2 < cptReponse3 ? cptReponse2 : cptReponse3;

    }

}
