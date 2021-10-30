package Animals;

public class Lion implements IDuelable {

  public String name() {
    return "lion";
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    int strength = 16;
    int weight = 111;
    return strength * friction * 6 - weight * gravity;
  }
  
  public double defense() {
    return 1;
  }

  public double attack() {
    return 150;
  }

  public double stamina() {
    return 1000;
  }
}