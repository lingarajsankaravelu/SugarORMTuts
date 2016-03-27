package com.hourglass.lingaraj.sugarormtuts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hourglass.lingaraj.sugarormtuts.database.UserTableSugar;

import java.util.List;

/**
 * Created by lingaraj on 3/26/16.
 */
public class UpdateTableData extends AppCompatActivity {

    EditText update_name,update_profession,update_senior,searchNameEditText;
    Button search,update;
    List<UserTableSugar> userTable;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update_layout);
        searchNameEditText = (EditText) findViewById(R.id.name_edittext);
        search = (Button) findViewById(R.id.search);
        update = (Button) findViewById(R.id.update);
        update_name = (EditText) findViewById(R.id.update_name);
        update_profession = (EditText) findViewById(R.id.update_profession);
        update_senior =  (EditText) findViewById(R.id.update_senior);

        /* Here we are searching by name from table, when you enter a name and press search , it will fetch the particular row,
         * and display in editText field, after changing the data you can save it with update code return below.
         */


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchNameEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter a name to search",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   long count = UserTableSugar.count(UserTableSugar.class);
                    if(count>0)
                    {
                        userTable = UserTableSugar.find(UserTableSugar.class,"name=?",searchNameEditText.getText().toString());
                        if(userTable==null)
                        {
                            Toast.makeText(getApplicationContext(),"No matching Record found",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            update_name.setText(userTable.get(0).name);
                            update_profession.setText(userTable.get(0).profession);
                            update_senior.setText(String.valueOf(userTable.get(0).senior));
                        }
                    }
                }

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(update_name.getText().toString().isEmpty() || update_profession.getText().toString().isEmpty() || update_senior.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Any of the three fields should not be empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Code to update User data on Table.
                    UserTableSugar userTableSugar = UserTableSugar.findById(UserTableSugar.class,userTable.get(0).getId());
                    userTableSugar.name =  update_name.getText().toString();
                    userTableSugar.profession = update_profession.getText().toString();
                    boolean value;
                    if(update_senior.getText().toString().equals("true") ||update_senior.getText().toString().equals("false"))
                    {
                        value = Boolean.valueOf(update_senior.getText().toString());
                    }
                    else
                    {
                        value = false;
                    }

                    userTableSugar.senior = value;
                    userTableSugar.save();
                    clearFields();
                    Toast.makeText(getApplicationContext(),"Table Data Updated",Toast.LENGTH_SHORT).show();


                }

            }
        });



    }

    private void clearFields() {
        update_name.setText("");
        update_profession.setText("");
        update_senior.setText("");
    }
}
