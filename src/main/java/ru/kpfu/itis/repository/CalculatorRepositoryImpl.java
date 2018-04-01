package ru.kpfu.itis.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepositoryImpl implements CalculatorRepository {

    Double digit;

    String oper = "";

    @Override
    public void addDigit(Double digit) {
        this.digit = digit;
    }

    @Override
    public void addMathAction(String oper) {
        this.oper = oper;
    }

    @Override
    public Double getDigit() {
        return digit;
    }

    @Override
    public String getMathAction() {
        return oper;
    }
}
