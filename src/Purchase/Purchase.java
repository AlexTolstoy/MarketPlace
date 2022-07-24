package Purchase;

import java.util.ArrayList;

/**
 * @author Alex Tolstoy
 */
public class Purchase {
    private int userId;
    private ArrayList<Integer> purchasedProducts;

    public Purchase(int userId, int productId) {
        this.userId = userId;
        purchasedProducts = new ArrayList<>();
        purchasedProducts.add(productId);
    }

    public int getUserId() {
        return userId;
    }

    public void addProduct(int productId){
        purchasedProducts.add(productId);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "userId=" + userId +
                ", purchasedProducts=" + purchasedProducts +
                '}';
    }
}
