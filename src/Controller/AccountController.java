package Controller;

import Entity.Account;
import Entity.Customer;
import Entity.Invoice;
import Service.AccountService;
import Service.InvoiceService;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    private Account account;
    private List<Account> accounts;
    private AccountService as;
    private List<Invoice> invoices;
    private InvoiceService is;
    public AccountController(AccountService as, List<Invoice> invoices) {
        this.as = as;
        this.account = as.getAccount();
        this.accounts = as.getAccounts();
        this.invoices = invoices;

    }
    public String getCustomerName(Customer customer) {
        return customer.getName();
    }
    public Account deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        return account;
    }

    public void withdraw(double amount) {
        if(account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        }
        else{
            System.out.println("Tài Khoản Của Quý khách không đủ số dư");
        }
    }
    public Account updateInfor(int id){
        Account foundAcc = as.updateInfor(id);
        return  foundAcc;
    }
    public void sortObj(){
        as.sortObj();
    }

    public List<Account> findByName(String name){
        List<Account> foundCus = as.findByName(name);
        return foundCus;
    }
    public Account findById(int id){
        Account foundCus = as.findById(id);
        return foundCus;
    }
    public void checkCanAccPay() {
        accounts.stream().forEach(account -> {
            double discount = account.getCustomer().getDiscount();
            double balance = account.getBalance();
            invoices.stream().forEach(invoice -> {
                double amount = invoice.getAmount();
                double discountedAmount = amount - (discount * amount / 100);
                if (balance >= discountedAmount) {
                    System.out.println("Account "+account.getId() + "Có thể thanh toán invoice "+ invoice.getId());
                }
            });
        });
    }
    public void checkCannotAccPay() {
        accounts.stream().forEach(account -> {
            double balance = account.getBalance();
            invoices.stream().forEach(invoice -> {
                double amount = invoice.getAmount();
                if (balance < amount) {
                    System.out.println("Acoount "+account.getId() + "không thể thanh toán invoice "+ invoice.getId());
                }
            });
        });
    }
}
