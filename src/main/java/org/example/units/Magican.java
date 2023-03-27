package org.example.units;

public class Magican extends BaseHero {
    protected int mana;

    public Magican(String name, int x, int y) {
        super("Маг",18, name, x, y, 10, 10, new int[]{7,8});
        mana = 20;
    }
}
