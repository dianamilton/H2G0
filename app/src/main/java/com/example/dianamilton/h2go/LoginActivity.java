package com.example.dianamilton.h2go;

/**
 * Created by dianamilton on 2/19/17.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * login page for user, sends to registration page if nonregistered user, checks user and passcode
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity"; //defines activity
    private static final int REQUEST_SIGNUP = 0; //defines signup request to switch screens

    //defines id as xml variable
    EditText _emailText;
    EditText _passwordText;
    Button _loginButton;
    TextView _signupLink;

    /**
     * Connects page to login layout xml file
     * Defines textboxes with certain inputs
     * Defines loginbutton, send to login() method
     * Signup link takes to signupActivity class for registration
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _emailText = (EditText) findViewById(R.id.input_email);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _loginButton = (Button) findViewById(R.id.btn_login);
        _signupLink = (TextView) findViewById(R.id.link_signup);

        /**
         * sets up Login Button, calls for login method
         */
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        /**
         * sets up Sign Up link, switches page to registration page
         */
        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    /**
     * Makes email and password into variables
     * Sends to mainactivity screen
     */
    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) { //if does not meet email or passcode requirements (for now), login fails
            //in later modules, will be if user and passcode are already in data base
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false); //initialize login button

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating..."); //popup for when login passes
        progressDialog.show();

        //allows user to input email and passcode to sign in
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess(); //if found, call onLoginSuccess method
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    /**
     * Finalizes login, takes to mainactivtiy page
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }


    /**
     * can't go back
     */
    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }


    /**
     * if login is successful, go to mainactivity page for logout button
     */
    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    /**
     * if login fails, show error message
     * Toast - pop up
     */
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    /**
     * checks if signup registration user, passcode is acceptable under requirements
     * @return true if passcode and email follow criteria
     */
    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}