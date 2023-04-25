package org.example.models.map;

public enum ContentType {
    empty(" "),
    hero("H"),
    monster("M");

    public String sprite;

    ContentType(String sprite){
        this.sprite = sprite;
    }
}
