package org.example.units;

import org.example.Names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements GameInterface {
    protected String name;
    protected String className;
    protected float hp, maxHp; // текущее здоровье, максимльное здоровье
    protected int atk; // атака
    protected int def; // защита
    protected int[] damage; // урон
    protected Position position;

    public BaseHero(String className, float hp, int x, int y, int atk, int def, int[] damage) {
        this.className = className;
        this.hp = this.maxHp = hp;
        this.name = getName();
        this.atk = atk;
        this.def = def;
        this.damage = damage;
        position = new Position(x, y);
    }

    private String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    @Override
    public String toString() {
        return className + ' ' + name + ", запас здоровья: "
                + hp + ", координаты: [" + position.x + ":" + position.y + "]";
    }

    //    заглушка, чтобы пока не прописывать в классах:
    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {
    }

    @Override
    public String getInfo() {
        return className;
    }

    protected BaseHero findClosestEnemy(ArrayList<BaseHero> enemies) {
        int index = 0;
        double minDistance = position.distance(enemies.get(index));
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).hp > 0) {
                double distance = position.distance(enemies.get(i));
                if (distance < minDistance) {
                    minDistance = distance;
                    index = i;
                }
            }
        }
        return enemies.get(index);

    }
}
