package ru.kpfu.itis.repository;

public interface CalculatorRepository {

    void addDigit(Double digit);

    void addMathAction(String oper);

    Double getDigit();

    String getMathAction();
}
