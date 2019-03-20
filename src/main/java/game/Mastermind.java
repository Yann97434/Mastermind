package game;

import org.apache.log4j.Logger;
import utils.ReadConfigGame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public  class   Mastermind extends Game {


    private MastermindCombination combinationMastermind = new MastermindCombination();
    private int nbExtract;
    private int nbExtractAttacker;
    private int nbExtractDefender;
    final static Logger log = Logger.getLogger(Mastermind.class);
    private int count;


    @Override
    public int challengerMode() {
        log.info("Bienvenue dans le mode Challenger de Mastermind!");
        gameMode = 1;
        combinationMastermind.generateCombination();
        /**for (int i = 0; i < combinationMastermind.combinationRandom.size(); i++) {
            combinationMastermind.combinationDefender.add(combinationMastermind.combinationRandom.get(i));
        }*/
        count = nbTry;
        for (int i = 0; i < nbTry; i++) {
            count = count - 1;
            combinationMastermind.writeCombination();
            combinationMastermind.combinationAttacker = new ArrayList<>();
            for (int j = 0; j < combinationMastermind.combinationList.size(); j++) {
                combinationMastermind.combinationAttacker.add(combinationMastermind.combinationList.get(j));
            }
            combinationMastermind.combinationDefender = new ArrayList<>();
            for (Integer a : combinationMastermind.combinationRandom) {
                combinationMastermind.combinationDefender.add(a);
            }
            nbExtract = combinationMastermind.arbitrage(combinationMastermind.combinationAttacker, combinationMastermind.combinationDefender) + combinationMastermind.arbitrage2(combinationMastermind.combinationAttacker, combinationMastermind.combinationDefender);

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

    @Override
    public int defenderMode() {
        log.info("Bienvenue dans le mode Defender de Mastermind!");
        gameMode = 2;
        log.info("Veuillez entrer votre combinaison secrète!");
        combinationMastermind.writeCombination();
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
            System.out.println("Combinaison ordinateur " + combinationMastermind.allCombination.get(0));
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
                log.info("Veuillez réessayer, Il vous reste " + count + " Essais!");;
            }
            List<List<Integer>> tmp2 = new ArrayList<>();/** Stock les valeurs commnunes et mal placés des combinaisons*/
            switch (nbExtract) {
                case 0:
                    combinationMastermind.allCombination = removeUseless(combinationMastermind.combinationAttacker);
                    break;
                case 1:
                    tmp2 = combinationMastermind.extract1(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 1);
                    break;
                case 2:
                    tmp2 = combinationMastermind.extract2(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 2);
                    break;
                case 3:
                    tmp2 = combinationMastermind.extract3(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 3);
                    break;
                case 4:
                    tmp2 = combinationMastermind.extract4(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 4);
                    break;
                case 5:
                    tmp2 = combinationMastermind.extract5(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 5);
                    break;
                case 6:
                    tmp2 = combinationMastermind.extract6(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 6);
                    break;
                case 7:
                    tmp2 = combinationMastermind.extract7(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 7);
                    break;
                case 8:
                    tmp2 = combinationMastermind.extract8(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 8);
                    break;
                case 9:
                    tmp2 = combinationMastermind.extract9(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 9);
                    break;
                default:
                    log.info("Problème!!!!!!!!!");
            }
        }
        log.info("Dommage vous avez perdu!!! la réponse est : " + combinationMastermind.combinationList);

        return 2;

    }


    @Override
    public int versusMode() throws FileNotFoundException {
        log.info("Bienvenue dans le mode Versus de Mastermind!");
        gameMode = 3;
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

        for (int i = 0; i < nbTry; i++) {


            System.out.println("Combinaison ordinateur " + combinationMastermind.allCombination.get(0));
            List<Integer> tmp = new ArrayList<>();/** Stock la combinaison de l'utilisateur et est utiliseé lors de la vérification des valeurs*/
            for (Integer a : combinationMastermind.combinationAttacker) {
                tmp.add(a);
            }
            List<Integer> tampon = new ArrayList<>();/** Stock toutes les combinaisons et est utiliseé lors de la vérification des valeurs*/
            for (Integer a : combinationMastermind.allCombination.get(0)) {
                tampon.add(a);
            }

            nbExtractDefender =  combinationMastermind.arbitrage(tmp, tampon) + combinationMastermind.arbitrage2(tmp, tampon);
            if (nbExtractDefender == tampon.size()) {
                System.out.println("l'ordinateur à trouvé votre combinaison!!!");
                return 2;
            }
            List<List<Integer>> tmp2 = new ArrayList<>();/** Stock les valeurs commnunes et mal placés des combinaisons*/
            switch (nbExtractDefender) {
                case 0:
                    combinationMastermind.allCombination = removeUseless(combinationMastermind.combinationAttacker);
                    break;
                case 1:
                    tmp2 = combinationMastermind.extract1(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 1);
                    break;
                case 2:
                    tmp2 = combinationMastermind.extract2(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 2);
                    break;
                case 3:
                    tmp2 = combinationMastermind.extract3(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 3);
                    break;
                case 4:
                    tmp2 = combinationMastermind.extract4(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 4);
                    break;
                case 5:
                    tmp2 = combinationMastermind.extract5(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 5);
                    break;
                case 6:
                    tmp2 = combinationMastermind.extract6(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 6);
                    break;
                case 7:
                    tmp2 = combinationMastermind.extract7(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 7);
                    break;
                case 8:
                    tmp2 = combinationMastermind.extract8(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 8);
                    break;
                case 9:
                    tmp2 = combinationMastermind.extract9(combinationMastermind.allCombination.get(0));
                    combinationMastermind.allCombination = removeCombination(combinationMastermind.allCombination, tmp2, 9);
                    break;
                default:
                    log.info("Problème!!!!!!!!!");
            }
        }
        return 3;
    }

    public ArrayList<ArrayList<Integer>> removeCombination(ArrayList<ArrayList<Integer>> possibleSolution, List<List<Integer>> tuple, int size) {

        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        possibleSolution.remove(0);
        for (int i = 0; i < possibleSolution.size(); i++) {
            count = 0;
            List<Integer> tmp2 = new ArrayList<>();
            for (int j = 0; j < possibleSolution.get(i).size(); j++) {
                tmp2.add(possibleSolution.get(i).get(j));
            }
            for (List<Integer> j : tuple) {
                for (Integer l : j) {
                    for (int k = 0; k < tmp2.size(); k++) {
                        if (l == tmp2.get(k)) {
                            count++;
                            tmp2.set(k, -1);
                        }
                    }
                }
            }
            if (count >= size && !tmp.contains(possibleSolution.get(i))) {
                tmp.add(possibleSolution.get(i));
                /**!*/
            }
        }
        return tmp;
    }

    private ArrayList<ArrayList<Integer>> removeUseless(ArrayList<Integer> combinationAttacker) {

        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < combinationMastermind.allCombination.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < combinationMastermind.allCombination.get(i).size(); j++) {
                for (int k = 0; k < combinationAttacker.size(); k++) {
                    if (combinationAttacker.get(j) == combinationMastermind.allCombination.get(i).get(j)) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                tmp.add(combinationMastermind.allCombination.get(i));
            }
        }
        return tmp;
    }



}
