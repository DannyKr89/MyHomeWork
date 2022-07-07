package com.example.myhomework.hw2345.model.ui;

import com.example.myhomework.hw2345.model.model.Calculator;
import com.example.myhomework.hw2345.model.model.Operators;

public class CalculatorPresenter {

    private CalculatorView view;
    private Calculator calculator;
    private double num1;
    private Double num2 = null;
    private Operators selectedOperator;
    private int dotCount = 1;
    private boolean dot = false;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }
    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(double digit) {
        if (!dot) {
            if (num2 == null) {
                num1 = num1 * 10 + digit;
                view.showResult(String.valueOf(num1));
            } else {
                num2 = num2 * 10 + digit;
                view.showResult(String.valueOf(num2));
            }
        } else {
            if (num2 == null) {
                num1 = num1 + digit / (10 * dotCount);
                dotCount *= 10;
                view.showResult(String.valueOf(num1));
            } else {
                num2 = num2 + digit / (10 * dotCount);
                dotCount *= 10;
                view.showResult(String.valueOf(num2));
            }
        }

    }

    public void onOperatorPressed(Operators operator) {
        if (selectedOperator != null) {
            num1 = calculator.perform(num1, num2, selectedOperator);
            view.showResult(String.valueOf(num1));
        }
        num2 = 0.0;
        dotCount = 1;
        dot = false;
        selectedOperator = operator;
    }

    public void onDotPressed() {
        if (!dot) {
            dot = true;
        } else {
            dot = false;
        }
    }

    public void clearAll() {
        num1 = 0.0;
        num2 = null;
        dotCount = 1;
        dot = false;
        selectedOperator = null;
        view.showResult(String.valueOf(num1));
    }

    public void getPercent() {
        if (num2 == null || num2 == 0.0 && num1 != 0) {
            num1 = num1 / 100;
            view.showResult(String.valueOf(num1));
            num2 = 0.0;
        } else if (num2 != null && num1 != 0) {
            if (selectedOperator == Operators.ADD) {
                num1 = calculator.perform(num1, num2, Operators.PRCADD);
                view.showResult(String.valueOf(num1));
                num2 = 0.0;
            } else if (selectedOperator == Operators.SUB) {
                num1 = calculator.perform(num1, num2, Operators.PRCSUB);
                view.showResult(String.valueOf(num1));
                num2 = 0.0;
            } else if (selectedOperator == Operators.MLT) {
                num1 = calculator.perform(num1, num2, Operators.PRCMLT);
                view.showResult(String.valueOf(num1));
                num2 = 0.0;
            } else if (selectedOperator == Operators.DIV) {
                num1 = calculator.perform(num1, num2, Operators.PRCDIV);
                view.showResult(String.valueOf(num1));
                num2 = 0.0;
            }

        }
    }

    public void erase(String text) {
        String str = "";
        if (num2 == null) {
            if (text.length() > 1) {
                for (int i = 0; i < text.length() - 1; i++) {
                    str += text.charAt(i);
                }
                num1 = Double.parseDouble(str);
                view.showResult(str);
            } else {
                num1 = 0.0;
                view.showResult(String.valueOf(num1));
            }
        } else {
            if (text.length() > 1) {
                for (int i = 0; i < text.length() - 1; i++) {
                    str += text.charAt(i);
                }
                num2 = Double.parseDouble(str);
                view.showResult(str);
            } else {
                num2 = 0.0;
                view.showResult(String.valueOf(num2));
            }
        }
    }
}
