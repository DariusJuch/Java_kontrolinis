import lt.itakademija.exam.*;

import java.util.HashMap;
import java.util.Map;

public class SwedBank implements Bank {
    private Map<String, Customer> customer = new HashMap<>();
    private int customerIdCounter = 1;
    private Map<String, Account> account = new HashMap<>();
    private int accountIdCounter = 1;
    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {
        if (personCode == null || personName == null){
            throw new NullPointerException("");
        }
        if (customer.values().stream().anyMatch(c -> c.getPersonCode().equals(personCode))){
            throw new CustomerCreateException("");
        }
        long customerId = Long.parseLong(String.valueOf(customerIdCounter++));
        return new Customer(customerId, personCode, personName);
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {
        if (customer == null || currency == null){
            throw new NullPointerException("");
        }

        long accountId = Long.parseLong(String.valueOf(accountIdCounter++));
        return new Account(accountId,customer,currency, getBalance(currency));
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {
        return null;
    }

    @Override
    public Money getBalance(Currency currency) {
        return null;
    }
}
