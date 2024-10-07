package Service;

import Entity.Customer;
import Entity.Igeneric;
import Global.Global;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomerService implements Igeneric<Customer> {
    private Customer customer;
    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    @Override
    public Customer updateInfor(int id) {
        Customer foundCus = customers.get(id);
        foundCus.setDiscount(customer.getDiscount() + 10);
        foundCus.setId(10);
        customer.setName("Ngoc Dung");
        return  foundCus;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public void sortObj() {
        customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> foundByName = customers.stream()
                .filter(customer1 -> Global.ignoreCase(customer1.getName(),name))
                .toList();
        return foundByName;
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> foundById = customers.stream()
                .filter(customer1 -> customer1.getId() == id)
                .findFirst();
        return foundById.isPresent() ? foundById.get() : null;
    }
}
