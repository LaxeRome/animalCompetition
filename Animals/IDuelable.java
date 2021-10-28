package Animals;

import Environments.*;

public interface IDuelable {
 
  public abstract String name();

  public int speed();

  public double defense();

  public double attack();

  public double stamina();
}