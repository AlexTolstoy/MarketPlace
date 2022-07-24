package MarketPlace;

import Person.User;
import Product.Product;
import Purchase.Purchase;

import java.util.ArrayList;

/**
 * @author Alex Tolstoy
 */
public class MarketPlace {
    private ArrayList<User> userList;
    private ArrayList<Product> productsList;
    private ArrayList<Purchase> purchaseList;

    public MarketPlace() {
        userList = new ArrayList<>();
        productsList = new ArrayList<>();
        purchaseList = new ArrayList<>();
        userList.add(new User(1, "Mike", "Dou", 500_000));
        userList.add(new User(2, "Alex", "Smith", 10_000_000));
        userList.add(new User(3, "Kate", "Dorian", 200_000));
        productsList.add(new Product(1, "Pizza", 1099));
        productsList.add(new Product(2, "Bicycle Santa Cruz", 500098));
        productsList.add(new Product(3, "OnePlus 10T", 90000));

    }

    public void showAllUsers() {
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    public void showAllProducts() {
        for (Product product : productsList) {
            System.out.println(product.toString());
        }
    }

    public void buyProduct(int userId, int productId) throws Exception {
        if (getUserById(userId) != null && getProductById(productId) != null) {
            if (getUserById(userId).decreaseMoney(getProductById(productId).getPrice())) {
                if (isUserPurchased(userId)) {
                    for (int i = 0; i < purchaseList.size(); i++) {
                        if (purchaseList.get(i).getUserId() == userId) {
                            purchaseList.get(i).addProduct(productId);
                        }
                    }
                } else {
                    purchaseList.add(new Purchase(userId, productId));
                }
                System.out.println(String.format("User %s %s bought %s",
                        getUserById(userId).getFirstName(),
                        getUserById(userId).getLastName(),
                        getProductById(productId).getName()));
            } else {
                throw new Exception("Not enough money to buy");
            }
        }
    }

    private User getUserById(int id) {
        if (id > 0 && id <= userList.size())
            return userList.get(id - 1);
        return null;
    }

    private Product getProductById(int id) {
        if (id > 0 && id <= productsList.size())
            return productsList.get(id - 1);
        return null;
    }

    private boolean isUserPurchased(int id) {
        boolean result = false;
        for (Purchase purchase : purchaseList) {
            if (purchase.getUserId() == id)
                result = true;
        }
        return result;
    }

    public void showAllPurchases() {
        for (Purchase purchase : purchaseList) {
            System.out.println(purchase.toString());
        }
    }

    public void showUserPurchaseById(int id) {
        for (Purchase purchase : purchaseList) {
            if (purchase.getUserId() == id) {
                ArrayList<Integer> purchases = purchase.getPurchasedProducts();
                System.out.println("User " + getUserById(id).getFirstName() + " "
                        + getUserById(id).getLastName() + " purchases:");
                for (Integer productsId : purchases) {
                    System.out.println(getProductById(productsId).getName());
                }
            }
        }
    }

    public void showUserByPurchaseProductId(int id) {
        if (getProductById(id) != null) {
            System.out.println("Product owners: ");
            for (Purchase purchase : purchaseList) {
                if (purchase.getPurchasedProducts().indexOf(id) >= 0) {
                    System.out.println(getUserById(purchase.getUserId()).getFirstName() + " "
                            + getUserById(purchase.getUserId()).getLastName());
                }
            }
        }
    }

    public void addUser(String firstName, String lastName, int money) {
        userList.add(new User(userList.get(userList.size() - 1).getId() + 1, firstName, lastName, money));
    }

    public void addProduct(String name, int price) {
        productsList.add(new Product(productsList.get(productsList.size() - 1).getId() + 1, name, price));
    }

    public void deleteUserById(int id) {
        if (getUserById(id) != null) {
            userList.remove(id - 1);
        }
    }

    public void deleteProductById(int id) {
        if (getProductById(id) != null) {
            productsList.remove(id - 1);
            for (int i = 0; i < purchaseList.size(); i++) {
                purchaseList.get(i).getPurchasedProducts().remove(id - 1);
            }
        }
    }
}
