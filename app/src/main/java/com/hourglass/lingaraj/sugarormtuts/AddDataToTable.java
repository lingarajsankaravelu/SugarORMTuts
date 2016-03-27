package com.hourglass.lingaraj.sugarormtuts;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hourglass.lingaraj.sugarormtuts.database.UserTableSugar;

/**
 * Created by lingaraj on 3/26/16.
 */
public class AddDataToTable extends AppCompatActivity {
    private Button submit,clear;
    private EditText name,profession,senior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        initialDeclaration();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* If submit button is pressed, this listener will be triggered, and get Text from each fields and right it to database.
                 *
                 */
                String temp_name = name.getText().toString();
                String temp_profession = profession.getText().toString();
                String temp_senior = senior.getText().toString();
                boolean value;
                if (temp_senior.equals("true")) {
                    value = true;
                } else if (temp_senior.equals("false")) {
                    value = false;
                } else {
                    value = false;
                }
                //Passing data to Table using Constructor which we have Created  inside UserTableSugar.java
                UserTableSugar userTable = new UserTableSugar(temp_name, temp_profession, value);
                userTable.save();
                //calling save will write the data in UserTableSugar.java variable to SQLite Table
                clearAllFields();
                Toast.makeText(getApplicationContext(), "Data added to Table", Toast.LENGTH_SHORT).show();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllFields();
            }
        });

    }

    private void clearAllFields() {

        name.setText("");
        profession.setText("");
        senior.setText("");
    }

    private void initialDeclaration() {
        name = (EditText) findViewById(R.id.name_edittext);
        profession = (EditText) findViewById(R.id.professsion_editText);
        senior = (EditText) findViewById(R.id.senior_editText);
        submit =(Button) findViewById(R.id.submit);
        clear = (Button) findViewById(R.id.clear);


    }
}
