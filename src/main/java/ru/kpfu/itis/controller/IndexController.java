package ru.kpfu.itis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.util.CalculatorFormValidator;

import javax.validation.Valid;

@Controller
public class IndexController {

    private static final Logger log = LogManager.getLogger(IndexController.class);

    @Autowired
    CalculatorService service;

    CalculatorFormValidator validator = new CalculatorFormValidator();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        System.out.println("HISTORY: " + service.getResult());
        service.addDigit(null);
        Calculator calc = new Calculator();
        model.addAttribute("calc", calc);
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String operate(@Valid @ModelAttribute("calc") Calculator calc,
                          BindingResult result,
                          @RequestParam("operation") String operation,
                          Model model) {
        /*validator.validate(calc, result);
        validator.validateByZero(service, calc, result);*/
        if (result.hasErrors()) {
            calc.setDigit("");
            calc.setOperation("");
            return "calc";
        }
        /*if (service.getDigit() == null) {
            service.addDigit(Double.valueOf(calc.getDigit()));
            service.addMathAction(operation);
            calc.setDigit(service.getDigit().toString());
            calc.setOperation(service.getMathAction());
            return "calc";
        }*/
        // отображение последнего мат.действия
        model.addAttribute("calc", service.calculate(Double.valueOf(calc.getDigit()), operation));
        return "calc";
    }
}
