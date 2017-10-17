package com.example.zaidjavaid.chucknorris;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButtonHandler bh = new ButtonHandler();
        v = new View(this, bh);
        setContentView(v);
    }

    private void buildURI()
    {
        URL CloudSearchUrl = Network.buildUrl();
        new ChuckNorris().execute(CloudSearchUrl);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        public void onClick(View v)
        {
            if(v.isButton(bh)v)
            {
                buildURI();
            }
        }
    }

    public class ChuckNorris extends AsyncTask<URL,Void,String>
    {
        @Override
        protected String doInBackground(URL... url)
        {
            // android.os.Debug.waitForDebugger();
            String toReturn = "Did not work";
            try {
                toReturn = Network.getResponseFromHttpUrl(url[0]);
            } catch (Exception e) {
                Log.d("doInBackground", "exception on get Response from HTTP call" + e.getMessage());
            }
            return toReturn;
        }
    }

    @Override
    protected void onPostExecute(String s)
    {
        try
        {
            JSONObject sentimentJSON = new JSONObject(s);
            JSONObject value = sentimentJSON.getJSONObject("value");
            // JSONArray theSentenceList= value.getJSONArray("docs");
            // JSONObject index = theSentenceList.getJSONObject(0);
            String id = value.get("id").toString();
            String joke = value.get("joke").toString();
            v.getText(id,joke);
            //textView.setText("id: "+id +"\n" + "joke: "+joke);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        v.updateSentenceSize();
        super.onPostExecute(s);
    }
}
