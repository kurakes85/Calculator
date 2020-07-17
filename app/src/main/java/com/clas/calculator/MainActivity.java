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

        Button getButton = findViewById(view.getId());

        switch (view.getId()) {
            case R.id.all_clear_button:
                isFirstInput = true;
                resultNumber = 0;
                operator = '+';
                setClearText("0");
                break;

            case R.id.clear_entry_button:
                setClearText("0");
                break;

            case R.id.back_space_button:
                if (resultText.getText().toString().length() > 1){
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0,getResultText.length() -1);
                    resultText.setText(subString);
                } else{
                    setClearText("0");
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
                resultNumber = intCal(resultNumber,lastNum,operator);

                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d("buttonClick", "add resultNumber = " + resultNumber);

                break;

                //결과를 출력하자!
            case R.id.result_button:

                resultNumber = intCal(resultNumber,Integer.parseInt(resultText.getText().toString()),operator);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d("buttonClick","add resultNumber" + resultNumber);
                break;

            default:
                Log.e("buttonClick", "default" + getButton.getText().toString() + "버튼이 클릭 되었습니다");
                break;
        }
    }

    //예외 처리와 중복되는 코드들을 위해 메소드를 만들어 중복을 방지 합시다!
    public void numButtonClick(View view){
        Button getButton = findViewById(view.getId());

        if (isFirstInput) {
            //숫자의 컬러가 들어가는 부분 12진수로 들어가요
            resultText.setTextColor(0xff000000);
            resultText.setText(getButton.getText().toString());
            isFirstInput = false;
        } else {
            resultText.append(getButton.getText().toString());
        }
    }

    public void setClearText(String clearText){
        isFirstInput = true;
        resultText.setTextColor(0xff666666);
        resultText.setText(clearText);
    }

    public int intCal(int result, int lastNum, char operator){
        if (operator == '+') {
            result += lastNum;
        } else if (operator == '-') {
            result -= lastNum;
        } else if (operator == '/') {
            result /= lastNum;
        } else if (operator == '*') {
            result *= lastNum;
        }

        return result;
    }
}