package com.example.calculator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    public Map<String, Object> calculate(@RequestParam double num1,
                                         @RequestParam double num2,
                                         @RequestParam String operator) {
        Map<String, Object> response = new HashMap<>();
        double result;

        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    response.put("error", "Cannot divide by zero.");
                    return response;
                }
                result = num1 / num2;
                break;
            default:
                response.put("error", "Invalid operator.");
                return response;
        }

        response.put("result", result);
        return response;
    }
}
