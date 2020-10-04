package com.shrimali.eduapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoryMapsAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MemoryMaps> MemoryList;

    public MemoryMapsAdapter(Context context, int layout, ArrayList<MemoryMaps> memoryList) {
        this.context = context;
        this.layout = layout;
        MemoryList = memoryList;
    }

    @Override
    public int getCount() {
        return MemoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return MemoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{

        ImageView imageView;
        TextView txtName, txtMention;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row ==  null) {

//            LayoutInflater inflater = (LayoutInflater) context.getSystemServiceName(Context.LAYOUT_INFLATER_SERVICE);
//            row = inflater.inflate(layout, null);
//            //chek ids
            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtMention = (TextView) row.findViewById(R.id.txtMention);
            holder.imageView = (ImageView) row.findViewById(R.id.imageMemo);
            row.setTag(holder);
        }
        else{

            holder = (ViewHolder) row.getTag();
        }
        MemoryMaps memoryMaps = MemoryList.get(position);

        holder.txtName.setText(memoryMaps.getName());
        holder.txtMention.setText(memoryMaps.getMention());

////      byte[] memoimage =  MemoryMaps.getImage();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(memoimage, 0 , memoimage.length);
//        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
