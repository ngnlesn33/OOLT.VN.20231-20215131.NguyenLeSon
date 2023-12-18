package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive.");
        }
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        // Check if the object is compared with itself
        if (o == this) {
            return true;
        }
        // Check if the object is an instance of Track
        // Typecast o to Track so that we can compare data members
        if (!(o instanceof Track other)) {
            return false;
        }
        // Compare the titles and return accordingly
        return Objects.equals(this.getTitle(), other.getTitle()) && Objects.equals(this.getLength(), other.getLength());
    }
}
