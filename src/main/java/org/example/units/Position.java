package org.example.units;

public class Position {
    protected int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(BaseHero target) {
        return Math.sqrt(Math.pow(target.position.x - x, 2) + Math.pow(target.position.y - y, 2));
    }
}
