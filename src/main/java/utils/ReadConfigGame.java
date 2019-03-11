package utils;

import utils.GetPropertiesValueGame;

import java.io.IOException;

public class ReadConfigGame {

    private String nbTry;
    private String listSize;
    private String digitCombination;
    private Integer devMode;

    public ReadConfigGame() {

        getProperties();
    }

    public String getNbTry() {
        return nbTry;
    }

    public void setNbTry(String nbTry) {
        this.nbTry = nbTry;
    }

    public String getListSize() {
        return listSize;
    }

    public void setListSize(String listSize) {
        this.listSize = listSize;
    }

    public String getDigitCombination() {
        return digitCombination;
    }

    public void setDigitCombination(String digitCombination) {
        this.digitCombination = digitCombination;
    }

    public Integer getDevMode() {
        return devMode;
    }

    public void setDevMode(Integer devMode) {
        this.devMode = devMode;
    }

    public void getProperties() {

        GetPropertiesValueGame properties = new GetPropertiesValueGame();
        try {
            properties.getPropValue();

            nbTry = properties.getProperties().get(0).toString();
            listSize = properties.getProperties().get(1).toString();
            digitCombination = properties.getProperties().get(2).toString();
            devMode = Integer.parseInt(properties.getProperties().get(3).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
