package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/4/16.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShippingCart extends Activity
         {
    Button button;
    ListView listView;
    ArrayAdapter<String> adapter;
    Activity con =null;
    String str = null;
    Double totalPrice = 0.0;
Integer shipCost = 0;
             Integer waitTime = 0;
             /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean flag = getIntent().getExtras().getBoolean("ShippingMethod");
         totalPrice = getIntent().getExtras().getDouble("TotalPrice");

        con = this;

        setContentView(R.layout.contentshippinglayout);

        findViewsById();

        setJsonValueInterface s = new setJsonValueInterface() {
            @Override
            public void SetJSONObject(JSONArray j) {
                ArrayList<String> sports = new ArrayList<>();
                for (int i = 0; i < j.length(); i++) {
                    try {
                        sports.add(j.getJSONObject(i).getString("group_id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter = new ArrayAdapter<String>(con,
                        android.R.layout.simple_list_item_multiple_choice, sports);
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                listView.setAdapter(adapter);

            }
        };

        if(flag == true) {
            str = "standard";
            shipCost = 5;
            waitTime = 1;
        }else {
            str = "expedite";
            shipCost = 15;
            waitTime = 5;
        }
        new ShippingCartGroupFetch(s,str).execute();
//        button.setOnClickListener(this);
        Button but = (Button) findViewById(R.id.submitToPersonal);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(con,"Thank you for placing the order",Toast.LENGTH_LONG).show();
            }
        });
        Button subComm = (Button) findViewById(R.id.submitToCommunity);
        subComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(con,"Thank you for placing the order",Toast.LENGTH_LONG).show();
                SparseBooleanArray checked = listView.getCheckedItemPositions();
                ArrayList<String> selectedItems = new ArrayList<String>();
                for (int i = 0; i < checked.size(); i++) {
                    // Item position in adapter
                    int position = checked.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(i))
                        selectedItems.add(adapter.getItem(position));
                }

                String[] outputStrArr = new String[selectedItems.size()];

                for (int i = 0; i < selectedItems.size(); i++) {
                    outputStrArr[i] = selectedItems.get(i);
                }
                String outputArrayAsString = "";
                for(int i=0;i<outputStrArr.length;i++) {
                    Log.i("Deepak", outputStrArr[i]);
                    outputArrayAsString +=outputStrArr[i]+",";
                }
                JSONObject j = new JSONObject();
                try {
                    j.put("user_id","dagrawa");
                    j.put("status","InProcess");
                    j.put("zip_code","560034");
                    j.put("group_id","grp1");
                    j.put("subc_groups",outputArrayAsString.substring(0,outputArrayAsString.length()-1));
                    j.put("shipping_method",str);
                    j.put("ship_cost",shipCost);
                    j.put("ship_discount",0);
                    j.put("total_amount",totalPrice);
                    j.put("wait_time",waitTime);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

        new ShippingCartGroupPost().execute(j);

            }
        });
    }

    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);

    }


}