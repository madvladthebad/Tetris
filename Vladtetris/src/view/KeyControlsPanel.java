/* 
* TCSS 305 � Spring 2013

* Assignment Tetris
*/
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 * 
 * @author Vladimir
 *@version TCSS 305 Spring 2013
 */
@SuppressWarnings("serial")
public class KeyControlsPanel extends JPanel {
  
  /**
   * the starting point in the x position for text.
   */
  
  private static final int STARTING_LINE = 10;
  
  /**
   * the default size of the control key panel.
   */
  
  private static final Dimension DEFUALT_SIZE = new Dimension(200, 150);
  
  
  /**
   * Constructor that sets the panel size and backround color.
   */
  public KeyControlsPanel() {
    super();
    setPreferredSize(DEFUALT_SIZE);
    setBackground(Color.orange);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
  }
  /**
   * @param the_graphics component to be drawn.
   */
  public void paintComponent(final Graphics the_graphics) {
    
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setPaint(Color.BLACK);
    g2d.setStroke(new BasicStroke(1));
    
    g2d.drawString("Control Keys:", STARTING_LINE, 20);
    g2d.drawString("SpaceBar: Drop Down", STARTING_LINE, 40);
    g2d.drawString("Left Arrow Key: Move Left", STARTING_LINE, 60);
    g2d.drawString("Right Arrow Key: Move Down", STARTING_LINE, 80);
    g2d.drawString("UP Arrow Key: Rotate", STARTING_LINE, 100);
    g2d.drawString("Down Arrow Key: Move down", STARTING_LINE, 120);
  }

}
