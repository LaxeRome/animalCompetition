import Animals.*;
import Environments.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
// when called, it will take the users selected animals and either start a duel, truel, or skirmish.
public class Fight {
  // the returned integer returns the value of the player that won. So if 1 is returned
  // player 1 has won. If 2 has returned player 2 has won.
  public static int duel(IDuelable one, IDuelable two, Environment currentEnvironment) {
    boolean fighting = false;
    JPanel game = new JPanel();
    game.setLayout(null);
    JFrame frame = new JFrame();
    frame.setSize(700, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(game);

    JProgressBar bar = new JProgressBar(0, 1000);
    bar.setStringPainted(true);
    bar.setForeground(Color.red);
    bar.setBackground(Color.darkGray);
    bar.setBounds(200, 200, 500, 30);
    bar.setValue(1000);
    game.add(bar);

    /*JLabel victory = new JLabel();
        victory.setBounds(100,100,350,40);
        victory.setFont(new Font(null, Font.BOLD, 20));
      
        switch(winner) {
          case 1:
           victory.setText("Player 1 has won!");
           break;
          case 2: 
           victory.setText("Player 2 has won!");
           break;
        }
        game.add(victory); */

    JButton button2 = new JButton("Back");
    button2.setBounds(350, 200, 75, 25);
    button2.addActionListener(new Replay());

    frame.setVisible(true);
    int delay = 50;
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int health1 = bar.getValue();
        if (bar.getValue() > 0) {
          health1 -= 10;
          bar.setValue(health1);
          System.out.println(bar.getValue());
        } else {
          ((Timer)(e.getSource())).stop();
          System.out.println("Finished.");
        }
      }
    };
    if (bar.getValue() > 0) {
      Timer timer = new Timer(delay, taskPerformer);
      timer.setRepeats(true);
      timer.start();
    }
    if (bar.getValue() <= 0) {
      fighting = true;
    }

    double stamina1 = one.stamina();
    System.out.println(stamina1);
    double stamina2 = two.stamina();
    System.out.println(stamina2);
    int winner = 0;
    // both of the animals variables are the same for now.
    while (fighting) {
      // Snake attacks first 
      int random1 = (int)(Math.random() * one.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
      System.out.println(one.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));

      if (random1 > 0) {
        // stamina is decreased based on the opposing animals attack attribute, and the defending animals defense attribute.
        stamina1 -= two.attack() * one.defense();
        System.out.println("Stamina 1: " + stamina1);
      }
      // if the hawk runs out of stamina, then the duel ends.
      if (stamina1 <= 0) {
        fighting = false;
        return 2;
      }
      // Hawk attacks.
      int random2 = (int)(Math.random() * two.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
      System.out.println(two.speed(currentEnvironment.friction(), currentEnvironment.gravity(), currentEnvironment.terrain(), currentEnvironment.waterdebuff()));
      if (random2 > 0) {
        stamina2 -= one.attack() * two.defense();
        System.out.println("Stamina 2: " + stamina2);
      }
      if (stamina2 <= 0) {
        fighting = false;
        return 1;
      }
    }
    System.out.println(winner);
    return winner;
  }
}