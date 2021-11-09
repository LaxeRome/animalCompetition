package Animals;
import java.util.*;
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
  private Scanner sin = new Scanner(System.in);
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
    this.attack = attack;
  }

  public void setStamina(int stamina) {
    this.stamina = stamina;
  }

  public String name() {
    return this.name;
  }

  public int speed(int friction, int gravity, int terrain, int waterdebuff) {
    return (this.strength * friction *  - this.weight * gravity) * terrain;
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