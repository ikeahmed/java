package com.me;

/** A simple Java starter program
    Converts temperatures between C and F
  */

public class TempConvert {
   private static double temp;
   private static String scale;
   
   /** internal method to convert Celsius to Fahrenheit
     */
   static double cToF( double degrees ) {
      return 9 * degrees / 5 + 32;
   }
   
   /** internal method to convert Fahrenheit to Celsius
     */
   static double fToC( double degrees ) {
      return 5 * ( degrees - 32 ) / 9;
   }
   
   /** main method of temperature conversion class
     * takes two input argument from command line
     * @param args[0] degrees as a real number
     * @param args[1] temperature scale C or F
     * @exception NumberFormatException occurs if the 
     *    first argument cannot be parsed as a number
     */
   public static void main( String[ ] args ) {
   // print usage message and stop if 
   //    less than two arguments supplied
      if ( args.length < 2 ) {
	   System.out.println(
	      "usage: TempConvert number C|F");
   	   return;
      }  // end of if statement

   // translate the first argument to a double value
   //    using a technique that works for all  
   //    versions of the Java platform
      temp = ( new Double( args[0] ) ).doubleValue();
   // The following simpler technique on Java 2 only
   //    temp = Double.parseDouble( args[0] );

   // From the second argument, select C-to-F or F-to-C 
   // Base selection on first character of input string 
      switch ( args[1].charAt( 0 ) ) {
   // store resulting scale and overwrite temperature
         case 'C': scale = "Fahrenheit";
	      temp = cToF( temp );	
	      break;
         case 'F': scale = "Celsius";
		temp = fToC( temp );
		break;
   // if input scale not recognized, print message
         default:  System.out.println(
		   "Specify scale as C or F only " );
	      return;
      } // end of select statement

   // output the input arguments and the converted
   //    temperature and scale
      System.out.println( args[0] + " " + args[1] 
	 + " converted to " + temp + " " + scale );
      return;
   }  // end of main method	
					  
} // end of class
