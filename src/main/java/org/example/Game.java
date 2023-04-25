package org.example;

import org.example.handler.handlers.InputHandler;
import org.example.handler.models.IHandler;
import org.example.models.characters.Heroes.Hero;
import org.example.models.map.GameMap;
import org.example.ui.IUi;
import org.example.ui.Ui;

public class Game {
    private final IHandler handler = new InputHandler();
    private final Hero hero;
    private final IUi ui = new Ui();
    private final GameMap map;

    public Game(){
        this.ui.selectHero();
        hero = handler.readSelectHeroAction();
        map = new GameMap(hero);
        ui.setMap(map);
        handler.initMoveCommand(ui,map,hero);
    }

    public void Start(){
        while (hero.isAlive()){
            playturn();
        }
    }

    public void playturn(){
        ui.displayMap();
        handler.readMoveAction();
    }
}
