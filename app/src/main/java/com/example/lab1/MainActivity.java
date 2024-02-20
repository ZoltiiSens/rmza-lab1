package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView answerTextView;
    EditText num1EditText, num2EditText;
    Button buttonElement;
    RadioGroup radioGroupElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextView = findViewById(R.id.headerText);
        num1EditText = findViewById(R.id.numOne);
        num2EditText = findViewById(R.id.numTwo);
        buttonElement = findViewById(R.id.button);
        radioGroupElement = findViewById(R.id.radioGroup);

        buttonElement.setOnClickListener(v -> {
            // Get numbers from EditTexts
            String num1 = num1EditText.getText().toString();
            String num2 = num2EditText.getText().toString();

            // Check if it is not empty
            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please, enter all numbers!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate chosen operation
            double result;
            final int markedRadioButtonId = radioGroupElement.getCheckedRadioButtonId();
            if (markedRadioButtonId == R.id.radioButtonPlus) {
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
            } else if (markedRadioButtonId == R.id.radioButtonMinus) {
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
            } else if (markedRadioButtonId == R.id.radioButtonMul) {
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
            } else if (markedRadioButtonId == R.id.radioButtonDiv) {
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
            } else {
                Toast.makeText(MainActivity.this, "Please, choose operation!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Show result
            answerTextView.setText(String.valueOf(result));
        });
    }
}