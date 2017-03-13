package com.example.dianamilton.h2go;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;

import static com.example.dianamilton.h2go.MainActivity.userList;

/**
 * list view to organize users into a list
 */
public class UserActivityList extends AppCompatActivity {
    ListView listView ;
    @Bind(R.id.btn_edit) Button _editButton;

    /**
     * Sets activity to layout, calls activity_userlist
     * Creates listView for users
     * Creates edit button that directs to accountinfoactivity, where user can edit information
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.userListView);
        Log.d("APP", "about to set adapter");
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_list_item_1, userList.getUser());
        Log.d("APP", "set the adapter");

        // Assign adapter to ListView
        listView.setAdapter(adapter);
        _editButton =(Button) findViewById(R.id.btn_edit);
        Log.d("APP", "about to access editButton");
        Log.d("APP", _editButton.toString());
        _editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AccountInfoActivity.class);
                startActivity(intent);
            }
        });
    }

}