package Person;

/**
 * @author Alex Tolstoy
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int money;

    public User(int id, String firstName, String lastName, int money) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean decreaseMoney(int count){
        boolean result = false;
        if (count < money){
            money -= count;
            result = true;
        }
        return result;
    }
    @Override
    public String toString() {
        return String.format("User's id: %d\nFirst Name: %s\nLast Name: %s\nAmount of money: %d.%02d",
                id, firstName, lastName, money / 100, money % 100);
    }
}
