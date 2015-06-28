package com.vaastavanand.rssfeed.util;

import com.vaastavanand.rssfeed.data.RssItem;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by vaastav on 28/06/15.
 */
public class RssReader {

    private String rssUrl;

    public RssReader(String rssUrl){
        this.rssUrl = rssUrl;
    }

    public List<RssItem> getItems() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        RssParseHandler handler = new RssParseHandler();
        parser.parse(rssUrl,handler);
        return handler.getItems();
    }
}
