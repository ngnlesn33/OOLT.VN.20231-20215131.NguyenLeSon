// Import necessary packages
package AimsProject.src.hust.soict.hedspi.aims.screen.manager;
import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
// Definition of the class for adding a book to the store
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    // Instance variable to store the input field for authors
    private JTextField authorsField;
    // Constructor for the AddBookToStoreScreen class
    public AddBookToStoreScreen(Store store) {
        // Call the constructor of the parent class
        super(store);
        // Set up the layout of the frame
        Container cp = getContentPane();
        // Add an input field for authors to the frame
        cp.add(new JLabel("Enter the authors of the book (separated by commas):"));
        authorsField = new JTextField(20);
        cp.add(authorsField);
        // Set frame properties
        setTitle("Add Book");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // Method to create a book object from the input values
    @Override
    protected Media createMediaItem(int id, String title, String category, float cost) {
        // Get the input values from the fields
//        String title = titleField.getText();
//        String category = categoryField.getText();
        String authorsString = authorsField.getText();
        // Split the authors string by commas to get an array of authors
        String[] authorsArray = authorsString.split(",");
        // Create a list of authors from the array
        ArrayList<String> authors = new ArrayList<>();
        for (String author : authorsArray) {
            authors.add(author.trim());
        }
        // Create a new book object with the input values
        // Return the book object
        return new Book(id, title, category, cost, authors);
    }
}
