package game;

import org.apache.log4j.Logger;
import java.util.ArrayList;

public class MoreOrLess extends Game {


    private MoreOrLessCombination combinationMoreOrLess = new MoreOrLessCombination();
    final static Logger log = Logger.getLogger(MoreOrLess.class);
    private int count;
    /**
     * Method challenger Mode of MoreOrLess Game
     */
    @Override
    public int challengerMode() {

        log.info("Bienvenue dans le mode Challenger de MoreOrLess!");
        gameMode = 1;
        combinationMoreOrLess.generateCombination();
        if (devMode == 1) {
            combinationMoreOrLess.displayCombination();
        }
        count = nbTry;
        for (int i = 0; i < nbTry; i++) {
            count = count - 1;
            try {
                combinationMoreOrLess.writeCombination();
            } catch (Exception e) {
                System.out.println("Votre combinaison n'est pas valide!!!");
                combinationMoreOrLess.writeCombination();}

            if (count == 0) {
                log.info("Dommage vous avez perdu!!! la réponse est : " + combinationMoreOrLess.combinationRandom);
            } else if (combinationMoreOrLess.analyseCombination(gameMode) == false) {
                log.info("Veuillez réessayer, Il vous reste " + count + " Essais!");
            } else {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            }
        }
        return 1;
    }


    /**
     * Method Defender Mode of MoreOrLess Game
     */

    @Override
    public int defenderMode() {

        log.info("Bienvenue dans le mode Defender de MoreOrLess!");
        gameMode = 2;
        try {
            combinationMoreOrLess.writeCombination();
        } catch (Exception e) {
            System.out.println("Votre combinaison n'est pas valide!!!");
            combinationMoreOrLess.writeCombination();}
        combinationMoreOrLess.computerCombination();
        count = nbTry;
        for (int i = 0; i < nbTry; i++) {
            count = count - 1;
            combinationMoreOrLess.analyseCombination(gameMode);
            combinationMoreOrLess.searchResult();
            if (count == 0) {
                log.info("Dommage vous avez perdu!!! la réponse est : " + combinationMoreOrLess.combinationList);
            } else if (combinationMoreOrLess.searchResult() == false) {
                log.info("Veuillez réessayer, Il vous reste " + count + " Essais!");
            } else {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            }
        }
        return 2;
    }

    /**
     * Method Versus Mode of MoreOrLess Game
     */

    @Override
    public int versusMode() {


        gameMode = 3;
        combinationMoreOrLess.combinationAttacker = new ArrayList<>();
        combinationMoreOrLess.combinationDefender = new ArrayList<>();
        log.info("Bienvenue dans le mode Duel de MoreOrLess!");
        combinationMoreOrLess.generateCombination();
        if (devMode == 1) {
            combinationMoreOrLess.displayCombination();
        }
        for (int i = 0; i < combinationMoreOrLess.combinationRandom.size(); i++) {
            combinationMoreOrLess.combinationDefender.add(combinationMoreOrLess.combinationRandom.get(i));
        }
        log.info("Veuillez entrer votre combinaison secrète!");
        try {
            combinationMoreOrLess.writeCombination();
        } catch (Exception e) {
            System.out.println("Votre combinaison n'est pas valide!!!");
            combinationMoreOrLess.writeCombination();}
        for (int i = 0; i < combinationMoreOrLess.combinationList.size(); i++) {
            combinationMoreOrLess.combinationAttacker.add(combinationMoreOrLess.combinationList.get(i));
        }
        do {
            log.info("A votre tour de jouer");
            combinationMoreOrLess.writeCombination();
            }
        while (combinationMoreOrLess.combinationCompare() == 0);
        if (combinationMoreOrLess.combinationCompare() == 1) {
            log.info("Félicitations vous avez gagné!!!");
        }else {
            log.info("L'ordinateur à gagné!!!");
        }

        return 3;
    }


}
