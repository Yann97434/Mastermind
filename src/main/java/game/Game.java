package game;

import java.util.Scanner;

public class Game {

    int gameMode;
    Scanner sc = new Scanner(System.in);


    public void choiceMode() {

        System.out.println("Veuillez choisir un mode de jeu!");
        System.out.println("1 - Attaquant");
        System.out.println("2 - Défenseur");
        System.out.println("3 - Duel");

        gameMode = sc.nextInt();

        switch (gameMode) {
            case 1:
                challengerMode();
                break;
            case 2:
                defenderMode();
                break;
            case 3:
                versusMode();
                break;
            default:
                System.out.println("Vous n'avez pas choisi une proposition de la liste");
        }


    }

    public void challengerMode() {

    }

    public void defenderMode() {

    }

    public void versusMode() {

    }
}
