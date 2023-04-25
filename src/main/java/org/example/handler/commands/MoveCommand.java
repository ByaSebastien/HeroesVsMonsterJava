package org.example.handler.commands;

import org.example.handler.models.Direction;
import org.example.handler.models.ICommand;
import org.example.handler.models.IFightSubscriber;
import org.example.models.characters.Heroes.Hero;
import org.example.models.map.ContentType;
import org.example.models.map.GameMap;
import org.example.models.map.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand implements ICommand {
    private final GameMap map;
    private final Hero hero;
    private final Direction direction;
    private final IFightSubscriber fightEvent;

    public MoveCommand(GameMap map, Hero hero, Direction direction, IFightSubscriber fightEventSubscriber){
        this.map = map;
        this.hero = hero;
        this.direction = direction;
        fightEvent = fightEventSubscriber;
    }

    private boolean canMove(Position position){
        return !map.isOut(position) && map.getContent(position).getContent() == ContentType.empty ;
    }

    @Override
    public void execute() {
        int x = hero.getPosition().getX();
        int y = hero.getPosition().getY();

        switch (direction) {
            case north -> execute(new Position(x - 1, y));
            case south -> execute(new Position(x + 1, y));
            case east -> execute(new Position(x, y + 1));
            case west -> execute(new Position(x, y - 1));
        }
    }

    public void execute(Position position){
        if(!canMove(position)){
            if(map.isOut(position)) return;
            if(map.getContent(position).getContent() == ContentType.monster){
                if(raiseFightEvent(position)){
                    map.removeMonster(position);
                }
            }
        }
        map.getContent(hero.getPosition()).setContent(ContentType.empty);
        hero.setPosition(position);
        map.getContent(position).setContent(ContentType.hero);
    }

    public boolean raiseFightEvent(Position position){
        return fightEvent.execute(position);
    }
}
