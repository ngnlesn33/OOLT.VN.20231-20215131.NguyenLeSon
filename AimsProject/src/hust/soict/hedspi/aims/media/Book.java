package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.List;

public class Book extends Media {
    private final List<String> authors;

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost); // Call the constructor of the superclass Media
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return super.toString() + ", authors=" + authors;
    }
}
