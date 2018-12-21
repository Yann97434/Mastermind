
import game.Mastermind;
import game.MoreOrLess;
import java.util.Scanner;

public class Menu {

    int menuSelection;
    int gameSelection;
    Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        System.out.println("Choix menu");
        System.out.println("1 - Selectionner un jeux");
        System.out.println("2 - Jouer");
        System.out.println("3 - Rejouer");
        System.out.println("4 - Quitter");

        menuSelection = sc.nextInt();

        switch (menuSelection) {
            case 1 :
                choiceGame();
                break;
            case 2 :
                play();
                break;
            case 3 :
                replay();
                break;
            case 4 :
                quit();
                break;
            default:
                System.out.println("Vous n'avez pas choisi une proposition de la liste!!!");
        }
    }

    public void choiceGame() {

        Mastermind mastermind = new Mastermind();
        MoreOrLess moreOrLess = new MoreOrLess();
        System.out.println("Veuillez choisir un jeu!");
        System.out.println("1 - +/-");
        System.out.println("2 - Mastermind");

        gameSelection = sc.nextInt();

        switch (gameSelection) {
            case 1:
                mastermind.choiceMode();
                break;
            case 2:
                moreOrLess.choiceMode();
                break;
            default:
                System.out.println("Vous n'avez pas choisi une proposition de la liste");
        }
    }

    public void play() {

    }

    public void replay() {

    }

    public void quit() {

    }
}
