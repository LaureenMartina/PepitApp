package com.example.laureen.pepitapp.model;

/**
 * Created by Florian on 17/07/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quizz {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_levels")
    @Expose
    private Integer idLevels;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answer1")
    @Expose
    private String answer1;
    @SerializedName("answer2")
    @Expose
    private String answer2;
    @SerializedName("answer3")
    @Expose
    private String answer3;
    @SerializedName("answer4")
    @Expose
    private String answer4;
    @SerializedName("correct_answer")
    @Expose
    private String correctAnswer;
    @SerializedName("difficulty")
    @Expose
    private Integer difficulty;
    @SerializedName("evaluate_lvl_player")
    @Expose
    private Integer evaluateLvlPlayer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLevels() {
        return idLevels;
    }

    public void setIdLevels(Integer idLevels) {
        this.idLevels = idLevels;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getEvaluateLvlPlayer() {
        return evaluateLvlPlayer;
    }

    public void setEvaluateLvlPlayer(Integer evaluateLvlPlayer) {
        this.evaluateLvlPlayer = evaluateLvlPlayer;
    }


    @Override
    public String toString() {
        return "Quizz{" +
                "id=" + id +
                ", idLevels=" + idLevels +
                ", question='" + question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", difficulty=" + difficulty +
                ", evaluateLvlPlayer=" + evaluateLvlPlayer +
                '}';
    }
}

