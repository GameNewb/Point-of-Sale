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

public class MasterCC extends CreditCard
{
    public MasterCC(String cNumber) {
        super(cNumber);
    }
    
    public static boolean isCardTypeOf(String ccnum)
    {
        if(ccnum.length() != 16) //Base case
        {
            return false;
        }
        
        return (ccnum.charAt(0) == '5' 
                && Character.getNumericValue(ccnum.charAt(1)) >= 1 
                && Character.getNumericValue(ccnum.charAt(1)) <= 5);
        
    }
}
