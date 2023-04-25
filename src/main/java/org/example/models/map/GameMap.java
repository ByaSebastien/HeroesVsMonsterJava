package org.example.models.map;

import org.example.models.characters.Heroes.Hero;
import org.example.models.characters.Monsters.Monster;
import org.example.models.characters.Monsters.MonsterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMap {
    private Hero hero;

    private final int width = 10;
    private final int height = 10;

    private final Map<Position, Monster> monsters = new HashMap<Position,Monster>();

    private final Cell[][] contents = new Cell[width][height];


    public GameMap(Hero hero){
        initMap(hero);
        generateMonsters();
    }

    public Monster getMonster(Position position){
        Monster m = monsters.get(position);
        return monsters.get(position);
    }
    public Cell getContent(Position position){
        int x = position.getX();
        int y = position.getY();
        return contents[x][y];
    }
    public Cell getContent(int x,int y) {
        return contents[x][y];
    }

    public boolean isOut(Position position){
        int x = position.getX();
        int y = position.getY();
        return (x < 0 || x >= width || y < 0 || y >= height);
    }

    public void removeMonster(Position position){
        int x = position.getX();
        int y = position.getY();
        contents[x][y].setContent(ContentType.empty);
        monsters.remove(position);
    }
    private void initMap(Hero hero){
        this.hero = hero;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                contents[i][j] = new Cell();
            }
        }
        this.hero.setPosition(new Position(4,4));
        contents[4][4].setContent(ContentType.hero);
    }

    private void generateMonsters(){
        Position position;
        Random rnd = new Random();
        for (int i = 0; i < 10; i++){
            Monster monster = MonsterFactory.generateMonster(this.hero);
            do{
                position = new Position(rnd.nextInt(width),rnd.nextInt(height));
            }while (contents[position.getX()][position.getY()].getContent() != ContentType.empty);
            monster.setPosition(position);
            monsters.put(position,monster);
            contents[position.getX()][position.getY()].setContent(ContentType.monster);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++){
            sb.append("| ");
            for (int j = 0; j < height; j++){
                sb.append(contents[i][j]).append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
