package Windows;

import Animals.*;
import Environments.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
// when called, it will take the users selected animals and either start a duel, truel, or skirmish.
public class Fight implements ActionListener {
  private static JFrame frame;
  private static JButton exitButton, backButton, rematchButton;
  private static JPanel game;
  private static JProgressBar animalHealth1, animalHealth2;
  private static Timer timer;
  // the returned integer returns the value of the player that won. So if 1 is returned
  // player 1 has won. If 2 has returned player 2 has won.
  public static void duel(IDuelable one, IDuelable two, Environment currentEnvironment) {
    IDisplayable colourScheme = currentEnvironment;
    System.out.println(currentEnvironment.environment());
    game = new JPanel();
    game.setBackground(colourScheme.BackgroundColor());
    game.setLayout(null);
    frame = new JFrame();
    frame.setSize(700, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(game);

    animalHealth1 = new JProgressBar(0, 10000);
    animalHealth1.setForeground(Color.red);
    animalHealth1.setBackground(Color.darkGray);
    animalHealth1.setBounds(10, 10, 500, 40);
    animalHealth1.setValue(10000);
    animalHealth1.setStringPainted(true);

    JLabel animalOne = new JLabel(one.name().toUpperCase());
    animalOne.setForeground(colourScheme.ForegroundColor());
    animalOne.setBounds(515,10,85,40);
    animalOne.setFont(new Font(null, Font.BOLD, 20));

    animalHealth2 = new JProgressBar(0, 10000);
    animalHealth2.setForeground(Color.red);
    animalHealth2.setBackground(Color.darkGray);
    animalHealth2.setBounds(10,100,500,40);
    animalHealth2.setValue(10000);
    animalHealth2.setStringPainted(true);

    JLabel animalTwo = new JLabel(two.name().toUpperCase());
    animalTwo.setForeground(colourScheme.ForegroundColor());
    animalTwo.setBounds(515,100,85,40);
    animalTwo.setFont(new Font(null, Font.BOLD, 20));

    JLabel winner = new JLabel();
    winner.setForeground(colourScheme.ForegroundColor());
    winner.setBounds(10,200,400,100);
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
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent buttons) {
        int health1 = animalHealth1.getValue();
        int health2 = animalHealth2.getValue();
        if (animalHealth1.getValue() > 0 && animalHealth2.getValue() > 0) {
          health1 -= attack(one, two, currentEnvironment);
          animalHealth1.setValue(health1);
          animalHealth1.setString(health1+"/"+10000+" HP");
          if(animalHealth1.getValue() > 0) {
            health2 -= attack(two, one, currentEnvironment);
            animalHealth2.setValue(health2);
            animalHealth2.setString(health2+"/"+10000+" HP");
            if(animalHealth2.getValue() <= 0) {
              animalHealth2.setString(0+"/"+10000+" HP");
              winner.setText("The winner is " + one.name());
              ((Timer)(buttons.getSource())).stop();
            }
          } else {
            animalHealth1.setString(0+"/"+10000+" HP");
            ((Timer)(buttons.getSource())).stop();
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
    if(buttons.getSource() == backButton) {
      game.setVisible(false);
      frame.dispose();
      Main.GUI();
    }
    if(buttons.getSource() == exitButton) {
      System.exit(0);
    }
    if(buttons.getSource() == rematchButton) {
      animalHealth1.setValue(10000);
      animalHealth1.setString("10000/10000 HP");
      animalHealth2.setValue(10000);
      animalHealth2.setString("10000/10000 HP");
      timer.start();
    }
  }

  public static double attack(IDuelable one, IDuelable two, Environment currentEnvironment) {
    double damage = 0;
    int random = (int)(Math.random() * one.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
    if (random > 0) {
        // stamina is decreased based on the opposing animals attack attribute, and the defending animals defense attribute.
        damage = two.attack() * one.defense();
      }
    return damage;
  }
}