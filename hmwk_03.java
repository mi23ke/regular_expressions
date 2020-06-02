// Mike Urbano
// mxu2814
// 2018-09-22

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.*;

public class hmwk_03 {
  public static void processToken( String token )
  {
    boolean match = false;
    Pattern ID = Pattern.compile( "^[\\$[a-z]][\\d[A-Z]]*|^[\\|][\\d[A-Z]]*[\\|]$" );
    Pattern INT = Pattern.compile( "^%[\\d[a-f[A-F]]]+" );
    Pattern FP = Pattern.compile( "[\\d]+\\.[\\d]+" );
    Matcher r = ID.matcher(token);
    boolean result = r.matches();
    if(result == true){
        System.out.println( ">" + token + "< matches ID" );
        match = true;}
    r = INT.matcher(token);
    result = r.matches();
    if(result == true){
        System.out.println( ">" + token + "< matches INT" );
        match = true;}
    r = FP.matcher(token);
    result = r.matches();
    if(result == true){
        System.out.println( ">" + token + "< matches FP" );
        match = true;}
    if(!match)System.out.println( ">" + token + "< does not match" );
  }

  public static void main( String[] args )
  {
    System.out.println( "processing tokens from " + args[ 0 ] + " ..." );

    try {
      Files.lines( Paths.get( args[ 0 ] ) ).forEachOrdered(
        line -> Arrays.stream( line.split( "\\s+" )  )
            .forEachOrdered( token -> processToken( token ) ) );
    } catch ( java.io.IOException e ) {
      e.printStackTrace();
    }
  }
}
