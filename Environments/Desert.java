package Environments;

import java.awt.*;

public class Desert extends Environment {

  public Color ForegroundColor() {
    return new Color(203, 163, 40);
  }

  public Color BackgroundColor() {
    return new Color(243, 227, 124);
  }

  public String environment() {
    return "desert";
  }

  public int friction() {
    return 7;
  }

  public int gravity() {
    return 6;
  }

  public int terrain() {
    return 1;
  }

  public int waterdebuff() {
    return 25;
  }
}