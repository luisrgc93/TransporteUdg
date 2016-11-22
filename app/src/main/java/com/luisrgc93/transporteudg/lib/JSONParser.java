package com.luisrgc93.transporteudg.lib;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by luisr_000 on 15/11/2016.
 */

public class JSONParser {

    static JSONArray jsonArray = null;

    public JSONParser()
    {

    }

    public JSONArray getJsonArray(String URL)
    {
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet getData = new HttpGet(URL);
        try
        {
            HttpResponse response = client.execute(getData);
            StatusLine statusLine = response.getStatusLine();

            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200)
            {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while((line=reader.readLine()) != null)
                {
                    stringBuilder.append(line);
                }
            }
            else
            {
                Log.e("===>", "Fallo al descargar del JSON");
            }
        }
        catch(ClientProtocolException e)
        { e.printStackTrace();}
        catch (IOException e)
        { e.printStackTrace();}

        try
        {
            jsonArray = new JSONArray(stringBuilder.toString());
        }catch (JSONException e)
        {
            Log.e("Json Parser","Error de optencion de datos"+e.toString());
        }
        return jsonArray;
    }

}
