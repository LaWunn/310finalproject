package locations;

import fileRW.FileReaderWriter;

import java.io.IOException;
import java.util.Scanner;

public class Warehouse implements Storage {
    int x;
    int y;
    int z;
    boolean success;
    String barcode;
    String location;
    FileReaderWriter fileData;
    Scanner textInput = new Scanner(System.in);

    public void list() {
        fileData = new FileReaderWriter();
        try {
            fileData.listInventory("Warehouse");
        } catch (IOException e) {
            System.out.println("Failed to read data from file.");
        }
    }
    //Format of spots: x-coordinate, y-coordinate, z-coordinate
    public void store(String barcode){
        System.out.println("Please enter the x coordinate of the storage space");
        x = textInput.nextInt();
        System.out.println("Please enter the y coordinate of the storage space");
        y = textInput.nextInt();
        System.out.println("Please enter the z coordinate of the storage space");
        z = textInput.nextInt();

        location = x + " " + y + " " + z;

        fileData = new FileReaderWriter();
        String spot = barcode + " " + location;
        System.out.println("Data {" + spot + "} will now be added to file");
        try {
            fileData.storeIntoInventory("Warehouse", spot);
        } catch (IOException e) {
            System.out.println("Failed to write data to file.");
        }

    }
    public boolean find(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            success = fileData.findInInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use finder method");
        }
        return success;
    }

    public void locate(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            fileData.locateInInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use locator method");
        }
    }
    public void take(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            fileData.takeFromInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use taker method");
        }
    }
}
