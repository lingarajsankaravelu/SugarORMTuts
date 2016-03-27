package com.hourglass.lingaraj.sugarormtuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* This is the homescreen of the application, contain button to add,delete,update, view table data.
 * When each button was clicked you will be taken to new activity. Where you can perform
 *  regarding operations.
 */

public class Home extends AppCompatActivity {
    private Button add,delete,update, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialDeclarations();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start activity for adding Data to table
                Intent intent = new Intent(getApplicationContext(),AddDataToTable.class);
                startActivity(intent);
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start activity for delete Data from table
                Intent intent = new Intent(getApplicationContext(),DeleteTableData.class);
                startActivity(intent);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start activity for view Data in table
                Intent intent = new Intent(getApplicationContext(),ViewTableData.class);
                startActivity(intent);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start activity for update Data in table
                Intent intent = new Intent(getApplicationContext(),UpdateTableData.class);
                startActivity(intent);

            }
        });

    }

    private void initialDeclarations() {
        add =(Button) findViewById(R.id.add_data);
        delete =(Button) findViewById(R.id.delete_record);
        update =(Button) findViewById(R.id.update_record);
        view = (Button) findViewById(R.id.view_data);


    }
}
