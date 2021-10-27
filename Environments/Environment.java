import java.util.*;
  

// current date, current hour 
public abstract class Environment { 
  public enum timeOfDay {
    MORNING,
    EVENING,
    NIGHT
  }

  public abstract String environment();

  public abstract boolean isWater();

  public static timeOfDay time() {
    Date time = new Date();
    int currentTime= time.getHours();
    timeOfDay currentHour = timeOfDay.EVENING;
    if(currentTime >= 19 && currentTime <= 5) {
      currentHour = timeOfDay.NIGHT;
    } else if(currentTime >= 6 && currentTime <= 11) {
      currentHour = timeOfDay.MORNING;
    } else if(currentTime >= 12 && currentTime <= 18) {
      currentHour = timeOfDay.EVENING;
    }
    return currentHour;
  }
}