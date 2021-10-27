import Animals.*;
// when called, it will take the users selected animals and either start a duel, truel, or skirmish.
public class Fight {
  // the returned integer returns the value of the player that won. So if 1 is returned
  // player 1 has won. If 2 has returned player 2 has won.
  public static int duel(IDuelable one, IDuelable two) {
    boolean fighting = true;
    double stamina1 = one.stamina();
    System.out.println(stamina1);
    double stamina2 = two.stamina();
    System.out.println(stamina2);
      int winner = 0;
      // both of the animals variables are the same for now.
      while(fighting) {
        // Snake attacks first 
        int random1 = (int)(Math.random() * one.speed());
        
        if(random1 > 0) {
          // stamina is decreased based on the opposing animals attack attribute, and the defending animals defense attribute.
          stamina1 -= two.attack() * one.defense();
          System.out.println("Stamina 1: " + stamina1);
        }
        // if the hawk runs out of stamina, then the duel ends.
        if(stamina1 <= 0) {
          fighting = false;
          return 2;
        }
        // Hawk attacks.
        int random2 = (int)(Math.random() * two.speed());
        if(random2 > 0) {
          stamina2 -= one.attack() * two.defense();
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