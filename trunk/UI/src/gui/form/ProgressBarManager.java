/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.form;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author Compaq
 */
public class ProgressBarManager {
  JProgressBar pbar;
  static final int MY_MINIMUM=0;
  static final int MY_MAXIMUM=100;

  public ProgressBarManager(JProgressBar apbar ){
      this.pbar = apbar;
  }


  public void runProgress(int presentage){
       final int percent = presentage;
       try {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
               updateBar(percent);
             }
         });
         java.lang.Thread.sleep(100);
       } catch (InterruptedException e) {;}
    }


  public void updateBar(int newValue) {
    pbar.setValue(newValue);
  }

}
