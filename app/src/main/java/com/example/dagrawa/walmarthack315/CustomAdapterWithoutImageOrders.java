package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dagrawa on 4/2/16.
 */
public class CustomAdapterWithoutImageOrders extends BaseAdapter {
    private static LayoutInflater inflater=null;

ArrayList<OrderDetail> creditArrayList=null;

    public CustomAdapterWithoutImageOrders(Activity activity, ArrayList<OrderDetail> arrayList) {
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
        View customView = inflater.inflate(R.layout.orders_custom_row, parent, false);

        TextView textView = (TextView) customView.findViewById(R.id.orderNo);
        TextView textView2 = (TextView) customView.findViewById(R.id.GroupIdRow);
        TextView textView3 = (TextView) customView.findViewById(R.id.statusRow);
        TextView textView4 = (TextView) customView.findViewById(R.id.ShippingCostRow);

        textView.setText(creditArrayList.get(position).getOrderNo());
        textView2.setText(creditArrayList.get(position).getGrpId());
        textView3.setText(creditArrayList.get(position).getStatus());
        textView4.setText(creditArrayList.get(position).getShipDiscount());

        return customView;
    }
}
