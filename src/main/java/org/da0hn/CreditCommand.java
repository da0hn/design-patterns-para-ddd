package org.da0hn;

import static org.da0hn.TransactionType.CREDIT;

public record CreditCommand(String accountDocument, double amount) implements Command {

  @Override public TransactionType operation() {
    return CREDIT;
  }
}
