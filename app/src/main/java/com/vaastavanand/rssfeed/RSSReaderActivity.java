package com.vaastavanand.rssfeed;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vaastavanand.rssfeed.data.RssItem;
import com.vaastavanand.rssfeed.listeners.ListListener;
import com.vaastavanand.rssfeed.util.RssReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RSSReaderActivity extends ListActivity {

    private RSSReaderActivity local;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssreader);
        local = this;
        GetRSSDataTask task = new GetRSSDataTask();
        task.execute("http://www.nasa.gov/rss/dyn/solar_system.rss");
        Log.d("RSS_ACT",Thread.currentThread().getName());
    }

    private class GetRSSDataTask extends AsyncTask<String,Void,List<RssItem> >{

        @Override
        protected List<RssItem> doInBackground(String... params) {

            Log.d("RSS_FEED",Thread.currentThread().getName());

            try{
                RssReader rssReader = new RssReader(params[0]);
                return rssReader.getItems();
            }catch(Exception e){
                Log.e("RSS_READER",e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<RssItem> result){
            ListView itcItems = (ListView) findViewById(R.id.list_item);
            ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1,result);
            itcItems.setAdapter(adapter);
            itcItems.setOnItemClickListener(new ListListener(result,local));
        }
    }

}
