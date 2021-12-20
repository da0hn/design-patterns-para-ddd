package org.da0hn;

public record CreditCommand(Account account, double amount) implements Command {
  @Override public void execute() {
    this.account.credit(this.amount);
  }

  @Override public String operation() {
    return "credit";
  }
}
