package Animals;

public class Hyena implements IDuelable {

  public String name() {
    return "hyena";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 7;
    int weight = 40;
    return strength * friction * 5 - weight * gravity;
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