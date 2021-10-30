package Environments;

import java.awt.*;

public class Beach extends Environment implements IDisplayable { 

  public Color ForegroundColor() {
    return Color.white;
  }

  public Color BackgroundColor() {
    return Color.blue;
  }

  public Font setFont() {
    return new Font(null, Font.BOLD, 20);
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

  public int adjustedSpeed(String animal, int animalSpeed) {
    int newSpeed = animalSpeed;

    return newSpeed;
  }
  // this environment has a big bonus to almost every 
  // animals defense.
  public double adjustedDefense(String animal, double animalDefense) {
    double newDefense = animalDefense;
    return newDefense;
  }
}