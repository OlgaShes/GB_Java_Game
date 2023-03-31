package org.example.units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> enemyTeam);

    String getInfo();
}
