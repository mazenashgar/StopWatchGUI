package project1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatchSupender extends JPanel {
    private JButton on;

    private SuspendListener listen;

    public StopWatchSupender() {

        on = new JButton("Suspend");

        listen = new SuspendListener();
        add(on);
        on.addActionListener(listen);
    }

    private class SuspendListener implements ActionListener {
        private int count = 0;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == on) {

                if (this.count == 0) {
                    StopWatch.setSuspended(true);
                    this.count++;
                } else {
                    StopWatch.setSuspended(false);
                    this.count--;
                }
            }
        }
    }
}
