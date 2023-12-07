package AimsProject.src.hust.soict.hedspi.aims.store;

import AimsProject.src.hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<>();

    public Store() {

    }

    public void addMediaToStore(Media media) {
        if (media != null && !this.itemsInStore.contains(media)) {
            this.itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        }
    }


    public void removeMediaFromStore(Media media) {
        if (media != null && this.itemsInStore.contains(media)) {
            this.itemsInStore.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media is not found in the store.");
        }
    }

    // Create a getter method for the itemsInStore attribute that returns the array.
    public ArrayList<Media> getItemsInStore() {
        // Return the itemsInStore attribute.
        return this.itemsInStore;
    }

    public Media getMedia(String title) {
        // Return the itemsInStore attribute.
        for (Media media : this.getItemsInStore()) {
            if (Objects.equals(media.getTitle(), title)) {
                return media;
            }
        }
        return null;
    }

    // Create a method called printStore that prints the details of all the discs in the store and their total number.
    public void printStore() {
        // Declare a variable to store the total number of discs in the store.
        int count = 0;
        // Print a header for the store information.
        System.out.println("The store has the following DVDs:");
        // Loop through the itemsInStore array.
        for (Media disc : this.itemsInStore) {
            // Check if the current element is not null, meaning it is not empty.
            if (disc != null) {
                // Increment the count variable by one, as there is one more disc in the store.
                count++;
                // Print the details of the current disc using its toString() method.
                System.out.println(disc);
            }
        }
        // Print a footer for the store information with the total number of discs in the store.
        System.out.println("The store has " + count + " DVDs in total.");
    }
}