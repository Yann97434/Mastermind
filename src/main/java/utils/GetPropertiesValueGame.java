package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetPropertiesValueGame {

    String result = "";
    InputStream inputStream;
    private String nbTry;
    private String listSize;
    private String digitCombination;
    private Integer devMode;
    private List<Object> getProp;

    public String getPropValue() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream   =   getClass ( ) . getClassLoader ( ) . getResourceAsStream ( propFileName ) ;

            if   ( inputStream   !=   null )   {
                prop . load ( inputStream ) ;
            }   else   {
                throw   new FileNotFoundException( "property file '"   +   propFileName   +   "' not found in the classpath" ) ;
            }

            nbTry = prop.getProperty("nbTry");
            listSize = prop.getProperty("listSize");
            digitCombination = prop.getProperty("digitCombination");
            devMode = Integer.parseInt(prop.getProperty("devMode"));

            getProp = new ArrayList<>();

            getProp.add(nbTry);
            getProp.add(listSize);
            getProp.add(digitCombination);
            getProp.add(devMode);

        } catch (Exception e) {
            System.out.println("Exception " + e );
        }
        return result;
    }

    public List<Object> getProperties() {

        return getProp;

    }

}