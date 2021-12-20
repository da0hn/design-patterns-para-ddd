package org.da0hn;

public interface Command {

  void execute();

  TransactionType operation();
}
