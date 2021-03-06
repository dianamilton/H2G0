package com.example.dianamilton.h2go;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.dianamilton.h2go.MainActivity.reportList;

public class ReportActivity extends AppCompatActivity {
    private static final String TAG = "ReportActivity"; //defines activity
    @Bind(R.id.btn_submit) Button _submitButton;
    @Bind(R.id.btn_cancel) Button _cancelButton; //defines logout button
    private Spinner conditionSpinner; //defines condition spinner
    private Spinner typeSpinner; //defines user spinner
    private Report report = new Report();

    private EditText nameField;
    private EditText latField;
    private EditText longField;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reportsRef = database.getReference("Reports");

    /**
     * defines buttons, defines spinner
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_report);
        ButterKnife.bind(this);

        typeSpinner = (Spinner) findViewById(R.id.spinner_type); //assign spinner variable
        List<TypeWaterEnum> list = new ArrayList<TypeWaterEnum>(); //inputs enum as array list
        /**
         * fills spinner with enum by part
         */
        list.add(TypeWaterEnum.Bottled);
        list.add(TypeWaterEnum.Lake);
        list.add(TypeWaterEnum.Stream);
        list.add(TypeWaterEnum.Spring);
        list.add(TypeWaterEnum.Well);
        list.add(TypeWaterEnum.Other);
        ArrayAdapter<TypeWaterEnum> dataAdapter = new ArrayAdapter<TypeWaterEnum>(this, android.R.layout.simple_spinner_item, list); //layout defining spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //layout defining spinner
        typeSpinner.setAdapter(dataAdapter); //set spinner

        conditionSpinner = (Spinner) findViewById(R.id.spinner_condition); //assign spinner variable
        List<ConditionEnum> list2 = new ArrayList<ConditionEnum>(); //inputs enum as array list
        /**
         * fills spinner with enum by part
         */
        list2.add(ConditionEnum.Potable);
        list2.add(ConditionEnum.TreatableClear);
        list2.add(ConditionEnum.TreatableMuddy);
        list2.add(ConditionEnum.Waste);
        ArrayAdapter<ConditionEnum> dataAdapter2 = new ArrayAdapter<ConditionEnum>(this, android.R.layout.simple_spinner_item, list2); //layout defining spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //layout defining spinner
        conditionSpinner.setAdapter(dataAdapter2); //set spinner

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };


        nameField = (EditText) findViewById(R.id.input_location);
        latField = (EditText) findViewById(R.id.input_latitude);
        longField = (EditText) findViewById(R.id.input_longitude);
        conditionSpinner = (Spinner) findViewById(R.id.spinner_condition);
        typeSpinner = (Spinner) findViewById(R.id.spinner_type);

        _submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                report.setName(nameField.getText().toString());
                report.setLat(latField.getText().toString());
                report.setLong(longField.getText().toString());
                report.setCondition(conditionSpinner.getSelectedItem().toString());
                report.setWorkerName(MainActivity.currentUser.getName());
                report.setType(typeSpinner.getSelectedItem().toString());
                report.setId(report.getId() + 1);
                MainActivity.reportList.addReport(report);
                reportsRef.setValue(reportList.reportList);
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

    /**
     *
     * @param menu
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
