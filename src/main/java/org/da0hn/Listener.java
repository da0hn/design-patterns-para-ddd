package org.da0hn;

public interface Listener {
  TransactionType operation();

  void notify(Command command);
}
