package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

// Comparator for sorting media by title, then cost
public class TitleThenCostComparator implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // If titles are the same, compare by cost (higher cost first)
        return -Float.compare(m1.getCost(), m2.getCost());
    }
}

