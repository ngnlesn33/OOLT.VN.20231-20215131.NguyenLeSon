package AimsProject.src.hust.soict.hedspi.test.screen.customer.store;

import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Track;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.CartController;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestViewStoreScreen extends Application {
    public static Cart cart;
    private static final Store store = new Store();

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "../../../../aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();
//        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King 1", "Animation", "Son", 5, 19.95f);
        ArrayList<String> authors = new ArrayList<>(List.of("J.K. Rowling"));
        Book book1 = new Book(2, "Harry Potter and the Sorcerer's Stone", "Fantasy", 24.95f, authors);
        Track track1 = new Track("Beat It", 425);
        Track track2 = new Track("Thriller", 436);
        ArrayList<Track> trackList = new ArrayList<>();
        trackList.add(track1);
        trackList.add(track2);
        CompactDisc cd1 = new CompactDisc(3, "Thriller", "Pop", 15.95f, 42, "Michael Jackson", "Michael Jackson", trackList);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Lion King 2", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Lion King 3", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Lion King 4", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "The Lion King 5", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6, "The Lion King 6", "Animation", "Son", 5, 19.95f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc(6, "The Lion King 7", "Animation", "Son", 5, 19.95f);

        store.addMediaToStore(dvd1);
        store.addMediaToStore(dvd2);
        store.addMediaToStore(dvd3);
        store.addMediaToStore(dvd4);
        

        cart.addMediaToCart(dvd1);
        cart.addMediaToCart(dvd2);
        cart.addMediaToCart(dvd3);
        cart.addMediaToCart(dvd4);
        cart.addMediaToCart(dvd5);
        cart.addMediaToCart(dvd6);
        cart.addMediaToCart(dvd7);
        cart.addMediaToCart(book1);
        cart.addMediaToCart(cd1);
        launch(args);
    }
}