package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void swap(View view){
        EditText txt1 = findViewById(R.id.txt1);
        EditText txt2 = findViewById(R.id.txt2);

        String firstText = txt1.getText().toString();
        String secondText = txt2.getText().toString();

        txt1.setText(secondText);
        txt2.setText(firstText);
    }

    public void check(View view){
        EditText txt1 = findViewById(R.id.txt1);
        EditText txt2 = findViewById(R.id.txt2);

        if(txt1.getText().toString().equals(txt2.getText().toString())){
            result = "SAME";
        }else{
            result = "NOT THE SAME";
        }

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }
}