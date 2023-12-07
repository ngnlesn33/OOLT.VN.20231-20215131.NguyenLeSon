// Import necessary packages
package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import AimsProject.src.hust.soict.hedspi.aims.media.*;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Definition of the main class for the Store Manager Screen
public class StoreManagerScreen extends JFrame {
    // Instance variable to store a reference to the store
    private final Store store;

    // Constructor for the Store Manager Screen
    public StoreManagerScreen(Store store) {
        // Initialize the store reference
        this.store = store;

        // Set up the layout of the frame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Set frame properties
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to create the North panel of the frame
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Method to create the menu bar of the frame
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update Store");
        menu.add(smUpdateStore);
        JMenuItem addBookItem = new JMenuItem("Add Book");
        smUpdateStore.add(addBookItem);
        JMenuItem addCDItem = new JMenuItem("Add CD");
        smUpdateStore.add(addCDItem);
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVDItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        addBookItem.addActionListener(e -> new AddBookToStoreScreen(store));

        addCDItem.addActionListener(e -> new AddCompactDiscToStoreScreen(store));

        addDVDItem.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));

        return menuBar;
    }

    // Method to create the header panel of the frame
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Method to create the center panel of the frame
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        // Get the list of items in the store
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        // Iterate over the first 9 items (you might want to handle cases where the store has fewer than 9 items)
        for (int i = 0; i < 9; i++) {
            // Create a cell for each media item
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    // Static nested class representing a panel for displaying media information
    public static class MediaStore extends JPanel {
        // Constructor for the MediaStore panel
        public MediaStore(Media media) {
            // Set the layout of the panel
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            // Create a label for the title of the media
            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
            title.setAlignmentX(CENTER_ALIGNMENT);
            // Create a label for the cost of the media
            JLabel cost = new JLabel(media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);
            // Create a container panel for additional components
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            // If the media is playable, add a "Play" button
            if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
                container.add(playButton);
            }
            // Add components to the MediaStore panel
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    // The main method to start the application
    public static void main(String[] args) {
        // Create a store instance
        Store store = new Store();
        // Create instances of digital video discs, a book, and a compact disc
        // Create an ArrayList of authors for the book
        ArrayList<String> authors = new ArrayList<>(List.of("J.K. Rowling"));
        // Create a book instance
        Book book1 = new Book(2, "Harry Potter and the Sorcerer's Stone", "Fantasy", 24.95f, authors);
        // Create an ArrayList of tracks
        Track track1 = new Track("Beat It", 425);
        Track track2 = new Track("Thriller", 436);
        ArrayList<Track> trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        // Create a compact disc instance
        CompactDisc cd1 = new CompactDisc(3, "Thriller", "Pop", 15.95f, 42, "Michael Jackson", "Michael Jackson", trackList);
        // Create more digital video discs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Lord of the Rings: The Return of the King (Extended Edition)", "Fantasy Adventure", "Peter Jackson", 5, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Lion King 3", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Lion King 4", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "The Lion King 5", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6, "The Lion King 6", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc(7, "The Lion King 7", "Animation", "Son", 5, 19.95f);

        // Add media items to the store
        store.addMediaToStore(dvd1);
        store.addMediaToStore(dvd2);
        store.addMediaToStore(dvd3);
        store.addMediaToStore(dvd4);
        store.addMediaToStore(dvd5);
        store.addMediaToStore(dvd6);
        store.addMediaToStore(dvd7);
        store.addMediaToStore(book1);
        store.addMediaToStore(cd1);

        // Create and display the StoreManagerScreen
        new StoreManagerScreen(store);
    }
}
