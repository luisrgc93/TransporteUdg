package com.luisrgc93.transporteudg;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by luisr_000 on 11/11/2016.
 */
public class Conexion {

    public static String PostDatos(String urlUsuario, String ParametrosUsuarios){

        URL url;
        HttpURLConnection httpURLConnection = null;

        try {
            url = new URL(urlUsuario);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            httpURLConnection.setUseCaches(false);

            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            DataOutputStream data = new DataOutputStream(httpURLConnection.getOutputStream());
            data.writeBytes(ParametrosUsuarios);
            data.flush();
            data.close();

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String linea;
            StringBuffer respuesta = new StringBuffer();

            while((linea = bufferedReader.readLine()) != null)
            {
                respuesta.append(linea);
                respuesta.append('\r');
            }

            bufferedReader.close();

            return respuesta.toString();
        }
        catch (Exception e)
        {
            return null;
        }
        finally {
            if(httpURLConnection != null)
            {
                httpURLConnection.disconnect();
            }
        }

    }
}
