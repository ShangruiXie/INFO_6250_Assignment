package com.neu.hm5.pojo;

public class Quiz {
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String correctAnswer1;
    private String correctAnswer2;
    private String correctAnswer3;
    private String correctAnswer4;
    private String correctAnswer5;

    public int getScore(){
        int score = 0;
        if(answer1.equals(correctAnswer1)) score++;
        if(answer2.equals(correctAnswer2)) score++;
        if(answer3.equals(correctAnswer3)) score++;
        if(answer4.equals(correctAnswer4)) score++;
        if(answer5.equals(correctAnswer5)) score++;

        return score;
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

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getCorrectAnswer1() {
        return correctAnswer1;
    }

    public void setCorrectAnswer1(String correctAnswer1) {
        this.correctAnswer1 = correctAnswer1;
    }

    public String getCorrectAnswer2() {
        return correctAnswer2;
    }

    public void setCorrectAnswer2(String correctAnswer2) {
        this.correctAnswer2 = correctAnswer2;
    }

    public String getCorrectAnswer3() {
        return correctAnswer3;
    }

    public void setCorrectAnswer3(String correctAnswer3) {
        this.correctAnswer3 = correctAnswer3;
    }

    public String getCorrectAnswer4() {
        return correctAnswer4;
    }

    public void setCorrectAnswer4(String correctAnswer4) {
        this.correctAnswer4 = correctAnswer4;
    }

    public String getCorrectAnswer5() {
        return correctAnswer5;
    }

    public void setCorrectAnswer5(String correctAnswer5) {
        this.correctAnswer5 = correctAnswer5;
    }
}
