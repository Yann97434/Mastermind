package game;

import utils.ReadConfigGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MastermindCombination extends Combination {


    public MastermindCombination(Random rand, ArrayList<Integer> combinationRandom, ArrayList<Integer> combinationList, ArrayList<String> combinationResultAttacker, ArrayList<String> combinationResultDefender, ArrayList<Integer> combinationAttacker, ArrayList<Integer> combinationDefender, String combinationWrite) {
        super(rand, combinationRandom, combinationList, combinationResultAttacker, combinationResultDefender, combinationAttacker, combinationDefender, combinationWrite);
        ReadConfigGame properties = new ReadConfigGame();
        digitCombination = Integer.parseInt(properties.getDigitCombination());
        listSize = Integer.parseInt(properties.getListSize());

    }


    public MastermindCombination() {
        super();
        ReadConfigGame properties = new ReadConfigGame();
        digitCombination = Integer.parseInt(properties.getDigitCombination());
        listSize = Integer.parseInt(properties.getListSize());
    }

    protected List<List<Integer>> val;


    /**
     * Method to generate all possible combinations
     * @return allCombination
     * @throws FileNotFoundException
     */
    public ArrayList<ArrayList<Integer>> listCombination() throws FileNotFoundException {


        int max = digitCombination;
        int size;
        int j = 1;
        allCombination = new ArrayList<>();
        ArrayList<Integer> sol = generateSolutionTab();
        for (; end(sol);) {
            size = sol.size() - 1;
            sol.set(size, j++);
            if (sol.get(sol.size() -1) == max + 1) {
                sol = reaffect(sol);
                j = 1;
            }
            allCombination.add(bufferTab(sol));
            /**System.out.println(sol);*/

        }

        File file = new File("/Users/yannicknillama/Java/listNombre.txt");
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < allCombination.size(); i++) {
            writer.println(allCombination.get(i));
        }
        writer.close();
        return allCombination;


    }

    private boolean end(ArrayList<Integer> sol) {

        for (int i = 0; i < sol.size(); i++) {
            if (sol.get(i) != digitCombination)
                return true;
        }
        return false;
    }

    private ArrayList<Integer> bufferTab(ArrayList<Integer> sol) {

        ArrayList<Integer> copy = new ArrayList<>(sol.size());
        for (int i = 0; i < sol.size(); i++) {
            copy.add(sol.get(i));
        }
        return copy;
    }

    private ArrayList<Integer> reaffect(ArrayList<Integer> sol) {

        for (int i = sol.size() - 1; i > 0; i--) {
            int j = sol.get(i - 1);
            j++;
            if (sol.get(i) == digitCombination + 1) {
                sol.set(i, 0);
                sol.set(i - 1, j);
            }
        }

        return sol;
    }

    private ArrayList<Integer> generateSolutionTab() {

        ArrayList<Integer> ret = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            ret.add(0);
        }

        return ret;
    }

    /**
     * Method to know the number of common values
     * @param combinationHuman
     * @param proposition
     * @return the number of common values
     */
    public int arbitrage(List<Integer> combinationHuman, List<Integer> proposition) {


        int count = 0;
        for (int i = 0 ; i < combinationHuman.size() ; i++) {
            if (combinationHuman.get(i) == proposition.get(i)) {
                count++;
                combinationHuman.set(i, -1);
                proposition.set(i, -1);
            }
        }
        log.info("Il y a " + count + " Valeurs communes!");
        return count;
    }


    /**
     * Method to know the number of misplaced values
     * @param combinationHuman
     * @param proposition
     * @return the number of misplaced values
     */
    public int  arbitrage2(List<Integer> combinationHuman, List<Integer> proposition) {

        int count = 0;
        for (int i = 0; i < combinationHuman.size(); i++){
            for (int j = 0; j < proposition.size(); j++){
                if (combinationHuman.get(i) == proposition.get(j) && combinationHuman.get(i) != -1) {
                    count++;
                    combinationHuman.set(i, -1);
                    proposition.set(j, -1);
                }
            }
        }
        log.info("Il y a " + count + " chiffres mal placés!");
        return count;
    }

    /**
     * Method for testing combinations
     * @param possibleSolution
     * @param tuple
     * @param size
     * @return possibleCombination
     */
    public ArrayList<ArrayList<Integer>> removeCombination(ArrayList<ArrayList<Integer>> possibleSolution, List<List<Integer>> tuple, int size) {

        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        possibleSolution.remove(0);
        for (int i = 0; i < possibleSolution.size(); i++) {
            int count = 0;
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
            }
        }
        return tmp;
    }

    /**
     * How to remove unnecessary combinations
     * @param combinationAttacker
     * @return possibleCombination
     */
    public ArrayList<ArrayList<Integer>> removeUseless(ArrayList<Integer> combinationAttacker) {

        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < allCombination.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < allCombination.get(i).size(); j++) {
                for (int k = 0; k < combinationAttacker.size(); k++) {
                    if (combinationAttacker.get(j) == allCombination.get(i).get(j)) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                tmp.add(allCombination.get(i));
            }
        }
        return tmp;
    }

    /**
     * How to create possible combinations of common or misplaced values
     * @param lst
     * @return possibleCombination of common or misplaced values
     */
    public List<List<Integer>> extract1(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {

            List<Integer> add = new ArrayList<>();
            add.add(lst.get(i1));
            val.add(add);
        }
        return val;
    }

    public List<List<Integer>> extract2(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 ; i2 < lst.size(); i2++) {

                List<Integer> add = new ArrayList<>();
                add.add(lst.get(i1));
                add.add(lst.get(i2));
                val.add(add);
            }
        }
        return val;
    }

    public List<List<Integer>> extract3(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 ; i3 < lst.size(); i3++) {
                    List<Integer> add = new ArrayList<>();
                    add.add(lst.get(i1));
                    add.add(lst.get(i2));
                    add.add(lst.get(i3));
                    val.add(add);
                }
            }
        }
        return val;
    }

    public List<List<Integer>> extract4(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 ; i4 < lst.size() ; i4++ ) {
                        List<Integer> add = new ArrayList<>();
                        add.add(lst.get(i1));
                        add.add(lst.get(i2));
                        add.add(lst.get(i3));
                        add.add(lst.get(i4));
                        val.add(add);
                    }
                }
            }
        }
        return val;
    }

    public List<List<Integer>> extract5(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 ; i5 < lst.size(); i5++) {
                            List<Integer> add = new ArrayList<>();
                            add.add(lst.get(i1));
                            add.add(lst.get(i2));
                            add.add(lst.get(i3));
                            add.add(lst.get(i4));
                            add.add(lst.get(i5));
                            val.add(add);
                        }
                    }
                }
            }
        }
        return val;
    }

    public List<List<Integer>> extract6(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 ; i6 < lst.size(); i6++) {
                                List<Integer> add = new ArrayList<>();
                                add.add(lst.get(i1));
                                add.add(lst.get(i2));
                                add.add(lst.get(i3));
                                add.add(lst.get(i4));
                                add.add(lst.get(i5));
                                add.add(lst.get(i6));
                                val.add(add);
                            }
                        }
                    }
                }
            }
        }
        return val;
    }

    public List<List<Integer>> extract7(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
                                for (int i7 = i6 ; i7 < lst.size(); i7++) {
                                    List<Integer> add = new ArrayList<>();
                                    add.add(lst.get(i1));
                                    add.add(lst.get(i2));
                                    add.add(lst.get(i3));
                                    add.add(lst.get(i4));
                                    add.add(lst.get(i5));
                                    add.add(lst.get(i6));
                                    add.add(lst.get(i7));
                                    val.add(add);
                                }
                            }
                        }
                    }
                }
            }
        }
        return val;
    }

    public List<List<Integer>> extract8(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
                                for (int i7 = i6 + 1; i7 < lst.size(); i7++) {
                                    for (int i8 = i7 ; i8 <lst.size(); i8++) {
                                        List<Integer> add = new ArrayList<>();
                                        add.add(lst.get(i1));
                                        add.add(lst.get(i2));
                                        add.add(lst.get(i3));
                                        add.add(lst.get(i4));
                                        add.add(lst.get(i5));
                                        add.add(lst.get(i6));
                                        add.add(lst.get(i7));
                                        add.add(lst.get(i8));
                                        val.add(add);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return val;
    }

    public List<List<Integer>> extract9(List<Integer> lst) {
        val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
                                for (int i7 = i6 + 1; i7 < lst.size(); i7++) {
                                    for (int i8 = i7 + 1; i8 <lst.size(); i8++) {
                                        for (int i9 = i8 ; i9 < lst.size(); i9++) {
                                            List<Integer> add = new ArrayList<>();
                                            add.add(lst.get(i1));
                                            add.add(lst.get(i2));
                                            add.add(lst.get(i3));
                                            add.add(lst.get(i4));
                                            add.add(lst.get(i5));
                                            add.add(lst.get(i6));
                                            add.add(lst.get(i7));
                                            add.add(lst.get(i8));
                                            add.add(lst.get(i9));
                                            val.add(add);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return val;
    }

}
