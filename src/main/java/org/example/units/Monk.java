package org.example.units;

public class Monk extends BaseHero{
    protected int mana;
    public Monk(String name, int x, int y) {
        super("Монах", 30, name, x, y, 12, 12, new int[]{9, 12});
        mana = 10;
    }
}

