package com.example.texansapp;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.timfey.texansapp.C0041R;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class RSSReaderKHOU extends ListActivity {
    private ArrayList<RSSItem> itemlist;
    private RSSListAdaptor rssadaptor;

    private class RSSListAdaptor extends ArrayAdapter<RSSItem> {
        private List<RSSItem> objects;

        public RSSListAdaptor(Context context, int textviewid, List<RSSItem> objects) {
            super(context, textviewid, objects);
            this.objects = null;
            this.objects = objects;
        }

        public int getCount() {
            return this.objects != null ? this.objects.size() : 0;
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public RSSItem getItem(int position) {
            return this.objects != null ? (RSSItem) this.objects.get(position) : null;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = ((LayoutInflater) RSSReaderKHOU.this.getSystemService("layout_inflater")).inflate(C0041R.layout.rssitemview, null);
            }
            RSSItem data = (RSSItem) this.objects.get(position);
            if (data != null) {
                TextView date = (TextView) view.findViewById(C0041R.id.txtDate);
                TextView description = (TextView) view.findViewById(C0041R.id.txtDescription);
                ((TextView) view.findViewById(C0041R.id.txtTitle)).setText(data.title);
                date.setText("on " + data.date);
                description.setText(data.description);
            }
            return view;
        }
    }

    private class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progress;

        private RetrieveRSSFeeds() {
            this.progress = null;
        }

        protected Void doInBackground(Void... params) {
            RSSReaderKHOU.this.retrieveRSSFeed("http://www.khou.com/sports/houstontexans/index.rss2", RSSReaderKHOU.this.itemlist);
            RSSReaderKHOU.this.rssadaptor = new RSSListAdaptor(RSSReaderKHOU.this, C0041R.layout.rssitemview, RSSReaderKHOU.this.itemlist);
            return null;
        }

        protected void onCancelled() {
            super.onCancelled();
        }

        protected void onPreExecute() {
            this.progress = ProgressDialog.show(RSSReaderKHOU.this, null, "Loading RSS Feeds...");
            super.onPreExecute();
        }

        protected void onPostExecute(Void result) {
            RSSReaderKHOU.this.setListAdapter(RSSReaderKHOU.this.rssadaptor);
            this.progress.dismiss();
            super.onPostExecute(result);
        }

        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    public RSSReaderKHOU() {
        this.itemlist = null;
        this.rssadaptor = null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0041R.layout.main);
        this.itemlist = new ArrayList();
        new RetrieveRSSFeeds().execute(new Void[0]);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((RSSItem) this.itemlist.get(position)).link)));
    }

    private void retrieveRSSFeed(String urlToRssFeed, ArrayList<RSSItem> list) {
        try {
            URL url = new URL(urlToRssFeed);
            XMLReader xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xmlreader.setContentHandler(new RSSParser(list));
            xmlreader.parse(new InputSource(url.openStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
