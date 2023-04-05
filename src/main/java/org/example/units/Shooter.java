package org.example.units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected int arrows; // запас стрел
    protected int accuracy; // точность

    public Shooter(String className, float hp, int x, int y,
                   int def, int[] damage, int arrows, int accuracy, int priority) {
        super(className, hp, x, y, def, damage, priority);
        this.arrows = arrows;
        this.accuracy = accuracy;
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> myTeam) {
        if (state == State.dead || arrows == 0) return;
        BaseHero enemy = findClosestEnemy(enemyTeam);
        if (enemy == null) return;
        shoot(findClosestEnemy(enemyTeam));
        if (!checkPeasant(myTeam)) arrows--;
//        System.out.println("    now: " + name  + " стрел: "  + arrows);
    }

    protected void shoot(BaseHero enemy) {
        double hit = countDamage(enemy);
        if (enemy.state != State.dead) {
            enemy.getDamage(hit);
//            System.out.println("    " + name + " Shoot: " + hit + " --> " + enemy);
        }
    }
    private Boolean checkPeasant(ArrayList<BaseHero> myTeam) {
        for (BaseHero h: myTeam) {
            if (h.getInfo().equals("Крестьянин") && h.state == State.stand) {
                h.setState(State.busy);
                return true;
            }
        }
        return false;
    }

    private double countDamage(BaseHero enemy) {
//        случайная сила удара * аккуратность * коэффициент дальности
//        System.out.println(position.closenessCoefficient(enemy));
        return (Math.random()*(damage[1] - damage[0]) + damage[0])
                * accuracy / 100
                * position.closenessCoefficient(enemy);
    }
}
