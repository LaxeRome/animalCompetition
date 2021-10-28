package Animals; 

import Environments.*;

public class Bear implements IDuelable {
  
  public String name() {
    return "bear";
  }

  public int speed() {
    double currentSpeed = 10;
    return 10;
  }

  public double defense() {
    return 0.7;
  }

  public double attack() {
    return 125;
  }

  public double stamina() {
    return 1000;
  }
}