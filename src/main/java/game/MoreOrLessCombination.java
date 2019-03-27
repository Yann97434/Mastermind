package game;

import java.util.ArrayList;
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
     * Method to search the combination in the challenger and defender mode of MoreOrLess
     * @return true if combiantionRandom == combinationList
     */

    public boolean analyseCombination(int gameMode) {

        result = false;
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
     * Method allowing the computer to think like a human in the challenger mode of MoreOrLess
     * @return true if combiantionRandom == combinationList
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
        return combinationRandom.equals(combinationList);
    }

    /**
     * Méthode permettant de comparer les combinaisons du joueur et de l'ordinateur dans le mode Versus de MoreOrLess
     * @return an int depending on the result
     */
    public int combinationCompare(){

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
        if (isWin(combinationResultAttacker)) {
            return 1;
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
        if (isWin(combinationResultDefender)) {
            return 2;
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

        return 0;
    }

    /**
     * Méthode permettant de retourner une valeur pour le vainqueur
     * @param l is combonationResult of attacker or defender
     * @return true if the combinationResult equals "="
     */
    private boolean isWin (List<String> l ) {

        for (String s : l) {
            if (s.equals("+") || s.equals("-")) {
                return false;
            }
        }
        return true;
    }
}


