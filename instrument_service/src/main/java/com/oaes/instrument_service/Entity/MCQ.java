package com.oaes.instrument_service.Entity;

import javax.persistence.Entity;

@Entity
public class MCQ extends Item{
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public MCQ() {}

    public MCQ(int itemId, String question, String correctAns, String subject, Author auth, String optionA, String optionB, String optionC, String optionD) {
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.setQuestion(question);
        this.setCorrectAnswer(correctAns);
        this.setSubject(subject);
        this.setAuthor(auth);
        this.setItemId(itemId);
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    @Override
    public String toString() {
        return "MCQ{" +
                "question='" + question + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", subject='" + subject + '\'' +
                ", author=" + author +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                '}';
    }
}
