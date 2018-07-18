package com.example.laureen.pepitapp.view;

import java.util.List;

/**
 * Created by Florian on 17/07/2018.
 */

public interface QuizzView {
    void getQuizz(List<String> questionApi, List<List<String>> incorrectAnswerApi, List<String> correctAnswerApi);
}
