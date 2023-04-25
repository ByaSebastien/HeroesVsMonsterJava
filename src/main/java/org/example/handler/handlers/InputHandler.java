package org.example.handler.handlers;

import org.example.handler.commands.FightCommand;
import org.example.handler.commands.MoveCommand;
import org.example.handler.models.Direction;
import org.example.handler.models.FightAction;
import org.example.handler.models.ICommand;
import org.example.handler.models.IHandler;
import org.example.models.characters.Heroes.Dwarf;
import org.example.models.characters.Heroes.Hero;
import org.example.models.characters.Heroes.Human;
import org.example.models.characters.Monsters.Monster;
import org.example.models.map.GameMap;
import org.example.models.map.Position;
import org.example.ui.IUi;

import java.util.Scanner;

public class InputHandler implements IHandler {
    private ICommand moveNorth;
    private ICommand moveSouth;
    private ICommand moveEast;
    private ICommand moveWest;

    private ICommand attack;
    private ICommand heal;

    public void initMoveCommand(IUi ui, GameMap map,Hero hero){
        moveNorth = new MoveCommand(map,hero, Direction.north,(Position position) -> handleFightEvent(ui,hero, map.getMonster(position)));
        moveSouth = new MoveCommand(map,hero, Direction.south,(Position position) -> handleFightEvent(ui,hero, map.getMonster(position)));
        moveEast = new MoveCommand(map,hero, Direction.east,(Position position) -> handleFightEvent(ui,hero, map.getMonster(position)));
        moveWest = new MoveCommand(map,hero, Direction.west,(Position position) -> handleFightEvent(ui,hero, map.getMonster(position)));
    }

    private boolean handleFightEvent(IUi ui, Hero hero, Monster monster){
        attack = new FightCommand(hero,monster, FightAction.attack);
        heal = new FightCommand(hero,monster,FightAction.heal);
        while (hero.isAlive() && monster.isAlive()){
            ui.fight(hero,monster);
            readFightAction();
            if(monster.isAlive())
                monster.attack(hero);
        }
        return hero.isAlive();
    }

    @Override
    public void readMoveAction() {
        Scanner scanner = new Scanner(System.in);
        String moveAction = scanner.nextLine();

        switch (moveAction.toLowerCase()) {
            case "z" -> this.moveNorth.execute();
            case "q" -> this.moveWest.execute();
            case "s" -> this.moveSouth.execute();
            case "d" -> this.moveEast.execute();
        }

//        scanner.close();
    }

    @Override
    public void readFightAction() {
        Scanner scanner = new Scanner(System.in);
        String fightChoice = scanner.nextLine();

        switch (fightChoice) {
            case "a" -> attack.execute();
            case "h" -> heal.execute();
        }
    }

    @Override
    public Hero readSelectHeroAction() {
        Scanner scanner = new Scanner(System.in);
        String heroChoice = scanner.nextLine();

        switch (heroChoice) {
            case "1" : return new Human("Dante");
            case "2" : return new Dwarf("Byby");
        }
        return null;
    }
}
