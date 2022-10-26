package com.test.may;

// the class where the program logic is written

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<PlayingCard> deck = new ArrayList<>();

    public static PlayingDeck playingDeck = new PlayingDeck();

    public static void main(String[] args) {

        playingDeck.sort();

        Person person1 = new Person(playingDeck, "Ваня");
        Person person2 = new Person(playingDeck, "Папа");

        Scanner input = new Scanner(System.in);

        while (true) {

            if (person1.list.size() == 1) {

                System.out.println("Игрок " + person1.name + " сказал \"УНО\"?\n1.Да\n2.Нет");

                int num = input.nextInt();

                boolean pass = false;

                switch (num) {

                    case 1:

                        break;

                    case 2:

                        for (int i = 0; i < 4; i++) {

                            person2.list.add(playingDeck.list.get(0));
                            playingDeck.list.remove(0);
                        }

                        break;

                    default:

                        System.out.println("Неправильный ввод!");
                        pass = true;

                        break;
                }

                if (pass) {

                    continue;
                }

            } else if (person2.list.size() == 1) {

                System.out.println("Игрок " + person2.name + " сказал \"УНО\"?\n\n1.Да\n2.Нет");

                int num = input.nextInt();

                boolean pass = false;

                switch (num) {

                    case 1:

                        break;

                    case 2:

                        for (int i = 0; i < 4; i++) {

                            person1.list.add(playingDeck.list.get(0));
                            playingDeck.list.remove(0);
                        }

                        break;

                    default:

                        System.out.println("Неправильный ввод!");
                        pass = true;

                        break;
                }

                if (pass) {

                    continue;
                }
            }

            if (person1.list.size() == 0) {

                System.out.println("Игрок " + person1.name + " выиграл!");
                break;

            } else if (person2.list.size() == 0) {

                System.out.println("Игрок " + person2.name + " выиграл!");
                break;

            }

            personChoice(person1, person2);

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            input.nextLine();

            personChoice(person2, person1);

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            input.nextLine();
        }
    }

    public static void personChoice(Person person, Person person2) {

        Printing.printPlayerDeck(person.list);
        Printing.printDeck(deck);

        System.out.println("Ход игрока " + person.name);

        PlayingCard personChoice = person.remove(deck);

        if (personChoice != null) {

            deck.add(personChoice);

            if (personChoice.reverse || personChoice.pass) {

                personChoice(person, person2);

            } else if (personChoice.addTwo) {

                for (int i = 0; i < 2; i++) {

                    person2.list.add(playingDeck.list.get(0));
                    playingDeck.list.remove(0);
                }

                personChoice(person, person2);

            } else if (personChoice.addFour) {

                Colors [ ] colors = { Colors.RED, Colors.GREEN, Colors.BLUE, Colors.YELLOW };

                System.out.println(Arrays.toString(colors));

                Scanner input = new Scanner(System.in);
                int number = input.nextInt() - 1;

                try {

                    PlayingDeck.nowColor = colors[number];

                } catch (Exception e) {

                    personChoice(person, person2);
                }

                for (int i = 0; i < 4; i++) {

                    person2.list.add(playingDeck.list.get(0));
                    playingDeck.list.remove(0);
                }

            } else if (personChoice.switchColor) {

                Colors [ ] colors = { Colors.RED, Colors.GREEN, Colors.BLUE, Colors.YELLOW };

                System.out.println(Arrays.toString(colors));

                Scanner input = new Scanner(System.in);
                int number = input.nextInt() - 1;

                try {

                    PlayingDeck.nowColor = colors[number];

                } catch (Exception e) {

                    personChoice(person, person2);
                }

                for (int i = 0; i < 4; i++) {

                    person2.list.add(playingDeck.list.get(0));
                    playingDeck.list.remove(0);
                }
            }

        } else {

            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }
}
