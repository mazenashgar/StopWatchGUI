package project1;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class stopWatchJFrame {
    public static void main(String[] args) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JPanel panel1 = new MyTimerPanel();
        JPanel panel2 = new MyTimerPanel();
        JPanel panel3 = new MyTimerPanel();
        JPanel panel4 = new StopWatchSupender();

        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        JFrame watchFrame = new JFrame("Stopwatch");

        watchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        watchFrame.add(container);
        watchFrame.pack();
        watchFrame.setVisible(true);

    }
}
