package org.example.ui;

import org.example.models.characters.Heroes.Hero;
import org.example.models.characters.Monsters.Monster;
import org.example.models.map.GameMap;

public interface IUi {
    void selectHero();

    void setMap(GameMap map);

    void displayMap();

    void fight(Hero hero, Monster monster);
}
