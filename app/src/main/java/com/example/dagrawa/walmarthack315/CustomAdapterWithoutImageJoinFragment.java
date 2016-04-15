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
public class CustomAdapterWithoutImageJoinFragment extends BaseAdapter {
    private static LayoutInflater inflater=null;

ArrayList<GroupDetail> creditArrayList=null;

    public CustomAdapterWithoutImageJoinFragment(Activity activity, ArrayList<GroupDetail> arrayList) {
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
        View customView = inflater.inflate(R.layout.joingroup_row, parent, false);

        TextView textView = (TextView) customView.findViewById(R.id.groupIdJoin);
        TextView textView2 = (TextView) customView.findViewById(R.id.groupAddress);

        textView.setText(creditArrayList.get(position).getGrp());
        textView2.setText(creditArrayList.get(position).getAddresses());

        return customView;
    }
}
