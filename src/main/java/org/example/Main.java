package org.example;

import org.example.units.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        heroes.add(new Arbalester("Иван", 1, 6));
        heroes.add(new Magican("Елисей", 2, 8));
        heroes.add(new Monk("Мирослав", 6, 1));
        heroes.add(new Peasant("Валькирий", 7, 3));
        heroes.add(new Sniper("Святополк", 9, 5));
        heroes.add(new Pikeman("Яромир", 5, 9));
        heroes.add(new Thief("Тихон", 4, 2));

        heroes.forEach(h -> System.out.println(h));


    }
}