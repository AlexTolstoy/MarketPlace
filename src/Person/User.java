package Person;

/**
 * @author Alex Tolstoy
 */
public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private int money;

    public User(int id, String firstName, String lastName, int money) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean decreaseMoney(int count){
        boolean result = false;
        if (count < money){
            money -= count;
            result = true;
        }
        return result;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("User's id: %d\nFirst Name: %s\nLast Name: %s\nAmount of money: %d.%02d",
                id, firstName, lastName, money / 100, money % 100);
    }
}
