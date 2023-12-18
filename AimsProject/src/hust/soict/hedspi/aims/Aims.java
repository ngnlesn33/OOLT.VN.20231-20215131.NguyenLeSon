package AimsProject.src.hust.soict.hedspi.aims;

import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import AimsProject.src.hust.soict.hedspi.aims.media.*;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.util.*;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    public static final MediaManager mediaManager = new MediaManager(store);

    public static void main(String[] args) throws PlayerException {
        // Create some Media items
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Son", 5, 19.95f);
        ArrayList<String> authors = new ArrayList<>(List.of("J.K. Rowling"));
        Book book1 = new Book(2, "Harry Potter and the Sorcerer's Stone", "Fantasy", 24.95f, authors);
        Track track1 = new Track("Beat It", 425);
        Track track2 = new Track("Thriller", 436);
        ArrayList<Track> trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        CompactDisc cd1 = new CompactDisc(3, "Thriller", "Pop", 15.95f, 42, "Michael Jackson", "Michael Jackson", trackList);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Lion King", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Lion King", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Lion King", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "The Lion King", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6, "The Lion King", "Animation", "Son", 5, 19.95f);

        store.addMediaToStore(dvd1);
        store.addMediaToStore(dvd2);
        store.addMediaToStore(dvd3);
        store.addMediaToStore(dvd4);
        store.addMediaToStore(dvd5);
        store.addMediaToStore(dvd6);
        store.addMediaToStore(book1);
        store.addMediaToStore(cd1);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() throws PlayerException {
        store.printStore();
        storeMenu();
    }

    public static void updateStore() {
        // Implement the logic to update the store
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store.");
        System.out.println("2. Remove a media from store.");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                mediaManager.addNewMedia();
                break;
            case 2:
                mediaManager.removeFromMedia();
                break;
            case 0:
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option! Please choose again.");
        }
    }

    public static void seeCurrentCart() {
        cart.printCart();
        Scanner scanner = new Scanner(System.in);
        cartMenu();
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                filterMediaInCart();
                break;
            case 2:
                sortMediaInCart();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                placeOrder();
                break;
            case 0:
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option! Please choose again.");
        }
    }

    private static void placeOrder() {
        System.out.println("You have ordered succesfully.");
        System.out.println("An order is created.");
        cart.emptyCart();
    }

    private static void sortMediaInCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title.");
        System.out.println("2. Sort by cost.");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
                cart.printCart();
                break;
            case 2:
                cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
                cart.printCart();
                break;
            case 0:
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option! Please choose again.");
        }
    }

    private static void filterMediaInCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by id.");
        System.out.println("2. Filter by title.");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the id: ");
                Scanner scannerId = new Scanner(System.in);
                int id = scannerId.nextInt();
                cart.filterById(id);
                break;
            case 2:
                System.out.println("Enter the title: ");
                Scanner scannerTitle = new Scanner(System.in);
                String title = scannerTitle.nextLine();
                cart.filterByTitle(title);
                break;
            case 0:
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option! Please choose again.");
        }
    }

    public static void storeMenu() throws PlayerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                viewMediaDetails(store);
                break;
            case 2:
                addMediaToCart(store, cart);
                break;
            case 3:
                playMedia();
                break;
            case 4:
                seeCurrentCart();
                break;
            case 0:
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option! Please choose again.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        // Check if the media is of type CD or DVD before displaying the "Play" option
        if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1" + (media instanceof CompactDisc || media instanceof DigitalVideoDisc ? "-2" : ""));

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addToCart(store, cart, media.getTitle());
                break;
            case 2:
                // Code to play the media if it's a CD or DVD
                break;
            case 0:
                // Code to go back to the previous menu
                break;
            default:
                System.out.println("Invalid option! Please choose again.");
                break;
        }
    }

    // Method to handle viewing media details
    public static void viewMediaDetails(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.getMedia(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found. Please try again.");
        }
    }

    public static void addMediaToCart(Store store, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();

        checkAndAddToCart(store, cart, title);
    }

    public static void addToCart(Store store, Cart cart, String title) {
        checkAndAddToCart(store, cart, title);
    }

    private static void checkAndAddToCart(Store store, Cart cart, String title) {
        Media media = store.getMedia(title);
        if (media != null) {
            cart.addMediaToCart(media);
            System.out.println("Media added to cart.");

            // If the media is a DVD, display the number of DVDs in the cart
            if (media instanceof DigitalVideoDisc) {
                int dvdCount = cart.getMediaCount(DigitalVideoDisc.class);
                System.out.println("There are now " + dvdCount + " DVDs in the cart.");
            }
        } else {
            System.out.println("Media not found. Please try again.");
        }
    }

    public static void playMedia() throws PlayerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = store.getMedia(title);
        if (media != null) {
            // If the media is a DVD, display the number of DVDs in the cart
            if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                ((Playable) media).play();
            } else System.out.println("Media cannot be play.");
        } else {
            System.out.println("Media not found. Please try again.");
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

}
