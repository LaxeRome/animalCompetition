package Animals;

public class Crocodile implements IDuelable {

  public String name() {
    return "crocodile";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 22;
    int weight = 102;
    return waterdebuff * (strength * friction * 4 - weight * gravity);
  }

  public double defense() {
    return 0.8;
  }

  public double attack() {
    return 100;
  }

  public double stamina() {
    return 10000;
  }
}