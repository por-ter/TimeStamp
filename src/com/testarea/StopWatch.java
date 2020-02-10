package com.testarea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import sun.rmi.runtime.Log;

@SuppressWarnings("serial")
public class StopWatch {

    private static final String imgIcon = "data/icon.png";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 150;

    private static final String RESETTIME = buildTime(0);

    private static int getResulutionHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getHeight();
    }

    private static int getResulutionWidth() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getWidth();
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.setVisible();
    }

    private static final String buildTime(final long elapsed) {
        long hundredths = elapsed / 10;
        long seconds = hundredths / 100;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        return String.format("%02d:%02d:%02d:%02d", hours, minutes % 60, seconds % 60, hundredths % 100);
    }

//    private final Log log = new Log("StopWatch");
    private final JTextField fieldTime;
    private final JButton buttonPlay;
    private final JButton buttonPause;
    private final Action actionPlay;
    private final Action actionPause;
    private final Action actionReset;

    private final JFrame frame;

    private final ReentrantLock lock = new ReentrantLock();

    private long lasttick = 0L;
    private boolean paused = false;
    private long elapsed = 0L;
    private ScheduledFuture<?> running = null;

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private final Runnable ticker = new Runnable() {
        public void run() {
            tick();
        }
    };

    public StopWatch() {
//        log.info("Building StopWatch constructor");
        frame = new JFrame("Stop Watch V 1.2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon(imgIcon).getImage());
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocation((getResulutionWidth() - WIDTH) / 2, (getResulutionHeight() - HEIGHT) / 2);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        frame.setContentPane(mainPanel);

        fieldTime = new JTextField(RESETTIME);
        fieldTime.setEditable(false);
        Font bigFont = fieldTime.getFont().deriveFont(Font.PLAIN, 50f);
        fieldTime.setFont(bigFont);
        mainPanel.add(fieldTime);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        actionPlay = new AbstractAction("Start") {

            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        };

        actionPause = new AbstractAction("Pause") {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        };

        actionReset = new AbstractAction("Reset") {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        };

        buttonPlay = new JButton(actionPlay);
        buttonPanel.add(buttonPlay);
        buttonPause = new JButton(actionPause);
        buttonPanel.add(buttonPause);
        buttonPanel.add(new JButton(actionReset));

//        log.info("Rendering and configuring frame elements");
    }

    private final void setVisible() {
        frame.setVisible(true);
        buttonPlay.requestFocusInWindow();
    }

    private void start() {
        lock.lock();
        try {
            if (running != null) {
                return;
            }

            paused = false;
            lasttick = System.currentTimeMillis();
            running = executor.scheduleAtFixedRate(ticker, 10, 10, TimeUnit.MILLISECONDS);

            actionPlay.setEnabled(false);
            actionPause.setEnabled(true);
            actionReset.setEnabled(false);
            buttonPause.requestFocusInWindow();
        } finally {
            lock.unlock();
        }
    }

    private void pause() {
        lock.lock();
        try {
            if (running == null) {
                return;
            }
            running.cancel(false);
            paused = true;
            running = null;

            actionPlay.setEnabled(true);
            actionPause.setEnabled(false);
            actionReset.setEnabled(true);
            buttonPlay.requestFocusInWindow();
        } finally {
            lock.unlock();
        }
    }

    private void reset() {
        lock.lock();
        try {
            if (running != null) {
                return;
            }
            elapsed = 0;
            displayTime(RESETTIME);

            actionPlay.setEnabled(true);
            actionPause.setEnabled(false);
            actionReset.setEnabled(true);
            buttonPlay.requestFocusInWindow();
        } finally {
            lock.unlock();
        }
    }

    private void tick() {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            long delta = now - lasttick;
            lasttick = now;
            if (!paused) {
                elapsed += delta;
                displayTime(buildTime(elapsed));
            }
        } finally {
            lock.unlock();
        }
    }

    private void displayTime(final String todisplay) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                fieldTime.setText(todisplay);
            }
        });
    }


}
