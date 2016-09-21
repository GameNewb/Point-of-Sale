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

public class AmExCC extends CreditCard {

    public AmExCC(String cNumber) {
        super(cNumber);
    }
    
    public static boolean isCardTypeOf(String ccnum)
    {
        if(ccnum.length() != 15) //Base case
        {
            return false;
        }
        
        return (ccnum.charAt(0) == '3' 
                && ccnum.charAt(1) == '4' 
                || ccnum.charAt(1) == '7');
        
    }
    
}
