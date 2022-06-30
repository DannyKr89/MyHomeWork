package com.example.myhomework.hw2345.model.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myhomework.R;
import com.example.myhomework.hw2345.model.CalculatorImpl;
import com.example.myhomework.hw2345.model.Operators;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    private TextView result;
    private CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = findViewById(R.id.resultView);

        calculatorPresenter = new CalculatorPresenter(this, new CalculatorImpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.btn_0, 0);
        digits.put(R.id.btn_1, 1);
        digits.put(R.id.btn_2, 2);
        digits.put(R.id.btn_3, 3);
        digits.put(R.id.btn_4, 4);
        digits.put(R.id.btn_5, 5);
        digits.put(R.id.btn_6, 6);
        digits.put(R.id.btn_7, 7);
        digits.put(R.id.btn_8, 8);
        digits.put(R.id.btn_9, 9);


        View.OnClickListener digitClickListener = v -> calculatorPresenter.onDigitPressed(digits.get(v.getId()));

        findViewById(R.id.btn_0).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_1).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_2).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_3).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_4).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_5).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_6).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_7).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_8).setOnClickListener(digitClickListener);
        findViewById(R.id.btn_9).setOnClickListener(digitClickListener);

        Map<Integer, Operators> operators = new HashMap<>();
        operators.put(R.id.btn_plus, Operators.ADD);
        operators.put(R.id.btn_minus, Operators.SUB);
        operators.put(R.id.btn_multiplication, Operators.MLT);
        operators.put(R.id.btn_division, Operators.DIV);

        View.OnClickListener operatorClickListener = v -> calculatorPresenter.onOperatorPressed(operators.get(v.getId()));

        findViewById(R.id.btn_plus).setOnClickListener(operatorClickListener);
        findViewById(R.id.btn_minus).setOnClickListener(operatorClickListener);
        findViewById(R.id.btn_multiplication).setOnClickListener(operatorClickListener);
        findViewById(R.id.btn_division).setOnClickListener(operatorClickListener);
        findViewById(R.id.btn_result).setOnClickListener(operatorClickListener);
        findViewById(R.id.btn_dot).setOnClickListener(v -> calculatorPresenter.onDotPressed());
        findViewById(R.id.btn_ac).setOnClickListener(v -> calculatorPresenter.clearAll());
        findViewById(R.id.btn_percent).setOnClickListener(v -> calculatorPresenter.getPercent());
        findViewById(R.id.btn_erase).setOnClickListener(v -> calculatorPresenter.erase(result.getText().toString()));

    }

    @Override
    public void showResult(String string) {
        result.setText(string);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculatorPresenter.setNum1(savedInstanceState.getDouble("save"));
        result.setText(String.valueOf(calculatorPresenter.getNum1()));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putDouble("save", calculatorPresenter.getNum1());
        super.onSaveInstanceState(outState);
    }
}