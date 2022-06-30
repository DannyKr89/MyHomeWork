package com.example.myhomework.model;

public class CalculatorImpl implements Calculator {
    @Override
    public double perform(double num1, Double num2, Operators operator) {
        switch (operator) {
            case ADD:
                return num1 + num2;
            case DIV:
                return num1 / num2;
            case MLT:
                return num1 * num2;
            case SUB:
                return num1 - num2;
            case PRCADD:
                return num1 + (num1 / 100 * num2);
            case PRCSUB:
                return num1 - (num1 / 100 * num2);
            case PRCMLT:
                return num1 * (num1 / 100 * num2);
            case PRCDIV:
                return num1 / (num1 / 100 * num2);
        }
        return 0;
    }

}
