package com.test.may;

import java.util.*;

public class Person {

    List<PlayingCard> list = new LinkedList<>();
    public String name;

    Person (PlayingDeck playingDeck, String name) {

        this.name = name;

        for (int i = 0; i < 7; i++) {

            list.add(playingDeck.list.get(0));
            playingDeck.list.remove(0);
        }
    }

    public PlayingCard remove(List<PlayingCard> deck) {

        boolean pass = true;

        if (Main.deck.size() != 0) {

            pass = canMove();
        }

        if (pass) {

            Scanner input = new Scanner(System.in);
            int num;

            try {

                num = input.nextInt() -1;

            } catch (InputMismatchException e) {

                System.out.println("Ведите число!");
                return remove(deck);
            }

            PlayingCard returnValue = list.get(num);

            if (deck.size() != 0) {

                if (test(returnValue, deck.get(Main.deck.size() - 1))) {

                    try {

                        list.remove(num);
                        return returnValue;

                    } catch (IndexOutOfBoundsException e) {

                        System.out.println("Введите номер карты!");
                        return remove(deck);
                    }

                } else {

                    System.out.println("Положите карту правильно!");
                    return remove(deck);
                }

            } else {

                try {

                    list.remove(num);
                    return returnValue;

                } catch (IndexOutOfBoundsException e2) {

                    System.out.println("Введите номер карты!");
                    return remove(deck);
                }
            }

        } else {

            return null;
        }
    }

    public static boolean test(PlayingCard playingCard1, PlayingCard playingCard2) {

        if (playingCard1.color == playingCard2.color) {

            return true;

        } else if (playingCard1.number == playingCard2.number) {

            return true;

        } else if (playingCard1.addTwo && playingCard2.addTwo) {

            return true;

        } else if (playingCard1.addFour) {

            return true;

        } else {

            return playingCard1.switchColor;

        }
    }

    private boolean canMove() {

        boolean pass = true;

        for (PlayingCard i : list) {

            if (test(i, Main.deck.get(Main.deck.size() - 1))) {

                pass = false;
                break;
            }
        }

        if (pass) {

            System.out.println("Не хватает карт!");

            PlayingCard _new = Main.playingDeck.list.get(0);

            list.add(_new);
            Main.playingDeck.list.remove(0);

            if (test(_new, Main.deck.get(Main.deck.size() - 1))) {

                System.out.println("Вы положили новую карту.");

            } else {

                System.out.println("Ход противника.");
            }

            return false;
        }

        return true;
    }
}
