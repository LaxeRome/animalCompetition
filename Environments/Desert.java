package Environments;

import java.awt.*;

public class Desert extends Environment implements IDisplayable {

  public Color ForegroundColor() {
    return new Color(203, 163, 40);
  }

  public Color BackgroundColor() {
    return new Color(243, 227, 124);
  }

  public Font setFont() {
    return new Font(null, Font.BOLD, 20);
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

  public int adjustedSpeed(String animal, int animalSpeed) {
    int newSpeed = animalSpeed;
    switch(animal) {
    case "crocodile":
     newSpeed *= 100; // very little chance of avoiding attacks.
     break;
    case "hawk": // not impacted by the default effects.
     break;
    case "hyena":
     newSpeed -= 1; // increases chance to avoid.
     break;
    case "snake": // not impacted by the default effects.
     break;
    default: // every animal has smaller chance to avoid in desert.
     newSpeed += 5;
    }
    return newSpeed;
  }
  // this environment has a big bonus to almost every 
  // animals defense.
  public double adjustedDefense(String animal, double animalDefense) {
    double newDefense = animalDefense;
    switch(animal) {
      case "crocodile":
       newDefense -= 0.4; // buffs crocodile defense.
       break;
      case "hawk":
       newDefense += 0.5; // weaker in beach environment.
       break; 
      default:
       newDefense -= 0.2;
       break;
    }
    return newDefense;
  }
}