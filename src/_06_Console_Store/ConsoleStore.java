package _06_Console_Store;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConsoleStore {

    /*
     * Write a program that simulates shopping in a store using the Scanner and
     * the classes in Generics_Store.
     * 
     * Note: You may need to modify existing code in Generics Store and/or add
     * additional items and pictures to fulfill all the requirements. You are
     * also free to add any additional methods or classes in Console Store that
     * might be helpful to you.
     * 
     * Requirements:
     * 
     * -Use Ternary operators in place of simple if/else statements and do-while
     * loops instead of while loops where appropriate.
     * 
     * - There should be at least four unique items the user can buy. These can
     * be food items, nonfood items or both.
     * 
     * - The user should have a stipend of money to spend and each item should
     * have its own price.
     * 
     * -The user should have the ability to add items to their cart, remove
     * items, view items or check out.
     * 
     * -The program should continue until the user chooses to check out.
     * 
     * -When the user checks out you should let them know if they do not have
     * enough money to purchase all their items and offer to put items back.
     * 
     * -If the user successfully purchases the items you should remove the
     * amount from their stipend, show them the pictures of what they bought and
     * print out a receipt showing their name, the individual prices of the
     * items and their total.
     */
	static int total;
    public static void main(String[] args) {
    	int budget = 50;
    	int aCost = 4;
    	int oCost = 5;
    	int cCost = 6;
    	int mCost = 7;
    	total = 0;
    	
    	ArrayList<String>fruitList = new ArrayList<String>();
    	ArrayList<Integer>fruitCost = new ArrayList<Integer>();
    	
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.println("name?");
    	String name = scan.next();
    	System.out.println("Do you want to add, remove, or checkout");
    	String again = scan.next();
    	 do {
    		
        	 if(again.equals("add")) {
        		 System.out.println("Do you want to buy an apple, orange, cherry, or mango");
        		 String choice = scan.next();
        		 
        		if(choice.equals("apple")) {
        			fruitList.add("apple");
        			fruitCost.add(aCost);
        			total += aCost;
        		}
        		else if(choice.equals("orange")) {
        			fruitList.add("ornage");
        			fruitCost.add(oCost);
        			total += oCost;
        		}
        		else if(choice.equals("cherry")) {
        			fruitList.add("cherry");
        			fruitCost.add(cCost);
        			total += cCost;
        		}
        		else if(choice.equals("mango")) {
        			fruitList.add("mango");
        			fruitCost.add(mCost);
        			total += mCost;
        		}
        		else {
        			System.out.println("error");
        		}
        			
        	 }
        	 else if(again.equals("remove")) {
        		 removeMethod(again, fruitCost, fruitList, total, aCost, oCost, cCost, mCost, scan);
        		 
        	 }
    		 
        	 System.out.println("Do you want to add, remove, or checkout");
             again = scan.next();
        } while (!again.equals("checkout")); 
           
        while(total > budget) {
        	System.out.println("you have too much");
        	removeMethod(again, fruitCost, fruitList, total, aCost, oCost, cCost, mCost, scan);
        }
        

        scan.close();
        System.out.println("Name: " + name);
        for(int i = 0; i<fruitList.size(); i++) {
        	System.out.println("Item: " + fruitList.get(i) + " Cost: " + fruitCost.get(i));
        }
        System.out.println("Cost: " + total);
    }
    
    
    public static void removeMethod(String again, ArrayList<Integer>fruitCost, ArrayList<String>fruitList, int total, int aCost, int oCost, int cCost, int mCost, Scanner scan) {
    	for(int i = 0; i< fruitCost.size(); i++) {
			 System.out.println("Item: " + fruitList.get(i) + " Cost: " + fruitCost.get(i));
			 
		 }
		 System.out.println("Total spent: " + total);
		 System.out.println("what index do you want to remove");
		 int removeIndex = scan.nextInt();
		 if(fruitList.get(removeIndex).equals("apple")) {
			total-=aCost; 
		 }
		 else if(fruitList.get(removeIndex).equals("orange")) {
			total-=oCost; 
		 }
		 else if(fruitList.get(removeIndex).equals("cherry")) {
			total-=cCost; 
		 }
		 else if(fruitList.get(removeIndex).equals("mango")) {
			total-=mCost; 
		 }
		 System.out.println(total);
		 ConsoleStore.total = total;
		 fruitList.remove(removeIndex);
		 fruitCost.remove(removeIndex);
    }

    
    public void showCart(ArrayList<String>fruitList) {
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	frame.add(panel);
    	frame.setVisible(true);
    	for(int i = 0; i < fruitList.size(); i++) {
    		if(fruitList.get(i).equals("apple")) {
    			panel.add();
    		}
    		else if (fruitList.get(i).equals("orange")) {
    			panel.add();
    		}
    		else if (fruitList.get(i).equals("cherry")) {
    			panel.add();
    		}
    		else if(fruitList.get(i).equals("mango")){
    			panel.add();
    		}
    	}
    }
    
    
    
}
