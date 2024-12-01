package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;

public class Service extends Parser{
    Elements elements;

    void convertToHashMap(Elements elements) {
        this.elements = elements;

        String allWord = elements.get(0).text();

        System.out.println(allWord);

        String[] words = new String[elements.size()];
        words = allWord.split(" ");

        String[] cleanedWords = Arrays.stream(words)
                .map(str -> str.replaceAll("\\W", ""))
                .filter(str -> !str.isEmpty())
                .filter(str -> str.length() > 3)
                .filter(str -> !str.matches(".*\\d.*") )
                .map(String::toLowerCase)
                .toArray(String[]::new);

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : cleanedWords) {

            map.put(word, map.getOrDefault(word, 0) + 1);

        }

        System.out.println("список:");

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }

}
