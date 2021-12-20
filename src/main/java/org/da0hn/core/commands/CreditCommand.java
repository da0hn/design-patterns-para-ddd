package org.da0hn.core.commands;

import org.da0hn.core.domain.TransactionType;
import org.da0hn.core.ports.Command;

import static org.da0hn.core.domain.TransactionType.CREDIT;

public record CreditCommand(String accountDocument, double amount) implements Command {

  @Override public TransactionType operation() {
    return CREDIT;
  }
}
