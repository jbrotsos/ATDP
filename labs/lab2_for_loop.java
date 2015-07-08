/**
 * 
 */
package for_loop_lab;

/**
 * @author james
 *
 */
public class ForLoopLab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// part a
		
        nameLoop();
        boxLoop ();
        numbersLoop ();
        numbersBackwardsLoop ();
		
		// part b
		
        nameForLoop ();
        forLoopMethod ();
        FibForLoopMethod ();
        printPatternMethod ();
	}

    public static void nameLoop () {

        // change the following statements into a for loop

    	System.out.println ("james");
    	System.out.println ("james");
    	System.out.println ("james");
    	System.out.println ("james");
    	System.out.println ("james");
    	System.out.println ("james");
    }

    public static void boxLoop () {
        
        // change the following statements into a for loop
    	
    	System.out.println ("+---------------+");
    	System.out.println ("|               |");
    	System.out.println ("|               |");
    	System.out.println ("+---------------+");
    	System.out.println ("+---------------+");
    	System.out.println ("|               |");
    	System.out.println ("|               |");
    	System.out.println ("+---------------+");
    	System.out.println ("+---------------+");
    	System.out.println ("|               |");
    	System.out.println ("|               |");
    	System.out.println ("+---------------+");
    }
   
    public static void numbersLoop () {

        // Write a for loop to print 4 through 10 to the console
        // 4 5 6 7 8 9 10
    
    }
     
    public static void numbersBackwardsLoop () {

       // write a for loop to print 10 through 0 to the console
       // 10 9 8 7 6 5 4 3 2 1 0
    	
    }

    static void nameForLoop () {

        // print your name to the console  and iterator 50 times using a for loop
    	
    }

    static void forLoopMethod () {

        // Exercise #2, pg 12
        // Write a for loop that produces the following output:
        // 1 4 9 16 25 36 49 64 81 100
  
    }

    static void FibForLoopMethod () {

        // Exercise #3, pg 125
        // Write a for loop to produce the Fibonacci sequence:
        // 1 1 2 3 5 8 13 21 34 55 89 144
    	
    }

    static void printPatternMethod () {

        // write a for loop that keeps the total count of adding 
    	// every odd number.  When the loop is done and before
        // the method is finished, print the total.  This method
        // should only print one line
    	
    }
}
