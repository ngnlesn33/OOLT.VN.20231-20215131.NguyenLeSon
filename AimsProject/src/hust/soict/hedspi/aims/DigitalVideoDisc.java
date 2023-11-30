// The package statement declares a package for the class
package AimsProject.src;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// The class representing a Digital Video Disc (DVD)
public class DigitalVideoDisc {

    // Private attributes of the DVD class
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Class attribute to keep track of the total number of DigitalVideoDisc instances
    private static int nbDigitalVideoDiscs = 0;

    // Instance attribute representing the unique identifier for each DVD instance
    private int id;

    // Getter method for retrieving the title of the DVD
    public String getTitle() {
        return this.title;
    }

    // Getter method for retrieving the category of the DVD
    public String getCategory() {
        return this.category;
    }

    // Setter method for setting the title of the DVD
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for retrieving the director of the DVD
    public String getDirector() {
        return this.director;
    }

    // Getter method for retrieving the length of the DVD
    public int getLength() {
        return this.length;
    }

    // Getter method for retrieving the cost of the DVD
    public float getCost() {
        return this.cost;
    }

    // Constructor for creating a DVD with only a title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor for creating a DVD with title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor for creating a DVD with title, category, director, and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Constructor for creating a DVD with various attributes and a reference to another DVD
    public DigitalVideoDisc(String title, String category, String director, int length, float cost, DigitalVideoDisc dvd1) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Constructor for creating a DVD with all attributes and updating class attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++; // Update the class attribute to count the total number of DVDs
        this.id = nbDigitalVideoDiscs; // Assign a unique identifier to the DVD instance
    }

    // Static method for retrieving the total number of DigitalVideoDisc instances
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Getter method for retrieving the unique identifier ***********************CART***********************of the DVD instance
    public int getId() {
        return id;
    }


    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " minutes: " + cost + " $";
    }

    // New method to print the list of ordered items and the total cost
    //
    public static void printOrderedItems(ArrayList<DigitalVideoDisc> cart) {
        // Print the header of the cart
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        // Iterate through each DVD in the cart and print its information
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i).toString());
        }

        // Calculate and print the total cost
        float totalCost = calculateTotalCost(cart);
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }

    // Helper method to calculate the total cost of items in the cart
    private static float calculateTotalCost(ArrayList<DigitalVideoDisc> cart) {
        float totalCost = 0;
        for (DigitalVideoDisc dvd : cart) {
            totalCost += dvd.getCost();
        }
        return totalCost;
    }

    public static void searchDVDByTitle(ArrayList<DigitalVideoDisc> cart){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        scanner.close();
        if (isMatching(userInput,cart)){
            System.out.println("Found dvd");
        }
        else System.out.println("Not found");

    }
    private static boolean isMatching(String title,ArrayList<DigitalVideoDisc> cart){
        for (DigitalVideoDisc dvd : cart){
            if (Objects.equals(title, dvd.getTitle()))
                return true;
        }
        return false;
    }

}
