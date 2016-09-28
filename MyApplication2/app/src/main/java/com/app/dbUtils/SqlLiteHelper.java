package com.app.dbUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.author;

/**
 * Created by wafer on 2016/9/28.
 */

//url: http://blog.csdn.net/jianghuiquan/article/details/8569252
public class SqlLiteHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "fileDB";
    private final static int DB_VERSION = 1;
    private final static String TABLE_NAME = "fileInfo";
    public SqlLiteHelper(Context context){
       super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME
                + "(id INTEGER PRIMARY KEY,"
                + " fileId VARCHAR(20),"
                + " upLoader VARCHAR(30),"
                + " fileName VARCHAR(30),"
                + " fileSize VARCHAR(20),"
                + " imageUrl VARCHAR(30))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists" +TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public Cursor query(String[] args){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE BookName LIKE ?", args);
        return cursor;
    }

    public long insert(String fileId,String fileName,String upLoader, String fileSize, String imageUrl) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fileId",fileId);
        cv.put("fileName",fileName);
        cv.put("upLoader",upLoader);
        cv.put("fileSize",fileSize);
        cv.put("imageUrl",imageUrl);
        long row = db.insert(TABLE_NAME, null, cv);
        return row;
    }

}
