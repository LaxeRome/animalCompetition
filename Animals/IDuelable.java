package Animals;

import Environments.*;
// This interface tells the animals what it needs to become a duelable animal.
public interface IDuelable {
 
  public abstract String name();
/* takes in the friciton, gravity, terrain debuff, and waterdebuff of the 
* environment to affect the overall speed.*/
  public int speed(int friction, int gravity, int terrain, int waterdebuff);

  public double defense();

  public double attack();

  public double stamina();
}