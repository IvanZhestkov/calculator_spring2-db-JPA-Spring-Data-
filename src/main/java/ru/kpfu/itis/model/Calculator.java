package ru.kpfu.itis.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Pattern(regexp = "^[0-9]*[.]?[0-9]+$", message = "Введены некорректные данные")
    private String digit;

    private String operation;

    @ManyToOne
    private User user;

    public Calculator(String digit, String operation, User user) {
        this.digit = digit;
        this.operation = operation;
        this.user = user;
    }

    public Calculator(){}

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
