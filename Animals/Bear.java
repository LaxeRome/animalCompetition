package Animals; 

public class Bear implements IDuelable {
  
    public int speed() {
        return 10;
    }
    public double defense() {
        return 0.7;
    }

    public double attack() {
        return 125;
    }

    public double stamina() {
      return 1000;
    }
}