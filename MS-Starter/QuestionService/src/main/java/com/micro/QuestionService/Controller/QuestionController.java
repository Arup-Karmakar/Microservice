package com.micro.QuestionService.Controller;

import com.micro.QuestionService.Entity.Question;
import com.micro.QuestionService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping("/addquestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question addQuestion = this.service.addQuestion(question);
        return new ResponseEntity<>(addQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/getquestion/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable int questionId){
        Question getQuestion = this.service.getQuestion(questionId);
        return new ResponseEntity<>(getQuestion , HttpStatus.OK);
    }

    @GetMapping("/getallquestion")
    public ResponseEntity<List<Question>> getAll(){
        List<Question> getall = this.service.getAllQuestion();
        return new ResponseEntity<>(getall , HttpStatus.OK);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionByQuizId(@PathVariable int quizId){
        List<Question> getQuesByQuizId = this.service.getQuestionByQuizId(quizId);
        return new ResponseEntity<>(getQuesByQuizId , HttpStatus.OK);
    }

}
