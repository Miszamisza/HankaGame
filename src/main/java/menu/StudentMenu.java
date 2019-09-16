package menu;

import javafx.geometry.HorizontalDirection;
import javafx.scene.input.ScrollEvent;
import studentFactory.StudentFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static menu.StudentMenu.HEIGHT;
import static menu.StudentMenu.WIDTH;

public class StudentMenu extends JFrame implements ActionListener{


    public static final int HEIGHT = 720;
    public static final int WIDTH = 1280;
    private JButton fanPiwa;
    private JButton fanWodki;
    private JButton fanWina;
    private JButton narkoMan;

    public StudentMenu() {
        fanPiwa = new JButton("Fan piwa");
        fanWodki = new JButton("Fan wódki");
        fanWina = new JButton("Fan Wina");
        narkoMan = new JButton("NarkoMan");

        fanPiwa.addActionListener(this);
        fanWodki.addActionListener(this);
        fanWina.addActionListener(this);
        narkoMan.addActionListener(this);

        setLayout(new GridLayout(4,1));
        add(fanPiwa);
        add(fanWodki);
        add(fanWina);
        add(narkoMan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        StudentFactory studentFactory = new StudentFactory();
        if(source == fanPiwa)
            studentFactory.studentCreate(fanPiwa);

        else if(source == fanWodki)
            studentFactory.studentCreate(fanWodki);

        else if(source == fanWina)
            studentFactory.studentCreate(fanWina);

        else if(source == narkoMan)
            studentFactory.studentCreate(narkoMan);

    }
}


class Test {
    public static void main(String[] args) {

            ActionFrame.run(new StudentMenu(), WIDTH, HEIGHT);

    }
}