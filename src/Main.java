import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import Service.AccountService;
import Service.CustomerService;
import Service.InvoiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Account> accounts = new ArrayList<Account>();
        List<Invoice> invoices = new ArrayList<Invoice>();
        customers.add(new Customer(1,"Nguyen Ngoc Duc", Gender.M,5));
        customers.add(new Customer(2,"Nguyen Thi Phuong",Gender.F,10));
        customers.add(new Customer(3,"Le Thi Dau",Gender.F,15));
        accounts.add(new Account(1,customers.get(0),1000,"Nguyen Ngoc Duc"));
        accounts.add(new Account(2,customers.get(1),1500,"Nguyen Thi Phuong"));
        accounts.add(new Account(3,customers.get(2),2000,"Nguyen Thi Dau"));

        invoices.add(new Invoice(1,customers.get(0),100, LocalDate.of(2024,6,20)));
        invoices.add(new Invoice(2,customers.get(1), 50,LocalDate.of(2024,8,12)));
        invoices.add(new Invoice(3,customers.get(2),80, LocalDate.of(2024,8,5)));

        AccountService as = new AccountService(accounts);
        InvoiceService is = new InvoiceService(invoices);
        CustomerService cs = new CustomerService(customers);
        AccountController ac = new AccountController(as,invoices);
        InvoiceController iv = new InvoiceController(is);
        CustomerController ct = new CustomerController(cs);

//        ac.updateInfor(1);
//        iv.updateInfor(2);
//        ct.updateInfor(3);

        ac.sortObj();
        iv.sortObj();
        ct.sortObj();

        List<Account> foundAccByName = ac.findByName("Duc");
        foundAccByName.forEach(System.out::println);
        List<Invoice> foundInvoiceByName = iv.findByName("Thi");
        foundInvoiceByName.forEach(System.out::println);
        List<Customer> foundCusByName = ct.findByName("Thi");
        foundCusByName.forEach(System.out::println);

        Account foundAcc = ac.findById(1);
        if(foundAcc != null){
            System.out.println(foundAcc);
        }else{
            System.out.println("Account not found!");
        }
        Invoice foundInvoice = iv.findById(4);
        if(foundInvoice != null){
            System.out.println(foundInvoice);
        }
        else{
            System.out.println("Invoice not found!");
        }
        Customer foundCus = ct.findById(2);
        if(foundCus != null){
            System.out.println(foundCus);
        }
        else{
            System.out.println("Customer not found!");
        }
        ac.checkCanAccPay();
        ac.checkCannotAccPay();

        List<Invoice> lst8Month = iv.get8MontInvoice();
        lst8Month.forEach(System.out::println);
    }
}