package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dinesh on 4/2/2016.
 */
class CustomAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Activity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return result[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        TextView dineshText = (TextView) customView.findViewById(R.id.listTextView);
        ImageView dineshImage = (ImageView) customView.findViewById(R.id.listImageView);
        ImageView cartImage = (ImageView) customView.findViewById(R.id.cartView);

        dineshText.setText(result[position]);
        dineshImage.setImageResource(imageId[position]);
        cartImage.setImageResource(R.drawable.cart);

        return customView;
    }
}
