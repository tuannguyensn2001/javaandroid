package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView result;
    Button plus, minus, multiply,divide;
    double ketqua=0;
    EditText  first,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result=(TextView) findViewById(R.id.result);
        plus = (Button) findViewById(R.id.plus);

        first = (EditText) findViewById(R.id.firstvalue);
        second = (EditText) findViewById(R.id.secondvalue);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String validateA = first.getText().toString();
             String validateB= second.getText().toString();
             if (validate(validateA,validateB)){
                 Toast.makeText(MainActivity2.this,"Vui lòng nhập đầy đủ",Toast.LENGTH_LONG).show();
                 return ;
             }

             int x = Integer.parseInt(validateA);
             int y = Integer.parseInt(validateB);

             ketqua = x+y;

             result.setText(ketqua+ "");

            }

        });
        minus = (Button) findViewById(R.id.minus);


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(first.getText().toString());
                int y = Integer.parseInt(second.getText().toString());
                ketqua=x-y+10;
                result.setText(ketqua+"");

            }

        });
        multiply = (Button) findViewById(R.id.multiply);


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(first.getText().toString());
                int y = Integer.parseInt(second.getText().toString());
                ketqua=x*y;
                result.setText(ketqua+"");

            }

        });
        divide = (Button) findViewById(R.id.divide);


        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(first.getText().toString());
                int y = Integer.parseInt(second.getText().toString());
                ketqua=x/y;
                result.setText(ketqua+"");

            }

        });



    }


    public static boolean validate(String x,String y)
    {
        return x.equals("") || y.equals("");
    }

}