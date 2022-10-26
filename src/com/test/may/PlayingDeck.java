package com.test.may;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class PlayingDeck {

    public List<PlayingCard> list = new LinkedList<>();
    public static Colors nowColor;

    PlayingDeck () {

        Colors [ ] colors = { Colors.RED, Colors.GREEN, Colors.BLUE, Colors.YELLOW };

        addRegularCards(colors);
        addUnusualCards(colors);
    }

    private void addRegularCards(Colors[] colors) {

        for (int num = 0; num < 10; num++) {

            for (Colors color : colors) {

                PlayingCard playingCard = new PlayingCard(color, num, false, false, false, false, false);

                list.add(playingCard);
                list.add(playingCard);
            }
        }
    }

    private void addUnusualCards(Colors[] colors) {

        for (Colors color2 : colors) {

            PlayingCard addTwo = new PlayingCard(color2, -1, true, false, false, false, false);
            PlayingCard reverse = new PlayingCard(color2, -1, false, false, false, true, false);
            PlayingCard pass = new PlayingCard(color2, -1, false, false, false, false, true);

            for (int i = 0; i < 2; i++) {

                list.add(addTwo);
                list.add(reverse);
                list.add(pass);
            }
        }

        PlayingCard switchColor = new PlayingCard(null, -1, false, false, true, false, false);
        PlayingCard addFour = new PlayingCard(null, -1, false, true, false, false, false);

        for (int i = 0; i < 4; i++) {

            list.add(addFour);
            list.add(switchColor);
        }
    }

    public void sort() {

        Collections.shuffle(list);
    }
}
