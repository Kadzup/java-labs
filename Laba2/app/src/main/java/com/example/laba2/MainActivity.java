package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView resultText;
    EditText inputField;
    Button verifyButton;

    boolean finished = false;
    int number = 55;
    String _temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init components
        inputField = (EditText)findViewById(R.id.inputField);
        resultText = (TextView)findViewById(R.id.resultText);
        verifyButton = (Button)findViewById(R.id.verifyBtn);

        inputField.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                _temp = s.toString();

                if(s.length() > 0){
                    verifyButton.setEnabled(true);
                }
                else{
                    verifyButton.setEnabled(false);
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
//                if(count > 0){
//                    verifyButton.setEnabled(true);
//                }
//                else{
//                    verifyButton.setEnabled(false);
//                }
            }
        });

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // generate new number
                if(finished){
                    number = 1 + (int)(Math.random() * 100);

                    verifyButton.setText(R.string.btn);
                    resultText.setText("");
                    inputField.setText("");
                    finished = false;
                    return;
                }

                int input = Integer.parseInt(_temp);

                // error
                if(input < 1 || input > 100){
                    resultText.setText(R.string.error);
                    resultText.setTextColor(Color.RED);
                }
                // bigger
                else if(input > number){
                    resultText.setText(R.string.less);
                    resultText.setTextColor(Color.BLUE);
                }
                // less
                else if(input < number){
                    resultText.setText(R.string.more);
                    resultText.setTextColor(Color.BLUE);
                }
                // correct
                else{
                    resultText.setText(R.string.right);
                    resultText.setTextColor(Color.GREEN);

                    verifyButton.setText(R.string.generate);
                    finished = true;
                }
            }
        });
    }
}