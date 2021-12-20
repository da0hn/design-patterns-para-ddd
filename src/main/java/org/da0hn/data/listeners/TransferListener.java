package org.da0hn.data.listeners;

import org.da0hn.core.commands.TransferCommand;
import org.da0hn.core.domain.TransactionType;
import org.da0hn.core.domain.TransferExecutor;
import org.da0hn.core.ports.AccountRepository;
import org.da0hn.core.ports.Command;
import org.da0hn.core.ports.Listener;

import static org.da0hn.core.domain.TransactionType.TRANSFER;

public class TransferListener implements Listener {
  private final AccountRepository accountRepository;

  public TransferListener(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override public TransactionType operation() {
    return TRANSFER;
  }

  @Override public void notify(final Command command) {
    if(!(command instanceof TransferCommand transferCommand)) {
      throw new IllegalArgumentException("Action cannot be executed");
    }
    final var transferExecutor = new TransferExecutor();

    final var accountFrom = this.accountRepository.get(transferCommand.from());
    final var accountTo = this.accountRepository.get(transferCommand.to());

    transferExecutor.execute(
      accountFrom,
      accountTo,
      transferCommand.amount()
    );
  }
}
