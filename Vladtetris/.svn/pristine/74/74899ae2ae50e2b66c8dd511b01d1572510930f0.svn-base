/* 
* TCSS 305 – Spring 2013

* Assignment Tetris
*/
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * 
 * @author Vladimir
 * @version TCSS Spring 2013.
 */
@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {
  
  //private Image my_backgroundImage;
  /**
   * the constructor that sets up the backround class.
   */
  public BackgroundPanel() {
    super();
    
  }
  /**
   * @param the_graphics that draw the backround image.
   */
  public void paintComponent(final Graphics the_graphics) {
    
    super.paintComponent(the_graphics);
    
    Image backgroundImage;
    try {
      backgroundImage = ImageIO.read(new File("Background.png"));
      the_graphics.drawImage(backgroundImage, 0, 0, null);
    } catch (final IOException e) {
      setBackground(Color.WHITE);
    }
    setBackground(Color.WHITE);
    //final Graphics2D g2d = (Graphics2D) the_graphics;
    //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Draw the background image.
    //the_graphics.drawImage(my_backgroundImage, 0, 0, null);
    /*BufferedImage backgroundImage;
    try {
      backgroundImage = ImageIO.read(new File("Background.png"));
      //final BufferedImage backgroundImage = ImageIO.read(new File("Background.png"));
      the_graphics.drawImage(backgroundImage, 0, 0, null);
      
    } catch (final IOException e) {
      // TODO Auto-generated catch block
      setBackground(Color.WHITE);
    }
    setBackground(Color.WHITE);
    */
      
  }
}