package org.da0hn;

import static org.da0hn.TransactionType.CREDIT;

public record CreditCommand(Account account, double amount) implements Command {
  @Override public void execute() {
    this.account.credit(this.amount);
  }

  @Override public TransactionType operation() {
    return CREDIT;
  }
}
