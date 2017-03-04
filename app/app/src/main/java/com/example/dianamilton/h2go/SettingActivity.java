package com.example.dianamilton.h2go;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * page for logout screen after login
 */
public class SettingActivity extends AppCompatActivity {
    private static final String TAG = "SettingActivity"; //defines activity
    @Bind(R.id.btn_accountInfo) Button _accountInfoButton; //defines logout button
    @Bind(R.id.btn_passcode) Button _passcodeButton; //defines logout button
    @Bind(R.id.btn_home) Button _homeButton;
    @Bind(R.id.btn_delete) Button _deleteButton;


    /**
     * creating button for logout
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        /**
         * sets up Logout Button, calls for switch screen to login page
         */
        _accountInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AccountInfoActivity.class);
                startActivity(intent);
            }
        });

        _passcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PasscodeActivity.class);
                startActivity(intent);
            }
        });

        _homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        _deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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