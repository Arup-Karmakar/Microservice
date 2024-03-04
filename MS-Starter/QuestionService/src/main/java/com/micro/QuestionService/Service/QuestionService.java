package com.micro.QuestionService.Service;

import com.micro.QuestionService.Entity.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);

    Question getQuestion(int questionId);

    List<Question> getAllQuestion();

    List<Question> getQuestionByQuizId(int quizId);
}
