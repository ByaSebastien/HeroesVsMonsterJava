package org.example.models.characters.Heroes;

import org.example.models.characters.Entity;
import org.example.models.characters.loots.IGold;
import org.example.models.characters.loots.ILeather;
import org.example.models.map.ContentType;

public abstract class Hero extends Entity implements IGold, ILeather {
    private String name;
    private int gold;
    private int leather;

    public Hero(String name, int strength, int stamina){
        super(strength, stamina);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public ContentType getSprite() {
        return ContentType.hero;
    }

    @Override
    public int getGold(){
        return gold;
    }

    @Override
    public void setGold(int value){
        this.gold = value;
    }

    @Override
    public int getLeather(){
        return leather;
    }

    @Override
    public void setLeather(int value){
        this.leather = value;
    }

    public void heal(){
        this.setHp(getMaxHp());
    }

    public void loot(Entity target){
        if(target instanceof IGold g){
            this.setGold(this.getGold() + g.getGold());
            System.out.println("You loot " + g.getGold() + " gold");
        }
        if(target instanceof ILeather l){
            this.setLeather(this.getLeather() + l .getLeather());
            System.out.println("You loot " + l.getLeather() + " leather");
        }
    }
}
