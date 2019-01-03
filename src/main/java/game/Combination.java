package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combination {


    private Random rand = new Random();
    protected ArrayList<Integer> nbRandom = new ArrayList<>();
    protected ArrayList<Integer> nbWrite = new ArrayList<>();

    public void writeCombination() {

        System.out.println("Veuillez saisir votre combinaison de chiffres");
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            nbWrite.add(sc.nextInt());
        }
        System.out.printf("Vous avez saisi " + nbWrite);

    }

    public void generateCombination() {

        for (int i = 0; i < 5; i++) {
            nbRandom.add(rand.nextInt(10 - 1 + 1) + 1);
        }
    }

    public void displayCombination() {

        System.out.println("Voici la liste complète des nombres aléatoire " + nbRandom);
    }

    public void analyseCombination() {

    }

}
