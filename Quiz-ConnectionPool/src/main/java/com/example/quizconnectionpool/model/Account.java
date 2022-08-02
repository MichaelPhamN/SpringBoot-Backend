package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private Integer accountId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Timestamp birthday;
    private String firstname;
    private String lastname;
    private Boolean isAdmin;
    private Boolean status;
}
