import java.awt.*;
import java.awt.event.*;
public class Game implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
    new Main();
    Main.GUI();
  }
}