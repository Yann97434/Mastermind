package game;


import java.util.ArrayList;
import java.util.Scanner;

public class MoreOrLess extends Game {

    /**MoreOrLess gameReplay = new MoreOrLess();*/

    private MoreOrLessCombination combination = new MoreOrLessCombination();
    protected ArrayList<Integer> combinationAttacker;
    protected ArrayList<Integer> combinationDefender;
    private int nbTry;
    private String replay;
    Scanner sc = new Scanner(System.in);

    @Override
    protected void challengerMode() {

        System.out.println("Vous avez choisi le mode Challenger !");
        gameMode = 1;
        combination.generateCombination();
        nbTry = 10;

        for (int i = 0; i < 5 ; i++) {
            nbTry = nbTry - 1;
            combination.writeCombination();
            if (combination.analyseCombination() == false) {
                System.out.println("Veuillez réessayer, Il vous reste " + nbTry + " Essais!");
            } else if (nbTry == 0) {
                System.out.println("Dommage vous avez perdu!!! la réponse est : ");
                combination.displayCombination();
            } else {
                System.out.println("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            }
        }

        /**System.out.println("Voulez vous rejouer? oui ou non?");
        replay = sc.next();
        if (replay == "yes") {
            gameReplay.challengerMode();*/
    }



    @Override
    protected void defenderMode() {

        System.out.println("Vous avez choisi le mode Defender !");
        gameMode = 2;
        combination.writeCombination();
        combination.computerCombination();
        nbTry = 10;
        for (int i = 0; i < 10 ; i++) {
            nbTry = nbTry - 1;
            combination.analyseCombination();
            combination.searchResult();
            if (combination.analyseCombination() == true) {
                System.out.println("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            } else {
                System.out.println("Il vous reste " + nbTry + " essais!");
            }
        }
        /**System.out.println("Voulez vous rejouer? oui ou non?");
        replay = sc.next();
        if (replay == "oui") {
            gameReplay.defenderMode();
        }*/
    }

    @Override
    protected void versusMode() {

        gameMode = 3;
        combinationAttacker = new ArrayList<>();
        combinationDefender = new ArrayList<>();


        System.out.println("Vous avez choisi le mode Duel !");

    }


}
