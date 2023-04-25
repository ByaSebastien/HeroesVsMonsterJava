package org.example.utils;

import java.util.*;

public enum Dice {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    D100(100);

    private final int diceValue;

    Dice(int value){
        diceValue = value;
    }

    public int throwDice(){
        return throwDice(1,1);
    }

    public int throwDice(int nbThrows){
        return throwDice(nbThrows,1);
    }

    public int throwDice(int nbThrows, int nbToKeep){
        Random rnd = new Random();

        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < nbThrows; i++){
            results.add(rnd.nextInt(diceValue) + 1);
        }

        return results.stream()
                .sorted(Comparator.reverseOrder())
                .limit(nbToKeep)
                .mapToInt(it -> it)
                .sum();
    }
}
