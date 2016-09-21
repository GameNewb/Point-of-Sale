/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posui;

import java.util.ArrayList;

/**
 *
 * @author Kiyeon
 * Kyle Del Castillo
 * Student #009445384
 * CS 151 - Object Oriented Design
 * Prof. Vidya Rangasayee
 * 
 */

public class MenuModel 
{
    private ArrayList<String> itemName = new ArrayList<String>();
    private ArrayList<Double> itemPrice = new ArrayList<Double>();
    private ArrayList<String> orderList = new ArrayList<String>();
    
    //Reflection
    public MenuModel(){}
    
    public MenuModel(ArrayList<String> name, ArrayList<Double> price)
    {
        this.itemName = name;
        this.itemPrice = price;
    }
    
    public MenuModel(String name, Double price)
    {
        this.itemName.add(name);
        this.itemPrice.add(price);
    }
    
    public MenuModel(ArrayList<Double> price)
    {
        itemPrice = price;
    }
    
    public void addItemName(String n)
    {
        this.itemName.add(n);
    }
    
    public void addItemPrice(Double p)
    {
        this.itemPrice.add(p);
    }
   
    public ArrayList<String> getItemName()
    {
        return itemName;
    }
    
    public ArrayList<Double> getItemPrice()
    {
        return itemPrice;
    }
    
   
}
