// This is a Java program that uses Swing to create a GUI that displays a number grid and allows the user to enter and delete digits

import javax.swing.*; // Import the Swing package for GUI components
import java.awt.*; // Import the AWT package for layout and event handling
import java.awt.event.ActionEvent; // Import the ActionEvent class for handling user actions
import java.awt.event.ActionListener; // Import the ActionListener interface for listening to user actions

public class NumberGrid extends JFrame { // Define a class that inherits from the JFrame class
    private final JButton[] btnNumbers = new JButton[10]; // Declare a private final array of JButton objects for the number buttons
    private final JTextField tfDisplay; // Declare a private final JTextField object for displaying the entered digits

    public NumberGrid() { // Define a constructor for the class
        tfDisplay = new JTextField(); // Create a new JTextField object
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Set the text orientation to right-to-left
        JPanel panelButtons = new JPanel(new GridLayout(4, 3)); // Create a new JPanel object with a 4x3 grid layout
        addButtons(panelButtons); // Call the addButtons method to add the buttons to the panel
        Container cp = getContentPane(); // Get the content pane of the frame
        cp.setLayout(new BorderLayout()); // Set the layout of the content pane to a border layout
        cp.add(tfDisplay, BorderLayout.NORTH); // Add the text field to the north region of the content pane
        cp.add(panelButtons, BorderLayout.CENTER); // Add the panel to the center region of the content pane
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation to exit the program
        setTitle("Number Grid"); // Set the title of the frame
        setSize(300, 300); // Set the size of the frame
        setVisible(true); // Set the frame to be visible
    }

    void addButtons(JPanel panelButtons) { // Define a method that takes a JPanel object as a parameter and adds the buttons to it
        ButtonListener btnListener = new ButtonListener(); // Create a new ButtonListener object
        for (int i = 1; i <= 9; i++) { // Loop from 1 to 9
            btnNumbers[i] = new JButton("" + i); // Create a new JButton object with the number as the label
            panelButtons.add(btnNumbers[i]); // Add the button to the panel
            btnNumbers[i].addActionListener(btnListener); // Add an action listener to the button
        }
        JButton btnDelete = new JButton("DEL"); // Create a new JButton object with the label "DEL"
        panelButtons.add(btnDelete); // Add the button to the panel
        btnDelete.addActionListener(btnListener); // Add an action listener to the button
        btnNumbers[0] = new JButton("0"); // Create a new JButton object with the label "0"
        panelButtons.add(btnNumbers[0]); // Add the button to the panel
        btnNumbers[0].addActionListener(btnListener); // Add an action listener to the button
        JButton btnReset = new JButton("C"); // Create a new JButton object with the label "C"
        panelButtons.add(btnReset); // Add the button to the panel
        btnReset.addActionListener(btnListener); // Add an action listener to the button
    }

    private class ButtonListener implements ActionListener { // Define a private inner class that implements the ActionListener interface
        @Override
        public void actionPerformed(ActionEvent e) { // Override the actionPerformed method to handle user actions
            String button = e.getActionCommand(); // Get the label of the button that was clicked
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') { // If the button is a digit
                tfDisplay.setText(tfDisplay.getText() + button); // Append the digit to the text field
            } else if (button.equals("DEL")) { // If the button is "DEL"
                if (!tfDisplay.getText().isEmpty()) { // If the text field is not empty
                    tfDisplay.setText(tfDisplay.getText().substring(0, tfDisplay.getText().length() - 1)); // Remove the last character from the text field
                }
            } else if (button.equals("C")) { // If the button is "C"
                tfDisplay.setText(""); // Clear the text field
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
