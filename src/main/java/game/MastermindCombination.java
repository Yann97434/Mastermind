/**package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MastermindCombination extends Combination {


    public MastermindCombination(Random rand, ArrayList<Integer> combinationRandom, ArrayList<Integer> combinationList, ArrayList<String> combinationResult, String combinationWrite, boolean result) {
        super(rand, combinationRandom, combinationList, combinationResult, combinationWrite, result);
    }

    public boolean analyseCombination() {


        return Arrays.equals(combinationRandom, combinationList);
    }

}*/
