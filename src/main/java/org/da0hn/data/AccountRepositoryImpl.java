package org.da0hn.data;

import org.da0hn.core.domain.Account;
import org.da0hn.core.ports.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

  private final List<Account> accounts;

  public AccountRepositoryImpl() {
    this.accounts = new ArrayList<>();
  }

  @Override public Account get(final String document) {
    return this.accounts.stream()
      .filter(account -> account.getDocument().equals(document))
      .findFirst()
      .orElseThrow(() -> new IllegalStateException("Account not found!"));
  }

  @Override public void save(final Account newAccount) {
    this.accounts.add(newAccount);
  }
}
