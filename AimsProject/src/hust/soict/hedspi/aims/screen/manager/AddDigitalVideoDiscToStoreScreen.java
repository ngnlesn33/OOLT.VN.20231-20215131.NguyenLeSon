// Import necessary packages
package AimsProject.src.hust.soict.hedspi.aims.screen.manager;
import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
// Definition of the class for adding a book to the store
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    // Instance variable to store the input field for authors
    private JTextField directorField;
    private JTextField lengthField;
    // Constructor for the AddBookToStoreScreen class
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        // Call the constructor of the parent class
        super(store);
        // Set up the layout of the frame
        Container cp = getContentPane();
        // Add an input field for authors to the frame
        cp.add(new JLabel("Enter the length of the CD (separated by commas):"));
        lengthField = new JTextField(20);
        cp.add(lengthField);
        cp.add(new JLabel("Enter the director of the CD (separated by commas):"));
        directorField = new JTextField(20);
        cp.add(directorField);
        // Set frame properties
        setTitle("Add DVD");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // Method to create a book object from the input values
    @Override
    protected Media createMediaItem(int id, String title, String category, float cost) {
        // Get the input values from the fields
//        String title = titleField.getText();
        int length = Integer.parseInt(lengthField.getText());
        String director = directorField.getText().trim();
        // Split the authors string by commas to get an array of authors
        // Create a list of authors from the array

        // Create a new book object with the input values
        // Return the book object
        return new DigitalVideoDisc(id, title, category,director,length ,cost);
    }
}
