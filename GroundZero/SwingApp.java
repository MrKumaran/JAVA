package Learning.GroundZero;

import javax.swing.*;

public class SwingApp {
    // UI framework inbuild in java...
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing macOS");
        JLabel label = new JLabel("Hello from Swing!");
        frame.add(label);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
