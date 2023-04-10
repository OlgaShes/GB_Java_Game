package org.example;

import org.example.units.BaseHero;
import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static int size = Main.UNITS;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(size-1, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(size-1, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(size-1, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 4;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseHero hero: Main.allTeams) {
            if (hero.getCoords()[0] == x && hero.getCoords()[1] == y){
                if (hero.getHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + hero.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.greenTeam.contains(hero)) out = "|" + (AnsiColors.ANSI_GREEN + hero.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (Main.blueTeam.contains(hero)) out = "|" + (AnsiColors.ANSI_BLUE + hero.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Main.allTeams.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Blue side");

        System.out.print(" ".repeat(l[0]-6));
        System.out.println(":\tGreen side");
        for (int i = 1; i < size + 1; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.blueTeam.get(0));
        tabSetter(Main.blueTeam.get(0).toString().length(), l[0]);
        System.out.println(Main.greenTeam.get(0));
        System.out.println(midl10);

        for (int i = 2; i < size; i++) {
            for (int j = 1; j < size + 1; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.blueTeam.get(i-1));
            tabSetter(Main.blueTeam.get(i-1).toString().length(), l[0]);
            System.out.println(Main.greenTeam.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < size + 1; j++) {
            System.out.print(getChar(size, j));
        }
        System.out.print("|    ");
        System.out.print(Main.blueTeam.get(size-1));
        tabSetter(Main.blueTeam.get(size-1).toString().length(), l[0]);
        System.out.println(Main.greenTeam.get(size-1));
        System.out.println(bottom10);
    }
}