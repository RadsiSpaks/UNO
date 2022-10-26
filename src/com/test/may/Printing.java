package com.test.may;

import java.util.List;

public class Printing {

    private static void setColor(PlayingCard card) {

        switch (card.color) {

            case RED:

                System.out.print(Values.ANSI_RED);
                break;

            case BLUE:

                System.out.print(Values.ANSI_BLUE);
                break;

            case GREEN:

                System.out.print(Values.ANSI_GREEN);
                break;

            case YELLOW:

                System.out.print(Values.ANSI_YELLOW);
                break;

            case null:

                System.out.print(Values.ANSI_BLACK);
                break;
        }
    }

    private static void printCard(PlayingCard card) {

        setColor(card);

        if (card.number != -1) {

            System.out.println("#######");
            System.out.println("#     #");
            System.out.println("#  " + card.number + "  #");
            System.out.println("#     #");
            System.out.println("#######");
        }

        else {

            if (card.addTwo) {

                System.out.println("#######");
                System.out.println("#     #");
                System.out.println("# +2  #");
                System.out.println("#     #");
                System.out.println("#######");
            }

            else if (card.addFour) {

                System.out.println("#######");
                System.out.println("#     #");
                System.out.println("# +4  #");
                System.out.println("#     #");
                System.out.println("#######");
            }

            else if (card.switchColor) {

                System.out.println("#######");
                System.out.println("#     #");
                System.out.println("# RGB #");
                System.out.println("#     #");
                System.out.println("#######");
            }

            else if (card.reverse) {

                System.out.println("#######");
                System.out.println("#     #");
                System.out.println("# REV #");
                System.out.println("#     #");
                System.out.println("#######");
            }

            else if (card.pass) {

                System.out.println("#######");
                System.out.println("#     #");
                System.out.println("#  ╳  #");
                System.out.println("#     #");
                System.out.println("#######");
            }
        }
    }

    public static void printDeck(List<PlayingCard> deck) {

        System.out.println("Поле:");

        int iNum = 0;

        for (PlayingCard i : deck) {

            iNum++;

            if (iNum == deck.size()) {

                printCard(i);
            }

            else {

                setColor(i);
                System.out.println("#######");
            }
        }
    }

    public static void printPlayerDeck(List<PlayingCard> deck) {

        int iNum = 0;

        for (PlayingCard i : deck) {

            iNum++;

            printCard(i);
            // System.out.println("\n" + iNum + "\n");
            System.out.println(iNum);
        }
    }
}
