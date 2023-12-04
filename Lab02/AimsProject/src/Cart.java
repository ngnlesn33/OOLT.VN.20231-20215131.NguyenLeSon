package Lab02.AimsProject.src;


public class Cart {
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[20];
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERED = 20;

    public Cart() {
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        int duplicateIndex = -1;
        if (this.qtyOrdered < 20) {
            int emptySlotIndex = -1;

            for (int i = 0; i <= this.qtyOrdered; ++i) {
                if (this.itemsOrdered[i] == null) {
                    emptySlotIndex = i;
                }

                if (this.itemsOrdered[i] != null && this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                    duplicateIndex = i;
                    break;
                }
            }

            if (emptySlotIndex != -1) {
                this.itemsOrdered[emptySlotIndex] = disc;
                ++this.qtyOrdered;
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
        DigitalVideoDisc[] var2 = dvdList;
        int var3 = dvdList.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            DigitalVideoDisc disc = var2[var4];
            this.addDigitalVideoDisc(disc);
        }

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int indexToRemove = -1;

        int i;
        for (i = 0; i < this.qtyOrdered; ++i) {
            if (this.itemsOrdered[i] != null && this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (i = indexToRemove; i < this.qtyOrdered; ++i) {
                this.itemsOrdered[i] = this.itemsOrdered[i + 1];
            }

            this.itemsOrdered[this.qtyOrdered - 1] = null;
            --this.qtyOrdered;
            System.out.println("Removed " + disc.getTitle() + " from cart.");
        } else {
            System.out.println(disc.getTitle() + " not found in cart.");
        }

    }

    public float totalCost() {
        float currentCost = 0.0F;

        for (int i = 0; i < this.qtyOrdered; ++i) {
            if (this.itemsOrdered[i] != null) {
                currentCost += this.itemsOrdered[i].getCost();
            }
        }

        return currentCost;
    }
}
