import game.Game;
import game.Mastermind;
import game.MoreOrLess;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private int menuSelection;
    private int gameSelection;
    Scanner sc = new Scanner(System.in);
    private int mode;
    final static Logger log = Logger.getLogger(Menu.class);

    /**
     * Method for displaying the menu
     */

    public void displayMenu() {

        try {

            log.info("Menu");
            log.info("1 - Selectionner un jeux");
            log.info("2 - Rejouer");
            log.info("3 - Quitter");

            menuSelection = sc.nextInt();

            switch (menuSelection) {
                case 1:
                    choiceGame();
                    break;
                case 2:
                    replay();
                    break;
                case 3:
                    quit();
                    break;
                default:
                    log.info("Vous n'avez pas choisi une proposition de la liste!!!");
            }
        } catch (Exception e){ log.info("Une exception à été attrapé!"); displayMenu(); }


    }

    /**
     * Method to choose the game
     */

    public void choiceGame() throws IOException {

        Game game = null;
        try {

            log.info("Veuillez choisir un jeu!");
            log.info("1 - +/-");
            log.info("2 - Mastermind");

            gameSelection = sc.nextInt();

            switch (gameSelection) {
                case 1:
                    game = new MoreOrLess();
                    log.info("Vous avez Choisi le MoreOrLess!");
                    break;
                case 2:
                    game = new Mastermind();
                    log.info("Vous avez choisi le Mastermind!");
                    break;
                default:
                    log.info("Vous n'avez pas choisi une proposition de la liste");
            }
        } catch (Exception e) {choiceGame();}

        if (game != null)
            mode = game.choiceMode();
        displayMenu();

    }

    /**
     * Method to replay a game
     */
    public void replay() {
        MoreOrLess game = new MoreOrLess();
        if (mode == 1) {
            game.challengerMode();
        } else if (mode == 2) {
            game.defenderMode();
        } else {
            game.versusMode();
        }
    }

    /**
     * Method to quit the game
     */
    public void quit() {
        log.info("Merci d'avoir joué!!!");
    }
}
