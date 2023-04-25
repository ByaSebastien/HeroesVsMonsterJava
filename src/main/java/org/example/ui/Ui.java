package org.example.ui;

import org.example.models.characters.Heroes.Hero;
import org.example.models.characters.Monsters.Monster;
import org.example.models.map.GameMap;

public class Ui implements IUi{
    private GameMap map;

    @Override
    public void selectHero() {
        StringBuilder sb = new StringBuilder();
        sb.append("Select your hero").append("\n");
        sb.append("________________").append("\n");
        sb.append("1 : Human").append("\n");
        sb.append("2 : Dwarf").append("\n");
        System.out.println(sb);
    }

    @Override
    public void setMap(GameMap map) {
        this.map = map;
    }

    @Override
    public void displayMap() {
        System.out.println(map);
    }

    @Override
    public void fight(Hero hero, Monster monster) {
        System.out.println(hero + " | " + hero.getHp() + " | " + monster + " | " + monster.getHp());
    }
}