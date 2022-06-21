package com.example.myhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button switchActivity1 = findViewById(R.id.switch_to_input);
        Button switchActivity2 = findViewById(R.id.switch_to_ems);

        switchActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputTypeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        switchActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}