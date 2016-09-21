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

public class VisaCC extends CreditCard{
    
    public VisaCC(String cNumber) {
        super(cNumber);
    }
    
    public static boolean isCardTypeOf(String ccnum)
    {
        if(ccnum.length() < 13 || ccnum.length() > 16 || ccnum.charAt(0) != '4')
        {
            return false;
        }
        
        return true;
    }
    
}
