package Animals;

import Environments.*;

public class Bull implements IDuelable {

  public String name() {
    return "bull";
  }

  public int speed() {
    return 15;
  }
  
  public double defense() {
    return 1;
  }

  public double attack() {
    return 125;
  }

  public double stamina() {
    return 1000;
  }
}