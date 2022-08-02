package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question implements Serializable {
    private Integer questionId;
    private Integer questionCategoryId;
    private String questionDescription;
    private String questionChoiceA;
    private String questionChoiceB;
    private String questionChoiceC;
    private String questionChoiceD;
    private String questionAnswer;
}
