package com.clas.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.clas.calculator.R;

public class MainActivity extends AppCompatActivity {
    //변수 선언
    boolean isFirstInput = true;
    int resultNumber = 0;
    char operator = '+';
    final String CLEAR_INPUT_TEXT = "0";

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

        Log.e("buttonClick", "buttonClick 시작" + getButton.getText().toString() + " 버튼이 클릭 되었습니다");
        Log.d("buttonClick", "defaultNumber = " + resultNumber);

        //스위치문도 한번 만들어 봐요

        switch (view.getId()) {
            case R.id.all_clear_button:
                isFirstInput = true;
                resultNumber = 0;
                operator = '+';
                resultText.setTextColor(0xff666666);
                resultText.setText(CLEAR_INPUT_TEXT);
                break;

            case R.id.clear_entry_button:
                isFirstInput = true;
                resultText.setText(CLEAR_INPUT_TEXT);
                break;

            case R.id.back_space_button:
                if (resultText.getText().toString().length() > 1){
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0,getResultText.length() -1);
                    resultText.setText(subString);
                } else{
                    resultText.setText(CLEAR_INPUT_TEXT);
                    isFirstInput = true;
                }
                break;

                //정수형 계산기 임으로 이건 패스!
            case R.id.decimal_button:
                Log.e("buttonClick", getButton.getText().toString() + " 버튼이 클릭 되었습니다");
                break;


            // 사칙연산 버튼 완료
            case R.id.addition_button:
            case R.id.subtraction_button :
            case R.id.division_button:
            case R.id.multiple_button:

                int lastNum = Integer.parseInt(resultText.getText().toString());
                if (operator == '+') {
                    resultNumber = resultNumber + lastNum;
                } else if (operator == '-') {
                    resultNumber = resultNumber - lastNum;

                } else if (operator == '/') {
                    resultNumber = resultNumber / lastNum;
                } else if (operator == '*') {
                    resultNumber = resultNumber * lastNum;
                }
                //오퍼레이터를 charAt으로 바꾸면서 반복 되는 작업을 줄였다.
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d("buttonClick", "add resultNumber = " + resultNumber);

                break;

                //결과를 출력하자!
            case R.id.result_button:
                if (operator == '+') {
                    resultNumber = resultNumber + Integer.parseInt(resultText.getText().toString());
                } else if (operator == '-') {
                    resultNumber = resultNumber + Integer.parseInt(resultText.getText().toString());
                } else if (operator == '/') {
                    resultNumber = resultNumber + Integer.parseInt(resultText.getText().toString());
                } else if (operator == '*') {
                    resultNumber = resultNumber + Integer.parseInt(resultText.getText().toString());
                }
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d("buttonClick","add resultNumber" + resultNumber);
                break;

            case R.id.num_0_button:
            case R.id.num_1_button:
            case R.id.num_2_button:
            case R.id.num_3_button:
            case R.id.num_4_button:
            case R.id.num_5_button:
            case R.id.num_6_button:
            case R.id.num_7_button:
            case R.id.num_8_button:
            case R.id.num_9_button:

                if (isFirstInput) {
                    //숫자의 컬러가 들어가는 부분 12진수로 들어가요
                    resultText.setTextColor(0xff000000);
                    resultText.setText(getButton.getText().toString());
                    isFirstInput = false;
                } else {
                    resultText.append(getButton.getText().toString());
                }
                break;

            //default 는 case 에서 정의 되지 않는 다른 값이 들어 왔을때 아래의 내용이 실행 되게 한다.
            default:
                //토스트 버튼 만들어서 동작이 안되는 버튼 확인 하기!
                //토스트 버튼은 일반 사용자가 볼수 없도록 하는경우가 많다
                //그래서 LOG 를 사용해서 로그캣 화면에서 볼수 있는 명령어로 바꿔 준다
                //Toast.makeText(getApplicationContext(), getButton.getText().toString() + "버튼이 클릭 되었습니다", Toast.LENGTH_LONG).show();
                Log.e("buttonClick", "default" + getButton.getText().toString() + "버튼이 클릭 되었습니다");
                break;
        }
    }
}