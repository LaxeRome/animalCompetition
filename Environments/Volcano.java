package Environments;

import java.awt.*;

public class Volcano extends Environment {

  public Color ForegroundColor() {
    return new Color(221, 164, 72);
  }

  public Color BackgroundColor() {
    return new Color(187, 52, 47);
  }

  public String environment() {
    return "volcano";
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