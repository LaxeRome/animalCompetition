// when called, it will take the users selected animals and either start a duel, truel, or skirmish.
public class Fight {
  public static int duel() {
    boolean fighting = true;
      Hawk hawk = new Hawk();
      int speed1 = hawk.speed();
      double defense1 = hawk.defense();
      double attack1 = hawk.attack();
      double stamina1 = hawk.stamina();

      Snake snake = new Snake();
      int speed2 = snake.speed();
      double defense2 = snake.defense();
      double attack2 = snake.attack();
      double stamina2 = snake.stamina();
      int winner = 0;
      // both of the animals variables are the same for now.
      while(fighting) {
        // Snake attacks first 
        int random1 = (int)(Math.random() * speed1) + 1;
        if(random1 == 1) {
          
        } else {
          // stamina is decreased based on the opposing animals attack attribute, and the defending animals defense attribute.
          stamina1 -= attack2 * defense1;
          System.out.println("Stamina 1: " + stamina1);
        }
        // if the hawk runs out of stamina, then the duel ends.
        if(stamina1 <= 0) {
          fighting = false;
          return 2;
        }
        // Hawk attacks.
        int random2 = (int)(Math.random() * speed2) + 1;
        if(random2 == 1) {
        } else {
          stamina2 -= attack1 * defense2;
          System.out.println("Stamina 2: " + stamina2);
        }
        if(stamina2 <= 0) {
          fighting = false;
          return 1;
        }
      }
      System.out.println(winner);
      return winner;
  }
  public static void truel() {

  }
  public static void skirmish() {

  }
}