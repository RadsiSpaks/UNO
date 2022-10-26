package com.test.may;

// the class responsible for the playing card

public class PlayingCard {

    // values

    public Colors color;
    public int number;
    public boolean addTwo;
    public boolean addFour;
    public boolean switchColor;
    public boolean reverse;
    public boolean pass;

    PlayingCard (Colors color, Integer number, boolean addTwo, boolean addFour, boolean switchColor, boolean reverse, boolean pass) {

        // set values

        this.color = color;
        this.number = number;
        this.addTwo = addTwo;
        this.addFour = addFour;
        this.switchColor = switchColor;
        this.reverse = reverse;
        this.pass = pass;
    }
}