package game;

import org.apache.log4j.Logger;
import utils.ReadConfigGame;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public  class   Mastermind extends Game {



    private MoreOrLessCombination combinationMoreOrLess = new MoreOrLessCombination();
    private MastermindCombination combinationMastermind = new MastermindCombination();
    private int nbExtract;
    final static Logger log = Logger.getLogger(Mastermind.class);


    @Override
    public int challengerMode() {
        log.info("Bienvenue dans le mode Challenger de Mastermind!");
        gameMode = 1;
        combinationMastermind.generateCombination();
        combinationMastermind.combinationDefender = new ArrayList<>();
        for (int i = 0; i < combinationMastermind.combinationRandom.size(); i++) {
            combinationMastermind.combinationDefender.add(combinationMastermind.combinationRandom.get(i));
        }
        for (int i = 0; i < 5 ; i++) {
            nbTry = nbTry - 1;
            combinationMastermind.writeCombination();
            combinationMastermind.combinationAttacker = new ArrayList<>();
            for (int j = 0; j < combinationMastermind.combinationList.size(); j++) {
                combinationMastermind.combinationAttacker.add(combinationMastermind.combinationList.get(j));
            }
            combinationMastermind.valCommun();
            combinationMastermind.wrongPlace();
            if (combinationMastermind.combinationList != combinationMastermind.combinationRandom) {
                log.info("Veuillez réessayer, Il vous reste " + nbTry + " Essais!");
            } else if (nbTry == 0) {
                log.info("Dommage vous avez perdu!!! la réponse est : ");
                combinationMastermind.displayCombination();
            } else {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            }
        }
        return 1;

    }

    @Override
    public int defenderMode() {
        log.info("Bienvenue dans le mode Defender de Mastermind!");
        gameMode = 2;
        log.info("Veuillez entrer votre combinaison secrète!");
        combinationMastermind.writeCombination();
        combinationMastermind.generateCombination();
        try {
            combinationMastermind.listCombination();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        combinationMastermind.combinationAttacker = new ArrayList<>();
        combinationMastermind.combinationDefender = new ArrayList<>();
        for (int i = 0; i < combinationMastermind.combinationRandom.size(); i++) {
            combinationMastermind.combinationDefender.add(combinationMastermind.combinationRandom.get(i));
        }
        for (int i = 0; i < combinationMastermind.combinationList.size(); i++) {
            combinationMastermind.combinationAttacker.add(combinationMastermind.combinationList.get(i));
        }
        nbExtract =  combinationMastermind.valCommun()+ combinationMastermind.wrongPlace();
        switch (nbExtract) {
            case 1:
                combinationMastermind.extract1(combinationMastermind.combinationExtract);
                break;
            case 2:
                combinationMastermind.extract2(combinationMastermind.combinationExtract);
                break;
            case 3:
                combinationMastermind.extract3(combinationMastermind.combinationExtract);
                break;
            case 4:
                combinationMastermind.extract4(combinationMastermind.combinationExtract);
                break;
            case 5:
                combinationMastermind.extract5(combinationMastermind.combinationExtract);
                break;
            case 6:
                combinationMastermind.extract6(combinationMastermind.combinationExtract);
                break;
            case 7:
                combinationMastermind.extract7(combinationMastermind.combinationExtract);
                break;
            case 8:
                combinationMastermind.extract8(combinationMastermind.combinationExtract);
                break;
            case 9:
                combinationMastermind.extract9(combinationMastermind.combinationExtract);
                break;
            default:
                log.info("Problème!!!!!!!!!");
        }
        combinationMastermind.removeCombination();
        for (int i = 0; i < 10 ; i++) {
            nbTry = nbTry - 1;
            combinationMoreOrLess.analyseCombination(gameMode);
            combinationMoreOrLess.searchResult();
            if (combinationMoreOrLess.analyseCombination(gameMode) == true) {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
            } else {
                log.info("Il vous reste " + nbTry + " essais!");
            }
        }
        return 2;

    }

    @Override
    public int versusMode() throws FileNotFoundException {
        log.info("Bienvenue dans le mode Versus de Mastermind!");
        gameMode = 3;
        combinationMastermind.generateCombination();
        combinationMastermind.listCombination();
        combinationMastermind.combinationAttacker = new ArrayList<>();
        combinationMastermind.combinationDefender = new ArrayList<>();
        for (int i = 0; i < combinationMastermind.combinationRandom.size(); i++) {
            combinationMastermind.combinationDefender.add(combinationMastermind.combinationRandom.get(i));
        }
        log.info("Veuillez entrer votre combinaison secrète!");
        combinationMastermind.writeCombination();
        for (int i = 0; i < combinationMastermind.combinationList.size(); i++) {
            combinationMastermind.combinationAttacker.add(combinationMastermind.combinationList.get(i));
        }
        nbExtract =  combinationMastermind.valCommun()+ combinationMastermind.wrongPlace();
        switch (nbExtract) {
            case 1:
                combinationMastermind.extract1(combinationMastermind.combinationExtract);
                break;
            case 2:
                combinationMastermind.extract2(combinationMastermind.combinationExtract);
                break;
            case 3:
                combinationMastermind.extract3(combinationMastermind.combinationExtract);
                break;
            case 4:
                combinationMastermind.extract4(combinationMastermind.combinationExtract);
                break;
            case 5:
                combinationMastermind.extract5(combinationMastermind.combinationExtract);
                break;
            case 6:
                combinationMastermind.extract6(combinationMastermind.combinationExtract);
                break;
            case 7:
                combinationMastermind.extract7(combinationMastermind.combinationExtract);
                break;
            case 8:
                combinationMastermind.extract8(combinationMastermind.combinationExtract);
                break;
            case 9:
                combinationMastermind.extract9(combinationMastermind.combinationExtract);
                break;
            default:
                log.info("Problème!!!!!!!!!");
        }
        combinationMastermind.removeCombination();
        return 3;
    }


}
