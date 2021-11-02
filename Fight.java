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
  private static JProgressBar animalHealth1, animalHealth2;
  private static Timer timer;
  // the returned integer returns the value of the player that won. So if 1 is returned
  // player 1 has won. If 2 has returned player 2 has won.
  public static void duel(IDuelable one, IDuelable two, Environment currentEnvironment) {
    System.out.println(currentEnvironment.environment());
    JPanel game = new JPanel();
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
    animalOne.setBounds(515,10,85,40);
    animalOne.setFont(new Font(null, Font.BOLD, 20));

    animalHealth2 = new JProgressBar(0, 10000);
    animalHealth2.setForeground(Color.red);
    animalHealth2.setBackground(Color.darkGray);
    animalHealth2.setBounds(10,100,500,40);
    animalHealth2.setValue(10000);
    animalHealth2.setStringPainted(true);

    JLabel animalTwo = new JLabel(two.name().toUpperCase());
    animalTwo.setBounds(515,100,85,40);
    animalTwo.setFont(new Font(null, Font.BOLD, 20));

    JLabel winner = new JLabel();
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
    int delay = 100;
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int health1 = animalHealth1.getValue();
        int health2 = animalHealth2.getValue();
        if (animalHealth1.getValue() > 0 && animalHealth2.getValue() > 0) {
          health1 -= attack1(one, two, currentEnvironment);
          animalHealth1.setValue(health1);
          animalHealth1.setString(health1+"/"+10000+" HP");
          if(animalHealth1.getValue() > 0) {
            health2 -= attack1(two, one, currentEnvironment);
            animalHealth2.setValue(health2);
            animalHealth2.setString(health2+"/"+10000+" HP");
            if(animalHealth2.getValue() <= 0) {
              animalHealth2.setString(0+"/"+10000+" HP");
              winner.setText("The Winner Is: " + one.name());
              ((Timer)(e.getSource())).stop();
            }
          } else {
            animalHealth1.setString(0+"/"+10000+" HP");
            ((Timer)(e.getSource())).stop();
            winner.setText("The Winner Is: " + two.name());
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

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == backButton) {
      frame.dispose();
      Main.GUI();
    }
    if (e.getSource() == exitButton) {
      System.exit(0);
    }
    if(e.getSource() == rematchButton) {
      animalHealth1.setValue(10000);
      animalHealth1.setString("10000/10000 HP");
      animalHealth2.setValue(10000);
      animalHealth2.setString("10000/10000 HP");
      timer.start();
    }
  }

  public static double attack1(IDuelable one, IDuelable two, Environment currentEnvironment) {
    double damage = 0;
    int random = (int)(Math.random() * one.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
    if (random > 0) {
        // stamina is decreased based on the opposing animals attack attribute, and the defending animals defense attribute.
        damage = two.attack() * one.defense();
      }
    return damage;
  }

  public static double attack2(IDuelable one, IDuelable two, Environment currentEnvironment) {
    double damage = 0;
    int random = (int)(Math.random() * two.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
    if (random > 0) {
        // stamina is decreased based on the opposing animals attack attribute, and the defending animals defense attribute.
      damage = one.attack() * two.defense();
    }
    return damage;
  }
}