package org.da0hn;

public interface Publisher {
  void register(Listener listener);
  void publish(Command command);
}
