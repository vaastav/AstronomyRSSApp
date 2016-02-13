package com.vaastavanand.rssfeed.data;
/**
 * @file RssItem.java
 *
 * @author vaastav on 27/06/15.
 */

/**
 * Object that holds information about RSS Feed Item
 *
 * @var m_title A String that holds the title of the RSS Feed Item
 * @var m_link A String that holds the link associated with the RSS Feed Item
 */
public class RssItem {
    private String m_title;
    private String m_link;

    /**
     * Returns the title of the RSS Feed Item
     * @return m_title
     */
    public String getTitle(){
        return m_title;
    }

    /**
     * Returns the link of the RSS Feed Item
     * @return m_link
     */
    public String getLink(){
        return m_link;
    }

    /**
     * Sets the link associated with the RSS Feed Item
     * @param link The link associated with the RSS Feed Item
     */
    public void setLink( String link ) {
        m_link = link;
    }

    /**
     * Sets the title of the RSS Feed Item
     * @param title Title of the RSS Feed Item
     */
    public void setTitle( String title ) {
        m_title = title;
    }

    @Override
    /**
     * String representation of the RSS Feed Item
     * @note The String representation is just the title of the item
     */
    public String toString(){
        return m_title;
    }

}
