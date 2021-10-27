import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Animals.*;
import Environments.*;

public class Main implements ActionListener {

  private static JLabel label, label2, success1, success2;
  private static JFrame frame;
  private static JPanel panel, game;
  private static JButton button, button2;
  private static JTextField userText, secondAnimal;
  private static String user, user2;
  public static String[] animals = {
    "snake",
    "hawk",
    "bull",
    "bear",
    "lion",
    "crocodile",
    "hyena",
    "elephant"
  };
  // Creates the main window for the user to input the animals.
  public static void GUI() {
    frame = new JFrame();
    frame.setSize(1080, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.black);
    panel.setOpaque(true);

    frame.add(panel);

    label = new JLabel("Player 1:");
    label.setBounds(10, 20, 80, 25);
    label.setForeground(Color.lightGray);
    label.setFont(new Font(null, Font.BOLD, 13));
    panel.add(label);

    userText = new JTextField();
    userText.setForeground(Color.white);
    userText.setBackground(Color.gray);
    userText.setBounds(80, 20, 165, 25);
    panel.add(userText);

    label2 = new JLabel("Player 2:");
    label2.setForeground(Color.lightGray);
    label2.setFont(new Font(null, Font.BOLD, 13));
    label2.setBounds(10, 50, 80, 25);
    panel.add(label2);

    secondAnimal = new JTextField();
    secondAnimal.setForeground(Color.white);
    secondAnimal.setBackground(Color.gray);
    secondAnimal.setBounds(80, 50, 165, 25);
    panel.add(secondAnimal);
    
    button = new JButton("Submit");
    button.setBounds(10, 80, 100, 25);
    button.addActionListener(new Main());
    panel.add(button);
    // prints out all the animals that the user is able to select.
    String options = "Your choices include: ";
    for (int i = 0; i < animals.length; i++) {
      if (i < animals.length - 1) {
        options += animals[i] + ", ";
      } else {
        options += animals[i];
      }
    }
    success1 = new JLabel("");
    success1.setBounds(280, 20, 300, 25);
    panel.add(success1);

    JLabel choices = new JLabel(options);
    choices.setForeground(Color.white);
    choices.setBounds(10, 110, 700, 25);
    panel.add(choices);

    success2 = new JLabel("");
    success2.setBounds(280, 50, 300, 25);
    panel.add(success2);
    frame.setSize(1080, 720);

    Environment currentEnvironment = getEnvironment();

    JLabel environmentLabel = new JLabel("The current environment is " + currentEnvironment.environment() + "!!!");
    environmentLabel.setFont(new Font(null, Font.BOLD, 22));
    environmentLabel.setBounds(150,200,500,40);
    if(currentEnvironment.environment().equals("desert")) {
      environmentLabel.setForeground(new Color(225,220,177));
    } else if(currentEnvironment.environment().equals("beach")) {
      environmentLabel.setForeground(new Color (95, 170, 215));
    }
    panel.add(environmentLabel);

    frame.setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    user = userText.getText(); 
    user2 = secondAnimal.getText();
    success1.setForeground(Color.lightGray);
    success2.setForeground(Color.lightGray);
    boolean firstInput = false;
    boolean secondInput = false;
    // This for loop goes through the animals array to check if the animals input were 
    // valid.
    for (int j = 0; j < animals.length; j++) {
      if (user.equalsIgnoreCase(animals[j])) {
        success1.setText("correct animal");
        firstInput = true;
      }
      if (user2.equalsIgnoreCase(animals[j])) {
        success2.setText("correct animal");
        secondInput = true;
      }
    }
    // if true, it will hide the panel, and create a new panel that shows the results of the
    // duel. It will then allow the user to play again if they click the "Back" button.
    if (firstInput && secondInput) {
      // Make the animals
      IDuelable firstPlayer = getDuelable(user);
      IDuelable secondPlayer = getDuelable(user2);

      // calls the duel method in the fight class.
      int winner = Fight.duel(firstPlayer, secondPlayer);
      panel.setVisible(false);
      game = new JPanel();
      game.setLayout(null);
      frame.add(game);

      JLabel victory = new JLabel();
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
      game.add(victory);

      button2 = new JButton("Back");
      button2.setBounds(200, 200, 75, 25);
      button2.addActionListener(new Replay());
      game.add(button2);
      game.setVisible(true);
    }
  }

  static final String HAWK = "hawk";
  static final String SNAKE = "snake";
  static final String BEAR = "bear";
  static final String CROCODILE = "crocodile";
  static final String LION = "lion";
  static final String HYENA = "hyena";
  static final String BULL = "bull";
  static final String ELEPHANT = "elephant";
  // calls the calss that the user has selected. 
  IDuelable getDuelable(String name) {
    switch(name) {
      case HAWK:
       return new Hawk();
      case SNAKE: 
       return new Snake();
      case BEAR:
       return new Bear();
      case CROCODILE: 
       return new Crocodile();
      case LION:  
       return new Lion();
      case HYENA: 
       return new Hyena();
      case BULL: 
       return new Bull();
      case ELEPHANT:
       return new Elephant();
      default: 
       return null;
    }
  }
// selects a random environment for the user to play in. 
  static Environment getEnvironment() {
    int random = (int)(Math.random() * 2);
    switch(random) {
      case 0:
       return new Desert();
      case 1:
       return new Beach();
      default:
       return null;
    }
  }

  public static void main(String[] args) {
    GUI();
  }
}