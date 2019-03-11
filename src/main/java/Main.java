import game.Game;
import game.Mastermind;
import game.MoreOrLess;


import org.apache.log4j.Logger;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);
    Game jeu = new MoreOrLess();
    public static void main(String[] args) {
        log.info("Lancement du jeu");
        Menu menu = new Menu();
        menu.displayMenu();

    }
}
