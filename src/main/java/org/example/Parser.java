package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
    String siteNameToParse;
    String bodyToParse;
    Elements lines;

    Elements parseAllWords (String siteNameToParse, String bodyToParse)  {
        this.siteNameToParse = siteNameToParse;
        this.bodyToParse = bodyToParse;

        try {
            Document doc = Jsoup
                    .connect(siteNameToParse) //или url
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                    .get();
            lines = doc.select(bodyToParse);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
       return lines;
    }
}
