package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category implements Serializable {
    private Integer catId;
    private String catName;
    public Category(String catName) {
        this.catName = catName;
    }
}
