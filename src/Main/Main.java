package Main;

import MarketPlace.MarketPlace;
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
            int userId;
            int productId;
            switch (command) {
                case 1 -> marketPlace.showAllUsers();
                case 2 -> marketPlace.showAllProducts();
                case 3 -> {
                    System.out.println("Enter user's id");
                    userId = scanner.nextInt();
                    System.out.println("Enter product's id");
                    productId = scanner.nextInt();
                    try {
                        marketPlace.buyProduct(userId, productId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {

                    }
                }
                case 4 -> {
                    System.out.println("Enter user's id");
                    userId = scanner.nextInt();
                    marketPlace.showUserPurchaseById(userId);
                }
                case 5 -> {
                    System.out.println("Enter product's id");
                    productId = scanner.nextInt();
                    marketPlace.showUserByPurchaseProductId(productId);
                }
                case 6 -> {
                    System.out.println("Enter first name:");
                    String firstName = scanner.next();
                    System.out.println("Enter last name:");
                    String lastName = scanner.next();
                    System.out.println("Enter amount of money:");
                    int money = scanner.nextInt() * 100;
                    marketPlace.addUser(firstName, lastName, money);
                }
                case 7 -> {
                    System.out.println("Enter product name:");
                    String name = scanner.next();
                    System.out.println("Enter price:");
                    int price = scanner.nextInt();
                    marketPlace.addProduct(name, price);
                }
                case 8 -> {
                    System.out.println("Enter user's id");
                    userId = scanner.nextInt();
                    marketPlace.deleteUserById(userId);
                }
                case 9 -> {
                    System.out.println("Enter product's id");
                    productId = scanner.nextInt();
                    marketPlace.deleteProductById(productId);
                }
            }
            showMenu();
            command = scanner.nextInt();
        }
        scanner.close();
    }
    private static void showMenu(){
        System.out.println("""
                -----------------------
                Menu:
                1 - Display list of all users
                2 - Display list of all products
                3 - Buy product
                4 - Display list of user products by user id
                5 - Display list of users that bought product by product id
                6 - Add new user
                7 - Add new product
                8 - Delete user by id
                9 - Delete product by id
                0 - Exit
                Waiting for a command""");
    }
}
