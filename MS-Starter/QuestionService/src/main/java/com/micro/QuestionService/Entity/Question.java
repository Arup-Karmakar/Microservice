package com.micro.QuestionService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Question {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int questionId;
      private String question;

      private int quizId;
}
