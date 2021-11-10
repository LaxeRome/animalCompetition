package Environments;

import java.awt.*;

public class Beach extends Environment { 

  public Color ForegroundColor() {
    return new Color(203, 163, 40);
  }

  public Color BackgroundColor() {
    return new Color(30,93,135);
  }

  public String environment() {
    return "beach";
  }

  public int friction() {
    return 6;
  }

  public int gravity() {
    return 5;
  }

  public int terrain() {
    return 5;
  }

  public int waterdebuff() {
    return 1;
  }
}