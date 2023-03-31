package org.example.units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected int arrows, maxArrows; // запас стрел
    protected int accuracy; // точность

    public Shooter(String className, float hp, int x, int y, int atk,
                   int def, int[] damage, int arrows, int accuracy) {
        super(className, hp, x, y, atk, def, damage);
        this.arrows = arrows;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {
        if (hp <= 0 || arrows == 0) return;
        shoot(findClosestEnemy(enemyTeam));
    }

    protected void shoot(BaseHero enemy) {
        System.out.println(this.toString() + " Shoot: " + enemy.toString());
    }
}
