package com.testarea;


/*
   A component that acts as a simple stop-watch.  When the user clicks
   on it, this componet starts timing.  When the user clicks again,
   it displays the time between the two clicks.  Clicking a third time
   starts another timer, etc.  While it is timing, the label just
   displays the message "Timing....".
*/

import java.awt.event.*;
import javax.swing.*;

public class StopWatch2 extends JLabel implements MouseListener {

   private long startTime;   // Start time of timer.
                             //   (Time is measured in milliseconds.)
                             
   private boolean running;  // True when the timer is running.
   
   public StopWatch2() {
         // Constructor.
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }
   
   public void mousePressed(MouseEvent evt) {
          // React when user presses the mouse by
          // starting or stoping the timer.
      if (running == false) {
            // Record the time and start the timer.
         running = true;
         startTime = evt.getWhen();  // Time when mouse was clicked.
         setText("Timing....");
      }
      else {
            // Stop the timer.  Compute the elapsed time since the
            // timer was started and display it.
         running = false;
         long endTime = evt.getWhen();
         double seconds = (endTime - startTime) / 1000.0;
         setText("Time: " + seconds + " sec.");
      }
   }
   
   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}  // end StopWatch

