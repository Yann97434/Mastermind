package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MoreOrLessCombination extends Combination {


    public MoreOrLessCombination(Random rand, ArrayList<Integer> combinationRandom, ArrayList<Integer> combinationList, ArrayList<String> combinationResult, String combinationWrite, boolean result) {
        super(rand, combinationRandom, combinationList, combinationResult, combinationWrite, result);
    }


    public MoreOrLessCombination() {
        super();
    }

    MoreOrLess game = new MoreOrLess();

    public boolean analyseCombination() {

        result = false;
        String symbol;
        String newLine = System.getProperty("line.separator");
        combinationResult = new ArrayList<>();

        switch (game.gameMode) {

            case 1:
                for (int i = 0; i < combinationRandom.size(); i++) {
                    if (combinationRandom.get(i) == combinationList.get(i)) {
                        combinationResult.add("=");
                    } else if (combinationRandom.get(i) < combinationList.get(i)) {
                        combinationResult.add("-");
                    } else {
                        combinationResult.add("+");
                    }
                }
                break;
            case 2:
                for (int i = 0; i < combinationRandom.size(); i++) {
                    if (combinationRandom.get(i) == combinationList.get(i)) {
                        combinationResult.add("=");
                    } else if (combinationRandom.get(i) < combinationList.get(i)) {
                        combinationResult.add("+");
                    } else {
                        combinationResult.add("-");
                    }
                }

        }

        System.out.println(" -> Réponse : " + combinationResult);

        return combinationRandom.equals(combinationList);
    }

    public boolean searchResult() {

        nbMin = 1;
        nbMax = 6;
        if (combinationRandom == null) {
            combinationRandom = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                combinationRandom.add(5);
            }
        } else {
            for (int i = 0; i < combinationResult.size(); i++) {

                /**if (combinationResult.get(i).equals("="));
                else if (combinationResult.get(i).equals("+")) {
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else combinationRandom.set(i, (combinationRandom.get(i)-nbMin)/2);*/

                if (combinationResult.get(i).equals("="));
                else if (combinationResult.get(i).equals("+") && combinationList.get(i) > 5) {
                    nbMax = 10;
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else if (combinationResult.get(i).equals("+") && combinationList.get(i) < 5) {
                    nbMax = 6;
                    combinationRandom.set(i, (combinationRandom.get(i)+nbMax)/2);
                } else combinationRandom.set(i, (combinationRandom.get(i)-nbMin)/2);
            }
        }
        System.out.println(" -> Réponse : " + combinationResult);
        return combinationRandom.equals(combinationList);
    }
}
