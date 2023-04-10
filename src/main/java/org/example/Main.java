package org.example;

import org.example.units.*;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static final int UNITS = 10;
    public static ArrayList<BaseHero> blueTeam = new ArrayList<>();
    public static ArrayList<BaseHero> greenTeam = new ArrayList<>();
    public static ArrayList<BaseHero> allTeams = new ArrayList<>();

    public static void main(String[] args) {
        initTeams();
        String step = "";
        while (!step.equals("q")) {
            View.view();
            for (BaseHero h : allTeams) {
                if (blueTeam.contains(h)) h.step(greenTeam, blueTeam);
                else h.step(blueTeam, greenTeam);
            }
            Collections.sort(allTeams);
            step = scanner.nextLine();
        }
    }

    private static ArrayList<BaseHero> createTeam(boolean firstTeam) {
        ArrayList<BaseHero> team = new ArrayList<>();
        if (firstTeam) {
            for (int i = 0; i < UNITS; i++) {
                switch (new Random().nextInt(4)) {
                    case 0 -> team.add(new Arbalester(i + 1, 1));
                    case 1 -> team.add(new Magican(i + 1, 1));
                    case 2 -> team.add(new Peasant(i + 1, 1));
                    default -> team.add(new Thief(i + 1, 1));
                }
            }
        } else {
            for (int i = 0; i < UNITS; i++) {
                switch (new Random().nextInt(4)) {
                    case 0 -> team.add(new Monk(i + 1, UNITS));
                    case 1 -> team.add(new Peasant(i + 1, UNITS));
                    case 2 -> team.add(new Sniper(i + 1, UNITS));
                    default -> team.add(new Pikeman(i + 1, UNITS));
                }
            }
        }
        return team;
    }

    private static void initTeams() {
        blueTeam = createTeam(true);
        greenTeam = createTeam(false);
        allTeams.addAll(blueTeam);
        allTeams.addAll(greenTeam);
        Collections.sort(allTeams);
    }
}