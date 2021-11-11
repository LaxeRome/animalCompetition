package Animals;

public class Elephant implements IDuelable {

  public String name() {
    return "elephant";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 18;
    int weight = 515;
    return strength * friction * 25 - weight * gravity;
  }

  public double defense() {
    return 1.5;
  }

  public double attack() {
    return 250;
  }

  public double stamina() {
    return 10000;
  }
}