package game;

import java.util.Scanner;

    public abstract class Game {

    protected int gameMode;
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

    protected abstract void challengerMode();


    protected abstract void defenderMode();


    protected abstract void versusMode();
}
