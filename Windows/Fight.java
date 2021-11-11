package Windows;

import Animals.*;
import Environments.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class Fight implements ActionListener {
  private static JFrame frame;
  private static JButton exitButton, backButton, rematchButton;
  private static JPanel game;
  private static JProgressBar animalHealth1, animalHealth2;
  private static Timer timer;

  /*
   * The duel method takes the paramaters of two animals, and one environment. It
   * takes the acquired information, and calculates the winner of the duel based
   * on a fighting algorithm. Once the winner has been found, the program then
   * displays the winner of the duel.
   */
  public static void duel(IDuelable one, IDuelable two, Environment currentEnvironment) {
    /*
     * colourScheme adjusts the colour scheme of the fight window based on the
     * current environment.
     */
    IDisplayable colourScheme = currentEnvironment;
    System.out.println(currentEnvironment.environment());
    game = new JPanel();
    game.setBackground(colourScheme.BackgroundColor());
    game.setLayout(null);
    frame = new JFrame();
    frame.setSize(700, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(game);

    animalHealth1 = new JProgressBar(0, (int) one.stamina());
    animalHealth1.setForeground(Color.red);
    animalHealth1.setBackground(Color.darkGray);
    animalHealth1.setBounds(10, 10, 500, 40);
    animalHealth1.setValue((int) one.stamina());
    animalHealth1.setStringPainted(true);

    JLabel animalOne = new JLabel(one.name().toUpperCase());
    animalOne.setForeground(colourScheme.ForegroundColor());
    animalOne.setBounds(515, 10, 185, 40);
    animalOne.setFont(new Font(null, Font.BOLD, 20));

    animalHealth2 = new JProgressBar(0, (int) two.stamina());
    animalHealth2.setForeground(Color.red);
    animalHealth2.setBackground(Color.darkGray);
    animalHealth2.setBounds(10, 100, 500, 40);
    animalHealth2.setValue((int) two.stamina());
    animalHealth2.setStringPainted(true);

    JLabel animalTwo = new JLabel(two.name().toUpperCase());
    animalTwo.setForeground(colourScheme.ForegroundColor());
    animalTwo.setBounds(515, 100, 185, 40);
    animalTwo.setFont(new Font(null, Font.BOLD, 20));

    JLabel winner = new JLabel();
    winner.setForeground(colourScheme.ForegroundColor());
    winner.setBounds(10, 200, 500, 100);
    winner.setFont(new Font(null, Font.BOLD, 30));

    backButton = new JButton("Back");
    backButton.setBounds(595, 205, 95, 25);
    backButton.addActionListener(new Fight());

    exitButton = new JButton("Exit");
    exitButton.setBounds(595, 235, 95, 25);
    exitButton.addActionListener(new Fight());

    rematchButton = new JButton("Rematch");
    rematchButton.setBounds(595, 175, 95, 25);
    rematchButton.addActionListener(new Fight());

    game.add(animalHealth1);
    game.add(animalOne);
    game.add(animalHealth2);
    game.add(animalTwo);
    game.add(winner);
    game.add(backButton);
    game.add(exitButton);
    game.add(rematchButton);

    frame.setVisible(true);
    int delay = 50;
    /*
     * This ActionListener modifies the health bar of the animals based on the
     * amount damage that the animal takes. Once one of the animals reaches less
     * than or equal to 0 health, then the fighting sequence ends. It then displays
     * the winner of the duel.
     */
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent buttons) {
        int health1 = animalHealth1.getValue();
        int health2 = animalHealth2.getValue();
        if (animalHealth1.getValue() > 0 && animalHealth2.getValue() > 0) {
          health1 -= attack(one, two, currentEnvironment);
          System.out.println(health1);
          animalHealth1.setValue(health1);
          animalHealth1.setString(health1 + "/" + (int) one.stamina() + " HP");
          if (animalHealth1.getValue() > 0) {
            System.out.println(health1);
            health2 -= attack(two, one, currentEnvironment);
            animalHealth2.setValue(health2);
            animalHealth2.setString(health2 + "/" + (int) two.stamina() + " HP");
            if (animalHealth2.getValue() <= 0) {
              animalHealth2.setString(0 + "/" + (int) two.stamina() + " HP");
              winner.setText("The winner is " + one.name());
              ((Timer) (buttons.getSource())).stop();
            }
          } else {
            animalHealth1.setString(0 + "/" + (int) one.stamina() + " HP");
            ((Timer) (buttons.getSource())).stop();
            winner.setText("The winner is " + two.name());
          }
        }
      }
    };
    timer = new Timer(delay, taskPerformer);
    timer.setRepeats(true);
    if (animalHealth1.getValue() > 0) {
      timer.start();
    }
  }

  public void actionPerformed(ActionEvent buttons) {
    // goes back to the main menu where the user can select new animals to duel with
    // each other.
    if (buttons.getSource() == backButton) {
      game.setVisible(false);
      frame.dispose();
      Main.GUI();
    }
    // when clicked, the program will be exited.
    if (buttons.getSource() == exitButton) {
      System.exit(0);
    }
    // if clicked, both animals will start fighting again with their health restored
    // to full.
    if (buttons.getSource() == rematchButton) {
      animalHealth1.setValue(animalHealth1.getMaximum());
      animalHealth2.setValue(animalHealth2.getMaximum());
      timer.start();
    }
  }

  // when the method is called, it calculates the amount of damage done.
  public static double attack(IDuelable one, IDuelable two, Environment currentEnvironment) {
    double damage = 0;
    int random = (int) (Math.random() * one.speed(currentEnvironment.friction(), currentEnvironment.gravity(),
        currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
    if (random > 0) {
      // stamina is decreased based on the opposing animals attack attribute, and the
      // defending animals defense attribute.
      damage = two.attack() * one.defense();
    }
    return damage;
  }
}