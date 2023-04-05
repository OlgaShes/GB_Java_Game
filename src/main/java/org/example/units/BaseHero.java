package org.example.units;

import org.example.Names;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterface, Comparable<BaseHero> {
    protected String name;
    protected String className;
    protected float hp, maxHp; // текущее здоровье, максимльное здоровье
    protected int def; // защита - индивидуальный процент уменьшения урона
    protected int[] damage; // урон
    protected Position position;
    protected int priority;

    protected enum State {stand, busy, dead}

    protected State state;

    public BaseHero(String className, float hp, int x, int y, int def, int[] damage, int priority) {
        this.className = className;
        this.hp = this.maxHp = hp;
        this.name = getName();
        this.def = def;
        this.damage = damage;
        position = new Position(x, y);
        this.priority = priority;
        state = State.stand;
    }

    private String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    @Override
    public String toString() {
        return className + ' ' + name + ", запас здоровья: "
                + hp + ", координаты: [" + position.x + ":" + position.y + "] " + state;
    }

    //    заглушка, чтобы пока не прописывать в классах:
    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> myTeam) {
    }

    @Override
    public String getInfo() {
        return className;
    }

    protected BaseHero findClosestEnemy(ArrayList<BaseHero> enemies) {
        int index = -1;
        double minDistance = position.maxDistance + 1;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).state != State.dead) {
                double distance = position.distance(enemies.get(i));
                if (distance < minDistance) {
                    minDistance = distance;
                    index = i;
                }
            }
        }
        if (index != -1) return enemies.get(index);
        else return null;
    }

    protected void getDamage(double damage) {
//        урон с учетом степени защиты
        hp -= damage * (100 - def) / 100;
        if (hp <= 0) {
            this.state = State.dead;
            hp = 0;
        }
    }

    protected void setState(State newState) {
        this.state = newState;
    }

    @Override
    public int compareTo(BaseHero bh) {
        if (this.priority < bh.priority) return 1;
        else if (this.priority > bh.priority) return -1;
        else {
            return Double.compare((bh.hp / bh.maxHp), (this.hp / this.maxHp));
        }
    }


}
