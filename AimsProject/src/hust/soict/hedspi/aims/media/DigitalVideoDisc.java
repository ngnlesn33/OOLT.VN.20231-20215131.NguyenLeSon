package AimsProject.src.hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    private static int nbDigitalVideoDiscs = 0; // Class attribute

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost, DigitalVideoDisc dvd1) {
        super(id, title, category, cost, length, director);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id,title, category, cost, length, director);
        nbDigitalVideoDiscs++; // Update the class attribute
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Override the toString() method in the DigitalVideoDisc class.
    public String toString() {
        // Return a string with the disc details.
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() +" - "+ this.getLength() + ": " + this.getCost() + " $";
    }

    public boolean isMatch(String title){
        return this.getTitle().equalsIgnoreCase(title.trim());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

