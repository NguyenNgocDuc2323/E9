package Service;

import Entity.Customer;
import Entity.Gender;
import Entity.Igeneric;
import Entity.Invoice;
import Global.Global;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InvoiceService implements Igeneric<Invoice> {
    private List<Invoice> invoices;
    private Invoice invoice;
    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    public Invoice getInvoice(Invoice invoice) {
        return this.invoice;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public List<Invoice> getInvoices() {
        return invoices;
    }
    public int getCustomerId() {
        int cusId = invoice.getCustomer().getId();
        return cusId;
    }
    public String getCustomerName() {
        String cusName = invoice.getCustomer().getName();
        return cusName;
    }
    public int getCustomerDiscount(){
        int dis = invoice.getCustomer().getDiscount();
        return dis;
    }
    public double getAmountAfterDiscount(){
        double amount = invoice.getAmount();
        int dis = getCustomerDiscount();
        return amount - (amount * dis);
    }

    @Override
    public Invoice updateInfor(int id) {
        Invoice foundInvoice = invoices.get(id);
        foundInvoice.setId(10);
        foundInvoice.setDiscount(foundInvoice.getDiscount() + 5);
        foundInvoice.setAmount(foundInvoice.getAmount() + 5);
        foundInvoice.setCustomer(foundInvoice.getCustomer());
        return invoice;
    }

    @Override
    public void sortObj() {
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getName))
                .forEach(System.out::println);
    }

    @Override
    public List<Invoice> findByName(String name) {
        List<Invoice> foundInvoices =  invoices.stream()
                .filter(invoice1 -> Global.ignoreCase(invoice1.getName(),name))
                .toList();
        return foundInvoices;
    }

    @Override
    public Invoice findById(int id) {
        Optional<Invoice> foundById = invoices.stream().filter(invoice1 -> invoice1.getId() == id).findFirst();
        return foundById.isPresent() ? foundById.get() : null;
    }
    public List<Invoice> get8MontInvoice(){
        List<Invoice> lst8Month = invoices.stream()
                .filter(invoice -> invoice.getCustomer().getGender() == Gender.F && invoice.getDateTime().getMonthValue() == 8)
                .toList();
        lst8Month.forEach(invoice1 -> invoice1.getCustomer().setDiscount(invoice1.getCustomer().getDiscount() + 10));
        return lst8Month.size() > 0 ? lst8Month : null;
    }

}
