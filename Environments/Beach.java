package Environments;

public class Beach extends Environment { 
  public String environment() {
    return "beach";
  }

  public int adjustedSpeed(String animal, int animalSpeed) {
    int newSpeed = animalSpeed;
    switch(animal) {
    case "crocodile":
     newSpeed /= 2; // higher chance to avoid.
     break;
    case "hawk":
     newSpeed *= 2; // lower chance to avoid.
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