package com.vaastavanand.rssfeed.listeners;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import com.vaastavanand.rssfeed.data.RssItem;

import java.util.List;

/**
 * Created by vaastav on 28/06/15.
 */
public class ListListener implements AdapterView.OnItemClickListener {

    List<RssItem> listItems;
    Activity activity;

    public ListListener(List<RssItem> items,Activity activity){
        listItems = items;
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(listItems.get(position).getLink()));
        activity.startActivity(i);

    }
}
