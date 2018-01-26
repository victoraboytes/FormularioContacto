package com.victoraboytes.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView txtinName, txtinDate, txtinPhone, txtinEmail, txtinContact;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtinName.getText().toString();
                String date = txtinDate.getText().toString();
                String phone = txtinPhone.getText().toString();
                String email = txtinEmail.getText().toString();
                String contactDescription = txtinContact.getText().toString();

                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.btn_edit_action), "true");
                intent.putExtra(getResources().getString(R.string.pname),name);
                intent.putExtra(getResources().getString(R.string.pdate),date);
                intent.putExtra(getResources().getString(R.string.pemail),email);
                intent.putExtra(getResources().getString(R.string.pphone),phone);
                intent.putExtra(getResources().getString(R.string.pcontact_description),contactDescription);
                startActivity(intent);
                finish();
            }
        });

        Bundle parameters = getIntent().getExtras();

        String name = parameters.getString(getResources().getString(R.string.pname));
        String date = parameters.getString(getResources().getString(R.string.pdate));
        String phone = parameters.getString(getResources().getString(R.string.pphone));
        String email = parameters.getString(getResources().getString(R.string.pemail));
        String contact = parameters.getString(getResources().getString(R.string.pcontact_description));

        this.txtinName = (TextView) findViewById(R.id.txtvName);
        this.txtinDate = (TextView) findViewById(R.id.txtvDate);
        this.txtinEmail = (TextView) findViewById(R.id.txtvEmail);
        this.txtinPhone = (TextView) findViewById(R.id.txtvPhone);
        this.txtinContact = (TextView) findViewById(R.id.txtvDescription);

        this.txtinName.setText(name);
        this.txtinDate.setText(date);
        this.txtinEmail.setText(email);
        this.txtinPhone.setText(phone);
        this.txtinContact.setText(contact);
    }
}
