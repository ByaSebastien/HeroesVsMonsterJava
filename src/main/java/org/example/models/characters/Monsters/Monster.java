package org.example.models.characters.Monsters;

import org.example.models.characters.Entity;
import org.example.models.map.ContentType;

public abstract class Monster extends Entity {
    public Monster(int strength, int stamina) {
        super(strength, stamina);
    }

    @Override
    public ContentType getSprite(){
        return ContentType.monster;
    }
}
