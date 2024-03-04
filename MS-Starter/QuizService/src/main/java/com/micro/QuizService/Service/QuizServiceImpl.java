package com.micro.QuizService.Service;

import com.micro.QuizService.Entity.Quiz;
import com.micro.QuizService.Repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz getQuiz(int id) {
        Quiz getQuiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz Id not found"));
        getQuiz.setQuestions(questionClient.getQuestionOfQuiz(getQuiz.getId()));
        return getQuiz;
    }


    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> getAll = this.quizRepo.findAll();

       List<Quiz> newQuizList=  getAll.stream().map(quiz ->
        {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

       return newQuizList;
    }
}