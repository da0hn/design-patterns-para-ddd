package org.da0hn;

public interface AccountService {
  void create(String document);
  void credit(String document, double amount);
  Account get(String document);
  void debit(String document, double amount);
  void transfer(String documentFrom, String documentTo, double amount);
}
