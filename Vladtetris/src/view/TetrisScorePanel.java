/* 
* TCSS 305 – Spring 2013

* Assignment Tetris
*/
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Vladimir Gudzyuk
 * @version TCSS 305 Spring 2013
 */
@SuppressWarnings("serial")
public class TetrisScorePanel extends JPanel {
  /**
   * the amount of points needed to reach next level.
   */
  
  private static final int SCORE_CALC_AMOUNT = 100;
  /**
   * the default size set for the score panel.
   */
  
  private static final Dimension DEFUALT_SIZE = new Dimension(200, 100);
  
  /**
   * the score ammount.
   */
  
  private int my_score;
  /**
   * the current level the player is on.
   */
  
  private int my_level;
  
  /**
   * the timer use to call update and move the piece down.
   */
  
  private final Timer my_move_timer;
  /**
   * 
   * @param the_move_timer the timer to be changed by the score and leve.
   */
  public TetrisScorePanel(final Timer the_move_timer) {
    super();
    
    my_move_timer = the_move_timer;
    setPreferredSize(DEFUALT_SIZE);
    
    setBackground(Color.MAGENTA);
    
    my_level = 1;
    
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
  }
  /**
   * @param the_graphics draws the score and level on the panel.
   */
  public void paintComponent(final Graphics the_graphics) {
    
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    g2d.drawString("SCORE: " + my_score, 10, 20);
    g2d.drawString("LEVEL: " + my_level, 10, 60);
  }
  /**
   * 
   * @param the_score adds the score ammount to the total score.
   */
  public void addScore(final int the_score) {
    my_score += the_score;
    if (my_score % SCORE_CALC_AMOUNT == 0 && my_move_timer.getDelay() >= 400) {
      final int x = my_move_timer.getDelay();
      my_move_timer.setDelay(x - SCORE_CALC_AMOUNT);
    }
    my_level = (my_score / SCORE_CALC_AMOUNT) + 1;
  }

}
