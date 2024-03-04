package com.micro.QuestionService.Service;

import com.micro.QuestionService.Entity.Question;
import com.micro.QuestionService.Repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public Question addQuestion(Question question) {
          return questionRepo.save(question);
    }

    @Override
    public Question getQuestion(int questionId) {
        return questionRepo.findById(questionId).orElseThrow(()-> new RuntimeException("Queston not found"));
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }

    @Override
    public List<Question> getQuestionByQuizId(int quizId) {
        return questionRepo.findByQuizId(quizId);
    }


}
