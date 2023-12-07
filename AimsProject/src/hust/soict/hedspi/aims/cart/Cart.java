package AimsProject.src.hust.soict.hedspi.aims.cart;


import AimsProject.src.hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final ArrayList<Media> itemsOrdered = new ArrayList<Media>();


    public Cart() {
    }

    public float totalCost() {
        float currentCost = 0.0F;

        for (Media media : itemsOrdered) {
            currentCost += media.getCost();
        }

        return currentCost;
    }

    public ArrayList<Media> getItemsOrder() {
        return this.itemsOrdered;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        for (Media item : this.getItemsOrder()) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**************************************************");
    }

    // Method to search for DVDs in the cart by title and print the results.
//    public void searchByTitle(String title) {
//        boolean matchFound = false;
//        for (Media item : this.getItemsOrder()) {
//            if (item != null && item.isMatch(title)) {
//                System.out.println(item);
//                matchFound = true;
//            }
//        }
//        if (!matchFound) {
//            // Print a message to notify the user.
//            System.out.println("No DVD with title " + title + " found in the cart.");
//        }
//    }

    public void addMediaToCart(Media media) {
        itemsOrdered.add(media);
        System.out.println("The media " + media.getTitle() + " has been added to cart.");
    }

    public void removeMediaFromCart(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media" + media.getTitle() + "has been removed.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    public int getMediaCount(Class<?> mediaType) {
        int count = 0;
        for (Media media : this.getItemsOrder()) {
            if (mediaType.isInstance(media)) {
                count++;
            }
        }
        return count;
    }

    public void filterById(int id) {
        // Find the media item with the given id in the cart
        Media mediaToFilter = null;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                mediaToFilter = media;
                break;
            }
        }
        // If found, display the media item's information
        if (mediaToFilter != null) {
            System.out.println("The media item with id " + id + " is:");
            System.out.println(mediaToFilter);
        } else {
            System.out.println("No media item found with id " + id + ".");
        }
    }

    public void filterByTitle(String title) {
        // Find all the media items with the given title in the cart
        List<Media> mediaToFilter = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                mediaToFilter.add(media);
            }
        }
        // If found, display the media items' information
        if (!mediaToFilter.isEmpty()) {
            System.out.println("The media items with title " + title + " are:");
            for (Media media : mediaToFilter) {
                System.out.println(media);
            }
        } else {
            System.out.println("No media item found with title " + title + ".");
        }
    }

    public void emptyCart(){
        itemsOrdered.clear();
    }
}