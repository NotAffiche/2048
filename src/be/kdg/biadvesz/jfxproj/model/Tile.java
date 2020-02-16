package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;

public class Tile {
    private int value;
    private int positionX;
    private int positionY;
    private Color color;

    public int getValue() {
        return this.value;
    }
    public int getPositionX() {
        return this.positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public Color getColor() { return this.color; }
    public void setColor(Color color) { this.color = color; }

    public void valueChange(Tile other) {
        if (other.getValue() == this.value) {
            this.value += other.getValue();
        }
    }

    public Tile(int value, int x, int y, Color color) {
        this.value = value;
        this.positionX = x;
        this.positionY = y;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%d", getValue());
    }
}
