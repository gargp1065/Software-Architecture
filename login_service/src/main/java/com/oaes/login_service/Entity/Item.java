package com.oaes.login_service.Entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    protected String question;

    protected String correctAnswer;

    protected String subject;

    @ManyToOne
    Author author;

//    public Item() {}

//    public Item(int itemId, String question, String correctAnswer, Author author) {
//        this.itemId = itemId;
//        this.question = question;
//        this.correctAnswer = correctAnswer;
//        this.author = author;
//    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctOption) {
        this.correctAnswer = correctOption;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
