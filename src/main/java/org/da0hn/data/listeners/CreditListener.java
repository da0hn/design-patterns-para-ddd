package org.da0hn.data.listeners;

import org.da0hn.core.commands.CreditCommand;
import org.da0hn.core.domain.TransactionType;
import org.da0hn.core.ports.AccountRepository;
import org.da0hn.core.ports.Command;
import org.da0hn.core.ports.Listener;

import static org.da0hn.core.domain.TransactionType.CREDIT;

public class CreditListener implements Listener {
  private final AccountRepository accountRepository;

  public CreditListener(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override public TransactionType operation() {
    return CREDIT;
  }

  @Override public void notify(final Command command) {
    if(!(command instanceof CreditCommand creditCommand)) {
      throw new IllegalArgumentException("Action cannot be executed");
    }
    final var account = this.accountRepository.get(creditCommand.accountDocument());
    account.credit(creditCommand.amount());
  }
}
