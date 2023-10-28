public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create DVD objects and add them to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 29.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 21.50f);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd4);
        System.out.println("Total cost is: " + anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd1);
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total cost is: " + anOrder.totalCost());
    }

}
