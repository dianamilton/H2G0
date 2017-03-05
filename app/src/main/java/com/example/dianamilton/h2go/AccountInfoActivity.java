package com.example.dianamilton.h2go;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountInfoActivity extends AppCompatActivity {
    private static final String TAG = "AccountInfoActivity"; //defines activity
    @Bind(R.id.btn_save) Button _saveButton;
    @Bind(R.id.btn_cancel) Button _cancelButton; //defines logout button
    private User user = new User();

    private EditText nameField;
    private EditText emailField;
    private EditText passcodeField;
    private EditText phoneNumberField;
    private EditText addressField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        ButterKnife.bind(this);

        nameField = (EditText) findViewById(R.id.input_name);
        emailField = (EditText) findViewById(R.id.input_email);
        passcodeField = (EditText) findViewById(R.id.input_password);
        phoneNumberField = (EditText) findViewById(R.id.input_phone);
        addressField = (EditText) findViewById(R.id.input_address);

        _saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivityList.class);
                startActivity(intent);
                user.setName(nameField.getText().toString());
                user.setEmail(emailField.getText().toString());
                user.setPasscode(passcodeField.getText().toString());
                user.setAddress(addressField.getText().toString());
                user.setNumber(phoneNumberField.getText().toString());
                MainActivity.userList.addUser(user);

            }
        });


        _cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}