package com.example.texansapp;

import android.support.v4.app.DialogFragment;
import android.support.v4.widget.CursorAdapter;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSParser extends DefaultHandler {
    private static final String TAG_ITEM = "item";
    private static final String[] xmltags;
    private StringBuilder builder;
    private int currentindex;
    private RSSItem currentitem;
    private boolean isParsing;
    private ArrayList<RSSItem> itemarray;

    static {
        xmltags = new String[]{"title", "link", "pubDate", "description", "enclosure"};
    }

    public RSSParser(ArrayList<RSSItem> itemarray) {
        this.currentitem = null;
        this.itemarray = null;
        this.currentindex = -1;
        this.isParsing = false;
        this.builder = new StringBuilder();
        this.itemarray = itemarray;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (this.isParsing && -1 != this.currentindex && this.builder != null) {
            this.builder.append(ch, start, length);
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equalsIgnoreCase(TAG_ITEM)) {
            this.currentitem = new RSSItem();
            this.currentindex = -1;
            this.isParsing = true;
            this.itemarray.add(this.currentitem);
            return;
        }
        this.currentindex = itemIndexFromString(localName);
        this.builder = null;
        if (-1 != this.currentindex) {
            this.builder = new StringBuilder();
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equalsIgnoreCase(TAG_ITEM)) {
            this.isParsing = false;
        } else if (this.currentindex != -1 && this.isParsing) {
            switch (this.currentindex) {
                case DialogFragment.STYLE_NORMAL /*0*/:
                    if (this.currentitem.title == null) {
                        this.currentitem.title = this.builder.toString();
                    }
                case CursorAdapter.FLAG_AUTO_REQUERY /*1*/:
                    this.currentitem.link = this.builder.toString();
                case CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER /*2*/:
                    this.currentitem.date = this.builder.toString();
                case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                    this.currentitem.description = this.builder.toString();
                case FragmentManagerImpl.ANIM_STYLE_CLOSE_EXIT /*4*/:
                    this.currentitem.description = this.builder.toString();
                default:
            }
        }
    }

    private int itemIndexFromString(String tagname) {
        for (int index = 0; index < xmltags.length; index++) {
            if (tagname.equalsIgnoreCase(xmltags[index])) {
                return index;
            }
        }
        return -1;
    }
}
