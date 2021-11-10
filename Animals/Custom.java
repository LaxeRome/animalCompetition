package Animals;

public class Custom implements IDuelable {
  public Custom() {
    System.out.println("Warning!");
    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println("To develop an understanding of how to create a custom animal,");
    System.out.println("you need to read the Documents folder in order to create a functioning custom animal.");
    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
  }
  private String name;
  private int speed;
  private int strength;
  private int weight;
  private double defense;
  private double attack;
  private int stamina;
  /* This class uses getters and setters so that the user can set the value of
  *  their custom animal, and then later on the algorithm can get the value
  *  during the duel.
  */
  public void setName(String name) {
    this.name = name;
  }

  public void setSpeed(int speed, int strength, int weight) {
    this.speed = speed;
    this.strength = strength;
    this.weight = weight;
  }

  public void setDefense(double defense) {
    this.defense = defense;
  }

  public void setAttack(double attack) {
    System.out.println();
    this.attack = attack;
  }

  public void setStamina(int stamina) {
    this.stamina = stamina;
  }

  public String name() {
    return this.name;
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    return this.strength * friction * this.speed - this.weight * gravity;
  }

  public double defense() {
    return this.defense;
  }

  public double attack() {
    return this.attack;
  }

  public double stamina() {
    return this.stamina;
  }
}