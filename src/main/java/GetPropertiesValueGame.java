/**import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesValueGame {

    String result = "";
    InputStream inputStream;
    private int nbTry;
    private int listSize;
    private int nbNumber;
    private int devMode;

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



        } catch (Exception e) {
            System.out.println("Exception " + e );
        }
    }
}*/