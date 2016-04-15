package com.example.dagrawa.walmarthack315;

/**
 * Created by hp on 02-04-2016.
 */


        import android.annotation.TargetApi;
        import android.app.Activity;
        import android.app.Fragment;
        import android.os.Build;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class JoinGroupFragment extends Fragment{
    View root;
    Activity context;
    public JoinGroupFragment(){}
    EditText et = null;
    Button subs = null;
    String groupsToSend= "";
    String addressToSend = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.joingroup, container, false);
        root = rootView;
        context = this.getActivity();
        subs = (Button)rootView.findViewById(R.id.subscribebutton);

        subs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("deepak",groupsToSend+"Deepak"+addressToSend);
                JSONObject j = new JSONObject();
                try {
                    j.put("user_id","dagrawa");
                    j.put("groups",groupsToSend.substring(0,groupsToSend.length()-1));
                    j.put("addresses",addressToSend.substring(0, addressToSend.length() - 1));
                    j.put("zip_code","123456");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new JoiningGroupSubscribe().execute(j);
            }
        });

        Button b = (Button)rootView.findViewById(R.id.SeachPerZipCode);
         et = (EditText) rootView.findViewById(R.id.ZipCodeSearchText);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subs.setVisibility(View.VISIBLE);
                final ArrayList<GroupDetail> arrayList = new ArrayList<>();
                setJsonValueInterface s = new setJsonValueInterface() {
                    @Override
                    public void SetJSONObject(JSONArray j) {
                        Log.i("Deepak in Join Grp fragment", j.toString());
                        for (int i = 0; i < j.length(); i++) {
                            try {
                                JSONObject ob = j.getJSONObject(i);
                                String adr[]= ob.getString("addresses").split(",");
                                String grpId[] = ob.getString("groups").split(",");
                                for(int in=0;in<adr.length;in++) {
                                    arrayList.add(new GroupDetail(adr[in],et.getText().toString(),grpId[in]));
                                }
                                ListAdapter myAdapter = new CustomAdapterWithoutImageJoinFragment(context, arrayList);
                                ListView listView = (ListView) root.findViewById(R.id.groupsSubscribed);

                                listView.setAdapter(myAdapter);

                                listView.setOnItemClickListener(
                                        new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                GroupDetail g = (GroupDetail) parent.getItemAtPosition(position);
                                                groupsToSend = groupsToSend + g.getGrp()+",";
                                                addressToSend = addressToSend + g.getAddresses()+",";

//                        String item = String.valueOf(parent.getItemAtPosition(position));
//                        Toast.makeText(getActivity(),item, Toast.LENGTH_LONG).show();
                                            }
                                        }
                                );

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                };
                new JoiningGroupTASKFetch(s,et.getText().toString()).execute();

            }
        });

        return rootView;
    }
}

