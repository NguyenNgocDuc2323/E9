package Entity;

import java.time.LocalDate;

public class Invoice extends Customer{
    private int id;
    Customer customer;
    private double amount;
    private LocalDate dateTime;

    public Invoice(int id, Customer customer, double amount, LocalDate dateTime) {
        super(customer.getId(), customer.getName(),customer.getGender(), customer.getDiscount());
        this.customer = customer;
        this.amount = amount;
        this.dateTime = dateTime;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
