package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combination {


    private Random rand = new Random();
    protected ArrayList<Integer> combinationRandom;
    protected ArrayList<Integer> combinationList;
    protected ArrayList<String> combinationResult;
    protected String combinationWrite;
    protected boolean result;
    protected int nbMin;
    protected int nbMax;


    public Combination() {}

    public Combination(Random rand, ArrayList<Integer> combinationRandom, ArrayList<Integer> combinationList, ArrayList<String> combinationResult, String combinationWrite, boolean result) {
        this.rand = rand;
        this.combinationRandom = combinationRandom;
        this.combinationList = combinationList;
        this.combinationResult = combinationResult;
        this.combinationWrite = combinationWrite;
        this.result = result;
    }


    public ArrayList<Integer> getCombinationRandom() {
        return combinationRandom;
    }

    public ArrayList<Integer> getCombinationList() {
        return combinationList;
    }

    public ArrayList<String> getCombinationResult() {
        return combinationResult;
    }

    public void writeCombination() {

        System.out.println("Veuillez saisir votre combinaison de chiffres");
        Scanner sc = new Scanner(System.in);
        combinationWrite = sc.next();
        combinationList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String tmp = "" + combinationWrite.charAt(i);
            combinationList.add(Integer.parseInt(tmp));
        }
        System.out.printf("Vous avez saisi : " + combinationList);

    }

    public void generateCombination() {
        combinationRandom = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            combinationRandom.add(rand.nextInt(9 - 1 + 1) + 1);
        }
    }

    public void computerCombination() {

        combinationRandom = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            combinationRandom.add(5);
        }

    }


    public void displayCombination() {

        System.out.println("Voici la liste complète des nombres aléatoire " + combinationRandom);
    }


}
