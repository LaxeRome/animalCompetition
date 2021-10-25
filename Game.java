import java.awt.*;
import java.awt.event.*;
public class Game implements ActionListener{
  // Recalls the main GUI method to restart the program.
  @Override
  public void actionPerformed(ActionEvent e) {
    new Main();
    Main.GUI();
  }
}