package palletechnology.com.jobportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Admin on 04-02-2017.
 */

public class MyDatabase {
    SQLiteDatabase sqLiteDatabase;
    MyHelper myHelper;

    public MyDatabase(Context c) {
        myHelper = new MyHelper(c,"jobportal.db",null,1);
    }
    public void open(){
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    public  void insertJobSeeker(String email , String password)
    {
        ContentValues cv = new ContentValues();
        cv.put("jmail",email);
        cv.put("jpass",password);
        sqLiteDatabase.insert("jobseeker",null,cv);//jobseeker is table name
    }
    public void insertJobs(String jdate,String jname,String jcity,String jexp,String jtype,String jtech,String jdesc ){
        ContentValues cv = new ContentValues();
        cv.put("jdate",jdate);
        cv.put("jname",jname);
        cv.put("jcity",jcity);
        cv.put("jexp",jexp);
        cv.put("jtype",jtype);
        cv.put("jtech",jtech);
        cv.put("jdesc",jdesc);
        sqLiteDatabase.insert("jobs",null,cv);
    }
    public void insertmyJobs(String jdate,String jname,String jcity,String jexp,String jtype,String jtech,String jdesc ){
        ContentValues cv = new ContentValues();
        cv.put("jdate",jdate);
        cv.put("jname",jname);
        cv.put("jcity",jcity);
        cv.put("jexp",jexp);
        cv.put("jtype",jtype);
        cv.put("jtech",jtech);
        cv.put("jdesc",jdesc);
        sqLiteDatabase.insert("myjobs",null,cv);
    }

    public Cursor queryjobseeker(){
        Cursor c = null;
        c = sqLiteDatabase.query("jobseeker",null,null,null,null,null,null);
        return c;

    }
    public Cursor queryjobs(String city,String tech)
    {
      //  Toast.makeText(MyDatabase.this, city  +" "+ tech, Toast.LENGTH_SHORT).show();
        Cursor c = null;
        c = sqLiteDatabase.query("jobs",null,"jcity=? AND jtech=?" ,new String[]{city,tech},null,null, "_id"+" DESC",null);
        return c;
    }
    public Cursor queryjobs(String city,String tech,String type)
    {
        //  Toast.makeText(MyDatabase.this, city  +" "+ tech, Toast.LENGTH_SHORT).show();
        Cursor c = null;
        c = sqLiteDatabase.query("jobs",null,"jcity=? AND jtech=? AND jtype=?" ,new String[]{city,tech,type},null,null, "_id"+" DESC",null);
        return c;
    }
    public Cursor querymyjobs()
    {
      Cursor c = null;
        c = sqLiteDatabase.query("myjobs",null,null,null,null,null,null,null);
        return c;
    }

    public  void  close()
    {
        sqLiteDatabase.close();
    }

    public class MyHelper extends SQLiteOpenHelper
{

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table jobseeker(_id integer primary key,jmail text,jpass text);");
        db.execSQL("Create table jobs(_id integer primary key ,jdate text,jname text,jcity text,jexp text,jtype text,jtech text,jdesc text);");
        db.execSQL("Create table myjobs(_id integer primary key ,jdate text,jname text,jcity text,jexp text,jtype text,jtech text,jdesc text);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
}
