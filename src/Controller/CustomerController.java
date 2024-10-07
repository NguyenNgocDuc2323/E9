package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerController {
    private Customer customer;
    private List<Customer> customers;
    private CustomerService cs;
    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
        this.customer = cs.getCustomer();
    }
    public Customer updateInfor(int id){
        Customer foundCus = cs.updateInfor(id);
        return foundCus;
    }
    public void sortObj(){
        cs.sortObj();
    }
    public List<Customer> findByName(String name){
        List<Customer> foundCus = cs.findByName(name);
        return foundCus;
    }
    public Customer findById(int id){
        Customer foundCus = cs.findById(id);
        return foundCus;
    }
}
