package org.example.units;

public class Sniper extends BaseHero {
    protected int arrows; // запас стрел
    protected int accuracy; // точность

    public Sniper(String name, int x, int y) {
                super("Снайпер",10, name, x, y, 6, 2, new int[]{2,3});
        arrows = 12;
        accuracy = 75;
    }
}
