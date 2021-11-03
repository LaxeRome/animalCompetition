package Animals; 

public class Bear implements IDuelable {
  
  public String name() {
    return "bear";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 10;
    int weight = 113;
    return strength * friction * 10 - weight * gravity;
  }

  public double defense() {
    return 0.7;
  }

  public double attack() {
    return 125;
  }

  public double stamina() {
    return 10000;
  }
}