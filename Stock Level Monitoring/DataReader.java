package cosc310proj;

import java.io.*;
import java.util.Scanner;
import java.lang.Integer;

public class DataReader {
	
	public static void readProduct() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Which product would you like to view: \n(type c to return to main screen)");
			String prod = in.nextLine();
			if (prod.equals("c"))
				mainStock.start();
			
			
			String[] fetch = prodReturn(prod);
			if (fetch == null) {
				
				System.out.println("Product not found!");
				mainStock.finish();
			}
			
			
			System.out.println("Product ID: " + fetch[0]);
			System.out.println("Product Name: " + fetch[1]);
			System.out.println("Part Number: " + fetch[2]);
			System.out.println("Product Label: " + fetch[3]);
			System.out.println("Start Inventory: " + fetch[4]);
			System.out.println("Inventory Received: " + fetch[5]);
			System.out.println("Inventory Shipped: " + fetch[6]);
			System.out.println("Inventory On Hand: " + fetch[7]);
			System.out.println("Minimum Required: " + fetch[8]);
	
			mainStock.finish();
			
		} catch (NullPointerException e) {
			
			System.out.println(e);
			
		}
	}
	
	
	
	public static void changeProduct() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Which product would you like to change?");
		String prod = in.nextLine();
		String[] fetch = prodReturn(prod);
		if (fetch == null) {
			
			System.out.println("Product not found!");
			mainStock.finish();
			
		} else {
			
			System.out.println("What would you like to change? \nType c to return to main screen");
			String c = in.nextLine();
			if (c.equals("c"))
				mainStock.start();
			int changeNo = 0;
			
			switch (c) {
				case "id": changeNo = 0; break;
				case "prodName": changeNo = 1; break;
				case "partNumber": changeNo = 2; break;
				case "prodLabel":changeNo = 3; break;
				case "startInventory": changeNo = 4; break;
				case "inventoryReceived": changeNo = 5; break;
				case "inventoryShipped": changeNo = 6; break;
				case "inventoryOnHand": changeNo = 7; break;
				case "minimumRequired": changeNo = 8; break;
				default: System.out.println("Attribute not found!"); mainStock.finish();
			}
			System.out.println("New change: ");
			String change = in.nextLine();
			
			fetch[changeNo] = change;
		
			try {
				File file = new File("products.txt");
				file = file.getAbsoluteFile();
				File newfile = new File("temp.txt");
				newfile = newfile.getAbsoluteFile();
				Scanner sc = new Scanner(file);
				FileWriter fw = new FileWriter(newfile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				int initial = lineReturn(prod);
				int lineNo = Integer.parseInt(fetch[0]);
				
				int i = 0;
				for (i = -1; sc.hasNext(); i++) {
					
					
					if (i == lineNo) {
						for (int j = 0; j < fetch.length; j++) {
							fw.write(fetch[j] + ", ");
						}	
						
					} else if(i == initial){
						
						String l = sc.nextLine();
						
					} else {
						String line = sc.nextLine();
						fw.write(line);
						fw.write("\n");
					}
					
					
					
				}
				
				if (lineNo > i) {
					
					for (int j = 0; j < fetch.length; j++) {
						fw.write(fetch[j] + ", ");
					}	
					
				}
				
				
				file.delete();
				newfile.renameTo(file);
				fw.close();
				bw.close();
			} catch (IOException e) {
				System.out.println("IO Exception!");
			}
			
			
		}
		
		mainStock.finish();
	}
	

	public static String[] prodReturn(String s) {
		String[] result = new String[9];
		try {
			File file = new File("products.txt");
			Scanner sc = new Scanner(file.getAbsoluteFile());
			for (int i = 0; sc.hasNext(); i++) {
				String line = sc.nextLine();
				String[] data = line.split(", ");
				if (s.equals(data[1])) {
					result = data;
					return result;

				}	
						
			}
			
			
		} catch (FileNotFoundException e) {
			return null;
			
		}
		
		return null;
		
	}
	
	public static int lineReturn(String s) {
		int result = 0;
		try {
			File file = new File("products.txt");
			Scanner sc = new Scanner(file.getAbsoluteFile());
			for (int i = 1; sc.hasNext(); i++) {
				String line = sc.nextLine();
				String[] data = line.split(", ");
				if (s.equals(data[1]))
					result = i;
				
						
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			return -1;
			
		} catch (IOException e) {
			System.out.println("IO Exception!");
		}
		
		return result; 
		
		
	}
	
}
