import game.Game;
import game.Mastermind;
import game.MoreOrLess;
import java.util.Scanner;

public class Menu {

    private int menuSelection;
    private int gameSelection;
    Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        try {

            System.out.println("Choix menu");
            System.out.println("1 - Selectionner un jeux");
            System.out.println("2 - Jouer");
            System.out.println("3 - Rejouer");
            System.out.println("4 - Quitter");

            menuSelection = sc.nextInt();

            switch (menuSelection) {
                case 1:
                    choiceGame();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    replay();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi une proposition de la liste!!!");
            }
        } catch (Exception e) {displayMenu();}

    }

    public void choiceGame() {

        Game game = null;
        try {

            System.out.println("Veuillez choisir un jeu!");
            System.out.println("1 - +/-");
            System.out.println("2 - Mastermind");

            gameSelection = sc.nextInt();

            switch (gameSelection) {
                case 1:
                    game = new Mastermind();
                    break;
                case 2:
                    game = new MoreOrLess();
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi une proposition de la liste");
            }
        } catch (Exception e) {choiceGame();}

        if (game != null)
            game.choiceMode();
    }

    public void play() {

    }

    public void replay() {

    }

    public void quit() {

    }
}
