package org.example.models.map;

public class Cell {
    private ContentType content;

    public Cell(){
        content = ContentType.empty;
    }

    public ContentType getContent() {
        return content;
    }

    public void setContent(ContentType content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content.sprite;
    }
}
