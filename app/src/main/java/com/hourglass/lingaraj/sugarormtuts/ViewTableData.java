package com.hourglass.lingaraj.sugarormtuts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.hourglass.lingaraj.sugarormtuts.database.UserTableSugar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingaraj on 3/26/16.
 */
public class ViewTableData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        long count = UserTableSugar.count(UserTableSugar.class);
        if(count>0)
        {
               /* Get all records in table and display in listview, where a button available for for deleting.
             *
            * */

            UserTableSugar.listAll(UserTableSugar.class);
            List<UserTableSugar> userTable = UserTableSugar.listAll(UserTableSugar.class);
            CustomAdapterListview madapter = new CustomAdapterListview(getApplicationContext(),userTable);
            listView.setAdapter(madapter);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No Data Available in Table", Toast.LENGTH_LONG);

        }

    }

    }
