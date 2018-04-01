package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.OperationRepository;
import ru.kpfu.itis.repository.SessionHistory;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.repository.CalculatorRepository;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    CalculatorRepository repository;

    @Autowired
    SessionHistory history;

    @Autowired
    OperationRepository operationRepository;

    @Override
    public void addDigit(Double digit) {
        repository.addDigit(digit);
    }

    @Override
    public void addMathAction(String oper) {
        repository.addMathAction(oper);
    }

    @Override
    public Double getDigit() {
        return repository.getDigit();
    }

    @Override
    public String getMathAction() {
        return repository.getMathAction();
    }

    @Override
    public Calculator calculate(Double digit, String operation) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        operationRepository.save(new Calculator(digit.toString(), operation, user));

        Calculator calc = new Calculator();

        if (getDigit() == null) {
            addDigit(digit);
            addMathAction(operation);
            calc.setDigit(getDigit().toString());
            calc.setOperation(getMathAction());
            return calc;
        }
        //penultimate digit
        Double a = getDigit();
        //last digit
        Double b = digit;
        double result = 0;
        try {
            result = Operation.calc(getMathAction(), a, b);
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
        }
        calc.setDigit(String.valueOf(result));
        addDigit(result);
        history.addResult(result);
        if (operation.equals("=")) {
            addDigit(null);
            return calc;
        }
        calc.setOperation(operation);
        addMathAction(operation);

        return calc;
    }

    @Override
    public Double getResult() {
        return history.getResult();
    }
}
