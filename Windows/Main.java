package Windows;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Animals.*;
import Environments.*;

public class Main implements ActionListener {
  private static Environment currentEnvironment;
  private static JLabel player1;
  private static JLabel player2;
  private static JLabel success1;
  private static JLabel success2;
  public static JFrame frame;
  private static JPanel menu;
  private static JButton submitButton;
  private static JButton helpButton;
  private static JButton exitButton;
  private static JTextField firstAnimal;
  private static JTextField secondAnimal;
  private static String user;
  private static String user2;
  public static String[] animals = {
    "snake", 
    "hawk", 
    "bull", 
    "bear", 
    "lion", 
    "crocodile", 
    "hyena", 
    "elephant",
    "custom" };
  static final String HAWK = "hawk";
  static final String SNAKE = "snake";
  static final String BEAR = "bear";
  static final String CROCODILE = "crocodile";
  static final String LION = "lion";
  static final String HYENA = "hyena";
  static final String BULL = "bull";
  static final String ELEPHANT = "elephant";

  // Creates the main window for the user to input the animals.
  public static void GUI() {
    frame = new JFrame();
    frame.setSize(750, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu = new JPanel();
    menu.setLayout(null);
    menu.setBackground(new Color(29, 30, 24));
    menu.setOpaque(true);

    frame.add(menu);

    player1 = new JLabel("Player 1:");
    player1.setBounds(10, 20, 80, 25);
    player1.setForeground(new Color(107, 143, 113));
    player1.setFont(new Font(null, Font.BOLD, 13));
    menu.add(player1);

    firstAnimal = new JTextField();
    firstAnimal.setForeground(new Color(29, 30, 24));
    firstAnimal.setBackground(new Color(170, 210, 186));
    firstAnimal.setBounds(80, 20, 165, 25);
    menu.add(firstAnimal);

    player2 = new JLabel("Player 2:");
    player2.setForeground(new Color(107, 143, 113));
    player2.setFont(new Font(null, Font.BOLD, 13));
    player2.setBounds(10, 50, 80, 25);
    menu.add(player2);

    secondAnimal = new JTextField();
    secondAnimal.setForeground(new Color(29, 30, 24));
    secondAnimal.setBackground(new Color(170, 210, 186));
    secondAnimal.setBounds(80, 50, 165, 25);
    menu.add(secondAnimal);

    submitButton = new JButton("Submit");
    submitButton.setBounds(10, 110, 100, 25);
    submitButton.addActionListener(new Main());
    menu.add(submitButton);

    helpButton = new JButton("Help");
    helpButton.setBounds(10, 230, 100, 25);
    helpButton.addActionListener(new Main());
    menu.add(helpButton);

    exitButton = new JButton("Exit");
    exitButton.setBounds(670, 235, 70, 25);
    exitButton.addActionListener(new Main());
    menu.add(exitButton);

    // prints out all the animals that the user is able to select.
    String options = "Your choices include: ";
    for (int i = 0; i < animals.length; i++) {
      if (i < animals.length - 1) {
        options += animals[i] + ", ";
      } else {
        options += animals[i];
      }
    }
    success1 = new JLabel();
    success1.setBounds(280, 20, 300, 25);
    menu.add(success1);

    JLabel choices = new JLabel(options);
    choices.setForeground(new Color(185, 245, 216));
    choices.setBounds(10, 80, 700, 25);
    menu.add(choices);

    success2 = new JLabel();
    success2.setBounds(280, 50, 300, 25);
    menu.add(success2);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent buttons) {
    // When clicked, the button calls the submitAnimal method.
    if (buttons.getSource() == submitButton) {
      selectAnimal();
    }
    // when clicked, the button opens the help menu.
    if (buttons.getSource() == helpButton) {
      menu.setVisible(false);
      frame.dispose();
      Help.helpWindow();
    }
    // when clicked, the button exits the program.
    if (buttons.getSource() == exitButton) {
      System.exit(0);
    }

  }

  public static void selectAnimal() {
    user = firstAnimal.getText();
    user2 = secondAnimal.getText();
    success1.setForeground(Color.lightGray);
    success2.setForeground(Color.lightGray);
    boolean firstInput = false;
    boolean secondInput = false;
    // Checks the input to verify that it was correct.
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
    /* Once the animals have been selected, the next step of the program is to 
    *  display the fight window. This if statement checks that if both of the inputs
    *  are correct animals, then the program will create an environment, and call the
    *  duel method inside of the Fight class.
    */
    if (firstInput && secondInput) {
      menu.setVisible(false);
      frame.dispose();
      IDuelable firstPlayer = getDuelable(user);
      IDuelable secondPlayer = getDuelable(user2);
      currentEnvironment = getEnvironment();
      Fight.duel(firstPlayer, secondPlayer, currentEnvironment);
    }
  }

  /* instantiates the class that the user has selected, and sets it to
  *  IDuelable variable.
  */
  static IDuelable getDuelable(String name) {
    switch (name) {
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
        return createCustomAnimal();
    }
  }
  // creates a custom animal by instantiating the Custom.java class.
  public static Custom createCustomAnimal() {
    Custom custom = new Custom();
    Scanner sin = new Scanner(System.in);
    System.out.print("Name: ");
    String name = sin.nextLine();
    custom.setName(name);

    System.out.print("Input Speed, Strength, Weight: ");
    int speed = sin.nextInt();
    int strength = sin.nextInt();
    int weight = sin.nextInt();
    custom.setSpeed(speed, strength, weight);

    System.out.print("Defense: ");
    double defense = sin.nextDouble();
    custom.setDefense(defense);

    System.out.print("Attack: ");
    double attack = sin.nextDouble();
    custom.setAttack(attack);

    System.out.print("Stamina: ");
    int stamina = sin.nextInt();
    custom.setStamina(stamina);
    return custom;
  }

  // selects a random environment for the animals to fight in.
  static Environment getEnvironment() {
    int random = (int) (Math.random() * 3);
    switch (random) {
      case 0:
        return new Desert();
      case 1:
        return new Beach();
      case 2:
        return new Volcano();
      default:
        return null;
    }
  }
  // calls to the GUI method.
  public static void main(String[] args) {
    GUI();
  }
}