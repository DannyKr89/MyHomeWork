package com.example.myhomework.hw2345.model.ui;

import static android.os.Build.VERSION_CODES.R;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myhomework.R;

import java.io.Serializable;

public class SettingsActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myhomework.R.layout.activity_settings);

        findViewById(com.example.myhomework.R.id.themeOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("theme", com.example.myhomework.R.style.Theme_MyHomeWork);
                Toast.makeText(SettingsActivity.this, com.example.myhomework.R.string.default_theme, Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK,data);
                finish();
            }
        });
        findViewById(com.example.myhomework.R.id.themeTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("theme", (int) com.example.myhomework.R.style.Theme_MyHomeWork_V2);
                Toast.makeText(SettingsActivity.this, com.example.myhomework.R.string.red_green_theme, Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK,data);
                finish();
            }
        });

        findViewById(com.example.myhomework.R.id.themeThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("theme", (int) com.example.myhomework.R.style.Theme_MyHomeWork_V3);
                Toast.makeText(SettingsActivity.this, com.example.myhomework.R.string.black_white_theme, Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK,data);
                finish();
            }
        });
    }
}