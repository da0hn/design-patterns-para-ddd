package org.da0hn;

import static org.da0hn.TransactionType.DEBIT;

public record DebitCommand(String accountDocument, double amount) implements Command {

  @Override public TransactionType operation() {
    return DEBIT;
  }
}
