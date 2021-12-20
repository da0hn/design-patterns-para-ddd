package org.da0hn.core.commands;

import org.da0hn.core.domain.TransactionType;
import org.da0hn.core.ports.Command;

import static org.da0hn.core.domain.TransactionType.TRANSFER;

public record TransferCommand(String from, String to, double amount) implements Command {

  @Override public TransactionType operation() {
    return TRANSFER;
  }
}
