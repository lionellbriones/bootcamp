package com.example.nonel.bootcamp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity implements View.OnClickListener{
    String old_result = "0";
    String result = "0";
    String operator = "";

    TextView tv_result;
    TextView tv_operator;

    //Numbers
    Button btn_num0;
    Button btn_num1;
    Button btn_num2;
    Button btn_num3;
    Button btn_num4;
    Button btn_num5;
    Button btn_num6;
    Button btn_num7;
    Button btn_num8;
    Button btn_num9;
    Button btn_num_dot;

    //Operators
    Button btn_operator_divide;
    Button btn_operator_multiply;
    Button btn_operator_subtract;
    Button btn_operator_add;
    Button btn_operator_modulo;
    Button btn_operator_equals;
    Button btn_operator_clear;

    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Dialog Box");

        alertDialogBuilder.setMessage("Click yes to exit.")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CalculatorActivity.this.finish();
                    }
                }).setPositiveButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_operator = (TextView) findViewById(R.id.tv_operator);

        //Numbers
        btn_num0 = (Button) findViewById(R.id.btn_num0);
        btn_num1 = (Button) findViewById(R.id.btn_num1);
        btn_num2 = (Button) findViewById(R.id.btn_num2);
        btn_num3 = (Button) findViewById(R.id.btn_num3);
        btn_num4 = (Button) findViewById(R.id.btn_num4);
        btn_num5 = (Button) findViewById(R.id.btn_num5);
        btn_num6 = (Button) findViewById(R.id.btn_num6);
        btn_num7 = (Button) findViewById(R.id.btn_num7);
        btn_num8 = (Button) findViewById(R.id.btn_num8);
        btn_num9 = (Button) findViewById(R.id.btn_num9);
        btn_num_dot = (Button) findViewById(R.id.btn_num_dot);

        btn_num0.setOnClickListener(this);
        btn_num1.setOnClickListener(this);
        btn_num2.setOnClickListener(this);
        btn_num3.setOnClickListener(this);
        btn_num4.setOnClickListener(this);
        btn_num5.setOnClickListener(this);
        btn_num6.setOnClickListener(this);
        btn_num7.setOnClickListener(this);
        btn_num8.setOnClickListener(this);
        btn_num9.setOnClickListener(this);
        btn_num_dot.setOnClickListener(this);

        //Operators
        btn_operator_multiply = (Button) findViewById(R.id.btn_operator_multiply);
        btn_operator_divide = (Button) findViewById(R.id.btn_operator_divide);
        btn_operator_add = (Button) findViewById(R.id.btn_operator_add);
        btn_operator_subtract = (Button) findViewById(R.id.btn_operator_subtract);
        btn_operator_modulo = (Button) findViewById(R.id.btn_operator_modulo);
        btn_operator_equals = (Button) findViewById(R.id.btn_operator_equals);
        btn_operator_clear = (Button) findViewById(R.id.btn_operator_clear);

        btn_operator_multiply.setOnClickListener(this);
        btn_operator_divide.setOnClickListener(this);
        btn_operator_add.setOnClickListener(this);
        btn_operator_subtract.setOnClickListener(this);
        btn_operator_modulo.setOnClickListener(this);
        btn_operator_equals.setOnClickListener(this);
        btn_operator_clear.setOnClickListener(this);
    }

    public void dialogError(String title){
        alertDialogBuilder.setTitle(title);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void compute(){
        Float newResult = 0f;
        Boolean divisionByZeroError = false;
        if(operator == "+"){
            newResult = Float.parseFloat(old_result) + Float.parseFloat(result);
        }else if(operator == "-"){
            newResult = Float.parseFloat(old_result) - Float.parseFloat(result);
        }else if(operator == "x"){
            newResult = Float.parseFloat(old_result) * Float.parseFloat(result);
        }else if(operator == "/"){
            if(result.equals("0")){
                divisionByZeroError = true;
                newResult = 0f;
            }else{
                newResult = Float.parseFloat(old_result) / Float.parseFloat(result);
            }
        }else if(operator == "%"){
            if(result.equals("0")){
                divisionByZeroError = true;
                newResult = 0f;
            }else{
                newResult = Float.parseFloat(old_result) % Float.parseFloat(result);
            }
        }

        if(divisionByZeroError){
            dialogError("Division by zero error.");
            tv_result.setText("Error");
        }else{
            if(newResult % 1 == 0){
                result = Integer.toString(Math.round(newResult));
            }else{
                result = Float.toString(newResult);
            }
            tv_result.setText(result);
        }

    }


    private void addToResult(String newResult){
        if(newResult == "."){
            if(!result.contains(".")){
                result += newResult;
            }
        }else if(newResult == "0"){
            if(result != "0"){
                result += newResult;
            }
        }else{
            if(result == "0"){
                result = newResult;
            }else{
                result += newResult;
            }
        }

        tv_result.setText(result);
    }

    private void triggerOperator(String newOperator){
        if(operator != ""){
            compute();
        }

        old_result = result;

        operator = newOperator;
        tv_operator.setText(operator);
        result = "0";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_num0:
                addToResult(btn_num0.getText() + "");
                break;
            case R.id.btn_num1:
                addToResult(btn_num1.getText() + "");
                break;
            case R.id.btn_num2:
                addToResult(btn_num2.getText() + "");
                break;
            case R.id.btn_num3:
                addToResult(btn_num3.getText() + "");
                break;
            case R.id.btn_num4:
                addToResult(btn_num4.getText() + "");
                break;
            case R.id.btn_num5:
                addToResult(btn_num5.getText() + "");
                break;
            case R.id.btn_num6:
                addToResult(btn_num6.getText() + "");
                break;
            case R.id.btn_num7:
                addToResult(btn_num7.getText() + "");
                break;
            case R.id.btn_num8:
                addToResult(btn_num8.getText() + "");
                break;
            case R.id.btn_num9:
                addToResult(btn_num9.getText() + "");
                break;
            case R.id.btn_num_dot:
                addToResult(btn_num_dot.getText() + "");
                break;
            case R.id.btn_operator_multiply:
                triggerOperator("x");
                break;
            case R.id.btn_operator_divide:
                triggerOperator("/");
                break;
            case R.id.btn_operator_add:
                triggerOperator("+");
                break;
            case R.id.btn_operator_subtract:
                triggerOperator("-");
                break;
            case R.id.btn_operator_modulo:
                triggerOperator("%");
                break;
            case R.id.btn_operator_equals:
                compute();
                result = "0";
                old_result = "0";
                operator = "";
                tv_operator.setText("");
                break;
            case R.id.btn_operator_clear:
                operator = "";
                old_result = "0";
                result = "0";
                tv_result.setText(result);
                tv_operator.setText(operator);
        }
    }
}
