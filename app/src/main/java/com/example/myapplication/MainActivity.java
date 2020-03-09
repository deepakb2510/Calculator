package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAdd,btnSubtract,btnDivide,btnMultiply,btnEqual,btnClear,btnBracket,btnDot,btnPercent;
    TextView tvInput,tvOutput;
    String process;
    boolean checkBracket=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnAdd=findViewById(R.id.btnAdd);
        btnSubtract=findViewById(R.id.btnSubtract);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivide);
        btnPercent=findViewById(R.id.btnPercent);

        btnClear=findViewById(R.id.btnClear);
        btnBracket=findViewById(R.id.btnBracket);
        btnDot=findViewById(R.id.btnDot);
        btnEqual=findViewById(R.id.btnEqual);

        tvInput=findViewById(R.id.tvInput);
        tvOutput=findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"+");
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"-");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"/");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"×");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+".");
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvInput.getText().toString();
                tvInput.setText(process+"%");
            }
        });
        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(checkBracket){
                process=tvInput.getText().toString();
                tvInput.setText(process+")");
                checkBracket=false;
            }else{
                process=tvInput.getText().toString();
                tvInput.setText(process+"(");
                checkBracket=true;
            }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            process=tvInput.getText().toString();
            process=process.replaceAll("×","*");
            process=process.replaceAll("%","/100");
            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            String finalresult="";
            try {
                Scriptable scriptable=rhino.initStandardObjects();
                finalresult=rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
            }catch (Exception e) {
                finalresult = "0";
            }
                tvOutput.setText(finalresult);
            }

        });


    }
}
