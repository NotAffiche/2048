package be.kdg.biadvesz.jfxproj.model.enums;

public enum Color {
    TWO(0xeee4da),
    FOUR(0xede0c8),
    EIGHT(0xf2b179),
    SIXTEEN(0xf59563),
    THIRTYTWO(0xf67c5f),
    SIXTYFOUR(0xf65e3b),
    ONETWENTYEIGHT(0xedcf72),
    TWOFIFTYSIX(0xedcc61),
    FIVETWELVE(0xF0C948),
    TENTWENTYFOUR(0xedc850),
    TWENTYFORTYEIGHT(0xedc53f),
    MOST(0xedc22e);

    private int val;
    Color(int val) {
        this.val = val;
    }
    public int getVal() { return this.val; }
}
