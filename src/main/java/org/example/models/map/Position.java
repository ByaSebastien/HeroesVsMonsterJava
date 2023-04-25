package org.example.models.map;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x,int y){
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || getClass() != o.getClass()) return false;
        Position p = (Position)o;
        return p.x == x && p.y == y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

