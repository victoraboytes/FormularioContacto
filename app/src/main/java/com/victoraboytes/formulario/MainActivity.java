package com.victoraboytes.formulario;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int day, month, year;
    private EditText txtinName, txtinPhone, txtinEmail, txtinContactDescription,txtinDate;
    String name, date, phone, email, contactDescription;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtinName = (EditText)findViewById(R.id.txtinName);
        txtinPhone = (EditText)findViewById(R.id.txtinPhone);
        txtinEmail = (EditText)findViewById(R.id.txtinEmail);
        txtinContactDescription = (EditText)findViewById(R.id.txtinContactDescription);
        txtinDate = (EditText)findViewById(R.id.txtinDate);
        txtinDate.setOnClickListener(this);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtinName.getText().toString();
                date = txtinDate.getText().toString();
                phone = txtinPhone.getText().toString();
                email = txtinEmail.getText().toString();
                contactDescription = txtinContactDescription.getText().toString();

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra(getResources().getString(R.string.pname),name);
                intent.putExtra(getResources().getString(R.string.pdate),date);
                intent.putExtra(getResources().getString(R.string.pemail),email);
                intent.putExtra(getResources().getString(R.string.pphone),phone);
                intent.putExtra(getResources().getString(R.string.pcontact_description),contactDescription);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.month = c.get(Calendar.MONTH);
        this.year = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtinDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }
                ,this.year, this.month, this.day);
        datePickerDialog.show();
    }
}