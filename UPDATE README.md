
# Introduction
This is an inventory management system. It is designed to:
1. Monitor stock levels on various materials and products
2. Mark down positions of various materials and products within the storage facility
3. Collect data on stock level changes, supply times and defective batches of supply
4. Plan ahead for a schedule to order new batch of materials based on consumption and lead time
5. Cooperate with management personnel decisions to alter ordering strategy in response to external factors such as drop in supply cost or difficulty getting supplied in the foreseeable future
6. Alert the responsible individuals when stock levels are not expected to sustain normal operations of the company for an adjustable number of days ahead

# Running and Compiling
To run and compile the system, the user will need to clone the Github repository and run the main class "launch.java" from the folder "launch".

# New Features

1. Two seperate interface

The employer and employees will have two seperate interfaces. The employer will have access to admin interface where they will be able to control what type of new product they will add to the system. Meanwhile, the employee's interface will have functions such as restocking and pricings.

2. Store and Add Price 

This feature allows you store items in the warehouse and add price tags to them. Afterwards, view their status by lisiting and show their avalibility and pricing.  This feature has been added to employee's interface so that when they recieve and store a product, they can attatch the price of the goods. 


3. Automatic Supply stock

This feature detect when an item supply is low in stocks and then it automatically add new supply. This feature has been added to the employees. When they take out an item for an order, if the stock of the product goes below a certain threshold, there will be a warning sign and the product will restock itself. 

public void take(): This function is used to take items from the warehouse.

public void returned(): This function is used to restock items.

public int getPrice(): This return the price of an item.

void checkOut(String iname): Check the name of the input item name and match with the corresponding function.

public void receivePrice(): Used to enter the price of an item.

public void listInventory(): Used to show the list of the inventory.


# public_workspace
This is the directory with folders holding each component.
# StockLevel
The Stock Level component of the system consists of 3 classes "mainStock", "ProductWriter", and "DataReader". The ProductWriter class contains all the methods and functions necessary to write new products in the inventory/stock, while the DataReader class contains all the methods that reads and returns the stock levels in the inventory. 

mainStock():

Contains the start, finish, and closeProgram functions. start() takes the user to a menu with 3 options to edit, add, or view products. finish() prompts the user to select an option, whether to make another option or terminate the program. closeProgram() closes the whole program

ProductWriter():
Contains the methods for all functions that have to do with writing a new product.

DataReader():
Contains the methods for reading data from the database file and editing the products in the database, as well as some helper methods to simplify the process of retrieving and editing the products. 

# StorageMap
StorageMapComponent is a class containing 5 methods named processOperations(), list(), store(), find() and take(). 
processOperations() allows the user to select a function and calls in other appropriate methods accordingly. It also repeats when the function is done so the next function can be selected right after. 
- list() will list all entries from the storage sites database represented by text files office.txt and warehouse.txt by calling list() in Office class or Warehouse class. The user chooses the storage site via text input to the console. 
- store() lets the user add lines of information to the storage. It first asks for the barcode to be entered in order to search for potentially repetitive entries through the find() method in Office class and Warehouse class. If there is, it will prompt the user to decide whether it should continue the storing process. It will next ask for the user to decide the storage site and pass through the barcode as a string to the store() method in the class for the chosen storage site. 
- find() searches for a barcode entered by the user in all storage site databases by passing through the barcode as a string to both find() methods in Office class and Warehouse class which returns a boolean. If it is true, the barcode will be passed through to the locate() method in Office class and Warehouse class which will print the location of the stored item with matching barcode to the console. 
- take() deletes lines of information from the storage database. It starts by asking for the barcode and passing it to the find() method in Office class and Warehouse class . If entries with the matching barcode is found, it will pass through the barcode to take() method in Office class and Warehouse class to delete the line of information while also printing the storage sites and location within the site through the console.

Storage class is an interface for all classes in the locations package. It has 5 methods, list(), store(), find(), locate() and take(). It is only used to make sure classes in the locations package will implement all these methods in order to be compatible with the StorageMapComponent class.

Office class implements Storage class with the same 5 methods. 
- list() calls on the listInventory() method in FileReaderWriter class and passes through the “Office” string so it would read from office.txt. It is also responsible for catching exceptions from listInventory() and will print an error message in the console.
- store() formats the line of information to be stored into office.txt while confirming the action by printing a message in the console. It combines the barcode parameter taken from the caller method and location name entered by the user to form a new spot string. This spot string along with the “Office” string are passed over to the storeIntoInventory() method in FileReaderWriter class. It is also responsible for catching exceptions from storeIntoInventory() and will print an error message in the console.
- find() calls the findInInventory() method in FileReaderWriter class and passes through both storage and barcode parameters received from its caller method into findInInventory(). It also catches exceptions from findInInventory() and prints an error message in the console if triggered.
- locate() calls the locateInInventory() method in FileReaderWriter class and passes through both storage and barcode parameters received from its caller method into locateInInventory(). It also catches exceptions from locateInInventory() and prints an error message in the console if triggered.
- take() calls the takeFromInventory() method in FileReaderWriter class and passes through both storage and barcode parameters received from its caller method into takeFromInventory(). It also catches exceptions from takeFromInventory() and prints an error message in the console if triggered.

Warehouse class implements Storage class with the same 5 methods.
- list() calls on the listInventory() method in FileReaderWriter class and passes through the “Warehouse” string so it would read from warehouse.txt. It is also responsible for catching exceptions from - listInventory() and will print an error message in the console.
- store() formats the line of information to be stored into warehouse.txt while confirming the action by printing a message in the console. It combines the barcode parameter taken from the caller method and location in the form of 3 integers corresponding to a 3D coordinate system used by the storage site which is entered by the user to form a new spot string. This spot string along with the “Warehouse” string are passed over to the storeIntoInventory() method in FileReaderWriter class. It is also responsible for catching exceptions from storeIntoInventory() and will print an error message in the console.
- find() calls the findInInventory() method in FileReaderWriter class and passes through both storage and barcode parameters received from its caller method into findInInventory(). It also catches exceptions from findInInventory() and prints an error message in the console if triggered.
- locate() calls the locateInInventory() method in FileReaderWriter class and passes through both storage and barcode parameters received from its caller method into locateInInventory(). It also catches exceptions from locateInInventory() and prints an error message in the console if triggered.
- take() calls the takeFromInventory() method in FileReaderWriter class and passes through both storage and barcode parameters received from its caller method into takeFromInventory(). It also catches exceptions from takeFromInventory() and prints an error message in the console if triggered.

FileReaderWriter class is a class containing 6 methods, listInventory(), storeIntoInventory(), findInInventory(), locateInInventory(), takeFromInventory() and splitOnSpace().
listInventory() takes in the storage parameter to decide whether it would work on office.txt or warehouse.txt. Then it would take the first line in the selected text file, separate it into multiple parts with the help of the splitOnSpace() method and format the information into a whole line that is printed by the console for the user to read. This process is repeated with a for loop until all lines in the text file have been processed.
- storeIntoInventory() takes in storage and spot string parameters from its caller method. Storage parameter is used to decide whether office.txt or warehouse.txt will be processed while spot parameter is the line of information that is added into the text file. Due to the way Java’s PrintWriter class works, existing information will have to be copied to memory space, information from the spot parameter is added to it and finally all information will replace everything within the text file.
- findInInventory() takes in two parameters, storage and barcode from its caller method. Storage parameter is used to decide whether office.txt or warehouse.txt will be processed. The splitOnSpace() method is used to separate each line into parts and the first part will be tested on whether it’s the same as the barcode parameter. If it finds at least 1 match in the whole text file, it will return true to the caller method and false otherwise. 
- locateInInventory() takes in two parameters, storage and barcode from its caller method. Storage parameter is used to decide whether office.txt or warehouse.txt will be processed. The splitOnSpace() method is used to separate each line into parts and the first part will be tested on whether it’s the same as the barcode parameter. When it finds a match, it will format the whole line of data and print in the console to show to the user. This is repeated until the whole text file has been processed.
- takeFromInventory() takes in two parameters, storage and barcode from its caller method. Storage parameter is used to decide whether office.txt or warehouse.txt will be processed. The splitOnSpace() method is used to separate each line into parts and the first part will be tested on whether it’s the same as the barcode parameter. When it finds a match, it will format the whole line of data, print in the console and delete the line from the text file. Due to the way Java’s PrintWriter class works, it has to copy all existing information to memory space, remove the line we found a match on and finally all information will replace everything within the text file.
- splitOnSpace() splits the line passed into it into multiple parts based on space in each line.

StorageMapTester class is a tester class which tests methods within Office, Warehouse and FileReaderWriter classes. 


# Stopper (Alert System)
The stopper or the alert system used in the inventory consists of three clases which are "Application", "Material", and "MaterialList".

Application class is the class that has all the alert system functions are combined to be executed when the feature is run by the user. Inside of the class, there are three functions. The first, the crucial one for the execution of the feature, is called "runAPP". It has all the functions written in other classes to run the alert system properly. The second function inside the Application class is called as "materialAdd". As it can be guessed from its name, it does add the names, amounts, maximum and minimum values of each material stored in the inventory. The third, and the final function inside this class, is named as "importExport". In this function, it performs either import or export process depending on the user's answers to the questions on the console. Questions helps to decide which material and amount to be imported or exported. The code functions with switch case. 


Material class is where the material is added. In other words, its constructor method is used as a materials data input panel. Due to this reason, it also consists of getters and setters. In addition, this is where the limits are chceked by the user's imputs to the console with "importAmount" and "exportAmount" functions. If the limits are exceeded, it executes execptions to show that limits are passed. One feature of the "exportAmount" function is that it bumps up a warning message if the amount of a material drops below the mimimum limit.  

As for the final class of the stopper feature, MaterialList class, it stores the materials as an arraylist made inside this class. With this informtaion, it has functions related to arraylist like: adding material, getting material list to see which elements are stored inside, or a different way to print the elements inside the arraylist using "toString" function.

# Stopper Functions

public String toString():it returns the elements to the console in a different format.
  
public void checkMinAmount(): checks if the amount left is below minStock.
  
public void giveWarning(): It gives the warning the user if the stock is below minStock.
  
public void runApp() throws LimitExceededException: it is the main function of the alert.
    
private void importExport(String appType, int materialIndex, int amount) throws LimitExceededException: it does the export and import applications based on the users choices.

These functions were implemented to improve the quality of the user interface. In other words, to increase the usability of the software. If these features were not implemented, it would be a lot harder fot the user to understand and to use the program.


