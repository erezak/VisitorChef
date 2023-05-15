import java.io.*;
import java.util.*;

// An abstract class for bank account events
abstract class BankAccountEvent implements Serializable {
  private final Date timestamp;

  public BankAccountEvent(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  // Apply this event to a bank account state
  public abstract void apply(BankAccount account);
}

// A class for account creation event
class AccountCreated extends BankAccountEvent {
  private final String owner;

  public AccountCreated(Date timestamp, String owner) {
    super(timestamp);
    this.owner = owner;
  }

  public String getOwner() {
    return owner;
  }

  @Override
  public void apply(BankAccount account) {
    account.setOwner(owner);
  }
}

// A class for money deposit event
class MoneyDeposited extends BankAccountEvent {
  private final double amount;

  public MoneyDeposited(Date timestamp, double amount) {
    super(timestamp);
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public void apply(BankAccount account) {
    account.deposit(amount);
  }
}

// A class for money withdrawal event
class MoneyWithdrawn extends BankAccountEvent {
  private final double amount;

  public MoneyWithdrawn(Date timestamp, double amount) {
    super(timestamp);
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public void apply(BankAccount account) {
    account.withdraw(amount);
  }
}

// A class for bank account state
class BankAccount implements Serializable {
  private String owner;
  private double balance;
  private List<BankAccountEvent> events;

  public BankAccount() {
    this.events = new ArrayList<>();
    this.balance = 0.0;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    this.balance += amount;
  }

  public void withdraw(double amount) {
    this.balance -= amount;
  }

  // Apply an event to this account and add it to the event list
  public void applyEvent(BankAccountEvent event) {
    event.apply(this);
    events.add(event);
  }

  // Calculate the current balance by replaying all the events
  public double calculateBalance() {
    double balance = 0.0;
    for (BankAccountEvent event : events) {
      if (event instanceof MoneyDeposited) {
        balance += ((MoneyDeposited) event).getAmount();
      } else if (event instanceof MoneyWithdrawn) {
        balance -= ((MoneyWithdrawn) event).getAmount();
      }
    }
    return balance;
  }

  // Create a snapshot of the current state and save it to a file
  public void saveSnapshot(String filename) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
      out.writeObject(this);
    }
  }

  // Restore the state from a snapshot file
  public static BankAccount loadSnapshot(String filename) throws IOException, ClassNotFoundException {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
      return (BankAccount) in.readObject();
    }
  }
}

// A test class to demonstrate the usage of bank account with event sourcing
public class BankEvents {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      // Create a new bank account with an initial balance of 100
      BankAccount account = new BankAccount();
      account.applyEvent(new AccountCreated(new Date(), "Alice"));
      account.applyEvent(new MoneyDeposited(new Date(), 100));
  
      // Print the current balance
      System.out.println("Current balance: " + account.getBalance());
  
      // Withdraw 50 and print the new balance
      account.applyEvent(new MoneyWithdrawn(new Date(), 50));
      System.out.println("New balance: " + account.getBalance());
  
      // Save a snapshot of the current state
      account.saveSnapshot("account.dat");
  
      // Deposit 20 and print the updated balance
      account.applyEvent(new MoneyDeposited(new Date(), 20));
      System.out.println("Updated balance: " + account.getBalance());
  
      // Load the snapshot and print the restored balance
      BankAccount restored = BankAccount.loadSnapshot("account.dat");
      System.out.println("Restored balance: " + restored.getBalance());
    }
  }
  