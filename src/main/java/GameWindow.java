import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        setTitle("HankaGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}