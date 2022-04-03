package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Integer first;
    private Integer second;
    private Boolean isOperationClick;
    private String operation;
    private Button btn_go_over;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        btn_go_over = findViewById(R.id.boot);

        btn_go_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String result = tvResult.getText().toString();
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                //нажал на единицу
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("1");
                }else if (isOperationClick){
                    tvResult.setText("1");
                }else {
                    tvResult.append("1");
                }
                isOperationClick = false;
                break;
            case R.id.btn_two:
                //нажал на двойку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("2");
                }else if (isOperationClick){
                    tvResult.setText("2");
                }else {
                    tvResult.append("2");
                }
                isOperationClick = false;
                break;
            case R.id.btn_three:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("3");
                }else if (isOperationClick){
                    tvResult.setText("3");
                }else {
                    tvResult.append("3");
                }
                isOperationClick = false;
                break;
            case R.id.btn_four:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("4");
                }else if (isOperationClick){
                    tvResult.setText("4");
                }else {
                    tvResult.append("4");
                }
                isOperationClick = false;
                break;

            case R.id.btn_five:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("5");
                }else if (isOperationClick){
                    tvResult.setText("5");
                }else {
                    tvResult.append("5");
                }
                isOperationClick = false;
                break;

            case R.id.btn_six:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("6");
                }else if (isOperationClick){
                    tvResult.setText("6");
                }else {
                    tvResult.append("6");
                }
                isOperationClick = false;
                break;

            case R.id.btn_seven:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("7");
                }else if (isOperationClick){
                    tvResult.setText("7");
                }else {
                    tvResult.append("7");
                }
                isOperationClick = false;
                break;

            case R.id.btn_eight:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("8");
                }else if (isOperationClick){
                    tvResult.setText("8");
                }else {
                    tvResult.append("8");
                }
                isOperationClick = false;
                break;

            case R.id.btn_nine:
                //нажал на тройку
                if (tvResult.getText().toString().equals("0")){
                    tvResult.setText("9");
                }else if (isOperationClick){
                    tvResult.setText("9");
                }else {
                    tvResult.append("9");
                }
                isOperationClick = false;
                break;

            case R.id.btn_null:
                if (tvResult.getText().toString().equals("0")){
                tvResult.setText("0");
            }else if (isOperationClick){
                tvResult.setText("0");
            }else {
                tvResult.append("0");
            }
                isOperationClick = false;
                break;

            case R.id.btn_clear:
                tvResult.setText("0");
                first = 0;
                second = 0;
                break;

            case R.id.btn_tochka:
                if (!tvResult.getText().toString().contains(".")){
                    tvResult.append(".");

                }
                break;

            case R.id.btn_minus:
                tvResult.setText("-");
                break;
        }
        btn_go_over.setVisibility(View.INVISIBLE);
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        btn_go_over.setVisibility(View.INVISIBLE);
        switch (view.getId()){
            case R.id.btn_plus:
                //12
                setFirstVar();
                isOperationClick = true;
                operation = "+";
                break;

            case R.id.btn_minus:
                setFirstVar();
                isOperationClick = true;
                operation = "-";
                break;

            case R.id.btn_umnojenie:
                setFirstVar();
                isOperationClick = true;
                operation = "x";
                break;

            case R.id.btn_delenie:
                setFirstVar();
                isOperationClick = true;
                operation = "/";
                break;

            case R.id.btn_plusandminus:
                setFirstVar();
                isOperationClick = true;
                operation = "+/-";
                break;

            case R.id.btn_pros:
                setFirstVar();
                isOperationClick = true;
                operation = "%";
                break;

            case R.id.btn_equal:
                btn_go_over.setVisibility(view.getVisibility());
                setSecond();
                Integer result = Integer.valueOf(0);
                isOperationClick = true;

                switch (operation){
                    case "+":
                        result = first + second;
                        tvResult.setText(result.toString());
                        break;

                    case "-":
                        result = first - second;
                    tvResult.setText(result.toString());
                    break;

                    case "x":
                        result = first * second;
                        tvResult.setText(result.toString());
                        break;

                    case "/":
                        result = first / second;
                        tvResult.setText(result.toString());
                        break;

                    case "+/-":
                        result = first *= - 1;
                        tvResult.setText(result.toString());
                        break;

                    case "%":
                        result = first / 100;
                        tvResult.setText(result.toString());
                        break;
                }
                btn_go_over.setVisibility(view.getVisibility());
                break;
        }
    }


    public void setSecond(){
        second = Integer.parseInt(tvResult.getText().toString());
    }

    public void setFirstVar(){
        first = Integer.parseInt(tvResult.getText().toString());

    }
}