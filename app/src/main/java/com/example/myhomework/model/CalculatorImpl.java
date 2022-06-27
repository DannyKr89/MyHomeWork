package com.example.myhomework.model;

public class CalculatorImpl implements Calculator {
    @Override
    public double perform(double num1, Double num2, Operators operators) {
        switch (operators) {
            case ADD:
                return num1 + num2;
            case DIV:
                return num1 / num2;
            case MLT:
                return num1 * num2;
            case SUB:
                return num1 - num2;
            case PRC:
                if (num2 == null && num1 != 0) {
                    return num1 / 100;
                } else if (num2 != null && num1 != 0) {
                    return num1 + (num1 / 100 * num2);
                }
        }
        return 0;
    }

}
