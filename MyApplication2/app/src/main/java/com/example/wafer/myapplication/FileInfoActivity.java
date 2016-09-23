package com.example.wafer.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.model.FileInfo;

import org.xutils.x;

/**
 * Created by wafer on 2016/9/23.
 */

public class FileInfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file);
        x.Ext.init(getApplication());
        FileInfo file = (FileInfo) getIntent().getSerializableExtra("fileInfo");
        TextView id = (TextView) findViewById(R.id.idContent);
        TextView fileName = (TextView) findViewById(R.id.fileNameContent);
        TextView uploader = (TextView) findViewById(R.id.uploaderContent);
        TextView size = (TextView) findViewById(R.id.sizeContetn);
        ImageView image = (ImageView) findViewById(R.id.imageContent);
        id.setText(file.getId());
        fileName.setText(file.getFileName());
        uploader.setText(file.getUpLoader());
        size.setText(file.getSize());
        x.image().bind(image, file.getFileUrl());
     }
}
