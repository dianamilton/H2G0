package com.example.dianamilton.h2go;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * page to redirect to settings, logout, report, list, map
 */
public class MainActivity extends AppCompatActivity {
    public static ReportList reportList = new ReportList();
    public static UserList userList = new UserList();
    public User currentUser = userList.getUser()[0];

    private static final String TAG = "LogoutActivity"; //defines activity
    @Bind(R.id.btn_logout) Button _logoutButton; //defines logout button
    @Bind(R.id.btn_report) Button _reportButton; //defines logout button
    @Bind(R.id.btn_settings) Button _settingsButton;
    @Bind(R.id.btn_list) Button _listButton;
    @Bind(R.id.btn_watermap) Button _waterMapButton;
    @Bind(R.id.btn_qualityReport) Button _qualityReport;


    /**
     * Connects activity page to mainactivity layout xml
     * Logout Button sends to the login page
     * Report Button on click sends to report activity, to submit water report
     * Quality Report Button sends to quality report activity IF user is worker or manager
     * Settings Button sends to settings activity page
     * List Button sends to list activity, list of reports
     * WaterMap button sends to map activity with pins for submitted water reports
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        ButterKnife.bind(this);
        /**
         * sets up Logout Button, calls for switch screen to login page
         */
        _logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        _reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intent);
            }
        });

        _qualityReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser.getType().equals("Worker") || currentUser.getType().equals("Manager")) {
                    Intent intent = new Intent(getApplicationContext(), QualityReportActivity.class);
                    startActivity(intent);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "User is not a Worker or Manager.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        _settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        _listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        _waterMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WaterMapsActivity.class);
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