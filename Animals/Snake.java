package Animals;

import Environments.*;

public class Snake implements IDuelable {

  public String name() {
    return "lion";
  }

  public int speed() {
    return 4;
  }
  
  public double defense() {
    return 1.5;
  }

  public double attack() {
    return 200;
  }

  public double stamina() {
    return 1000;
  }
}