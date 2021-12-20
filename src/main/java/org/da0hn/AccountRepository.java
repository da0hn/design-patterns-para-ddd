package org.da0hn;

public interface AccountRepository {
  Account get(String document);
  void save(Account newAccount);
}
