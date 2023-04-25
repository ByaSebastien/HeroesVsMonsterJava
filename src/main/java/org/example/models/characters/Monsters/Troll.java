package org.example.models.characters.Monsters;

import org.example.models.characters.loots.IGold;
import org.example.utils.Dice;

public class Troll extends Monster implements IGold {
    private int gold;

    public Troll() {
        super(1, 0);
        gold = Dice.D10.throwDice();
    }

    @Override
    public int getGold(){
        return gold;
    }

    @Override
    public void setGold(int value){
        this.gold = value;
    }
}
