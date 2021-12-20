package org.da0hn;

import static org.da0hn.TransactionType.TRANSFER;

public record TransferCommand(String from, String to, double amount) implements Command {

  @Override public TransactionType operation() {
    return TRANSFER;
  }
}
