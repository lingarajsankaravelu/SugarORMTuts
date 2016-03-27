package com.hourglass.lingaraj.sugarormtuts;

/**
 * Created by lingaraj on 3/26/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hourglass.lingaraj.sugarormtuts.database.UserTableSugar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingaraj on 9/28/15.
 */
public class CustomAdapterListviewDelete extends BaseAdapter {
    private Context tcontext;
    private LayoutInflater inflater;
    public  ViewHolder holder=null;
    private List<UserTableSugar> userTable = new ArrayList<>();

    CustomAdapterListviewDelete(Context context,List<UserTableSugar> values)
    {
         this.tcontext=context;
        this.userTable = values;
        this.inflater=LayoutInflater.from(context);
    }


    public int getCount() {

        return userTable.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.layout_listview_delete,null);
            holder=new ViewHolder();
            holder.name=(TextView) convertView.findViewById(R.id.name_textview);
            holder.profession=(TextView)convertView.findViewById(R.id.profession_textview);
            holder.senior=(TextView)convertView.findViewById(R.id.senior_textview);
            holder.delete = (Button) convertView.findViewById(R.id.delete_record_list);
            convertView.setTag(holder);

        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.name.setText(this.userTable.get(position).name);
        holder.profession.setText(this.userTable.get(position).profession);
        holder.senior.setText(String.valueOf(this.userTable.get(position).senior));
        holder.delete.setTag(position);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Delete button will be available for each row, when pressed it will deleted the particular data from Table,
                 * and also the data in list.
                 */
                int pos = (int) v.getTag();
                Toast.makeText(tcontext,String.valueOf(pos),Toast.LENGTH_LONG).show();
                UserTableSugar userTableSugar = UserTableSugar.findById(UserTableSugar.class,userTable.get(pos).getId());
                userTableSugar.delete();
                userTable.remove(pos);
                notifyDataSetChanged();


            }
        });
        return convertView;
    }
    static  class ViewHolder
    {
        TextView name,profession,senior;
        Button delete;
    }



}
