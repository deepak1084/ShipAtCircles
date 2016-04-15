package com.example.dagrawa.walmarthack315;

/**
 * Created by hp on 02-04-2016.
 */


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CreateGroupFragment extends Fragment {

    public CreateGroupFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_create_group, container, false);

        final EditText groupName = (EditText) rootView.findViewById(R.id.GroupName);
        final EditText groupId = (EditText) rootView.findViewById(R.id.GroupId);
        final EditText address = (EditText) rootView.findViewById(R.id.Address);
        final EditText zipCode = (EditText) rootView.findViewById(R.id.ZipCode);
        final EditText city = (EditText) rootView.findViewById(R.id.CityName);
        final EditText stateName = (EditText) rootView.findViewById(R.id.StateName);
        final EditText countryName = (EditText) rootView.findViewById(R.id.CountryName);

        final Button button = (Button) rootView.findViewById(R.id.CreateGroupButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject j = new JSONObject();
                try {
                    j.put("zip_code",zipCode.getText());
                    j.put("country",countryName.getText());
                    j.put("state",stateName.getText());
                    j.put("state",stateName.getText());
                    j.put("city", city.getText());
                    j.put("addressline1", address.getText());
                    j.put("group_id",groupId.getText());
                    j.put("user_id","dagrawa");
                    j.put("last_name",groupName.getText());
                    j.put("first_name","DEEPAK");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
//System.out.print(j.toString());
                Toast.makeText(v.getContext(),"Group is created.", Toast.LENGTH_SHORT).show();
                new CreateGroupAsyncCall().execute(j);
            }
        });


        return rootView;
    }
}
