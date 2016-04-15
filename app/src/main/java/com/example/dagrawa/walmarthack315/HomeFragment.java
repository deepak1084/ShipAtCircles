package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 02-04-2016.
 */

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HomeFragment extends Fragment {
    int count = 0;
    TextView tt ;
    double TotalPrice = 0;
    Set<Integer> posn = new HashSet<Integer>();
    public HomeFragment(){}
    Context con = null;
    Button b;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tt= (TextView)this.getActivity().findViewById(R.id.textView);
        b = (Button)this.getActivity().findViewById(R.id.checkoutbuttoncart);
        con = this.getActivity();
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con,CheckOut.class);
                intent.putExtra("total_price",TotalPrice);
                intent.putExtra("set", (Serializable) posn);
                intent.putExtra("Count",count);


                startActivity(intent);

            }
        });
        final String[] items = {"Apple iPhone 6s (Space Grey" +
                ", 64GB)\n\n$649.00","Harry Potter and the Goblet of Fire\n\n$10.00","RCA Home Theatre System with Bluetooth\n\n$90.00","RCA gaming controller\n\n$49.99","SanDisk Ultra MicroSD 64GB\n\n$30.00","Photron Tripod Stand\n\n$17.00"};
        int[] itemImages = {R.drawable.iphone,R.drawable.book,R.drawable.home_theatre,R.drawable.controller,R.drawable.sdcard,R.drawable.tripod};
        //  ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        ListAdapter myAdapter = new CustomAdapter(this.getActivity(), items, itemImages);
        ListView dinesListView = (ListView) rootView.findViewById(R.id.listView);

        dinesListView.setAdapter(myAdapter);

        dinesListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        String price = item.substring(item.lastIndexOf('$') + 1);
                        TotalPrice = TotalPrice + Double.parseDouble(price);
                        posn.add(position);



                        count++;


                        System.out.println("textView" + tt);

                        if (tt != null) {
                            tt.setText(String.valueOf(TotalPrice));
                        }
//                        Toast.makeText(getContext(), item, Toast.LENGTH_LONG).show();
//                        Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
                    }
                }
        );





        return rootView;
    }


}