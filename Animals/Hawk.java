package Animals;

public class Hawk implements IDuelable {

  public String name() {
    return "hawk";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 28;
    int weight = 65;
    return (strength * friction * 2 - weight * gravity) * terrain;
  }

  public double defense() {
    return 1.5;
  }

  public double attack() {
    return 75;
  }

  public double stamina() {
    return 10000;
  }
}