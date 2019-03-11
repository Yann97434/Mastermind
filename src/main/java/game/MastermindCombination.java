package game;

import utils.ReadConfigGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<int[]> listCombination() throws FileNotFoundException {

        /**ArrayList<Integer> digitCombination = generateDigitCombination();*/
        ReadConfigGame properties = new ReadConfigGame();
        int max = digitCombination;
        allCombination = new ArrayList<>();
        int sol[] = generateSolutionTab();
        for (; end(sol);) {
            sol[sol.length - 1] += 1;
            if (sol[sol.length - 1] == max + 1)
                sol = reaffect(sol);
            allCombination.add(bufferTab(sol));
            /**System.out.println(Arrays.toString(sol));*/

        }
        /**solve(allCombination); /**solve fonction permettant de faire la recherche du mastermind*/
        File file = new File("/Users/yannicknillama/Java/listNombre.txt");
        PrintWriter writer = new PrintWriter(file);
        for (int[] str : allCombination) {
            writer.println(str);
        }
        writer.close();
        return allCombination;


    }

    private ArrayList<Integer> generateDigitCombination() {

        ArrayList<Integer> ret = new ArrayList<>(digitCombination);

        for (int i = 0; i < digitCombination; i++) {
            ret.add(i) ;
        }
        return ret;
    }

    private ArrayList<Integer> sizeCombination() {

        ArrayList<Integer> ret = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            ret.add(i) ;
        }
        return ret;
    }

    private boolean end(int[] sol) {

        for (int i = 0; i < sol.length; i++) {
            if (sol[i] != digitCombination)
                return true;
        }
        return false;
    }

    private int[] bufferTab(int[] sol) {

        int[] copy = new int[sol.length];
        for (int i = 0; i < sol.length; i++) {
            copy[i] = sol[i];
        }
        return copy;
    }

    private int[] reaffect(int[] sol) {

        for (int i = sol.length - 1; i > 0; i--) {
            if (sol[i] == digitCombination + 1) {
                sol[i] = 0;
                sol[i - 1]++;
            }
        }

        return sol;
    }

    private int[] generateSolutionTab() {

        int[] ret = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            ret[i] = 0;
        }

        return ret;
    }


    public void removeCombination() {

        combinationPossible = new ArrayList<int[]>();
        for (int i = 0; i < allCombination.size(); i++) {
            for (int j = 0; j < combinationExtract.size(); j++) {
                if (combinationExtract.get(i).equals(allCombination.get(i))) {
                    combinationPossible.add(allCombination.get(i));
                    log.info("combinaison ajoutée " + Arrays.toString(combinationPossible.get(i)));
                } else {
                    allCombination.remove(i);
                    log.info("combinaison supprimée " + Arrays.toString(allCombination.get(i)));
                }
            }
        }
    }

    private void solve() {

    }

    public List<List<Integer>> extract1(List<Integer> lst) {
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {

            List<Integer> add = new ArrayList<>();
            add.add(lst.get(i1));
            val.add(add);
        }
        System.out.println(val);
        return val;
    }

    public List<List<Integer>> extract2(List<Integer> lst) {
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {

                List<Integer> add = new ArrayList<>();
                add.add(lst.get(i1));
                add.add(lst.get(i2));
                val.add(add);
            }
        }
        System.out.println(val);
        return val;
    }

    public List<List<Integer>> extract3(List<Integer> lst) {
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    List<Integer> add = new ArrayList<>();
                    add.add(lst.get(i1));
                    add.add(lst.get(i2));
                    add.add(lst.get(i3));
                    val.add(add);
                }
            }
        }
        System.out.println(val);
        return val;
    }

    public List<List<Integer>> extract4(List<Integer> lst) {
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
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
        System.out.println(val);
        return val;
    }

    public List<List<Integer>> extract5(List<Integer> lst) {
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
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
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
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
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
                                for (int i7 = i6 + 1; i7 < lst.size(); i7++) {
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
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
                                for (int i7 = i6 + 1; i7 < lst.size(); i7++) {
                                    for (int i8 = i7 + 1; i8 <lst.size(); i8++) {
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
        List<List<Integer>> val = new ArrayList<>();

        for (int i1 = 0; i1 < lst.size(); i1++) {
            for (int i2 = i1 + 1; i2 < lst.size(); i2++) {
                for (int i3 = i2 + 1; i3 < lst.size(); i3++) {
                    for (int i4 = i3 +1; i4 < lst.size() ; i4++ ) {
                        for (int i5 = i4 + 1; i5 < lst.size(); i5++) {
                            for (int i6 = i5 + 1; i6 < lst.size(); i6++) {
                                for (int i7 = i6 + 1; i7 < lst.size(); i7++) {
                                    for (int i8 = i7 + 1; i8 <lst.size(); i8++) {
                                        for (int i9 = i8 + 1; i9 < lst.size(); i9++) {
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
