package org.example.units;

import java.util.Arrays;

public abstract class BaseHero {
    protected String name;
    protected String className;
    protected float hp, maxHp; // текущее здоровье, максимльное здоровье
    protected int x, y; // координаты на поле
    protected int atk; // атака
    protected int def; // защита
    protected int[] damage; // урон

    public BaseHero(String className, float hp, String name, int x, int y, int atk, int def, int[] damage) {
        this.className = className;
        this.hp = this.maxHp = hp;
        this.name = name;
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.def = def;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return className + ' ' + name + ", запас здоровья: "
                + hp + ", координаты: [" + x + ":" + y + "]";
    }
}
