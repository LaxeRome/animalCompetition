package Animals;

import Environments.*;

public class Hawk implements IDuelable {

  public String name() {
    return "hawk";
  }

  public int speed() {
    return 2;
  }

  public double defense() {
    return 1.5;
  }

  public double attack() {
    return 75;
  }

  public double stamina() {
    return 1000;
  }
}