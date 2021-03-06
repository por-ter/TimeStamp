/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author D.Porter
 */
public class TESTUI extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    public TESTUI() {
        initComponents();
    }

    WorkDay stempeln = new WorkDay();
    int hour = 0;
    int mins = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newDayButton = new javax.swing.JButton();
        kommenButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        feierabendLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pauseLabel = new javax.swing.JLabel();
        gehenButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        todayDateTimeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        elapsedTimeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        newDayButton.setText("New Day");
        newDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeEvents(evt);
                startElapsedTimer(evt);
            }
        });

        kommenButton.setText("Kommen");
        kommenButton.setEnabled(false);
        kommenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stempelnKommen(evt);
                arbeitStempelnKommen(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Feierabend"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        feierabendLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feierabendLabel.setText("--:--");
        jPanel2.add(feierabendLabel, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pause"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        pauseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pauseLabel.setText("--:--");
        jPanel4.add(pauseLabel, java.awt.BorderLayout.CENTER);

        gehenButton.setText("Gehen");
        gehenButton.setEnabled(false);
        gehenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stempelnGehen(evt);
                pauseStempeln(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Arbeit"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("--:--");
        jPanel5.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kommenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gehenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newDayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gehenButton, jPanel2, jPanel4, jPanel5, kommenButton, newDayButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kommenButton)
                    .addComponent(gehenButton)
                    .addComponent(newDayButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        todayDateTimeLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        todayDateTimeLabel.setText("Current Date Platzhalter");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stempeln"));
        jScrollPane1.setAutoscrolls(true);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zeit", "Bezeichnung"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        elapsedTimeLabel.setBackground(new java.awt.Color(255, 255, 255));
        elapsedTimeLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        elapsedTimeLabel.setForeground(new java.awt.Color(0, 0, 51));
        elapsedTimeLabel.setText("00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(todayDateTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(elapsedTimeLabel))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(todayDateTimeLabel)
                    .addComponent(elapsedTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // When NewDay is clicked
    private void startTimeEvents(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeEvents

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if (newDayButton.getText().equalsIgnoreCase("new day")) {
            newDayButton.setText("Reset");

            // Set the current date and time label
            Timer timer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    todayDateTimeLabel.setText(WorkDay.getNowDateTime());

                }
            });
            timer.start();

            // Calculate and set the Feierabend time label
            feierabendLabel.setText(WorkDay.getFeierAbend());

            // Make initial TimeStamp in table
            String kommenTimeStamp = WorkDay.timeStamp();
            model.addRow(new Object[]{kommenTimeStamp, "Kommen"});

            // Hide/Enable buttons to prevent misuse
            kommenButton.setEnabled(false);
            gehenButton.setEnabled(true);

        } else {
            
            mins = 0;

            // Calculate and set the new Feierabend time label
            feierabendLabel.setText(WorkDay.getFeierAbend());

            // Delete ALL rows
            int rows = model.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            // Make initial TimeStamp in table again with new resetted time
            String kommenTimeStamp = WorkDay.timeStamp();
            model.addRow(new Object[]{kommenTimeStamp, "Kommen"});

            // Hide/Enable buttons to prevent misuse
            kommenButton.setEnabled(true);
            gehenButton.setEnabled(false);

        }


    }//GEN-LAST:event_startTimeEvents

    // To mark the table with gehen times
    private void stempelnGehen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stempelnGehen
        mins = 0;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{WorkDay.timeStamp(), "Gehen"});

        kommenButton.setEnabled(true);
        gehenButton.setEnabled(false);

        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }//GEN-LAST:event_stempelnGehen

    // To mark the table with kommen times
    private void stempelnKommen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stempelnKommen
        mins = 0;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{WorkDay.timeStamp(), "Kommen"});

        kommenButton.setEnabled(false);
        gehenButton.setEnabled(true);

        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }//GEN-LAST:event_stempelnKommen
    
    
    // Secondary action from the NEWDAY button at start, to set the elapsed time timer
    private void startElapsedTimer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startElapsedTimer

        String test = WorkDay.timeStamp();
        
        

        Timer timer = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {

                int secs = LocalDateTime.now().getSecond();
//                System.out.println(mins++);

                // if secs < 10
                if (secs < 10) {
                    elapsedTimeLabel.setText("00:0" + mins + ":0" + secs);
                }
                if (secs < 10 && mins >= 10) {
                    elapsedTimeLabel.setText("00:" + mins + ":0" + secs);
                }

                // if secs > 10
                if (secs >= 10) {
                    elapsedTimeLabel.setText("00:0" + mins + ":" + secs);
                }
                if (secs >= 10 && mins >= 10) {
                    elapsedTimeLabel.setText("00:" + mins + ":" + secs);
                }
                // if secs 59 then mins++
                if (secs == 59) {
                    mins++;
//                    mins = mins * 0.250;
//                    mins++;
                    System.out.println(mins);
//                    mins = mins - 3;
//                    System.out.println(mins);
                }
                if (mins == 59) {
                    hour++;
                }

//                try {
//                    elapsedTimeLabel.setText(WorkDay.elapsedTime(test));
//                } catch (ParseException ex) {
//                    Logger.getLogger(TESTUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
        timer.start();
    }//GEN-LAST:event_startElapsedTimer

    private void pauseStempeln(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseStempeln
        Timer timer = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(mins < 10){
                    pauseLabel.setText("00:0" +mins);
                } else {
                    pauseLabel.setText("00:" +mins);
                }
                
            }
        });
        timer.start();
    }//GEN-LAST:event_pauseStempeln
    
    int arbeitMins = 0;
    int arbeitHours = 0;
    
    private void arbeitStempelnKommen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbeitStempelnKommen
        Timer timer = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(mins < 10){
                    pauseLabel.setText("00:0" +mins);
                } else {
                    pauseLabel.setText("00:" +mins);
                }
                
            }
        });
        timer.start();
    }//GEN-LAST:event_arbeitStempelnKommen

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TESTUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TESTUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TESTUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TESTUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TESTUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel elapsedTimeLabel;
    private javax.swing.JLabel feierabendLabel;
    private javax.swing.JButton gehenButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton kommenButton;
    private javax.swing.JButton newDayButton;
    private javax.swing.JLabel pauseLabel;
    private javax.swing.JLabel todayDateTimeLabel;
    // End of variables declaration//GEN-END:variables
}
