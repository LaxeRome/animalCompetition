package Environments;

import java.util.*;
import java.awt.*;
  

// current date, current hour 
public abstract class Environment implements IDisplayable { 
  public enum timeOfDay {
    MORNING,
    EVENING,
    NIGHT
  }

  public abstract int friction();

  public abstract int gravity(); 

  public abstract int terrain();

  public abstract int waterdebuff();

  public abstract String environment();

  public static timeOfDay time() {
    Date time = new Date();
    int currentTime= time.getHours();
    timeOfDay currentHour = timeOfDay.EVENING;
    if(currentTime >= 19 || currentTime <= 5) {
      currentHour = timeOfDay.NIGHT;
    } else if(currentTime >= 6 && currentTime <= 11) {
      currentHour = timeOfDay.MORNING;
    } else if(currentTime >= 12 && currentTime <= 18) {
      currentHour = timeOfDay.EVENING;
    }
    return currentHour;
  }
}