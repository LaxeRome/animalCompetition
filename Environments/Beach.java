package Environments;

public class Beach extends Environment { 
  public String environment() {
    return "beach";
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