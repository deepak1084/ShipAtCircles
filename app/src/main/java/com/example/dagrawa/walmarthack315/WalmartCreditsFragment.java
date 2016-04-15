package com.example.dagrawa.walmarthack315;

/**
 * Created by hp on 02-04-2016.
 */


        import android.annotation.TargetApi;
        import android.app.Activity;
        import android.app.Fragment;
        import android.content.Context;
        import android.os.Build;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListAdapter;
        import android.widget.ListView;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.Collection;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class WalmartCreditsFragment extends Fragment {

    public WalmartCreditsFragment(){}
    View root;
    Activity context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.walmartcredits, container, false);
        root = rootView;
        context = this.getActivity();
        final ArrayList<CreditClass> arrayList = new ArrayList<>();

//        arrayList.add(new CreditClass("Deepak",20));
//        arrayList.add(new CreditClass("Dinesg",10));

    setJsonValueInterface s = new setJsonValueInterface() {
        @Override
        public void SetJSONObject(JSONArray j) {
            Log.i("deepak in credit fragment", j.toString());
            for(int i=0;i<j.length();i++) {
                try {
                    JSONObject ob = j.getJSONObject(i);
                    arrayList.add(new CreditClass(ob.getString("order_no"),Integer.parseInt(ob.getString("ship_discount"))));
                    ListAdapter myAdapter = new CustomAdapterWithoutImage(context,arrayList);
                    ListView dinesListView = (ListView) root.findViewById(R.id.listView);

                    dinesListView.setAdapter(myAdapter);

                    dinesListView.setOnItemClickListener(
                            new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
        new CreditsFetchingTask(s).execute();

        //  ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);



        return rootView;
    }
}
