package com.example.laureen.pepitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.laureen.pepitapp.model.User;
import com.example.laureen.pepitapp.presenter.TestPersonalityUserPresenter;
import com.example.laureen.pepitapp.view.TestPersonalityUserView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestPersonalityUserActivity extends AppCompatActivity implements TestPersonalityUserView {
    private static final String TAG = "PersonalityUserActivity";

    public int typeProfilNinja = 1;
    public int typeProfilProf = 2;
    public int typeProfilExplorer = 3;


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
        this.arrQuestionsPersonality.clear();
        this.arrAnswerPersonality.clear();
        this.arrQuestionsPersonality.addAll(questionsPersonality);
        this.arrAnswerPersonality.addAll(answerPersonality);

        Log.d("questions params", questionsPersonality.toString());
        Log.d("answers params", answerPersonality.toString());

        Log.d("questions attribut", this.arrQuestionsPersonality.toString());
        Log.d("answers attribut", this.arrAnswerPersonality.toString());

        nextQuestion();

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


    @OnClick(R.id.btn_answer_personality_quizz)
    public void checkAnswerQuizz(){
        Log.e("cptQuestion", String.valueOf(cptQuestion));
        if(cptQuestion == arrQuestionsPersonality.size() - 1){
            int idPersonality = endPersonalityTest();

            User profil = new User();
            profil.setId_type_profil(idPersonality);

            Log.e("idpersonality", String.valueOf(idPersonality));
            testPersonalityUserPresenter.updateTypeProfil(this, idPersonality);

            Intent intent = new Intent(TestPersonalityUserActivity.this, GameActivity.class);
            startActivity(intent);

        }

        int idRadioButtonChecked = radio_group_personalityRG.getCheckedRadioButtonId(); // ex id = 21544
        RadioButton radioButtonChecked = findViewById(idRadioButtonChecked); // nol id dans le xml
        Log.d("rb checked", radioButtonChecked.toString());
        Log.d("rb", answer1PersonalityRB.toString());
        Log.d("rb", String.valueOf(answer1PersonalityRB.equals(radioButtonChecked)));
        Log.d("rb", String.valueOf(answer2PersonalityRB.equals(radioButtonChecked)));

        if(answer1PersonalityRB.equals(radioButtonChecked)){
            arrIdUserAnswer.add(cptQuestion, 1);
        }
        if(answer2PersonalityRB.equals(radioButtonChecked)){
            arrIdUserAnswer.add(cptQuestion, 2);
        }
        if(answer3PersonalityRB.equals(radioButtonChecked)){
            arrIdUserAnswer.add(cptQuestion, 3);
        }


        cptQuestion += 1;
        if(cptQuestion < arrQuestionsPersonality.size() -1){
            nextQuestion();
        }
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
        Log.e("cptReponse1", String.valueOf(cptReponse1));
        Log.e("cptReponse2", String.valueOf(cptReponse2));
        Log.e("cptReponse3", String.valueOf(cptReponse3));

        return cptReponse1 > cptReponse2 ? cptReponse1 > cptReponse3 ? typeProfilNinja : typeProfilExplorer : cptReponse2 > cptReponse3 ? typeProfilProf : typeProfilExplorer;

    }

}
