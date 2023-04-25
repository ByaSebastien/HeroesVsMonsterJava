package org.example.models.characters;

import org.example.models.map.ContentType;
import org.example.models.map.Position;
import org.example.models.properties.Stat;
import org.example.models.properties.StatType;
import org.example.utils.Dice;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private final List<IDieEventSubscriber> dieEvent = new ArrayList<IDieEventSubscriber>();

    private int hp;

    private final Stat stats = new Stat();

    private Position position;

    public Entity(int strength, int stamina){
        stats.generate(strength, stamina);
        setHp(getMaxHp());
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int value){
        this.hp = value < 0 ? 0 : Math.min(value, getMaxHp());
        if(getHp() == 0) raiseDieEvent();
    }

    public int getMaxHp(){
        return stats.getStat(StatType.maxHp);
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public abstract ContentType getSprite();

    public boolean isAlive(){
        return getHp() > 0;
    }

    public void attack(Entity target){
        int damage = Dice.D4.throwDice() + stats.modifier(StatType.strength);
        target.setHp(target.getHp() - Math.max(damage,1));
    }

    public void addDieSubscriber(IDieEventSubscriber subscriber){
        this.dieEvent.add(subscriber);
    }

    public void raiseDieEvent(){
        this.dieEvent.forEach(IDieEventSubscriber::execute);
    }

    @Override
    public String toString() {
        return getSprite().sprite;
    }
}
