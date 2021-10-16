import java.util.*;

public class ChooseAnimal {
  private String[] animals = {
            "snake",
            "hawk",
            "bull",
            "bear",
            "lion",
            "crocodile",
            "hyena"
        };
  private Scanner sin = new Scanner(System.in);
  private boolean check = true, correctWord = false;
  private String currentWord = "";
  private int i = 0;
  
  public String[] selectAnimal(){
        String[] animalsChosen = {"",""};
        while (check){ 
            currentWord = sin.nextLine();
            for (int j = 0; j < 7; j++) {
                if (currentWord.equals(animals[j]) && !currentWord.equals(animalsChosen[1])) {
                    animalsChosen[j] = currentWord;
                    correctWord = true;
                    i += 1;
                }
            }
            if (correctWord) {
                System.out.println("Incorrect input, please try again.");
            }
            if (i == 2) {
                check = false;
            }
            correctWord = false;
            System.out.println(i);
        }
        return animalsChosen;
  }
}