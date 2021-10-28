package Animals;

import Environments.*;

public class Hyena implements IDuelable {

  public String name() {
    return "hyena";
  }

  public int speed() {
    return 5;
  }

  public double defense() {
    return 1;
  }

  public double attack() {
    return 100;
  }

  public double stamina() {
    return 1000;
  }
}