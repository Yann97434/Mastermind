package game;


import org.apache.log4j.Logger;
import utils.ReadConfigGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combination {


    private Random rand = new Random();
    protected ArrayList<Integer> combinationRandom;
    protected ArrayList<Integer> combinationList;
    protected ArrayList<String> combinationResultAttacker;
    protected ArrayList<String> combinationResultDefender;
    protected ArrayList<Integer> combinationAttacker;
    protected ArrayList<Integer> combinationDefender;
    protected ArrayList<ArrayList<Integer>> allCombination;

    protected String combinationWrite;
    protected boolean result;
    protected int nbMin;
    protected int nbMax;
    protected int digitCombination;
    protected int listSize;

    final static Logger log = Logger.getLogger(Combination.class);


    public Combination() {
        super();
        ReadConfigGame properties = new ReadConfigGame();
        digitCombination = Integer.parseInt(properties.getDigitCombination());
        listSize = Integer.parseInt(properties.getListSize());
    }


    public Combination(Random rand, ArrayList<Integer> combinationRandom, ArrayList<Integer> combinationList, ArrayList<String> combinationResultAttacker, ArrayList<String> combinationResultDefender, ArrayList<Integer> combinationAttacker, ArrayList<Integer> combinationDefender, String combinationWrite) {
        this.rand = rand;
        this.combinationRandom = combinationRandom;
        this.combinationList = combinationList;
        this.combinationResultAttacker = combinationResultAttacker;
        this.combinationResultDefender = combinationResultDefender;
        this.combinationAttacker = combinationAttacker;
        this.combinationDefender = combinationDefender;
        this.combinationWrite = combinationWrite;
    }

    public ArrayList<Integer> getCombinationRandom() {
        return combinationRandom;
    }

    public ArrayList<Integer> getCombinationList() {
        return combinationList;
    }

    public ArrayList<Integer> getCombinationAttacker() { return combinationAttacker; }

    public ArrayList<Integer> getCombinationDefender() { return combinationDefender; }

    /**
     * Method allowing the player to write his combination
     */

    public void writeCombination() {

        log.info("Veuillez saisir votre combinaison de " + listSize +" chiffres");
        Scanner sc = new Scanner(System.in);
        combinationWrite = sc.next();
        combinationList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            String tmp = "" + combinationWrite.charAt(i);
            combinationList.add(Integer.parseInt(tmp));
        }
        log.info("Vous avez saisi : " + combinationList);

    }

    /**
     * Method that allows the computer to generate a random combination
     */

    public void generateCombination() {
        combinationRandom = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            combinationRandom.add(rand.nextInt(digitCombination ) + 1);
        }
    }

    /**
     * Method for Starting Combination of the Computer When Searching in the MoreOrLess Defender and Duel Mode
     */

    public void computerCombination() {

        combinationRandom = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            combinationRandom.add(digitCombination / 2);
        }

    }

    /**
     * Method that displays the random combination of the computer
     */

    public void displayCombination() {

        log.info("Voici la combinaison secrète de l'ordinateur " + combinationRandom);
    }

}

