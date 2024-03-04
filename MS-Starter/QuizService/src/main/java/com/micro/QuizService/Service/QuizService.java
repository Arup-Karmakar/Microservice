package com.micro.QuizService.Service;

import com.micro.QuizService.Entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);

    Quiz getQuiz(int id);

    List<Quiz> getAllQuiz();
}
