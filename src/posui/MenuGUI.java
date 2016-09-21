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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MenuGUI extends JFrame 
{
    Presenter presenter;
    
    private JButton[] itemButtons;
    private JLabel[] itemLabels;
    private JLabel[] priceLabels;
   
    private JPanel orderPane = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel orderList = new JPanel();
    
    private JTextField ccEntry = new JTextField("Enter CC #");
    
    private double total = 0.00;
    private JTextField totalCost = new JTextField(Double.toString(total), 20);
   
    private JLabel orderDetails = new JLabel("Your order");
    private JLabel totalField = new JLabel("Total Amount: ");
    private JPanel totalPane = new JPanel();
   
    private JButton confirm = new JButton("Place Order");
    private JButton cancel = new JButton("Cancel Order");
    
    private String ccNum;

    public MenuGUI(Presenter presenter) 
    {
        this.presenter = presenter;
        presenter.attachView(this);
        showGUI();
    }

    private void showGUI() 
    {
        presenter.loadMenuItems();
        
        JFrame theFrame = new JFrame("McPatterns Point of Sale");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLayout(new BorderLayout());
        
        JPanel title = new JPanel(new FlowLayout());
        title.add(new JLabel("Welcome to McPatterns"));
        title.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "Powered by Food"));
        title.setBackground(Color.ORANGE);
        title.setOpaque(true);

        orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
        orderPane.setPreferredSize(new Dimension(225,225));
        orderPane.setBackground(Color.ORANGE);
        orderPane.setOpaque(true);
        
        orderDetails.setBorder(new TitledBorder(new LineBorder(Color.black, 2),"Receipt"));
        orderDetails.setMaximumSize(new Dimension(Integer.MAX_VALUE, orderPane.getMinimumSize().height));
        
        //Set order layout
        orderList.setLayout(new GridLayout(0,2));
        
        //Set button panel layout
        buttonPanel.setLayout(new GridLayout(6,2));//BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); //Vertical Alignment, dependent on menu length/size
        
        //Button Creation
        itemButtons = new JButton[presenter.getMenuSize()]; //set JButton array
        itemLabels = new JLabel[presenter.getMenuSize()]; //set size
        priceLabels = new JLabel[presenter.getPriceSize()]; //set price size
        
        //Creates buttons depending on menu
        createButtons();
        orderList.setBorder(new LineBorder(Color.BLACK,2));
        
        //Set totalCost textfield alignment and size
        totalCost.setPreferredSize(new Dimension(30,25));
        totalCost.setHorizontalAlignment(JTextField.CENTER);
        totalCost.setEditable(false);
        
        totalField.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        totalField.setMaximumSize(new Dimension(Integer.MAX_VALUE, orderPane.getMinimumSize().height));
        
        totalPane.setBorder(new LineBorder(Color.BLACK,1));
        totalPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, orderPane.getMinimumSize().height));
        totalPane.add(totalCost);
        
        ccEntry.setMaximumSize(new Dimension(Integer.MAX_VALUE, orderPane.getMinimumSize().height));
        ccEntry.setPreferredSize(new Dimension(30,25));
        ccEntry.setHorizontalAlignment(JTextField.CENTER);
        ccEntry.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ccEntry.setText("");
            }
        });
        
        orderPane.setBorder(new CompoundBorder(new LineBorder(Color.black, 2), new BevelBorder(BevelBorder.RAISED)));
        orderPane.add(orderDetails);
        orderPane.add(orderList);
        orderPane.add(totalField);
        orderPane.add(totalPane);
        orderPane.add(ccEntry);
        
        //Placing Order - buttons disabled first
        confirm.setMaximumSize(new Dimension(Integer.MAX_VALUE, orderPane.getMinimumSize().height));
        confirm.setEnabled(false);
        
        confirm.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //Another validation to check whether there's orders or not
                if(presenter.getOrders().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "There are no orders present.");
                    orderDetails.setText("No orders");
                    ccEntry.setText(""); //Clears the text field
                }
                else
                {
                    ccNum = ccEntry.getText(); //Gets the user input for cc number
                    checkCard();
                    ccEntry.setText(""); //Reverts the credit card number back to normal for protection purposes.
                    //disableJButton();
                }
                
            }
        });
        
        //Order Cancelling - buttons disabled first
        cancel.setMaximumSize(new Dimension(Integer.MAX_VALUE, orderPane.getMinimumSize().height));
        cancel.setEnabled(false);
        
        cancel.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //Another validation to check whether there's orders or not
                if(presenter.getOrders().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "There are no orders present.");
                    orderDetails.setText("No orders");
                    ccEntry.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Order cancelled.");
                    clearOrderReceipt();
                    orderDetails.setText("Order cancelled");
                    //disableJButton();
                }
                
            }
        });

        orderPane.add(confirm);
        orderPane.add(cancel);
        
        theFrame.add(title,BorderLayout.NORTH);
        theFrame.add(buttonPanel, BorderLayout.CENTER);
        theFrame.add(orderPane, BorderLayout.EAST);
        theFrame.setSize(1000,800);

        theFrame.pack();
        theFrame.setVisible(true);

    }
    
    //Handle button creation
    private void createButtons()
    {
        for(int i = 0; i < presenter.getMenuSize(); i++) 
        {
            final int temp = i;
            itemButtons[i] = new JButton(presenter.getMenuList().get(i));
            
            itemLabels[i] = new JLabel(presenter.getMenuList().get(i));
            itemLabels[i].setHorizontalAlignment(JLabel.LEFT);
            
            priceLabels[i] = new JLabel(Double.toString(presenter.getPriceList().get(i)));
            priceLabels[i].setHorizontalAlignment(JLabel.RIGHT);
            
            itemButtons[i].setPreferredSize(new Dimension(150, 80));
            buttonPanel.add(itemButtons[i]);
            itemButtons[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    orderList.add(itemLabels[temp]);
                    orderList.add(priceLabels[temp]);
                    total += presenter.getPriceList().get(temp);
                    updateTotalCost(total);
                    
                    //Add the orders to presenter
                    presenter.addToOrders(itemLabels[temp].getText());
                    presenter.checkOrderExistance();
                    
                    orderList.validate();
                    orderList.repaint();
                }
            });
        }
        
    }
    
    /*
        Checks card if it's valid or not
        
        COMMENTS:
        I let the GUI handle the validation since I wanted it to show a message dialog when there's an error or if the card is accepted
        I didn't want to go back and forth between the factory/credit card and GUI
    */
    private void checkCard()
    {
        if(ccNum.matches("[0-9]+")) //Checks to see if user accidentally inputs a letter
        {
            CreditCardFactory cFactory = new CreditCardFactory(); //Create new factory
            CreditCard card = cFactory.initializeCreditCard(ccNum); //Generate new credit card

            //Check if its a valid card
            if(card == null) 
            {
                JOptionPane.showMessageDialog(null,"Invalid Credit Card. Try again.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, card.getCCBrand() + " credit card " + ccNum + " is valid and has been accepted.");
                orderDetails.setText("Order confirmed for " + ccEntry.getText());

                JOptionPane.showMessageDialog(null, "Order has been placed!");
                
                System.out.println("\n-------------------");
                System.out.println("Number of orders: " + presenter.getOrders().size());
                System.out.println("-------------------");
                for(int i = 0; i < presenter.getOrders().size(); i++)
                {
                    System.out.println(presenter.getOrders().get(i));
                }
                System.out.println("-------------------");

                clearOrderReceipt();
            }
        } //End outer if
        else
        {
            JOptionPane.showMessageDialog(null, "Input contains letters. Credit card number must have numbers only.");
        }
    }
    
    //Resets and clear all order
    private void clearOrderReceipt()
    {
        //Clears all order
        presenter.getOrders().clear();
        
        //Remove labels
        for(int j = 0; j < itemLabels.length; j++)
        {   
            orderList.remove(itemLabels[j]); //Removes label names
            orderList.remove(priceLabels[j]); //Removes prices
        }
                
        //Revert total back to 0
        total = 0.00;
        updateTotalCost(total);
        
        orderList.validate();
        orderList.repaint();
    }
   
    //Update the total cost
    private void updateTotalCost(Double tCost)
    {
        totalCost.setText(String.format("%.2f", tCost));
    }
    
    /*
        In conjunction with Presenter's order list,
        Either enable or disable the jbuttons for placing/cancelling order when there is no order
    */
    public void enableJButton()
    {
        confirm.setEnabled(true);
        cancel.setEnabled(true);
    }
    
    public void disableJButton()
    {
        confirm.setEnabled(false);
        cancel.setEnabled(false);
    }
    
} //End MenuGUI