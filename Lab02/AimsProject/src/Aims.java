package Lab02.AimsProject.src;//

public class Aims {

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95F);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 24.99F);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 29.99F);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 21.5F);
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
