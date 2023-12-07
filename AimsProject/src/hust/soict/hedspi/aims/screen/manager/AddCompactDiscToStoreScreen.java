package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.media.Track;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    // Instance variable to store the input field for authors
    private JTextField artistsField;
    private JTextField lengthField;
    private JTextField directorsField;
    // Constructor for the AddBookToStoreScreen class
    public AddCompactDiscToStoreScreen(Store store) {
        // Call the constructor of the parent class
        super(store);
        // Set up the layout of the frame
        Container cp = getContentPane();
        // Add an input field for authors to the frame
        cp.add(new JLabel("Enter the length of the CD:"));
        lengthField = new JTextField(20);
        cp.add(lengthField);
        cp.add(new JLabel("Enter the directors of the CD (separated by commas):"));
        directorsField = new JTextField(20);
        cp.add(directorsField);
        cp.add(new JLabel("Enter the artists of the CD (separated by commas):"));
        artistsField = new JTextField(20);
        cp.add(artistsField);
        // Set frame properties
        setTitle("Add CD");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // Method to create a book object from the input values
    @Override
    protected Media createMediaItem(int id, String title, String category, float cost) {

        int length = Integer.parseInt(lengthField.getText());

        String director = directorsField.getText();

        String artist = artistsField.getText();

        // Create a new book object with the input values
        // Return the book object
        return new CompactDisc(id, title, category, cost, length, director, artist);
    }
}
