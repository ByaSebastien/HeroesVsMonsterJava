package org.example.handler.models;

import org.example.models.characters.Heroes.Hero;
import org.example.models.map.GameMap;
import org.example.ui.IUi;

public interface IHandler {
    void readMoveAction();
    void readFightAction();
    Hero readSelectHeroAction();
    void initMoveCommand(IUi ui, GameMap map, Hero hero);
}
