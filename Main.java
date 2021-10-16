import java.util.*;

public class Main {

  static String[] animals = {
    "snake",
    "hawk",
    "bull",
    "bear",
    "lion",
    "crocodile",
    "hyena"
  }, landtype = {
    "snake",
    "bull",
    "bear",
    "lion",
    "hyena"
  }, airtype = {
    "hawk"
  }, watertype = {
    "crocodile"
  };

  public static String selectAnimal(String animal1) {

    Scanner sin = new Scanner(System.in);
    String animal = "";
    boolean check = true, correctWord = false;
    while (check) {
      animal = sin.nextLine();
      animal = animal.toLowerCase();
      if (animal.equals("exit")) {
        System.exit(0);
      }
      for (int i = 0; i < 7; i++) {
        if (animal.equals(animals[i]) && !animal.equals(animal1)) {
          correctWord = true;
          check = false;
        }
      }
      if (!correctWord) {
        System.out.println("Incorrect input, please try again.");
      }
      correctWord = false;
    }
    return animal;
  }
  public static boolean isType(String animal, String[] type) {
    boolean isTrue = false;
    for (int j = 0; j < type.length; j++) {
      if (animal.equals(type[j])) {
        isTrue = true;
      }
    }
    return isTrue;
  }

  public static void type(String animal) {
    boolean airAnimal = false;
    boolean landAnimal = isType(animal, landtype);
    if (landAnimal) {
      LandType print = new LandType();
    }
    if (!landAnimal) {
      airAnimal = isType(animal, airtype);
      AirType print = new AirType();
    } else if (!airAnimal && !landAnimal) {
      isType(animal, watertype);
      WaterType print = new WaterType();
    }
  }

  public static void main(String[] args) {
    String animal1 = selectAnimal("");
    type(animal1);
    String animal2 = selectAnimal(animal1);
    type(animal2);
  }
}