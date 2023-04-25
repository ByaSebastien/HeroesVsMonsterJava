package org.example.handler.commands;

import org.example.handler.models.FightAction;
import org.example.handler.models.ICommand;
import org.example.models.characters.Heroes.Hero;
import org.example.models.characters.Monsters.Monster;

public class FightCommand implements ICommand {
    private final Hero hero;
    private final Monster monster;
    private final FightAction action;

    public FightCommand(Hero hero,Monster monster,FightAction action){
        this.hero = hero;
        this.monster = monster;
        this.action = action;
    }

    @Override
    public void execute() {
        switch (action){
            case attack -> hero.attack(monster);
            case heal -> hero.heal();
        }
    }
}
