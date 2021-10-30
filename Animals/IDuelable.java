package Animals;

import Environments.*;

public interface IDuelable {
 
  public abstract String name();

  public int speed(int friction, int gravity, int terrain, int waterdebuff);

  public double defense();

  public double attack();

  public double stamina();
}