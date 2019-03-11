package game;


import org.apache.log4j.Logger;

import java.util.ArrayList;

public class MoreOrLess extends Game {


    private MoreOrLessCombination combinationMoreOrLess = new MoreOrLessCombination();
    final static Logger log = Logger.getLogger(MoreOrLess.class);

    /**
     * Méthode challenger Mode of MoreOrLess Game
     */
    @Override
    public int challengerMode() {

        log.info("Bienvenue dans le mode Challenger de MoreOrLess!");
        gameMode = 1;
        combinationMoreOrLess.generateCombination();

        for (int i = 0; i < 5 ; i++) {
            nbTry = nbTry - 1;
            combinationMoreOrLess.writeCombination();
            if (combinationMoreOrLess.analyseCombination(gameMode) == false) {
                log.info("Veuillez réessayer, Il vous reste " + nbTry + " Essais!");
            } else if (nbTry == 0) {
                log.info("Dommage vous avez perdu!!! la réponse est : ");
                combinationMoreOrLess.displayCombination();
            } else {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            }
        }
        return 1;
    }


    /**
     * Méthode Defender Mode of MoreOrLess Game
     */

    @Override
    public int defenderMode() {

        log.info("Bienvenue dans le mode Defender de MoreOrLess!");
        gameMode = 2;
        combinationMoreOrLess.writeCombination();
        combinationMoreOrLess.computerCombination();
        for (int i = 0; i < 10 ; i++) {
            nbTry = nbTry - 1;
            combinationMoreOrLess.analyseCombination(gameMode);
            combinationMoreOrLess.searchResult();
            if (combinationMoreOrLess.analyseCombination(gameMode) == true) {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            } else {
                log.info("Il vous reste " + nbTry + " essais!");
            }
        }
        return 2;
    }

    /**
     * Méthode Versus Mode of MoreOrLess Game
     */

    @Override
    public int versusMode() {

        int turn = 0;
        gameMode = 3;
        combinationMoreOrLess.combinationAttacker = new ArrayList<>();
        combinationMoreOrLess.combinationDefender = new ArrayList<>();
        log.info("Bienvenue dans le mode Duel de MoreOrLess!");
        combinationMoreOrLess.generateCombination();
        for (int i = 0; i < combinationMoreOrLess.combinationRandom.size(); i++) {
            combinationMoreOrLess.combinationDefender.add(combinationMoreOrLess.combinationRandom.get(i));
        }
        log.info("Veuillez entrer votre combinaison secrète!");
        combinationMoreOrLess.writeCombination();
        for (int i = 0; i < combinationMoreOrLess.combinationList.size(); i++) {
            combinationMoreOrLess.combinationAttacker.add(combinationMoreOrLess.combinationList.get(i));
        }
        do {
            log.info("A votre tour de jouer");
            combinationMoreOrLess.writeCombination();
            }
        while (combinationMoreOrLess.combinationCompare() == false) ;
        return 3;
    }


}
