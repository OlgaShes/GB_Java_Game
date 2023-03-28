package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(10);
            int y = new Random().nextInt(10);
            switch (new Random().nextInt(7)) {
                case 0:
                    heroes.add(new Arbalester(x, y));
                    break;
                case 1:
                    heroes.add(new Magican(x, y));
                    break;
                case 2:
                    heroes.add(new Monk(x, y));
                    break;
                case 3:
                    heroes.add(new Peasant(x, y));
                    break;
                case 4:
                    heroes.add(new Sniper(x, y));
                    break;
                case 5:
                    heroes.add(new Pikeman(x, y));
                    break;
                default:
                    heroes.add(new Thief(x, y));
            }
        }
        heroes.forEach(h -> System.out.println(h));
        heroes.forEach(h -> System.out.println(h.getInfo()));

    }
}