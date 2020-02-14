package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;

public class Tile {
    private int value;
    private int positionX;
    private int positionY;
    Color color;

    public int getValue() {
        return value;
    }
    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void valueChange(Tile other) {
        if (other.getValue() == this.value) {
            this.value += other.getValue();
        }
    }

    public Tile(int value, int x, int y) {
        this.value = value;
        this.positionX = x;
        this.positionY = y;
    }

    @Override
    public String toString() {
        return String.format("%d", this.value);
    }
}
