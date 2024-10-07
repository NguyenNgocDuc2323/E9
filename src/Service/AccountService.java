package Service;

import Entity.Account;
import Entity.Igeneric;
import Global.Global;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AccountService implements Igeneric<Account> {
    private Account account;
    private List<Account> accounts;
    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }
    public Account getAccount() {
        return account;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    @Override
    public Account updateInfor(int id) {
        Account foundAcc = accounts.get(id);
        foundAcc.setId(10);
        foundAcc.setBalance(account.getBalance() + 1000);
        foundAcc.setCustomer(account.getCustomer());
        foundAcc.setDiscount(account.getDiscount() + 10);
        foundAcc.setName("Ngoc Dung");
        return foundAcc;
    }
    @Override
    public void sortObj() {
        accounts.stream()
                .sorted(Comparator.comparing(Account::getName))
                .forEach(System.out::println);
    }

    @Override
    public List<Account> findByName(String name) {
        List<Account> foundByName = accounts.stream()
                .filter(account1 -> Global.ignoreCase(account1.getName(),name))
                .toList();
        return foundByName;
    }

    @Override
    public Account findById(int id) {
        Optional<Account> foundById = accounts.stream()
                .filter(account1 -> account1.getId() == id)
                .findFirst();
        return foundById.isPresent() ? foundById.get() : null;
    }
}
