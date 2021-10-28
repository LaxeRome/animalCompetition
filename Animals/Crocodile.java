package Animals;

import Environments.*;

public class Crocodile implements IDuelable {

  public String name() {
    return "crocodile";
  }

  public int speed() {
    return 4;
  }
  
  public double defense() {
    return 0.8;
  }
 
  public double attack() {
    return 100;
  }
     
  public double stamina() {
    return 1000;
  }
}