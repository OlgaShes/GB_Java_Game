package org.example.units;

import java.util.ArrayList;

public abstract class Healer extends BaseHero{
    protected int mana, maxMana;

    public Healer(String className, float hp, int x, int y, int def, int[] damage,
                  int mana, int priority) {
        super(className, hp, x, y, def, damage, priority);
        this.mana = this.maxMana = mana;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> myTeam) {
        System.out.println("Step of Healer");
    }
}
