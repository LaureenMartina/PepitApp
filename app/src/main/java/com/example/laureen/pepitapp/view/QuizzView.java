package com.example.laureen.pepitapp.view;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 17/07/2018.
 */

public interface QuizzView {
    void getQuizz(List<String> questionApi, List<List<String>> incorrectAnswerApi, List<String> correctAnswerApi, ArrayList<Integer> idsLevel);
    //void updateExperience(int exp, Context context);
    //void updateHistoric(List<Integer> id_levels, int exp, Context context);
}
