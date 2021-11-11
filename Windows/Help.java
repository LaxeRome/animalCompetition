package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Help implements ActionListener {
  private static JFrame frame;
  private static JButton backButton;
  // creates a help window.
  public static void helpWindow() {
    frame = new JFrame();
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel help = new JPanel();
    help.setLayout(null);
    help.setBackground(new Color(255, 134, 0));
    frame.add(help);

    JLabel title = new JLabel("Need Help?");
    title.setBounds(220, 10, 160, 40);
    title.setForeground(new Color(39, 24, 126));
    title.setFont(new Font(null, Font.BOLD, 20));

    JLabel gameDescTitle = new JLabel("What is this game about?");
    gameDescTitle.setForeground(Color.white);
    gameDescTitle.setBounds(10, 70, 220, 30);
    gameDescTitle.setFont(new Font(null, Font.ITALIC, 16));

    JLabel gameDesc = new JLabel(
        "<html>This game is a player vs. player game where the user is allowed to select two different animals that will fight it out. The environment that they fight in is randomly selected, you can tell which environment has been selected when you see the colour scheme of the game panel. (More info on README.md)</html>");
    gameDesc.setForeground(Color.white);
    gameDesc.setBounds(10, 80, 210, 250);

    JLabel tutorialDesc = new JLabel("How To Play");
    tutorialDesc.setForeground(Color.white);
    tutorialDesc.setBounds(350, 70, 220, 30);
    tutorialDesc.setFont(new Font(null, Font.ITALIC, 16));

    JLabel tutorial = new JLabel(
        "<html>Input two animals shown on main screen. Click submit. Wait for the duel to finish. You can then click rematch to replay the duel. Back to select another animal, when you are done with the game click exit to leave.</html>");
    tutorial.setForeground(Color.white);
    tutorial.setBounds(350, 50, 210, 250);

    backButton = new JButton("Back");
    backButton.setBounds(500, 340, 70, 25);
    backButton.addActionListener(new Help());

    help.add(title);
    help.add(gameDescTitle);
    help.add(gameDesc);
    help.add(tutorialDesc);
    help.add(tutorial);
    help.add(backButton);

    frame.setVisible(true);
  }

  // goes back to the main menu.
  public void actionPerformed(ActionEvent buttons) {
    if (buttons.getSource() == backButton) {
      frame.dispose();
      Main.GUI();
    }
  }
}