/*
 * Alexander Moore
 * animalCompetition
 * TBD
 */
package animalCompetition;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main implements ActionListener {

    private static JLabel label, label2, success1, success2;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton button;
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
        frame.setSize(480,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel);

        panel.setLayout(null);

        label = new JLabel("Player 1:");
        label.setForeground(Color.WHITE);
        label.setBounds(10, 20, 60, 25);
        panel.add(label);

        userText = new JTextField();
        userText.setBackground(Color.LIGHT_GRAY);
        userText.setBounds(80, 20, 165, 25);
        panel.add(userText);

        label2 = new JLabel("Player 2:");
        label2.setForeground(Color.WHITE);
        label2.setBounds(10, 50, 60, 25);
        panel.add(label2);

        secondAnimal = new JTextField();
        secondAnimal.setBackground(Color.LIGHT_GRAY);
        secondAnimal.setBounds(80, 49, 165, 25);
        panel.add(secondAnimal);

        button = new JButton("Submit");
        button.setForeground(Color.BLACK);
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
        success1.setForeground(Color.LIGHT_GRAY);
        success1.setBounds(280, 20, 300, 25);
        panel.add(success1);

        JLabel choices = new JLabel(options);
        choices.setForeground(Color.WHITE);
        choices.setBounds(10, 110, 500, 25);
        panel.add(choices);

        success2 = new JLabel("");
        success2.setForeground(Color.LIGHT_GRAY);
        success2.setBounds(280, 50, 300, 25);
        panel.add(success2);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user = userText.getText();
        user2 = secondAnimal.getText();
        success1.setText("");
        success2.setText("");
        verifyCorrectAnimal();
    }

    public static void verifyCorrectAnimal() {
        boolean firstInput = false;
        boolean secondInput = false;
        for (int j = 0; j < animals.length; j++) {
            if (user.equals(animals[j])) {
            	firstInput = true;
                success1.setText("correct animal type.");
            }
            if (user2.equals(animals[j])) {
                secondInput = true;
                success2.setText("correct animal type.");
            }
        }
        if(firstInput && secondInput) {
        	typeOfAnimal(user);
        	typeOfAnimal(user2);
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

    public static void typeOfAnimal(String animal) {
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
        System.out.println("test");
    }
}