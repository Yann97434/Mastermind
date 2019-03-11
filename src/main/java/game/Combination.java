package game;


import org.apache.log4j.Logger;
import utils.ReadConfigGame;

import java.util.ArrayList;
import java.util.List;
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
    protected ArrayList<Integer> combinationExtract;
    protected ArrayList<int[]> combinationPossible;
    protected List<int[]> allCombination;

    protected String combinationWrite;
    protected boolean result;
    protected int nbMin;
    protected int nbMax;
    protected int digitCombination;
    protected int listSize;

    final static Logger log = Logger.getLogger(Combination.class);


    /**public Combination() {}*/

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
     * Méthode permettant au joueur d'écrire sa combinaison
     */

    public void writeCombination() {

        log.info("Veuillez saisir votre combinaison de " + listSize +" chiffres");
        Scanner sc = new Scanner(System.in);
        combinationWrite = sc.next();
        combinationList = new ArrayList<>();
        /**combinationAttacker = new ArrayList<>();*/
        for (int i = 0; i < listSize; i++) {
            String tmp = "" + combinationWrite.charAt(i);
            combinationList.add(Integer.parseInt(tmp));
        }
        log.info("Vous avez saisi : " + combinationList);

    }

    /**
     * Méthode permettant à l'ordinateur de générer une combinaison aléatoire
     */

    public void generateCombination() {
        combinationRandom = new ArrayList<>();
        /**combinationDefender = new ArrayList<>();*/
        for (int i = 0; i < listSize; i++) {
            combinationRandom.add(rand.nextInt(digitCombination - 1 + 1) + 1);
        }
    }

    /**
     * Méthode pour la combinaison de départ de l'ordinateur lors de la recherche dans le mode Defender et Duel du MoreOrLess
     */

    public void computerCombination() {

        combinationRandom = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            combinationRandom.add(5);
        }

    }

    /**
     * Méthode qui affiche la combinaison aléatoire de l'ordinateur
     */

    public void displayCombination() {

        log.info("Voici la liste complète des nombres aléatoire " + combinationRandom);
    }

    public int valCommun(/**ArrayList<Integer> combinationAttacker, ArrayList<Integer> combinationDefender*/) {

        combinationExtract = new ArrayList<>();
        int count = 0;
        for (int i = 0 ; i < combinationAttacker.size() ; i++) {
            if (combinationAttacker.get(i) == combinationDefender.get(i)) {
                count++;
                combinationExtract.add(combinationAttacker.get(i));
                combinationAttacker.set(i, -1);
                combinationDefender.set(i, -1);
            }
        }
        log.info("il y a " + count + " Valeurs communes!");
        return count;
    }

    public int  wrongPlace(/**ArrayList<Integer> combinationAttacker, ArrayList<Integer> combinationDefender*/) {

        int count = 0;
        for (int i = 0; i < combinationAttacker.size(); i++){
            for (int j = 0; j < combinationDefender.size(); j++){
                if (combinationAttacker.get(i) == combinationDefender.get(j) && combinationAttacker.get(i) != -1) {
                    count++;
                    combinationExtract.add(combinationAttacker.get(i));
                    combinationAttacker.set(i, -1);
                    combinationDefender.set(j, -1);
                }
            }
        }
        log.info("il y a " + count + " chiffres mal placés!");
        return count;
    }

}

