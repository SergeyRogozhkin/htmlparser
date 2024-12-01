package org.example;

import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       String nameSiteToParse = "https://ru.stackoverflow.com/";
        Parser parser = new Parser();
        Service service = new Service();
        Elements parsed = parser.parseAllWords(nameSiteToParse, "body");
        System.out.println("Запарсили сайт, получили Elements name.");
        System.out.println("Отсортируем и выведем по нужной логике:");
        service.convertToHashMap(parsed);

    }
}