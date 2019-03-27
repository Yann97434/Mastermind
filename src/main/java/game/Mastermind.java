package game;

import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public  class   Mastermind extends Game {


    private MastermindCombination combinationMastermind = new MastermindCombination();
    private int nbExtract;
    private int nbExtractAttacker;
    private int nbExtractDefender;
    final static Logger log = Logger.getLogger(Mastermind.class);
    private int count;


    /**
     * Method challenger Mode of Mastermind Game
     */

    @Override
    public int challengerMode() {
        log.info("Bienvenue dans le mode Challenger de Mastermind!");
        gameMode = 1;
        combinationMastermind.generateCombination();
        if (devMode == 1) {
            combinationMastermind.displayCombination();
        }
        count = nbTry;
        for (int i = 0; i < nbTry; i++) {
            count = count - 1;
            try {
                combinationMastermind.writeCombination();
            } catch (Exception e) {
                System.out.println("Votre combinaison n'est pas valide!!!");
                combinationMastermind.writeCombination();}

            combinationMastermind.combinationDefender = new ArrayList<>();
            for (Integer a : combinationMastermind.combinationRandom) {
                combinationMastermind.combinationDefender.add(a);
            }
            nbExtract = combinationMastermind.arbitrage(combinationMastermind.combinationList, combinationMastermind.combinationDefender) + combinationMastermind.arbitrage2(combinationMastermind.combinationAttacker, combinationMastermind.combinationDefender);

            if (nbExtract == combinationMastermind.combinationRandom.size()) {
                log.info("Félicitations vous avez trouvé la bonne combinaison!!!");
                break;
            } else if (count == 0) {
                log.info("Dommage vous avez perdu!!! la réponse est : " + combinationMastermind.combinationRandom);
                break;
            } else {
                log.info("Veuillez réessayer, Il vous reste " + count + " Essais!");
            }
        }
        return 1;

    }

    /**
     * Method defender Mode of Mastermind Game
     */

    @Override
    public int defenderMode() {
        log.info("Bienvenue dans le mode Defender de Mastermind!");
        gameMode = 2;
        log.info("Veuillez entrer votre combinaison secrète!");
        try {
            combinationMastermind.writeCombination();
        } catch (Exception e) {
            System.out.println("Votre combinaison n'est pas valide!!!");
            combinationMastermind.writeCombination();}
        try {
            combinationMastermind.listCombination();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        combinationMastermind.combinationAttacker = new ArrayList<>(); /** sert à stocker la combinaison secrète de l'utilisateur*/

        for (int i = 0; i < combinationMastermind.combinationList.size(); i++) {
            combinationMastermind.combinationAttacker.add(combinationMastermind.combinationList.get(i));
        }
        count = nbTry;
        for (int i = 0; i < nbTry; i++) {
            count = count - 1;
            log.info("Combinaison ordinateur " + combinationMastermind.allCombination.get(0));
            List<Integer> tmp = new ArrayList<>();/** Stock la combinaison de l'utilisateur et est utiliseé lors de la vérification des valeurs*/
            for (Integer a : combinationMastermind.combinationAttacker) {
                tmp.add(a);
            }
            List<Integer> tampon = new ArrayList<>();/** Stock toutes les combinaisons et est utiliseé lors de la vérification des valeurs*/
            for (Integer a : combinationMastermind.allCombination.get(0)) {
                tampon.add(a);
            }
            nbExtract =  combinationMastermind.arbitrage(tmp, tampon) + combinationMastermind.arbitrage2(tmp, tampon);
            if (nbExtract == tampon.size()) {
                System.out.println("l'ordinateur à trouvé votre combinaison!!!");
                return 2;
            } else {
                log.info("Veuillez réessayer, Il vous reste " + count + " Essais!");
            }
            List<List<Integer>> tmp2 = new ArrayList<>();/** Stock les valeurs commnunes et mal placés des combinaisons*/
            switch (nbExtract) {
                case 0:
                    combinationMastermind.allCombination = combinationMastermind.removeUseless(combinationMastermind.allCombination.get(0));
                    break;
                case 1:
                    tmp2 = combinationMastermind.extract1(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 1);
                    break;
                case 2:
                    tmp2 = combinationMastermind.extract2(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 2);
                    break;
                case 3:
                    tmp2 = combinationMastermind.extract3(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 3);
                    break;
                case 4:
                    tmp2 = combinationMastermind.extract4(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 4);
                    break;
                case 5:
                    tmp2 = combinationMastermind.extract5(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 5);
                    break;
                case 6:
                    tmp2 = combinationMastermind.extract6(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 6);
                    break;
                case 7:
                    tmp2 = combinationMastermind.extract7(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 7);
                    break;
                case 8:
                    tmp2 = combinationMastermind.extract8(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 8);
                    break;
                case 9:
                    tmp2 = combinationMastermind.extract9(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 9);
                    break;
                default:
                    log.info("Problème!!!!!!!!!");
            }
        }
        log.info("Dommage vous avez perdu!!! la réponse est : " + combinationMastermind.combinationList);

        return 2;

    }


    /**
     * Method versus Mode of Mastermind Game
     */

    @Override
    public int versusMode() throws FileNotFoundException {
        log.info("Bienvenue dans le mode Versus de Mastermind!");
        gameMode = 3;
        combinationMastermind.generateCombination();
        if (devMode == 1) {
            combinationMastermind.displayCombination();
        }
        combinationMastermind.listCombination();
        combinationMastermind.combinationAttacker = new ArrayList<>();
        combinationMastermind.combinationDefender = new ArrayList<>();
        for (int i = 0; i < combinationMastermind.combinationRandom.size(); i++) {
            combinationMastermind.combinationDefender.add(combinationMastermind.combinationRandom.get(i));
        }
        log.info("Veuillez entrer votre combinaison secrète!");
        try {
            combinationMastermind.writeCombination();
        } catch (Exception e) {
            System.out.println("Votre combinaison n'est pas valide!!!");
            combinationMastermind.writeCombination();}
        for (int i = 0; i < combinationMastermind.combinationList.size(); i++) {
            combinationMastermind.combinationAttacker.add(combinationMastermind.combinationList.get(i));
        }

        for (int i = 0; i < nbTry; i++) {

            log.info("A vous de jouer!");
            try {
                combinationMastermind.writeCombination();
            } catch (Exception e) {
                System.out.println("Votre combinaison n'est pas valide!!!");
                combinationMastermind.writeCombination();}
            for (int j = 0; j < combinationMastermind.combinationRandom.size(); j++) {
                combinationMastermind.combinationDefender.add(combinationMastermind.combinationRandom.get(j));
            }
            log.info("Joueur : ");
            nbExtractAttacker = combinationMastermind.arbitrage(combinationMastermind.combinationList, combinationMastermind.combinationDefender) + combinationMastermind.arbitrage2(combinationMastermind.combinationList, combinationMastermind.combinationDefender);
            if (nbExtractAttacker == combinationMastermind.combinationRandom.size()) {
                log.info("Vous avez trouvé la combinaison de l'ordinateur!!!");
                return 2;
            }
            System.out.println("Combinaison ordinateur " + combinationMastermind.allCombination.get(0));
            List<Integer> tmp = new ArrayList<>();/** Stock la combinaison de l'utilisateur et est utiliseé lors de la vérification des valeurs*/
            for (Integer a : combinationMastermind.combinationAttacker) {
                tmp.add(a);
            }
            List<Integer> tampon = new ArrayList<>();/** Stock toutes les combinaisons et est utiliseé lors de la vérification des valeurs*/
            for (Integer a : combinationMastermind.allCombination.get(0)) {
                tampon.add(a);
            }
            log.info("Ordinateur : ");
            nbExtractDefender =  combinationMastermind.arbitrage(tmp, tampon) + combinationMastermind.arbitrage2(tmp, tampon);
            if (nbExtractDefender == tampon.size()) {
                log.info("l'ordinateur à trouvé votre combinaison!!!");
                return 2;
            }
            List<List<Integer>> tmp2 = new ArrayList<>();/** Stock les valeurs commnunes et mal placés des combinaisons*/
            switch (nbExtractDefender) {
                case 0:
                    combinationMastermind.allCombination = combinationMastermind.removeUseless(combinationMastermind.allCombination.get(0));
                    break;
                case 1:
                    tmp2 = combinationMastermind.extract1(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 1);
                    break;
                case 2:
                    tmp2 = combinationMastermind.extract2(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 2);
                    break;
                case 3:
                    tmp2 = combinationMastermind.extract3(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 3);
                    break;
                case 4:
                    tmp2 = combinationMastermind.extract4(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 4);
                    break;
                case 5:
                    tmp2 = combinationMastermind.extract5(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 5);
                    break;
                case 6:
                    tmp2 = combinationMastermind.extract6(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 6);
                    break;
                case 7:
                    tmp2 = combinationMastermind.extract7(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 7);
                    break;
                case 8:
                    tmp2 = combinationMastermind.extract8(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 8);
                    break;
                case 9:
                    tmp2 = combinationMastermind.extract9(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = combinationMastermind.removeCombination(combinationMastermind.allCombination, tmp2, 9);
                    break;
                default:
                    log.info("Problème!!!!!!!!!");
            }
        }
        return 3;
    }




}
