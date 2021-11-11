package Environments;

// This abstract class defines what an environment is.
public abstract class Environment implements IDisplayable {

  public abstract int friction();

  public abstract int gravity();

  public abstract int terrain();

  public abstract int waterdebuff();

  public abstract String environment();

}
