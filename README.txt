user: 009445384, (Del Castillo, Kyle)

NOTES:

The program is hardcoded to read "menu.txt". I wanted the user to be able to input their own menu, but I felt that it would be faster for you(the grader) to simply replace the contents of menu.txt and so I did not implement that interaction.

The program is fully functional in terms of the requirements (i think), but when an order is placed or cancelled, some labels or buttons gets resized and becomes smaller. 
I'm not very familiar with swing/GUI, and so I don't really know how to fix it. I would appreciate any comments or hints on how to fix this to make it look nicer.

Another small issue that I came across is that the order name/price label are not being inputted multiple times when clicked multiple times. On the order arraylist, it's added multiple times, but on the order panel(UI), there's only 1 label. 
I've read on stackoverflow that a widget/label or any component can only be put into a panel once, and that's maybe why this happens. For simplicity, I did not implement an order "count tab" in the order panel.

========================================================================================================================================================

DESIGN PATTERN:
Honestly, I'm not really sure what the overall design pattern is for my program, although I feel like it's a Composite/Decorator structural pattern. 
For the creation of credit cards, I used a Factory Method for my pattern.

PROS/CONS:
The cons is that, there is a strong association between classes. This means that if there are no menu items/objects, then the GUI will not be able to create the buttons and will be useless.
There is a composition between the classes, and in a way, that makes the design poor since one cannot exist without the other.

The pros is that, the responsibility of the classes are different with one another, even though they have a strong composition. Each class does its own thing despite relying on another class' data. 
Also, one class can override another class method if need be.


========================================================================================================================================================

General breakdown of classes:

PoS - main method
MenuModel - used for creation of objects for menu and its price
Presenter - used for loading menu files in conjunction with MenuModel. Also used for creation of order arraylist objects.
MenuGui - used for creation of UI. It's the one in charge of one credit card validation(credit entry containing only numbers, no letters) for design reason(SEE COMMENTS ON CODE - LINE 235)
CreditCardFactory - used to create the appropriate credit card
CreditCard - similar to MenuModel, handles object creation and variable initialization
AmEX, Visa, Discover, Master - subclasses in charge of appropriate validation


========================================================================================================================================================