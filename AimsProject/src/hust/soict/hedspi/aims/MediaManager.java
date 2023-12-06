package AimsProject.src.hust.soict.hedspi.aims;

import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediaManager {
    private final Store store;
    private Scanner scanner;

    public MediaManager(Store store) {
        this.scanner = new Scanner(System.in);
        this.store = store;
    }

    public void addNewMedia() {
        System.out.println("What type of media would you like to add? (Book/CD/DVD)");
        String mediaType = scanner.nextLine().trim().toLowerCase();

        switch (mediaType) {
            case "book":
                addBook();
                break;
            case "cd":
                addCD();
                break;
            case "dvd":
                addDVD();
                break;
            default:
                System.out.println("Invalid media type.");
                break;
        }
    }

    private void addBook() {
        // Prompt for and read book details
        System.out.println("Enter Book ID, Title, Category, Cost, and Authors (comma separated):");
        int id = scanner.nextInt();
        String title = scanner.next();
        String category = scanner.next();
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the remaining newline
        String authorsLine = scanner.nextLine();
        List<String> authors = new ArrayList<>(List.of(authorsLine.split(",")));

        Book book = new Book(id, title, category, cost, authors);
        store.addMedia(book);
    }

    private void addCD() {
        // Prompt for and read CD details
        System.out.println("Enter CD ID, Title, Category, Cost, Length, Director, Artist:");
        int id = scanner.nextInt();
        String title = scanner.next();
        String category = scanner.next();
        float cost = scanner.nextFloat();
        int length = scanner.nextInt();
        String director = scanner.next();
        String artist = scanner.next();
        scanner.nextLine(); // Consume the remaining newline
        // Assume tracks are added separately

        CompactDisc cd = new CompactDisc(id, title, category, cost, length, director, artist, new ArrayList<>());
        store.addMedia(cd);
    }

    private void addDVD() {
        // Prompt for and read DVD details
        System.out.println("Enter DVD ID, Title, Category, Director, Length, Cost:");
        int id = scanner.nextInt();
        String title = scanner.next();
        String category = scanner.next();
        String director = scanner.next();
        int length = scanner.nextInt();
        float cost = scanner.nextFloat();

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
        store.addMedia(dvd);
    }

    public void removeFromMedia() {
        System.out.println("Enter the ID of the media you want to remove:");
        int mediaId = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        Media mediaToRemove = findMediaById(mediaId);
        if (mediaToRemove != null) {
            store.removeMedia(mediaToRemove);
            System.out.println("Media with ID " + mediaId + " has been removed.");
        } else {
            System.out.println("No media found with ID " + mediaId + ".");
        }
    }

    private Media findMediaById(int id) {
        for (Media media : store.getItemsInStore()) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }
}
