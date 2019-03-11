package game;

import game.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MoreOrLessCombination extends Combination {


    public MoreOrLessCombination(Random rand, ArrayList<Integer> combinationRandom, ArrayList<Integer> combinationList, ArrayList<String> combinationResultAttacker, ArrayList<String> combinationResultDefender, ArrayList<Integer> combinationAttacker, ArrayList<Integer> combinationDefender, String combinationWrite) {
        super(rand, combinationRandom, combinationList, combinationResultAttacker, combinationResultDefender, combinationAttacker, combinationDefender, combinationWrite);
    }

    public MoreOrLessCombination() {
        super();
    }



    /**
     * Méthode permettant de chercher la combinaison dans le mode challenger et defender de MoreOrLess
     * @return combination equals
     */

    public boolean analyseCombination(int gameMode) {

        result = false;
        /**combinationAttacker = new ArrayList<>();
        combinationDefender = new ArrayList<>();*/
        combinationResultAttacker = new ArrayList<>();
        combinationResultDefender = new ArrayList<>();

        switch (gameMode) {

            case 1:
                for (int i = 0; i < combinationRandom.size(); i++) {
                    if (combinationRandom.get(i) == combinationList.get(i)) {
                        combinationResultAttacker.add("=");
                    } else if (combinationRandom.get(i) < combinationList.get(i)) {
                        combinationResultAttacker.add("-");
                    } else {
                        combinationResultAttacker.add("+");
                    }
                }
                log.info(" -> Réponse : " + combinationResultAttacker);
                break;

            case 2:
                for (int i = 0; i < combinationRandom.size(); i++) {
                    if (combinationRandom.get(i) == combinationList.get(i)) {
                        combinationResultDefender.add("=");
                    } else if (combinationRandom.get(i) < combinationList.get(i)) {
                        combinationResultDefender.add("+");
                    } else {
                        combinationResultDefender.add("-");
                    }
                }
                log.info(" -> Réponse : " + combinationResultDefender);
                break;
        }
        return combinationRandom.equals(combinationList);
    }

    /**
     * Methode permetttant à l'ordinateur de réfléchir comme un humain dans le challenger du MoreOrLess
     * @return combination equals
     */

    public boolean searchResult() {

        nbMin = 1;
        nbMax = 6;
        if (combinationRandom == null) {
            combinationRandom = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                combinationRandom.add(5);
            }
        } else {
            for (int i = 0; i < combinationResultDefender.size(); i++) {
                if (combinationResultDefender.get(i).equals("="));
                else if (combinationResultDefender.get(i).equals("+") && combinationList.get(i) > 5) {
                    nbMax = 10;
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else if (combinationResultDefender.get(i).equals("+") && combinationList.get(i) < 5) {
                    nbMax = 6;
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else combinationRandom.set(i, (combinationRandom.get(i)-nbMin)/2);
            }
        }
        log.info(" -> Réponse : " + combinationResultDefender);
        return combinationRandom.equals(combinationList);
    }

    /**
     * Méthode permettant de comparer les combinaisons du joueur et de l'ordinateur dans le mode Versus de MoreOrLess
     * @return combination equals
     */
    public boolean combinationCompare(){

        /**combinationAttacker = new ArrayList<>();
        combinationDefender = new ArrayList<>();*/
        combinationResultAttacker = new ArrayList<>();
        combinationResultDefender = new ArrayList<>();

        for (int i = 0; i < combinationDefender.size(); i++) {
            if (combinationDefender.get(i) == combinationList.get(i)) {
                combinationResultAttacker.add("=");
            } else if (combinationDefender.get(i) < combinationList.get(i)) {
                combinationResultAttacker.add("-");
            } else {
                combinationResultAttacker.add("+");
            }
        }

        for (int i = 0; i < combinationRandom.size(); i++) {
            if (combinationRandom.get(i) == combinationAttacker.get(i)) {
                combinationResultDefender.add("=");
            } else if (combinationRandom.get(i) < combinationAttacker.get(i)) {
                combinationResultDefender.add("+");
            } else {
                combinationResultDefender.add("-");
            }
        }

        log.info(" -> Réponse Ordinateur : " + combinationResultAttacker);
        log.info(" -> Réponse Joueur : " + combinationResultDefender);

        nbMin = 1;
        nbMax = 6;
        if (combinationRandom == null) {
            combinationRandom = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                combinationRandom.add(5);
            }
        } else {
            for (int i = 0; i < combinationResultDefender.size(); i++) {
                if (combinationResultDefender.get(i).equals("="));
                else if (combinationResultDefender.get(i).equals("+") && combinationList.get(i) > 5) {
                    nbMax = 10;
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else if (combinationResultDefender.get(i).equals("+") && combinationList.get(i) < 5) {
                    nbMax = 6;
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else combinationRandom.set(i, (combinationRandom.get(i)-nbMin)/2);
            }
        }

        return combinationRandom.equals(combinationAttacker) || combinationList.equals(combinationDefender);
    }
}
