package com.example.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.model.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Question added successfully";
    }

    public String updateQuestion(Integer id, Question question) {
        Question existingQuestion = questionDao.findById(id).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setQuestionTitle(question.getQuestionTitle());
            existingQuestion.setCategory(question.getCategory());
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setRightAnswer(question.getRightAnswer());
            existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
            questionDao.save(existingQuestion);
            return "Question updated successfully";
        }
        return "No QUestion for the given id";
    }

    public String deleteQuestion(Integer id) {
        Question existingQuestion = questionDao.findById(id).orElse(null);
        if (existingQuestion != null) {
            questionDao.deleteById(id);
            return "Question deleted successfully";
        }
        return "Question not found";
    }

}
