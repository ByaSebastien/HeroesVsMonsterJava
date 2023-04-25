package org.example.models.characters.Monsters;

import org.example.models.characters.loots.IGold;
import org.example.models.characters.loots.ILeather;
import org.example.utils.Dice;

public class Dragon extends Monster implements IGold, ILeather {
    private int gold;

    private int leather;

    public Dragon() {
        super(1, 1);
        gold = Dice.D10.throwDice();
        leather = Dice.D10.throwDice();
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
}
