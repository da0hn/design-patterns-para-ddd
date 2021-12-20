package org.da0hn;

public record DebitCommand(Account account, double amount) implements Command {
  @Override public void execute() {
    this.account.debit(this.amount);
  }

  @Override public String operation() {
    return "debit";
  }
}
