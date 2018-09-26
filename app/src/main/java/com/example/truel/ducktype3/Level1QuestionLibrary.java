package com.example.truel.ducktype3;

public class Level1QuestionLibrary {
    private String lvl1question;
    private String lvl1option1;
    private String lvl1option2;
    private String lvl1option3;
    private String lvl1option4;

    private int lvl1answerNR;

    public Level1QuestionLibrary() {}

    public Level1QuestionLibrary(String lvl1question, String lvl1option1, String lvl1option2, String lvl1option3, String lvl1option4, int lvl1answerNR) {
        this.lvl1question = lvl1question;
        this.lvl1option1 = lvl1option1;
        this.lvl1option2 = lvl1option2;
        this.lvl1option3 = lvl1option3;
        this.lvl1option4 = lvl1option4;
        this.lvl1answerNR = lvl1answerNR;
    }

    public String getLvl1question() {
        return lvl1question;
    }

    public void setLvl1question(String lvl1question) {
        this.lvl1question = lvl1question;
    }

    public String getLvl1option1() {
        return lvl1option1;
    }

    public void setLvl1option1(String lvl1option1) {
        this.lvl1option1 = lvl1option1;
    }

    public String getLvl1option2() {
        return lvl1option2;
    }

    public void setLvl1option2(String lvl1option2) {
        this.lvl1option2 = lvl1option2;
    }

    public String getLvl1option3() {
        return lvl1option3;
    }

    public void setLvl1option3(String lvl1option3) {
        this.lvl1option3 = lvl1option3;
    }

    public String getLvl1option4() {
        return lvl1option4;
    }

    public void setLvl1option4(String lvl1option4) {
        this.lvl1option4 = lvl1option4;
    }

    public int getLvl1answerNR() {
        return lvl1answerNR;
    }

    public void setLvl1answerNR(int lvl1answerNR) {
        this.lvl1answerNR = lvl1answerNR;
    }
}
