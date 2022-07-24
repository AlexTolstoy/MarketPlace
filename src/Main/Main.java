package Main;

import MarketPlace.MarketPlace;
import Person.User;
import Product.Product;

import java.util.Scanner;

/**
 * @author Alex Tolstoy
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = new String();
        MarketPlace marketPlace = new MarketPlace();

        try {
            marketPlace.buyProduct(2, 2);
            marketPlace.buyProduct(2, 1);
            marketPlace.buyProduct(3, 3);
            marketPlace.buyProduct(1, 1);
            marketPlace.buyProduct(1, 2);
            marketPlace.buyProduct(3, 3);
        } catch (Exception e) {

        }

    }
}
