package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

// Comparator for sorting media by cost, then title
public class CostThenTitleComparator implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costComparison = -Float.compare(m1.getCost(), m2.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // If costs are the same, compare by title
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
