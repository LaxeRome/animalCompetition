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
        }, landtype = {"snake","bull","bear","lion","hyena"},airtype = {"hawk"},watertype = {"crocodile"};

        public static String selectAnimal(String animal1) {
      
        Scanner sin = new Scanner(System.in);
        String animal = "";
        boolean check = true, correctWord = false;
        while (check) {
            animal = sin.nextLine();
            animal = animal.toLowerCase();
            if(animal.equals("exit")) {
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
    public static int isType(String[] typeOfAnimal, String animal, int typeValue) {
      int isCorrectType = 0;
      for(int j = 0; j < typeOfAnimal.length;) {
        if(typeOfAnimal[j].equals(animal)) {
          isCorrectType = typeValue;
        }
      }
      return isCorrectType;
    }

    public static int typeOfAnimal(String animal) {
      int type = 0;
      int land = isType(landtype, animal, 1);
      int air = isType(airtype, animal, 2);
      int water = isType(watertype, animal, 3);
      return type;
    }

    public static void main(String[] args) {
      String animal1 = selectAnimal("");
      String animal2 = selectAnimal(animal1);

    }
}