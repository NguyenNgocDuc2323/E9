package Entity;

public class Account extends Customer{
    private int id;
    private Customer customer;
    private double balance;
    private String name;
    public Account(int id,Customer customer, double balance,String name) {
        super(customer.getId(), customer.getName(),customer.getGender(), customer.getDiscount());
        this.customer = customer;
        this.balance = balance;
        this.id = id;
        this.name = name;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
