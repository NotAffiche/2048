package be.kdg.biadvesz.jfxproj.model;

import be.kdg.biadvesz.jfxproj.model.enums.Color;
import javafx.scene.control.Label;

public class Tile extends Label {
    //ATTRIB
    private int value;
    private int positionX;
    private int positionY;
    private Color color;

    //GET & SET
    public int getValue() { return this.value; }
    public int getPositionX() { return this.positionX; }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setColor(int val) { setColorByVal(val); }

    //CTOR
    public Tile(int value, int x, int y) {
        this.value = value;
        this.positionX = x;
        this.positionY = y;
        setColor(value);
    }

    //OVERRIDE
    @Override
    public String toString() {
        return String.format("%d", getValue());
    }

    //METHODS
    public void valueChange(Tile other) {
        if (other.getValue() == this.value) {
            this.value += other.getValue();
            setColor(this.getValue());
        }
    }
    //gives color to tile according to tile value
    private void setColorByVal(int val) {
        switch (val) {
            case 2:
                this.setColor(Color.TWO);
                break;
            case 4:
                this.setColor(Color.FOUR);
                break;
            case 8:
                this.setColor(Color.EIGHT);
                break;
            case 16:
                this.setColor(Color.SIXTEEN);
                break;
            case 32:
                this.setColor(Color.THIRTYTWO);
                break;
            case 64:
                this.setColor(Color.SIXTYFOUR);
                break;
            case 128:
                this.setColor(Color.ONETWENTYEIGHT);
                break;
            case 256:
                this.setColor(Color.TWOFIFTYSIX);
                break;
            case 512:
                this.setColor(Color.FIVETWELVE);
                break;
            case 1024:
                this.setColor(Color.TENTWENTYFOUR);
                break;
            case 2048:
                this.setColor(Color.TWENTYFORTYEIGHT);
                break;
            default:
                this.setColor(Color.MOST);
                break;
        }
    }
}
