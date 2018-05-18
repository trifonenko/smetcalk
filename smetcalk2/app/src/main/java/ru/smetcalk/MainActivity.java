package ru.smetcalk;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;

    TextView tvResult;
    TextView text_poz;
    TextView text_smr;

    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;

    String oper = "";
    double c1 = 1;
    double c2 = 1;
    double c3 = 1;
    double c4 = 1;
    double c5 = 1;
    double c6 = 0;
    double c7 = 0;
    double c8 = 0;
    double c9 = 1;
    double c10 = 0;
    double c11 = 0;
    double c12 = 1;
    double c13 = 1;
    double c14 = 1;

    double r1 = 0.010;
    double r2 = 0.009;
    double r3 = 0.008;
    double r4 = 0.007;
    double r5 = 0.006;
    double r6 = 0.005;
    double r7 = 0.004;
    double r8 = 0.003;
    double r9 = 0.0025;
    double r10 = 0.0023;
    double r11 = 0.002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // находим элементы
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        tvResult = (TextView) findViewById(R.id.tvResult);
        text_poz = (TextView) findViewById(R.id.text2);
        text_smr = (TextView) findViewById(R.id.text3);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        c13 = 0.5;
                        break;
                    case R.id.radioButton2:
                        c13 = 1;
                        break;
                    case R.id.radioButton3:
                        c13 = 1.5;
                        break;

                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton4:
                        c14 = 1;
                        break;
                    case R.id.radioButton5:
                        c14 = 0.5;
                        break;
                    case R.id.radioButton6:
                        c14 = 0.35;
                        break;
                }
            }
        });


        final Switch aSwitch0 = (Switch) findViewById(R.id.s0); //режим
        aSwitch0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch0.isChecked()) {
                    etNum2.setEnabled(true);
                    etNum2.setCursorVisible(true);
                    etNum2.setText(null);
                    text_smr.setTypeface(Typeface.DEFAULT_BOLD);
                    etNum1.setEnabled(false);
                    etNum1.setCursorVisible(false);
                    etNum1.setText("0");
                    text_poz.setTypeface(Typeface.DEFAULT);
                }
                else {
                    etNum1.setEnabled(true);
                    etNum1.setCursorVisible(true);
                    etNum1.setText(null);
                    text_poz.setTypeface(Typeface.DEFAULT_BOLD);
                    etNum2.setEnabled(false);
                    etNum2.setCursorVisible(false);
                    etNum2.setText("0");
                    text_smr.setTypeface(Typeface.DEFAULT);
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                float num1 = 0;
                float num2 = 0;
                // Проверяем поля на пустоту
                if (TextUtils.isEmpty(etNum1.getText().toString())) {
                    return;
                }
                if (TextUtils.isEmpty(etNum2.getText().toString())) {
                    return;
                }
                // читаем EditText и заполняем переменные числами
                num1 = Float.parseFloat(etNum1.getText().toString());
                num2 = Float.parseFloat(etNum2.getText().toString());
                // формируем строку вывода

                if (num2 == 0) {

                    double result = (30) * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 * num1 + c6 + c7 + c10 + c11 + c8;
                    double newResult = new BigDecimal(Math.max(result, 700)).setScale(0, RoundingMode.UP).doubleValue();
                    tvResult.setText(newResult + " руб.");
                }
                else {
                    if(num2<50000) {
                    double result =  c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8 + 999;
                    double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                    tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<100000){
                    double result = c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8 + 1499;
                    double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                    tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<500000){
                        double result = num2 * r1 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<1000000){
                        double result = num2 * r2 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<1500000){
                        double result = num2 * r3 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<2000000){
                        double result = num2 * r4 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<3000000){
                        double result = num2 * r5 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<5000000){
                        double result = num2 * r6 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<10000000){
                        double result = num2 * r7 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<20000000){
                        double result = num2 * r8 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<30000000){
                        double result = num2 * r9 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<40000000){
                        double result = num2 * r10 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2<50000000){
                        double result = num2 * r11 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                    else if (num2>50000000){
                        double result = num2 * r11 * c1 * c2 * c3 * c4 * c5 * c9 * c13 * c14 + c6 + c7 + c10 + c11 + c8;
                        double newResult = new BigDecimal(result).setScale(0, RoundingMode.UP).doubleValue();
                        tvResult.setText(newResult + " руб.");
                    }
                }
            }

        });




        final Switch aSwitch1 = (Switch) findViewById(R.id.s1); //По ведомости
        aSwitch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch1.isChecked())
                    c1 = 1.35;
                else {
                    c1 = 1;
                }
            }
        });
        final Switch aSwitch2 = (Switch) findViewById(R.id.s2); //Восстановление сметы по смете Заказчика
        aSwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                    if (aSwitch2.isChecked())
                        c2 = 0.5;
                    else {
                        c2 = 1;
                    }
                }
            });
        final Switch aSwitch3 = (Switch) findViewById(R.id.s3); //Редактирование готовой сметы XML
        aSwitch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch3.isChecked())
                    c3 = 0.3;
                else {
                    c3 = 1;
                }
            }
        });
        final Switch aSwitch4 = (Switch) findViewById(R.id.s4); //Редактирование готовой сметы Excel
        aSwitch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch4.isChecked())
                    c4 = 3;
                else {
                    c4 = 1;
                }
            }
        });
        final Switch aSwitch5 = (Switch) findViewById(R.id.s5); //Срочность
        aSwitch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch5.isChecked())
                    c5 = 1.5;
                else {
                    c5 = 1;
                }
            }
        });
        final Switch aSwitch6 = (Switch) findViewById(R.id.s6); //Акты
        aSwitch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch6.isChecked())
                    c6 = 500;
                else {
                    c6 = 0;
                }
            }
        });
        final Switch aSwitch7 = (Switch) findViewById(R.id.s7); //Составление вед
        aSwitch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch7.isChecked())
                    c7 = 1000;
                else {
                    c7 = 0;
                }
            }
        });
        final Switch aSwitch8 = (Switch) findViewById(R.id.s8); //Выезд
        aSwitch8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch8.isChecked())
                    c8 = 1000;
                else {
                    c8 = 0;
                }
            }
        });
        final Switch aSwitch9 = (Switch) findViewById(R.id.s9); //Проверка
        aSwitch9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch9.isChecked())
                    c9 = 0.7;
                else {
                    c9 = 1;
                }
            }
        });
        final Switch aSwitch10 = (Switch) findViewById(R.id.s10); //Исходники
        aSwitch10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch10.isChecked())
                    c10 = 500;
                else {
                    c10 = 0;
                }
            }
        });
        final Switch aSwitch11 = (Switch) findViewById(R.id.s11); //ССР
        aSwitch11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch11.isChecked())
                    c11 = 1000;
                else {
                    c11 = 0;
                }
            }
        });
        final Switch aSwitch12 = (Switch) findViewById(R.id.s12); //ССР
        aSwitch12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch12.isChecked())
                    c12 = 0.3;
                else {
                    c12 = 1;
                }
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}

