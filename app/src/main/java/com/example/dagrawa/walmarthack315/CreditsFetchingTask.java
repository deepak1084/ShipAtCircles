package com.example.dagrawa.walmarthack315;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by dagrawa on 4/3/16.
 */
public class CreditsFetchingTask extends AsyncTask<Void,Void,JSONArray> {
    setJsonValueInterface setInterface=null;
    public CreditsFetchingTask(setJsonValueInterface s) {
    this.setInterface = s;
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        URL url = null;
        JSONArray j = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://172.16.100.234:8081/orders/dagrawa");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");


            int HttpResult =urlConnection.getResponseCode();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream(),
                            "utf-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
            String retString=new String(sb.toString());
            j = new JSONArray(retString);
            Log.i("deepak",retString);

    } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return j;
        }
    }

    @Override
    protected void onPostExecute(JSONArray jsonObject) {
        setInterface.SetJSONObject(jsonObject);
    }

}
