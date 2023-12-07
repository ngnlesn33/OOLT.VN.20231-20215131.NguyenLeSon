// Import necessary packages
package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Definition of the abstract class for adding an item to the store
public abstract class AddItemToStoreScreen extends JFrame implements ActionListener {
    // Instance variables to store the input fields and buttons
    protected JTextField idField;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;
    protected JButton addButton;
    protected JButton cancelButton;
    // Instance variable to store a reference to the store
    protected final Store store;

    // Constructor for the AddItemToStoreScreen class
    public AddItemToStoreScreen(Store store) {
        // Initialize the store reference
        this.store = store;
        // Set up the layout of the frame
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(8, 2, 5, 5));
        cp.add(new JLabel("Enter the id of the item:"));
        idField = new JTextField(20);
        cp.add(idField);
        cp.add(new JLabel("Enter the title of the item:"));
        titleField = new JTextField(20);
        cp.add(titleField);
        cp.add(new JLabel("Enter the category of the item:"));
        categoryField = new JTextField(20);
        cp.add(categoryField);
        cp.add(new JLabel("Enter the cost of the item:"));
        costField = new JTextField(20);
        cp.add(costField);
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        cp.add(addButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        cp.add(cancelButton);
        // Set frame properties
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Abstract method to create a media object from the input values
    protected abstract Media createMediaItem(int id,String title,String category, float cost);

    // Method to handle the action events of the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the event
        Object source = e.getSource();
        // If the source is the add button
        if (source == addButton) {
            // Get the input values from the fields
            String idString = idField.getText();
            String title = titleField.getText();
            String category = categoryField.getText();
            String costString = costField.getText();
            // Validate the input values
            if (idString.isEmpty() || title.isEmpty() || category.isEmpty() || costString.isEmpty()) {
                // Show an error message if any field is empty
                JOptionPane.showMessageDialog(this, "Please enter all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int id = Integer.parseInt(idString);
                    // Parse the cost string to a float value
                    float cost = Float.parseFloat(costString);
                    // Create a media object from the input values by calling the abstract method
                    Media media = createMediaItem(id,title,category,cost);
                    // Add the media object to the store
                    store.addMediaToStore(media);
                    // Show a success message
                    JOptionPane.showMessageDialog(this, "The item has been added to the store", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Close the frame
                    dispose();
                } catch (NumberFormatException ex) {
                    // Show an error message if the cost string is not a valid float value
                    JOptionPane.showMessageDialog(this, "Please enter a valid cost", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        // If the source is the cancel button
        if (source == cancelButton) {
            // Close the frame
            dispose();
        }
    }
}
