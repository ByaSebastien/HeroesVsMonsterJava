package org.example.models.characters.Monsters;

import org.example.models.characters.loots.ILeather;
import org.example.utils.Dice;

public class Wolf extends Monster implements ILeather {
    private int leather;

    public Wolf() {
        super(0, 0);
        leather = Dice.D10.throwDice();
    }

    @Override
    public int getLeather() {
        return leather;
    }

    @Override
    public void setLeather(int value) {
        this.leather = leather;
    }
}
