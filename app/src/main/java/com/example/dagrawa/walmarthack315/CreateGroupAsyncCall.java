package com.example.dagrawa.walmarthack315;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by dagrawa on 4/3/16.
 */
public class CreateGroupAsyncCall extends AsyncTask<JSONObject,Void,Void> {

    @Override
    protected Void doInBackground(JSONObject... params) {

        URL url = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://172.16.100.234:8081/users/");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(params[0].toString());
            out.close();
            Log.i("Data",params[0].toString());

            int HttpResult =urlConnection.getResponseCode();

        Log.i("Deepak", String.valueOf(HttpResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
         finally {
            if(url != null)
                urlConnection.disconnect();
            }

        return null;
    }
}
