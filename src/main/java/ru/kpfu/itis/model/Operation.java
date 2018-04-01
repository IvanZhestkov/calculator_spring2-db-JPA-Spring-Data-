package ru.kpfu.itis.model;

public class Operation {

    public static double calc(String operation, double a, double b) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0f;
        }
    }
}
