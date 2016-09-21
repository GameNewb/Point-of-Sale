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

public abstract class CreditCard 
{
    private String ccNumber;
    private String ccBrand = "";
    
    public CreditCard(String cNumber)
    {
        ccNumber = cNumber;
    }
    
    public String getCCNumber()
    {
        return ccNumber;
    }
    
    public String getCCBrand()
    {
        return ccBrand;
    }
    
    public void setCCNumber(String num)
    {
        ccNumber = num;
    }
    
    public void setCCBrand(String brand)
    {
        ccBrand = brand;
    }

    public static boolean isCardTypeOf(String cc)
    {
        if(cc.length() > 16)
        {
            return false;
        }
        
        return true;
    }
}
