package com.example.swe311_final_assignment_swe1904867;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME="XiarismsDb.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table USER(email TEXT primary key, password TEXT, status TEXT)");
        sqLiteDatabase.execSQL("create table PLANS(plan_id INTEGER primary key autoincrement, email TEXT, name TEXT, note TEXT, image INT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists USER");
        sqLiteDatabase.execSQL("drop table if exists PLANS");
    }

    public Boolean insertData(String email, String password, String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("status",status);
        long result=db.insert("USER",null,contentValues);
        if(result==1)
            return false;
        else
            return true;
    }

    public Boolean checkUser(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from USER where email = ?",new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from USER where email = ? and password = ?", new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public String getActiveUsername(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select email from USER where status='1'",null);
        if(cursor.moveToFirst()){
            return cursor.getString((cursor.getColumnIndex("email")));
        }
        return "";
    }

    public String getActivePassword(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select password from USER where status='1'",null);
        if(cursor.moveToFirst()){
            return cursor.getString((cursor.getColumnIndex("password")));
        }
        return "";
    }

    public Boolean updateActiveStatus(String email){
        resetAllStatus();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("status","1");
        long result=db.update("USER",contentValues,"email = ?", new String[]{email});
        if(result==1)
            return false;
        else
            return true;
    }

    public Boolean deleteActiveUsernameAccount(){
        String email=getActiveUsername();
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("USER", "email = ?", new String[]{email});
        db.close();
        return true;
    }

    public Boolean resetAllStatus(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("status","0");
        long result=db.update("USER",contentValues,null,null);
        if(result==1)
            return false;
        else
            return true;
    }

    public Boolean changeActiveUserEmail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        long result=db.update("USER",contentValues,"status = '1'", null);
        if(result==1)
            return false;
        else
            return true;
    }

    public Boolean changeActiveUserPassword(String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",password);
        long result=db.update("USER",contentValues,"status = '1'", null);
        if(result==1)
            return false;
        else
            return true;
    }

    public Cursor getPlanData(){
        String email=getActiveUsername();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from PLANS where email = ?",new String[]{email});
        if(cursor.moveToFirst()){
            return cursor;
        }
        return null;
    }

    public Boolean insertPlan(int image, String name, String note){
        String email=getActiveUsername();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("note",note);
        contentValues.put("image",image);
        long result=db.insert("PLANS",null,contentValues);
        if(result==1)
            return false;
        else
            return true;
    }

    public Boolean deletePlan(int planId){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("PLANS", "plan_id = ?", new String[]{Integer.toString(planId)});
        db.close();
        return true;
    }
}
