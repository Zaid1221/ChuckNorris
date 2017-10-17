package com.example.zaidjavaid.chucknorris;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Zaid Javaid on 10/17/2017.
 */

public class Network
{
    public static String getResponseFromHttpUrl(URL url) throws IOException
    {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static URL buildUrl()
    {
        Uri builtURI = Uri.parse("http://api.icndb.com/jokes/random").buildUpon()
            .build();
        URL url2= null;
        try
        {
            url2 = new URL(builtURI.toString());
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return url2;
    }
}
