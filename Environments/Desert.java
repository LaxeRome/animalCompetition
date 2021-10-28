package Environments;

public class Desert extends Environment {

  public String environment() {
    return "desert";
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
  // this particular environment has no impact on 
  // animal stamina.
  public double adjustedStamina(String animal, double animalStamina) {
    double newStamina = animalStamina;
    return newStamina; 
  }
}