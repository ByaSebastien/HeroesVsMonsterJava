package org.example.models.properties;

import org.example.utils.Dice;

import java.util.HashMap;
import java.util.Map;

public class Stat {
    private final Map<StatType,Integer> stats = new HashMap<StatType, Integer>();

    public Map<StatType,Integer> getStats() {return stats ;}

    public Integer getStat(StatType type){
        if(!stats.containsKey(type))
            return  0;
        return stats.get(type);
    }

    public void setStat(StatType type,Integer value){
        stats.put(type,value);
    }

    public void generate(int strength, int stamina){
        setStat(StatType.strength,Dice.D6.throwDice(5,4) + strength);
        setStat(StatType.stamina,Dice.D6.throwDice(5,4) + stamina);
        setStat(StatType.maxHp,getStat(StatType.stamina) + modifier(StatType.stamina));
        applyModifier();
    }

    public void applyModifier(){
        for(StatType stat : StatType.values()){
            setStat(stat, getStat(stat) + modifier(stat));
        }
    }

    public int modifier(StatType stat){
        if(getStat(stat) > 15) return 3;
        if(getStat(stat) > 10) return 2;
        if(getStat(stat) > 5) return 1;
        return 0;
    }
}
