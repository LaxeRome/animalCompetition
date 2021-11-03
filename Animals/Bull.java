package Animals;

public class Bull implements IDuelable {

  public String name() {
    return "bull";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 29;
    int weight = 500;
    return strength * friction * 15 - weight * gravity;
  }
  
  public double defense() {
    return 1;
  }

  public double attack() {
    return 125;
  }

  public double stamina() {
    return 10000;
  }
}