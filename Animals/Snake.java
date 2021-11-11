package Animals;

public class Snake implements IDuelable {

  public String name() {
    return "snake";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 2;
    int weight = 9;
    return strength * friction * 4 - weight * gravity;
  }

  public double defense() {
    return 1.5;
  }

  public double attack() {
    return 150;
  }

  public double stamina() {
    return 10000;
  }
}