package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dagrawa on 4/2/16.
 */
public class CustomAdapterWithoutImage extends BaseAdapter {
    private static LayoutInflater inflater=null;

ArrayList<CreditClass> creditArrayList=null;

    public CustomAdapterWithoutImage(Activity activity,ArrayList<CreditClass> arrayList) {
creditArrayList = arrayList;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return creditArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return creditArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = inflater.inflate(R.layout.custom_row_credits, parent, false);

        TextView textView = (TextView) customView.findViewById(R.id.creditsListTextView);
        TextView textView2 = (TextView) customView.findViewById(R.id.credits);

        textView.setText(creditArrayList.get(position).getOrderName());
        textView2.setText("+"+creditArrayList.get(position).getRefund()+"$");

        return customView;
    }
}
