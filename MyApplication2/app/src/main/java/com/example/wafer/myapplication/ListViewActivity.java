package com.example.wafer.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.adapter.MyAdapter;
import com.app.model.FileInfo;

import java.util.List;

/**
 * Created by wafer on 2016/9/28.
 */

public class ListViewActivity extends Activity {
    private ListView lv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*-------------------------------------------*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        lv = (ListView) findViewById(R.id.listView);
        List<FileInfo> list = (List<FileInfo>) getIntent().getSerializableExtra("fileList");
        adapter = new MyAdapter(this, list);
        lv.setAdapter(adapter);
    }
}
