package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> team1 = createTeam(true);
        ArrayList<BaseHero> team2 = createTeam(false);

        team1.forEach(h -> System.out.println(h));
        team1.forEach(h -> System.out.println(h.getInfo()));

        team2.forEach(h -> System.out.println(h));
        team2.forEach(h -> System.out.println(h.getInfo()));

        for (BaseHero h : team1) {
            if (h instanceof Arbalester) h.step(team2);
        }
        for (BaseHero h : team2) {
            if (h instanceof Sniper) h.step(team1);
        }
    }

    public static ArrayList<BaseHero> createTeam(boolean firstTeam) {
        ArrayList<BaseHero> team = new ArrayList<>();
        if (firstTeam) {
            for (int i = 0; i < 10; i++) {
                switch (new Random().nextInt(4)) {
                    case 0:
                        team.add(new Arbalester(0, i));
                        break;
                    case 1:
                        team.add(new Magican(0, i));
                        break;
                    case 2:
                        team.add(new Peasant(0, i));
                        break;
                    default:
                        team.add(new Thief(0, i));
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                switch (new Random().nextInt(4)) {
                    case 0:
                        team.add(new Monk(9, i));
                        break;
                    case 1:
                        team.add(new Peasant(9, i));
                        break;
                    case 2:
                        team.add(new Sniper(9, i));
                        break;
                    default:
                        team.add(new Pikeman(9, i));
                }
            }
        }
        return team;
    }
}