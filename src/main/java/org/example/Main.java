package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Указываем URL сайта
        String url = "http://news.example.com/";

        // Загружаем документ
        Document document = Jsoup.connect(url).get();

        // Находим все элементы h2
        Elements headlines = document.select("h2");

        // Проходимся по каждому элементу и выводим его содержимое
        for (Element headline : headlines) {
            System.out.println(headline.text());
        }


    }
}