package org.example.units;

public class Arbalester extends BaseHero{
    protected int arrows; // запас стрел
    protected int accuracy; // точность

    public Arbalester(String name, int x, int y) {
        super("Арбалетчик",10, name, x, y, 4, 4, new int[]{2,8});
        arrows = 12;
        accuracy = 70;
    }
}
