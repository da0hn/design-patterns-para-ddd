package org.da0hn;

import static org.da0hn.TransactionType.DEBIT;

public record DebitCommand(Account account, double amount) implements Command {
  @Override public void execute() {
    this.account.debit(this.amount);
  }

  @Override public TransactionType operation() {
    return DEBIT;
  }
}
