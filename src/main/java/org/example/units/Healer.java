package org.example.units;

import java.util.ArrayList;

public abstract class Healer extends BaseHero{
    protected int mana, maxMana;

    public Healer(String className, float hp, int x, int y, int atk, int def, int[] damage,
                  int mana) {
        super(className, hp, x, y, atk, def, damage);
        this.mana = this.maxMana = mana;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {
        System.out.println("Step of Healer");;
    }
}
