package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class TextParser {
    public static void main(String[] args) throws IOException {
        // Указываем URL сайта
        String url = "http://news.example.com/";

        // Загружаем документ
        Document doc = Jsoup
                .connect("https://ru.stackoverflow.com/") //или url
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .get();

        // Находим все элементы body. весь текст на всей странице
        Elements headlines = doc.select("body");

        String allWord = headlines.get(0).text();

        System.out.println(allWord);

        String[] words = new String[headlines.size()];
        words = allWord.split(" ");

        //удаляем лишние знаки
        String[] cleanedWords = Arrays.stream(words)
                .map(str -> str.replaceAll("\\W", ""))
                .filter(str -> !str.isEmpty())
                .filter(str -> str.length() > 3)
                .map(String::toLowerCase)
                .toArray(String[]::new);

      //  System.out.println("==================================");

        //  for (int i = 0; i < cleanedWords.length; i++) {
       //     System.out.println(cleanedWords[i]);
       // }

        HashMap<String, Integer> map = new HashMap<>();
            for (String word : cleanedWords) {

                map.put(word, map.getOrDefault(word, 0) + 1);

            }

        System.out.println("список:");
       // for (String key : map.keySet()) {
       //     System.out.println(key + ": " + map.get(key));
       // }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));


        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }




    }
}
