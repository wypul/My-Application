package com.example.vipul.myapplication;

/**
 * Created by vipul on 3/4/15.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by vipul on 30/3/15.
 */
public class VipulDatabaseAdapter{
    VipulHelper helper;

    public VipulDatabaseAdapter(Context context)
    {
        helper = new VipulHelper(context);
    }

    public long insertData(String name, String roll_no, String cgpa, String per_12, String per_10, String back){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VipulHelper.NAME,name);
        contentValues.put(VipulHelper.ROLL_NO,roll_no);
        contentValues.put(VipulHelper.CGPA,cgpa);
        contentValues.put(VipulHelper.PERCENTAGE_12,per_12);
        contentValues.put(VipulHelper.PERCENTAGE_10,per_10);
        contentValues.put(VipulHelper.BACK,back);
        long id = db.insert(VipulHelper.TABLE_NAME,null,contentValues);
        return id;
    }

    public void checkdb(){
        SQLiteDatabase db = helper.getWritableDatabase();
        helper.onUpgrade(db, 3, 4);
        //db.execSQL(helper.DROP_TABLE);
        //db.execSQL(helper.CREATE_TABLE);
    }

    public ArrayList getData(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {VipulHelper.UID,VipulHelper.NAME,VipulHelper.ROLL_NO,VipulHelper.CGPA,VipulHelper.PERCENTAGE_12,VipulHelper.PERCENTAGE_10,VipulHelper.BACK};
        Cursor cursor = db.query(VipulHelper.TABLE_NAME,columns,null,null,null,null,null);
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()){
            int cid = cursor.getInt(0);
            arrayList.add(cursor.getString(1));
            arrayList.add(cursor.getString(2));
            arrayList.add(cursor.getString(3));
            arrayList.add(cursor.getString(4));
            arrayList.add(cursor.getString(5));
            arrayList.add(cursor.getString(6));
        }
        return arrayList;
    }

    static class VipulHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "tuplacementdatabase";
        private static final String TABLE_NAME = "tuplacement";
        private static final int DATABASE_VERSION = 3;
        private static final String UID = "_id";
        private static final String NAME = "name";
        private static final String CGPA = "cgpa";
        private static final String ROLL_NO = "roll_no";
        private static final String PERCENTAGE_12 = "per_12";
        private static final String PERCENTAGE_10 = "per_10";
        private static final String BACK = "back";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+ROLL_NO+" VARCHAR(255), "+CGPA+" VARCHAR(255), "+PERCENTAGE_12+" VARCHAR(255), "+PERCENTAGE_10+" VARCHAR(255), "+BACK+" VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME ;
        private Context context;

        public VipulHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context,"Cunstructor called");
        }



        @Override
        public void onCreate(SQLiteDatabase db) {

            try{
                db.execSQL(CREATE_TABLE);
                Message.message(context,"oncreate called");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i2) {
            try {
                db.execSQL(DROP_TABLE);
                Message.message(context,"Table dropped");
                onCreate(db);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

