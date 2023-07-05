package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String index() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String submit(@RequestParam double firstNumber, double secondNumber,String calculation, Model model) {
        double result = 0;
        switch (calculation){
            case "Addition(+)":
                result = firstNumber+secondNumber;
                break;
            case "Subtraction(-)":
                result = firstNumber-secondNumber;
                break;
            case "Multiplication(X)":
                result = firstNumber*secondNumber;
                break;
            case "Division(/)":
                result = firstNumber/secondNumber;
                break;
        }
        calculation = calculation.substring(0, calculation.length() - 3);
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("result", result);
        model.addAttribute("calculation",calculation);
        return "calculator";
    }
}
