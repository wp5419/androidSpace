package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.model.FileInfo;
import com.example.wafer.myapplication.R;

import org.xutils.x;

import java.util.List;
import java.util.Map;

/**
 * Created by wafer on 2016/9/28.
 */

public class MyAdapter extends BaseAdapter {
    private LayoutInflater inFlater;
    private List<FileInfo> itemList;
    private Context context;
    public MyAdapter(Context context, List<FileInfo> itemList){
        this.context = context;
        this.inFlater = LayoutInflater.from(context);
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inFlater.inflate(R.layout.file,null);
            holder = new ViewHolder();
            holder.fileId = (TextView) convertView.findViewById(R.id.idContent);
            holder.upLoader = (TextView) convertView.findViewById(R.id.uploaderContent);
            holder.fileName = (TextView) convertView.findViewById(R.id.fileNameContent);
            holder.fileSize = (TextView) convertView.findViewById(R.id.sizeContetn);
            holder.image = (ImageView) convertView.findViewById(R.id.imageContent);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fileId.setText(itemList.get(position).getfileId());
        holder.upLoader.setText(itemList.get(position).getUpLoader());
        holder.fileName.setText(itemList.get(position).getFileName());
        holder.fileSize.setText(itemList.get(position).getSize());
        holder.image.setOnClickListener(new ImageListener());
        x.image().bind(holder.image, itemList.get(position).getFileUrl());
        return convertView;
    }


    public  class  ViewHolder{
        public TextView fileId;
        public TextView upLoader;
        public TextView fileSize;
        public TextView fileName;
        public ImageView image;
    }
    public class  ImageListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"图片点击", Toast.LENGTH_LONG).show();
        }
    }
}
