package Animals;

import Environments.*;

public class Lion implements IDuelable {

  public String name() {
    return "lion";
  }

  public int speed() {
    return 6;
  }
  
  public double defense() {
    return 1;
  }

  public double attack() {
    return 150;
  }

  public double stamina() {
    return 1000;
  }
}