package org.example.units;

import org.example.Names;

import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements GameInterface{
    protected String name;
    protected String className;
    protected float hp, maxHp; // текущее здоровье, максимльное здоровье
    protected int x, y; // координаты на поле
    protected int atk; // атака
    protected int def; // защита
    protected int[] damage; // урон

    public BaseHero(String className, float hp, int x, int y, int atk, int def, int[] damage) {
        this.className = className;
        this.hp = this.maxHp = hp;
        this.name = getName();
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.def = def;
        this.damage = damage;
    }
    private static  String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    @Override
    public String toString() {
        return className + ' ' + name + ", запас здоровья: "
                + hp + ", координаты: [" + x + ":" + y + "]";
    }
//    заглушка, чтобы пока не прописывать в классах:
    @Override
    public void step() {}

    @Override
    public String getInfo(){return className;}
}
