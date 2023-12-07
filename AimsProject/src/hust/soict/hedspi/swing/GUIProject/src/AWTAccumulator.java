// This is a Java program that uses AWT to create a GUI that accumulates the sum of integers entered by the user

import java.awt.*; // Import the AWT package for GUI components
import java.awt.event.ActionEvent; // Import the ActionEvent class for handling user actions
import java.awt.event.ActionListener; // Import the ActionListener interface for listening to user actions

public class AWTAccumulator extends Frame { // Define a class that inherits from the Frame class
    private final TextField tfInput; // Declare a private final TextField object for user input
    private final TextField tfOutput; // Declare a private final TextField object for output display
    private int sum = 0; // Declare and initialize a private int variable for the accumulated sum, init to 0

    // Constructor to set up the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); // Set the layout of the frame to a 2x2 grid
        add(new Label("Enter an Integer: ")); // Add a label to the first cell of the grid
        tfInput = new TextField(10); // Create a new TextField object with 10 columns for user input
        add(tfInput); // Add the TextField object to the second cell of the grid
        tfInput.addActionListener(new TFInputListener()); // Add an action listener to the TextField object
        add(new Label("The Accumulated Sum is: ")); // Add a label to the third cell of the grid
        tfOutput = new TextField(10); // Create a new TextField object with 10 columns for output display
        tfOutput.setEditable(false); // Set the TextField object to be non-editable
        add(tfOutput); // Add the TextField object to the fourth cell of the grid
        setTitle("AWT Accumulator"); // Set the title of the frame
        setSize(400, 170); // Set the size of the frame
        setVisible(true); // Set the frame to be visible
    }

    public static void main(String[] args) {
        new AWTAccumulator(); // Create a new instance of the AWTAccumulator class
    }

    private class TFInputListener implements ActionListener { // Define a private inner class that implements the ActionListener interface
        @Override
        public void actionPerformed(ActionEvent evt) { // Override the actionPerformed method to handle user actions
            int numberIn = Integer.parseInt(tfInput.getText()); // Parse the user input as an integer
            sum += numberIn; // Add the user input to the sum
            tfInput.setText(""); // Clear the user input
            tfOutput.setText(sum + ""); // Display the sum as a string
        }
    }
}
