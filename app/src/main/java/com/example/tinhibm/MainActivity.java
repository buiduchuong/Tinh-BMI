package com.example.tinhibm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_tittle, textView_ten, textView_chieuCao, textView_cannag, textView_BMi, textView_chuandoan;
    EditText editText_ten, editText_chieuCao, editText_cannang, editText_BMI, editText_chuandoan;
    Button button_tinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        button_tinh.setOnClickListener(view -> {
            editText_BMI.setText(tinhBMI() + "");
            editText_chuandoan.setText(chuanDoan());
            editText_ten.setText("");
            editText_cannang.setText("");
            editText_chieuCao.setText("");
        });
    }

    private void anhxa() {
        textView_BMi = findViewById(R.id.textView_BMI);
        textView_cannag = findViewById(R.id.textView_CanNang);
        textView_chieuCao = findViewById(R.id.textView_Cao);
        textView_ten = findViewById(R.id.textView_nhapTen);
        textView_chuandoan = findViewById(R.id.textView_chuanDoan);
        textView_tittle = findViewById(R.id.textView_title);
        editText_BMI = findViewById(R.id.edit_BIM);
        editText_cannang = findViewById(R.id.edit_CanNang);
        editText_chieuCao = findViewById(R.id.edit_Cao);
        editText_chuandoan = findViewById(R.id.edit_chuandoan);
        editText_ten = findViewById(R.id.edit_nhapTen);
        button_tinh = findViewById(R.id.button_tinhBMI);
    }

    private double tinhBMI() {
        double chieuCao = Double.parseDouble(editText_chieuCao.getText().toString().trim());
        double canNang = Double.parseDouble(editText_cannang.getText().toString().trim());
        return (canNang) / (chieuCao * chieuCao);
    }

    private String chuanDoan() {
        if (tinhBMI() < 18) {
            return "Người gầy";
        } else if (18 <= tinhBMI() && tinhBMI() <= 24.9) {
            return "Người bình thường";
        } else if (25 <= tinhBMI() && tinhBMI() < 30) {
            return "Người béo phì độ I";
        } else if (30 <= tinhBMI() && tinhBMI() < 35) {
            return "Người béo phì độ II";
        } else {
            return "Người béo phì độ III";
        }
    }
}