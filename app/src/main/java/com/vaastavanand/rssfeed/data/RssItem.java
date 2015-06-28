package com.vaastavanand.rssfeed.data;
/**
 * Created by vaastav on 27/06/15.
 */
public class RssItem {
    private String title;
    private String link;

    public String getTitle(){
        return title;
    }
    public String getLink(){
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return title;
    }

}
