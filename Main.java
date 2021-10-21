import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    private static JLabel label, label2, success1, success2;
    private static JFrame frame;
    private static JPanel panel, game;
    private static JButton button, button2;
    private static JTextField userText, secondAnimal;
    private static String user, user2;
    private static String[] animals = {
            "snake",
            "hawk",
            "bull",
            "bear",
            "lion",
            "crocodile",
            "hyena"
    }, landtype = {
            "snake",
            "bull",
            "bear",
            "lion",
            "hyena"
    }, airtype = {
            "hawk"
    }, watertype = {
            "crocodile"
    };

    public static void GUI() {
        frame = new JFrame();
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("Player 1:");
        label.setBounds(10, 20, 60, 25);
        panel.add(label);

        userText = new JTextField();
        userText.setBounds(80, 20, 165, 25);
        panel.add(userText);

        label2 = new JLabel("Player 2:");
        label2.setBounds(10, 50, 60, 25);
        panel.add(label2);

        secondAnimal = new JTextField();
        secondAnimal.setBounds(80, 50, 165, 25);
        panel.add(secondAnimal);

        button = new JButton("Submit");
        button.setBounds(10, 80, 100, 25);
        button.addActionListener(new Main());
        panel.add(button);
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
        choices.setBounds(10, 110, 500, 25);
        panel.add(choices);

        success2 = new JLabel("");
        success2.setBounds(280, 50, 300, 25);
        panel.add(success2);
        frame.setSize(1080,720);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean firstInput = false;
        boolean secondInput = false;
        user = userText.getText();
        user2 = secondAnimal.getText();
        success1.setText("");
        success2.setText("");
        for (int j = 0; j < animals.length; j++) {
            if (user.equals(animals[j])) {
                success1.setText("correct animal type.");
                firstInput = true;
            }
            if (user2.equals(animals[j])) {
                success2.setText("correct animal type.");
                secondInput = true;
            }
        }
        if (firstInput && secondInput) {
          panel.setVisible(false);
          game = new JPanel();
          game.setLayout(null);
          frame.add(game);

          button2 = new JButton("Test");
          button2.setBounds(200,200,75,25);
          button2.addActionListener(new Game());
          game.add(button2);
          game.setVisible(true);
        } 
    }
   
    public static boolean isType(String animal, String[] type) {
        boolean isTrue = false;
        for (int j = 0; j < type.length; j++) {
            if (animal.equals(type[j])) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    public static void type(String animal) {
        boolean airAnimal = false;
        boolean landAnimal = isType(animal, landtype);
        if (landAnimal) {
            LandType print = new LandType();
        }
        if (!landAnimal) {
            airAnimal = isType(animal, airtype);
            if (airAnimal) {
                AirType print = new AirType();
            }
        } else if (!airAnimal && !landAnimal) {
            isType(animal, watertype);
            WaterType print = new WaterType();
        }
    }

    public static void main(String[] args) {
        GUI();
    }
}