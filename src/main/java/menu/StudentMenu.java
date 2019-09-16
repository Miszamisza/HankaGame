package menu;

import studentFactory.StudentFactory;
import studentFactory.StudentInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static menu.StudentMenu.HEIGHT;
import static menu.StudentMenu.WIDTH;

public class StudentMenu extends JFrame implements ActionListener{


    public static final int HEIGHT = 720;
    public static final int WIDTH = 1280;
    private JTextArea jTextArea;
    private JButton button;
    private StudentFactory studentFactory = new StudentFactory();
    private int  buttonWidth = 200;


    public StudentMenu() {
        jTextArea = new JTextArea();
        String[] labels = {"Fan piwa", "Fan wódki", "Fan wina", "NarkoMan"};
        for (int i = 0; i < labels.length; i++) {
            button = new JButton(labels[i]);
            add(button);
            button.setBounds(540,buttonWidth,200, 60);
            button.addActionListener(this);
            buttonWidth+=70;
        }
        setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((JButton)e.getSource()).getText();
        StudentInterface student = studentFactory.studentCreate(name);
        jTextArea.setText(student.toString());
    }
}


class Test {
    public static void main(String[] args) {

            ActionFrame.run(new StudentMenu(), WIDTH, HEIGHT);

    }
}