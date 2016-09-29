package com.app.dbUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.model.FileInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        /**
         * 第二种方法
         */
        /*
        table：表名称
        colums：列名称数组
        selection：条件子句，相当于where
        selectionArgs：条件语句的参数数组
        groupBy：分组
        having：分组条件
        orderBy：排序类
        limit：分页查询的限制
        Cursor：返回值，相当于结果集ResultSet*/

       /* getCount()	总记录条数
        isFirst()	判断是否第一条记录
        isLast()	判断是否最后一条记录
        moveToFirst()	移动到第一条记录
        moveToLast()	移动到最后一条记录
        move(int offset)	移动到指定的记录
        moveToNext()	移动到吓一条记录
        moveToPrevious()	移动到上一条记录
        getColumnIndex(String columnName)	获得指定列索引的int类型值
*/
/*
        Cursor  c = db.query("user",null,null,null,null,null,null);
        if(c.moveToFirst()){
            for (int i = 0 ; i<c.getCount(); i++){
                c.move(i);
                String xx = c.getString(c.getColumnIndex(""));
                *//**
                 * xxxxxxx;
                 *//*
            }
        }*/
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

    public List<FileInfo> queryFile(){
        List<FileInfo> list = new ArrayList<FileInfo>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor  c = db.query("fileInfo",null,null,null,null,null,null);
     /*   if(c.moveToFirst()){
            for (int i = 0 ; i<c.getCount(); i++){
                c.move(i);
                FileInfo file = new FileInfo();
                file.setfileId(c.getString(c.getColumnIndex("fileId")));
                file.setFileName(c.getString(c.getColumnIndex("fileName")));
                file.setUpLoader(c.getString(c.getColumnIndex("upLoader")));
                file.setFileUrl(c.getString(c.getColumnIndex("imageUrl")));
                file.setSize(c.getString(c.getColumnIndex("fileSize")));
                list.add(file);
            }
        }*/
        while (c.moveToNext()){
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                FileInfo file = new FileInfo();
                file.setfileId(c.getString(c.getColumnIndex("fileId")));
                file.setFileName(c.getString(c.getColumnIndex("fileName")));
                file.setUpLoader(c.getString(c.getColumnIndex("upLoader")));
                file.setFileUrl(c.getString(c.getColumnIndex("imageUrl")));
                file.setSize(c.getString(c.getColumnIndex("fileSize")));
                list.add(file);
            }
        }
        return list;
    }

}
