package Controller;

import Entity.Customer;
import Entity.Invoice;
import Service.InvoiceService;

import java.util.List;

public class InvoiceController {
    private InvoiceService is;
    private Invoice invoice;
    private List<Invoice> invoices;
    public InvoiceController(InvoiceService is) {
        this.is = is;
        this.invoice = is.getInvoice();
        this.invoices = is.getInvoices();
    }

    public int getCustomerId(){
        int cusId = is.getCustomerId();
        return cusId < 0 ? -1 : cusId;
    }
    public String getCustomerName(){
        String cusName = is.getCustomerName();
        return cusName == null ? "" : cusName;
    }
    public int getCustomerDiscount(){
        int cusDis = is.getCustomerDiscount();
        return cusDis < 0 ? -1 : cusDis;
    }
    public double getAmountAfterDiscount(){
        double amountAfterDis = is.getAmountAfterDiscount();
        return amountAfterDis < 0 ? -1 : amountAfterDis;
    }
    public Invoice updateInfor(int id){
        Invoice foundInvoice =  is.updateInfor(id);
        return foundInvoice;
    }
    public void sortObj(){
        is.sortObj();
    }
    public List<Invoice> findByName(String name){
        List<Invoice> foundCus = is.findByName(name);
        return foundCus;
    }
    public Invoice findById(int id){
        Invoice foundCus = is.findById(id);
        return foundCus;
    }
    public List<Invoice> get8MontInvoice(){
        List<Invoice> foundCus = is.get8MontInvoice();
        return foundCus.size() > 0 ? foundCus : null;
    }
}
