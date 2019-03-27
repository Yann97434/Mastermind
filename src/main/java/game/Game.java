package game;

import org.apache.log4j.Logger;
import utils.ReadConfigGame;

import java.io.IOException;
import java.util.Scanner;

public abstract class Game {


    protected int gameMode;
    protected int nbTry;
    protected int devMode;
    Scanner sc = new Scanner(System.in);
    final static Logger log = Logger.getLogger(Game.class);


    public Game() {
        super();
        ReadConfigGame properties = new ReadConfigGame();
        nbTry = Integer.parseInt(properties.getNbTry());
        devMode = properties.getDevMode();
    }


    /**
     * Method for choosing the game mode
     * @return
     */

    public int choiceMode() {

        try {
        log.info("Veuillez choisir un mode de jeu!");
        log.info("1 - Attaquant");
        log.info("2 - Défenseur");
        log.info("3 - Duel");

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
                    log.info("Vous n'avez pas choisi une proposition de la liste");
            }
        } catch (Exception e) {return choiceMode();}


        return gameMode;

    }


    protected abstract int challengerMode();


    protected abstract int defenderMode();


    protected abstract int versusMode() throws IOException;
}
