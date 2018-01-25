package fr.parisnanterre.pmoo.immobiler_app.util;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import fr.parisnanterre.pmoo.immobiler_app.activity.MainActivity;

public class ToolsPpmInJava {


    public static int checkSelfPermission(Context context, String permission) {
        if (permission == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(permission, android.os.Process.myPid(), android.os.Process.myUid());
    }


    public static String getJson(String urlString)
    {
        HttpURLConnection urlConnection = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            urlConnection.setUseCaches(false);
            urlConnection.connect();
            int conResponse = urlConnection.getResponseCode();
            switch (conResponse) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader
                            (new InputStreamReader(urlConnection.getInputStream()));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + System.lineSeparator());
                    }
                    br.close();
            }
        } catch (Exception ex) {
            Log.e(MainActivity.class.getCanonicalName(), null, ex);
            sb.setLength(0);
        } finally {
            try {
                if (urlConnection != null)
                    urlConnection.disconnect();
            } catch (Exception ex) {
                Log.e(MainActivity.class.getCanonicalName(), null, ex);
            }
        }
        return sb.toString();
    }

    public static String getFinalURL(String urlString) {
        int responseCode = 0;
        String redirectedUrl = null;
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) new URL(urlString).openConnection();
            con.setInstanceFollowRedirects(false);
            con.connect();
            responseCode = con.getResponseCode();
            redirectedUrl = con.getHeaderField("Location");
        } catch (Exception ex) {
            Log.e(MainActivity.class.getCanonicalName(), null, ex);
            redirectedUrl = null;
        } finally {
            try {
                if (con != null)
                    con.disconnect();
            } catch (Exception ex) {
                Log.e(MainActivity.class.getCanonicalName(), null, ex);
            }
        }
        if ((responseCode == HttpURLConnection.HTTP_MOVED_PERM ||
                responseCode == HttpURLConnection.HTTP_MOVED_TEMP ) &&
                redirectedUrl != null) {
            return getFinalURL(redirectedUrl);
        }
        return urlString;
    }

}



