package org.example;

import org.example.units.*;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<BaseHero> team1 = createTeam(true);
        ArrayList<BaseHero> team2 = createTeam(false);
        System.out.println("Команда 1:");
        team1.forEach(h -> System.out.println(h));
        System.out.println("Команда 2:");
        team2.forEach(h -> System.out.println(h));

        System.out.println("Старт игры");
        ArrayList<BaseHero> allTeams = new ArrayList<>();
        allTeams.addAll(team1);
        allTeams.addAll(team2);
        Collections.sort(allTeams);
        allTeams.forEach(h -> System.out.println(h));

        String step = "";
        int index = 0;
        while (!step.equals("q")) {
            System.out.println("======== Ход " + (++index)+ " ========");
            for (BaseHero h: allTeams) {
                if (team1.contains(h)) h.step(team2, team1);
                else h.step(team1, team2);
            }
            System.out.println("======== Результат хода ========");
            System.out.println("Команда 1:");
            team1.forEach(h -> System.out.println(h));
            System.out.println("Команда 2:");
            team2.forEach(h -> System.out.println(h));
            Collections.sort(allTeams);
            step = scanner.nextLine();
        }

    }

    public static ArrayList<BaseHero> createTeam(boolean firstTeam) {
        ArrayList<BaseHero> team = new ArrayList<>();
        if (firstTeam) {
            for (int i = 0; i < 10; i++) {
                switch (new Random().nextInt(4)) {
                    case 0 -> team.add(new Arbalester(0, i));
                    case 1 -> team.add(new Magican(0, i));
                    case 2 -> team.add(new Peasant(0, i));
                    default -> team.add(new Thief(0, i));
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                switch (new Random().nextInt(4)) {
                    case 0 -> team.add(new Monk(9, i));
                    case 1 -> team.add(new Peasant(9, i));
                    case 2 -> team.add(new Sniper(9, i));
                    default -> team.add(new Pikeman(9, i));
                }
            }
        }
        return team;
    }
}