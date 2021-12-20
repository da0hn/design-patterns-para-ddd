package org.da0hn.core.ports;

import org.da0hn.core.domain.Account;

public interface AccountRepository {
  Account get(String document);
  void save(Account newAccount);
}
