package org.example.models.characters.Monsters;

import org.example.models.characters.Heroes.Hero;
import org.example.utils.Dice;

import java.util.Random;

public class MonsterFactory {
    public static Monster generateMonster(Hero hero){
        int rng = Dice.D6.throwDice();
        Monster monster;
        switch (rng){
            case 1:
            case 2:
            case 3:
                monster = new Wolf();
                break;
            case 4:
            case 5:
                monster = new Troll();
                break;
            default:
                monster = new Dragon();
                break;
        }
        monster.addDieSubscriber(() -> hero.loot(monster));
        monster.addDieSubscriber(() -> hero.heal());
        return monster;
    }
}
