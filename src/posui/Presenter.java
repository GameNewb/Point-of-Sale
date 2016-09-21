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

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Presenter 
{
    private FileReader file;
    private BufferedReader bufferFile; 
    
    private String menuFile = "menu.txt";
    private String line;
    private String[] item;
    
    private ArrayList<String> orderList = new ArrayList<String>();
    
    MenuModel model = new MenuModel();
    MenuGUI view;
    
    void loadMenuItems() 
    {
        openFile();
        try{
            while((line = bufferFile.readLine()) != null)
            {
                //Split first
                item = line.split("\\|"); 
                
                //Adds item to model and load it
                model.addItemName(item[0]);
                model.addItemPrice(Double.parseDouble(item[1]));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    } 
    
    public void openFile()
    {
        try{
            file = new FileReader(menuFile);
            
            bufferFile = new BufferedReader(file);      
        }
        catch(Exception e)
        {
            System.out.println("Invalid file name.");
        }
    }

    void attachView(MenuGUI view) 
    {
        this.view = view;
    }
    
    /*
        Checks to see if there's orders
        Used to enable "Place order" and "Clear order"
    */
    public void checkOrderExistance()
    {
        if(!orderList.isEmpty())
        {
            view.enableJButton();
        }
        else
        {
            view.disableJButton();
        }
    }
    
    public ArrayList<String> getMenuList()
    {
        return model.getItemName();
    }
    
    public ArrayList<Double> getPriceList()
    {
        return model.getItemPrice();
    }
    
    public int getMenuSize()
    {
        return model.getItemName().size();
    }
    
    public int getPriceSize()
    {
        return model.getItemPrice().size();
    }
    
    public void addToOrders(String o)
    {
        this.orderList.add(o);
    }
    
    public ArrayList<String> getOrders()
    {
        return orderList;
    }
    
} //End Presenter