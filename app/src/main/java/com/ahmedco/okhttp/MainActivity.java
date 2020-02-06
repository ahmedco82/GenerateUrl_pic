package com.ahmedco.okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//https://www.zoftino.com/android-okhttp-example

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private Button getb;
    private Button postb;
    private Button getqueryb;
    private TextView respone;

    ArrayList<String> list = new ArrayList<String>();
    public static ArrayList<String> list2 = new ArrayList<String>();

    //https://stackoverflow.com/questions/35939635/how-to-crawl-multiple-urls-using-jsoup
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] Url = new String[]{
                "https://abcnews.go.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
                , "http://www.abc.net.au/news"
                , "https://www.aftenposten.no"
                , "http://www.aljazeera.com"
                , "http://www.ansa.it"
                , "http://www.argaam.com"
                , "http://arstechnica.com"
                , "https://arynews.tv/ud/"
                , "https://apnews.com/"
                , "http://www.afr.com"
                , "https://www.axios.com"
                , "http://www.bbc.co.uk/news"
                , "http://www.bbc.co.uk/sport"
                , "http://www.bild.de"
                , "https://br.blastingnews.com"
                , "http://www.bleacherreport.com"
                , "http://www.bloomberg.com"
                , "http://www.breitbart.com"
                , "http://www.businessinsider.com"
                , "http://uk.businessinsider.com"
            };
              for (int i = 0; i < Url.length; ++i) {
                 list.add(Url[i]);

              }
              Log.i("origList0 ", "" + Url.length);
              // getHtmlFromWeb(list);
         // String[] urls = new String[]{"http://www.dmoz.org/", "http://www.dmoz.org/Computers/Computer_Science/", "https://docs.oracle.com/en/"};

        // Create and start workers
        List<Worker> workers = new ArrayList<>(Url.length);
        for (String url : Url) {
            Worker w = new Worker(url);
            workers.add(w);
            new Thread(w).start();
        }
         // Retrieve results
        for(Worker w : workers) {
            Elements results = w.waitForResults();
            if(results != null)
               Log.i("get00_ ", "" + results.size());
              //System.out.println(w.getName() + ": "+results.size());
            else
              Log.i("get00 ", "had some error!");
             //System.err.println(w.getName() + " had some error!");
          }
       }
    }
    
class Worker implements Runnable {

    private String url;
    private Elements results;
    private String name;
    private static int number = 0;

    private final Object lock = new Object();

    public Worker(String url) {
        this.url = url;
        this.name = "Worker-" + (number++);
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Document doc = Jsoup.connect(this.url).get();
            //Elements links = doc.select("a");
            //Element links = doc.select("a").first();
            //Elements links = doc.select("link[href]");
            Elements links =  doc.getElementsByTag("meta");
            // Update results
            synchronized (lock) {
             this.results = links;
                for (Element link : results) {
                    if ("og:image".equals(link.attr("property"))) {
                        String src = link.attr("content");
                        Log.i("get_links ", "" + src);
                    }
                }
               lock.notifyAll();
            }
        } catch (IOException e) {
            // You should implement a better error handling code..
            System.err.println("Error while parsing: "+this.url);
            e.printStackTrace();
        }
    }

    public Elements waitForResults(){
        synchronized(lock){
            try {
                while (this.results == null){
                    lock.wait();
                }
                return this.results;
            } catch (InterruptedException e) {
                // Again better error handling
                e.printStackTrace();
            }
            return null;
        }
    }
}



/*
    class Worker implements Runnable {

        private String url;
        private Elements results;
        private String name;
        private int number = 0;

        private final Object lock = new Object();

        public Worker(String url) {
            this.url = url;
            this.name = "Worker-" + (number++);

        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                Document doc = Jsoup.connect(this.url).get();
                // Elements links = doc.select("a");
                // Document doc = Jsoup.connect(group.get(i)).get();
                Elements links = doc.getElementsByTag("meta");
                for (Element link : links) {
                    if ("og:image".equals(link.attr("property"))) {
                        String src = link.attr("content");
                        Log.i("getUrlImage0 ", "" + src);
                        list2.add(src);
                    }
                }

                Log.i("getSiz0:: ", "" + list2.size());
                // Update results
                synchronized (lock) {
                    this.results = links;
                    lock.notifyAll();
                }
            } catch (IOException e) {
                // You should implement a better error handling code..
                //System.err.println("Error while parsing: " + this.url);
                Log.e("Eroor0 ", ""+this.url);
                e.printStackTrace();
            }
        }

        public Elements waitForResults() {
            synchronized (lock) {
                try {
                    while (this.results == null) {
                        lock.wait();
                    }
                    return this.results;
                } catch (InterruptedException e) {
                    // Again better error handling
                    e.printStackTrace();
                }
                return null;
            }
        }
    }
*/



/*
    private void getHtmlFromWeb(final ArrayList<String> group) {
        new Thread(new Runnable(){
            @Override
            public void run() {
               // group
                final StringBuilder stringBuilder = new StringBuilder();
                try {
                    String src="";
                    for (int i=0; i<group.size(); i++) {
                     Document doc = Jsoup.connect(group.get(i)).get();
                       Elements links = doc.getElementsByTag("meta");
                        for(Element link : links) {
                          if("og:image".equals(link.attr("property"))) {
                              src = link.attr("content");
                               Log.i("getUrlImage0 ", ""+src);
                              list2.add(1);
                            }
                        }
                        Log.i("getSizeUrlImage0 ", ""+list2.size());
                    }
                } catch (IOException e) {
                    stringBuilder.append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     //   textView.setText(stringBuilder.toString());
                    }
                });
            }
        }).start();
    }
*/