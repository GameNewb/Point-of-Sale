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

public class CreditCardFactory 
{
    public CreditCard initializeCreditCard(String newCard)
    {
        CreditCard creditcard = null;
        
        if(newCard.length() == 0 || newCard.length() > 19) //Check if its a credit card
        {
            return creditcard;
        }
        else if(VisaCC.isCardTypeOf(newCard))
        {
            creditcard = new VisaCC(newCard);
            creditcard.setCCBrand("Visa");
            return creditcard;
        }
        else if(MasterCC.isCardTypeOf(newCard))
        {
            creditcard = new MasterCC(newCard);
            creditcard.setCCBrand("Master Card");
            return creditcard;
        }
        else if(AmExCC.isCardTypeOf(newCard))
        {
            creditcard = new AmExCC(newCard);
            creditcard.setCCBrand("American Express");
            return creditcard;
        }
        else if(DiscoverCC.isCardTypeOf(newCard))
        {
            creditcard = new DiscoverCC(newCard);
            creditcard.setCCBrand("Discover");
            return creditcard;
        }
        
        return creditcard;
    }
    
}
