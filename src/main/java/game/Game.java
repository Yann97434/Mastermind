package game;

import org.apache.log4j.Logger;
import utils.ReadConfigGame;

import java.io.IOException;
import java.util.Scanner;

public abstract class Game {

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    protected int size;
    protected int gameMode;
    protected int nbTry;
    Scanner sc = new Scanner(System.in);
    final static Logger log = Logger.getLogger(Game.class);

    public Game() {
        super();
        ReadConfigGame properties = new ReadConfigGame();
        nbTry = Integer.parseInt(properties.getNbTry());
    }


    /**
     * Méthode permettant de choisir le mode de jeu
     * @return
     */

    public int choiceMode() throws IOException {


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

        return gameMode;

    }


    protected abstract int challengerMode();


    protected abstract int defenderMode();


    protected abstract int versusMode() throws IOException;
}
