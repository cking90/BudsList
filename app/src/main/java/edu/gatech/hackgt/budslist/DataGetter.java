package edu.gatech.hackgt.budslist;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.gatech.hackgt.budslist.models.Book;

public class DataGetter extends Thread {

    public static String[] getData(String url, Book b) {
        final String urldata = url;
        final String[] data = new String[2];
        new Thread(new Runnable() {
            @Override
            public void run() {
                String str ="blank";
                String authorName = "blank";
                try {
                    Document doc = Jsoup.connect(urldata).get();
                    String body = doc.body().text();

                    Pattern titlePattern = Pattern.compile("Full Title (.+?) ISBN");
                    Matcher titleMatcher = titlePattern.matcher(body);
                    if (titleMatcher.find()) {
                        str = titleMatcher.group(1);
                    }

                    Pattern authorPattern = Pattern.compile("Authors (.+?) [Overview|Edition]");
                    Matcher authorMatcher = authorPattern.matcher(body);
                    if (authorMatcher.find()) {
                        authorName = authorMatcher.group(1);
                    }
                } catch (Exception e) {
                    str = e.getMessage();
                }
                final String title = str;
                final String author = authorName;
                data[0] = title;
                data[1] = author;
            }
        }).start();
        return data;
    }

}



