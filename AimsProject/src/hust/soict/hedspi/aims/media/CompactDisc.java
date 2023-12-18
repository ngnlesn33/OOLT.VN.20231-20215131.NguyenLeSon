package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void printTrack() {
        for (Track track : this.getTracks()) {

        }
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) { // Check if the input track is already in the list of tracks
            System.out.println("The track " + track.getTitle() + " already exists in the CD");
        } else {
            tracks.add(track); // Add the track to the list of tracks
            System.out.println("The track " + track.getTitle() + " has been added to the CD");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) { // Check if the input track existed in the list of tracks
            tracks.remove(track); // Remove the track from the list of tracks
            System.out.println("The track " + track.getTitle() + " has been removed from the CD");
        } else {
            System.out.println("The track " + track.getTitle() + " does not exist in the CD");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0; // Initialize the total length of the CD
        for (Track track : tracks) { // Loop through each track in the list of tracks
            totalLength += track.getLength(); // Add the length of the track to the total length
        }
        return totalLength; // Return the total length of the CD
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive.");
        }
    }

    public String toString() {
        // Return a string with the disc details.
        return super.toString() + ", artist=" + artist;
    }

}

