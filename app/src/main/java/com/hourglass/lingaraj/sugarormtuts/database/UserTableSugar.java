package com.hourglass.lingaraj.sugarormtuts.database;

import com.orm.SugarRecord;

/**
 * Created by lingaraj on 3/26/16.
 */
public class UserTableSugar extends SugarRecord {

    public String name;
    public String profession;
    public boolean senior;

    public UserTableSugar()
    {

    }

   public UserTableSugar(String person_name,String profess,boolean value)
    {
        this.name = person_name;
        this.profession = profess;
        this.senior = value;
    }

}
