package org.da0hn.data.listeners;

import org.da0hn.core.commands.DebitCommand;
import org.da0hn.core.domain.TransactionType;
import org.da0hn.core.ports.AccountRepository;
import org.da0hn.core.ports.Command;
import org.da0hn.core.ports.Listener;

import static org.da0hn.core.domain.TransactionType.DEBIT;

public class DebitListener implements Listener {
  private final AccountRepository accountRepository;

  public DebitListener(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override public TransactionType operation() {
    return DEBIT;
  }

  @Override public void notify(final Command command) {
    if(!(command instanceof DebitCommand debitCommand)) {
      throw new IllegalArgumentException("Action cannot be executed");
    }
    final var account = this.accountRepository.get(debitCommand.accountDocument());
    account.debit(debitCommand.amount());
  }
}
