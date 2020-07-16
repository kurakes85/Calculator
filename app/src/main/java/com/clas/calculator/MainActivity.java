package com.clas.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.clas.calculator.R;

public class MainActivity extends AppCompatActivity {
    //변수 선언
    boolean isFirstInput = true;
    int resultNumber = 0;
    char operator = '+';

    //결과가 나오는 위젯
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_text);
    }

    public void buttonClick(View view) {
//버튼을 위로 올렸다
        Button getButton = findViewById(view.getId());


        if (view.getId() == R.id.all_clear_button) {
            isFirstInput = true;
            resultNumber = 0;
            operator = '+';
            //숫자의 컬러가 들어가는 부분 12진수로 들어가요
            resultText.setTextColor(0xff666666);
            resultText.setText(String.valueOf(resultNumber));
        }



        if (view.getId() == R.id.num_0_button
                || view.getId() == R.id.num_1_button
                || view.getId() == R.id.num_2_button
                || view.getId() == R.id.num_3_button
                || view.getId() == R.id.num_4_button
                || view.getId() == R.id.num_5_button
                || view.getId() == R.id.num_6_button
                || view.getId() == R.id.num_7_button
                || view.getId() == R.id.num_8_button
                || view.getId() == R.id.num_9_button) {
            if (isFirstInput) {
                resultText.setTextColor(0xff000000);
                resultText.setText(getButton.getText().toString());
                isFirstInput = false;
            } else {
                resultText.append(getButton.getText().toString());
            }
        }
    }

    
}