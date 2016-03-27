package com.hourglass.lingaraj.sugarormtuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hourglass.lingaraj.sugarormtuts.database.UserTableSugar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingaraj on 9/28/15.
 */
public class CustomAdapterListview extends BaseAdapter {

    private LayoutInflater inflater;
    public  ViewHolder holder=null;
    private List<UserTableSugar> userTable = new ArrayList<>();

    CustomAdapterListview(Context context,List<UserTableSugar> values)
    {
       // this.tcontext=context;
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
            convertView=inflater.inflate(R.layout.layout_for_listview_show,null);
            holder=new ViewHolder();
            holder.name=(TextView) convertView.findViewById(R.id.name_textview);
            holder.profession=(TextView)convertView.findViewById(R.id.profession_textview);
            holder.senior=(TextView)convertView.findViewById(R.id.senior_textview);

            convertView.setTag(holder);

        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.name.setText(this.userTable.get(position).name);
        holder.profession.setText(this.userTable.get(position).profession);
        holder.senior.setText(String.valueOf(this.userTable.get(position).senior));
        return convertView;
    }
    static  class ViewHolder
    {
        TextView name,profession,senior;
    }


}
