package org.da0hn;

import static org.da0hn.TransactionType.TRANSFER;

public class TransferHandler implements Listener {
  private final AccountRepository accountRepository;

  public TransferHandler(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override public TransactionType operation() {
    return TRANSFER;
  }

  @Override public void notify(final Command command) {
    if(!(command instanceof TransferCommand transferCommand)) {
      throw new IllegalArgumentException("Action cannot be executed");
    }
    final var transferService = new TransferService();

    final var accountFrom = this.accountRepository.get(transferCommand.from());
    final var accountTo = this.accountRepository.get(transferCommand.to());

    transferService.transfer(
      accountFrom,
      accountTo,
      transferCommand.amount()
    );
  }
}
