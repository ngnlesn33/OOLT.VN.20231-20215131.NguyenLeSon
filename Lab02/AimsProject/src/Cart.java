package Lab02.AimsProject.src;

public class Cart {
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERED = 20;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        int duplicateIndex = -1;
        // Find the first empty slot in itemsOrdered
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            int emptySlotIndex = -1;
            for (int i = 0; i <= qtyOrdered; i++) {
                if (itemsOrdered[i] == null) {
                    emptySlotIndex = i;
                }
                if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                    duplicateIndex = i;
                    break;
                }

            }
            // If an empty slot is found, add the disc
            if (emptySlotIndex != -1) {
                itemsOrdered[emptySlotIndex] = disc;
                qtyOrdered++;
                if (duplicateIndex != -1) {
                    System.out.println("A disc with the same title already exists.");
                }
                System.out.println("Added " + disc.getTitle() + " to cart.");
            } else {
                System.out.println("No empty slots available in the cart.");
            }
        } else {
            System.out.println("Cart is already full. Cannot add more items.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    //    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
    //        for (DigitalVideoDisc dvd : dvds) {
    //            addDigitalVideoDisc(dvd);
    //        }
    //    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int indexToRemove = -1;
        // Find the index to remove
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                indexToRemove = i;
                break;
            }
        }

        // If found the index, remove the disc by shifting  elements to the left
        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < qtyOrdered; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("Removed " + disc.getTitle() + " from cart.");
        } else {
            System.out.println(disc.getTitle() + " not found in cart.");
        }
    }

    public float totalCost() {
        float currentCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) {
                currentCost += itemsOrdered[i].getCost();
            }
        }
        return currentCost;
    }
}
