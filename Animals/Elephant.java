package Animals;

import Environments.*;

public class Elephant implements IDuelable {
  
  public String name() {
    return "bear";
  }
  
  public int speed() {
    return 25;
  }

  public double defense() {
    return 1.5;
  }

  public double attack() {
    return 250;
  }

  public double stamina() {
    return 1000;
  }
}