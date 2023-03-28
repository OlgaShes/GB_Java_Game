package org.example.units;

public class Peasant extends BaseHero{
    protected int burden; // остаток подносимых боеприпасов

    public Peasant(int x, int y) {
        super("Крестьянин",5, x, y, 1, 5, new int[]{1,1});
        burden = 25;
    }
}
