package com.micro.QuizService.Controller;

import com.micro.QuizService.Entity.Quiz;
import com.micro.QuizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/addquiz")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz addQuiz = this.quizService.addQuiz(quiz);
        return new ResponseEntity<>(addQuiz, HttpStatus.CREATED);
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable int id){
        Quiz getQuiz = this.quizService.getQuiz(id);
        return new ResponseEntity<>(getQuiz,HttpStatus.OK);
    }

    @GetMapping("/gatallquiz")
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        List<Quiz> getAll = this.quizService.getAllQuiz();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }

}
