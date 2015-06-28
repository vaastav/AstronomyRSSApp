package com.vaastavanand.rssfeed.util;


import com.vaastavanand.rssfeed.data.RssItem;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by vaastav on 28/06/15.
 */
public class RssParseHandler extends DefaultHandler{

    private List<RssItem> rssItems;
    private RssItem currentItem;
    private boolean parsingTitle;
    private boolean parsingLink;

    public RssParseHandler(){
        rssItems = new ArrayList<RssItem>();
    }

    public List<RssItem> getItems(){
        return rssItems;
    }

    public void startElement(String uri,String localName,String qName,Attributes attributes){
        if(qName.equals("item"))
            currentItem = new RssItem();
        else if(qName.equals("title"))
            parsingTitle = true;
        else if(qName.equals("link"))
            parsingLink = true;
    }

    public void endElement(String uri,String localName, String qName,Attributes attributes){
        if(qName.equals("item")){
            rssItems.add(currentItem);
            currentItem = null;
        }
        else if(qName.equals("title"))
            parsingTitle = false;
        else if(qName.equals("link"))
            parsingLink = false;
    }

    @Override
    public void characters(char[] ch, int start, int length)throws SAXException{
        if(parsingTitle){
            if(currentItem != null){
                currentItem.setTitle(new String(ch,start,length));
            }
        }
        else if(parsingLink){
            if(currentItem != null){
                currentItem.setLink(new String(ch,start,length));
                parsingLink = false;
            }
        }
    }
}
