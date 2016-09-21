/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posui;

/**
 *
 * @author Kiyeon
 * Kyle Del Castillo
 * Student #009445384
 * CS 151 - Object Oriented Design
 * Prof. Vidya Rangasayee
 * 
 */

public class DiscoverCC extends CreditCard{

    public DiscoverCC(String cNumber) {
        super(cNumber);
    }
    
    public static boolean isCardTypeOf(String ccnum)
    {
        String numCheck = "6011";
        String firstFour = ccnum.substring(0, 4);
        
        if(ccnum.length() != 16) //Base case
        {
            return false;
        }
        
        return firstFour.equals(numCheck);
        
    }
    
}
