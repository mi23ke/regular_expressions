// Mike Urbano
// mxu2814
// 2018-09-22

using System;
using System.IO;
using System.Text.RegularExpressions;

public class hmwk_03
{
  static public void processToken( string token ) {
    bool no_match = true;
    string ID = "^[(\\$)(a-z)][(A-Z0-9)*]*$|^[(\\|)][(A-Z0-9)*]*[(\\|)]$";       
    string INT = @"^%[0-9a-fA-F]+";
    string FP = @"(\b\d+)(\.)(\d+)";
    Match result = Regex.Match(token, ID);
    if(result.Success){
      Console.WriteLine(">" + token + "< matches ID");
      no_match = false;}
    result = Regex.Match(token, FP);
    if(result.Success){
      Console.WriteLine(">" + token + "< matches FP");
      no_match = false;}
    result = Regex.Match(token, INT);
    if(result.Success){
      Console.WriteLine(">" + token + "< matches Int");
      no_match = false;}
    if(no_match)Console.WriteLine(">" + token + "< does not match");
  }

  static public void Main( string[] args )
  {
    Console.WriteLine( "processing tokens from " + args[ 0 ] + " ..." );

    foreach ( string line in File.ReadAllLines( args[ 0 ] ) ) {
      foreach ( string token in line.Split( (char []) null, StringSplitOptions.RemoveEmptyEntries ) ) {
        processToken( token );
      }
    }
  }
}
