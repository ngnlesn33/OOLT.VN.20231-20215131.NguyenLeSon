package AimsProject.src.hust.soict.hedspi.aims.store;


import AimsProject.src.hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new Store object
        Store myStore = new Store();

        // Create some Media items
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Son", 5, 19.95f);
        ArrayList<String> authors = new ArrayList<>(List.of("J.K. Rowling"));
        Book book1 = new Book(1, "Harry Potter and the Sorcerer's Stone", "Fantasy", 24.95f, authors);
        Track track1 = new Track("Beat It", 425);
        Track track2 = new Track("Thriller", 436);
        ArrayList<Track> trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        CompactDisc cd1 = new CompactDisc(2, "Thriller", "Pop", 15.95f, 42, "Michael Jackson", "Michael Jackson", trackList);

        // Add the Media items to the store
        myStore.addMediaToStore(dvd1);
        myStore.addMediaToStore(book1);
        myStore.addMediaToStore(cd1);

        // Remove a Media item from the store
        myStore.removeMediaFromStore(dvd1);

        // Print the items in the store
        System.out.println("Items in store:");
        for (Media media : myStore.getItemsInStore()) {
            if (media != null) {
                System.out.println(media);
            }
        }
    }
}
