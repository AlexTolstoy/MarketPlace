package Main;

import MarketPlace.MarketPlace;
import Person.User;
import Product.Product;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author Alex Tolstoy
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command;
        MarketPlace marketPlace = new MarketPlace();
        showMenu();
        command = scanner.nextInt();
        while (command != 0){
            int userId = 0;
            int productId = 0;
            switch(command){
                case 1:
                    marketPlace.showAllUsers();
                    break;
                case 2:
                    marketPlace.showAllProducts();
                    break;
                case 3:
                    System.out.println("Enter user's id");
                    userId = scanner.nextInt();
                    System.out.println("Enter product's id");
                    productId = scanner.nextInt();
                    try {
                        marketPlace.buyProduct(userId, productId);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println("Enter user's id");
                    userId = scanner.nextInt();
                    marketPlace.showUserPurchaseById(userId);
                    break;
                case 5:
                    System.out.println("Enter product's id");
                    productId = scanner.nextInt();
                    marketPlace.showUserByPurchaseProductId(productId);
                    break;
            }
            showMenu();
            command = scanner.nextInt();
        }
        scanner.close();
    }
    private static void showMenu(){
        System.out.println("-----------------------\n" +
                "Menu:\n1 - Display list of all users\n" +
                "2 - Display list of all products\n" +
                "3 - Buy product\n" +
                "4 - Display list of user products by user id\n" +
                "5 - Display list of users that bought product by product id\n" +
                "0 - Exit\n" +
                "Waiting for a command");
    }
}
