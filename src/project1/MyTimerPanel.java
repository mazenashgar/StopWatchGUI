package project1;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class MyTimerPanel extends JPanel {

    private JButton load;
    private JButton save;
    private JButton add;
    private JButton sub;
    private JButton start;
    private JButton stop;
    private JButton inc;
    private JButton dec;
    private JButton reset;
    private StopWatch guiWatch;

    private Timer javaTimer;
    private TimerListener timer;
    private boolean startStop = false;
    private String suspendNotice;

    private JLabel stopWatchDisplay;

    public MyTimerPanel() {

        timer = new TimerListener();
        guiWatch = new StopWatch(0, 0, 0);
        javaTimer = new Timer(1, timer);
        javaTimer.start();

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400, 200));

        stopWatchDisplay = new JLabel(guiWatch.toString());

        GridBagConstraints loc1 = new GridBagConstraints();
        loc1.gridy = 0;
        loc1.gridx = 2;
        loc1.gridwidth = 2;
        loc1.insets = new Insets(5, 5, 5, 5);
        add(stopWatchDisplay, loc1);

        start = new JButton("Start");
        GridBagConstraints loc2 = new GridBagConstraints();
        loc2.gridy = 1;
        loc2.gridx = 1;
        loc2.gridwidth = 1;
        add(start, loc2);
        start.addActionListener(timer);

        stop = new JButton("Stop");
        GridBagConstraints loc3 = new GridBagConstraints();
        loc3.gridy = 2;
        loc3.gridx = 1;
        loc3.gridwidth = 1;
        add(stop, loc3);
        stop.addActionListener(timer);

        inc = new JButton("Inc");
        GridBagConstraints loc4 = new GridBagConstraints();
        loc4.gridy = 1;
        loc4.gridx = 2;
        loc4.gridwidth = 1;
        add(inc, loc4);
        inc.addActionListener(timer);

        dec = new JButton("Dec");
        GridBagConstraints loc5 = new GridBagConstraints();
        loc5.gridy = 2;
        loc5.gridx = 2;
        loc5.gridwidth = 1;
        add(dec, loc5);
        dec.addActionListener(timer);

        add = new JButton("Add");
        GridBagConstraints loc6 = new GridBagConstraints();
        loc6.gridy = 1;
        loc6.gridx = 3;
        loc6.gridwidth = 1;
        add(add, loc6);
        add.addActionListener(timer);

        sub = new JButton("Sub");
        GridBagConstraints loc7 = new GridBagConstraints();
        loc7.gridy = 2;
        loc7.gridx = 3;
        loc7.gridwidth = 1;
        add(sub, loc7);
        sub.addActionListener(timer);

        save = new JButton("save");
        GridBagConstraints loc8 = new GridBagConstraints();
        loc8.gridy = 1;
        loc8.gridx = 4;
        loc8.gridwidth = 1;
        add(save, loc8);
        save.addActionListener(timer);

        load = new JButton("Load");
        GridBagConstraints loc9 = new GridBagConstraints();
        loc9.gridy = 2;
        loc9.gridx = 4;
        loc9.gridwidth = 1;
        add(load, loc9);
        load.addActionListener(timer);

        reset = new JButton("reset");
        GridBagConstraints loc10 = new GridBagConstraints();
        loc10.gridy = 5;
        loc10.gridx = 2;
        loc10.gridwidth = 2;
        add(reset, loc10);
        reset.addActionListener(timer);

    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (guiWatch.isSuspended()) {
                suspendNotice = "Suspended";
            } else {
                suspendNotice = "";
            }

            if (startStop == true) {
                guiWatch.add(1);
            }

            if (e.getSource() == inc) {
                startStop = false;
                guiWatch.add(1);
            }

            if (e.getSource() == stop) {
                startStop = false;
            }

            if (e.getSource() == start) {
                startStop = true;
            }

            if (e.getSource() == load) {
                startStop = false;
                if (!guiWatch.isSuspended()) {
                    JFileChooser file = new JFileChooser();
                    file.setCurrentDirectory(new File(System.getProperty("user.dir")));
                    int results = file.showOpenDialog(null);
                    if (results != JFileChooser.APPROVE_OPTION) {
                        System.out.println("No file selected");
                    } else {
                        File newFile = file.getSelectedFile();
                        String watchFile = newFile.getName();
                        guiWatch.load(watchFile);
                    }
                }
            }

            if (e.getSource() == save) {
                startStop = false;
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int results = file.showSaveDialog(null);
                if (results != JFileChooser.APPROVE_OPTION) {
                    System.out.println("No file selected");
                } else {
                    File newFile = file.getSelectedFile();
                    String watchFile = newFile.getName();
                    guiWatch.save(watchFile);
                }
            }

            if (e.getSource() == add) {
                startStop = false;
                if (!guiWatch.isSuspended()) {
                    String addBox = JOptionPane.showInputDialog(null, "Enter Milliseconds to add:");

                    if (addBox != null) {
                        try {
                            int userInput = Integer.parseInt(addBox);

                            if (userInput > 0) {
                                guiWatch.add(userInput);
                            } else if (userInput == 0) {
                                JOptionPane.showMessageDialog(null, "Can't add a zero");
                            } else if (userInput < 0) {
                                JOptionPane.showMessageDialog(null, "Can't add a negative number");
                            }
                        } catch (Exception error) {
                            JOptionPane.showMessageDialog(null, "Try again");
                        }
                    }
                }
            }

            if (e.getSource() == sub) {
                startStop = false;
                if (!guiWatch.isSuspended()) {
                    String subBox = JOptionPane.showInputDialog(null, "Enter Milliseconds to subtract:");


                    if (subBox != null) {
                        try {
                            int userInput = Integer.parseInt(subBox);

                            if (userInput > 0) {
                                guiWatch.sub(userInput);
                            } else if (userInput == 0) {
                                JOptionPane.showMessageDialog(null, "Can't subtract a zero");
                            } else if (userInput < 0) {
                                JOptionPane.showMessageDialog(null, "Can't subtract a negative number");
                            }
                        } catch (Exception error) {
                            JOptionPane.showMessageDialog(null, "Try again");
                        }
                    }
                }
            }

            if (e.getSource() == dec) {
                startStop = false;
                try {
                    guiWatch.sub(1);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Can't decrement");
                }
            }

            if (e.getSource() == reset) {
                startStop = false;
                if (!guiWatch.isSuspended()) {
                    guiWatch = new StopWatch(0, 0, 0);
                }
            }

            stopWatchDisplay.setText(guiWatch.toString() + " " + suspendNotice);
        }
    }
}


