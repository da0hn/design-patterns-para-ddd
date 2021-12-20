package org.da0hn.core.ports;

public interface Publisher {
  void register(Listener listener);
  void publish(Command command);
}
