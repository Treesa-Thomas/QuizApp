package com.example.quizapp.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
