/* 
* TCSS 305 – Spring 2013

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

import model.Board;
/**
 * 
 * @author Vladimir
 *@version TCSS 305 Spring 2013
 */
@SuppressWarnings("serial")
public class NextPiecePanel extends JPanel {
  /**
   * the level depth in pexels used for x or y values.
   */
  private static final int LEVEL_THREE_VALUE = 100;
  
  /**
   * the level depth in pexels used for x or y values.
   */
  
  private static final int LEVEL_FOUR_VALUE = 120;
  /**
   * the depth in pixels used in x or y values.
   */
  
  private static final int LEVEL_ONE_VALUE = 60;
  /**
   * the depth in pixels used in x or y values.
   */
  
  private static final int LEVEL_TWO_VALUE = 80;
  
  /**
   * the defalut square pixel size.
   */
  
  private static final int SQUARE_SIZE = 20;
  /**
   * the default dimension size for the panel.
   */
  
  private static final Dimension DEFUALT_SIZE = new Dimension(200, 150);
  /**
   * the playing board to be played on.
   */
  private final Board my_playing_board;
  /**
   * 
   * @param the_playing_board the playing board to be played on.
   */
  
  public NextPiecePanel(final Board the_playing_board) {
    super();
    setPreferredSize(DEFUALT_SIZE);
    setBackground(Color.orange);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    my_playing_board = the_playing_board;
    
  }
  /**
   * @param the_graphics that draw that shapes
   */
  public void paintComponent(final Graphics the_graphics) {
    
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setPaint(Color.RED);
    g2d.setStroke(new BasicStroke(1));
    if (!my_playing_board.gameIsOver()) {
      if ("model.IPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_THREE_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_FOUR_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      }
      if ("model.JPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_THREE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      
      } else if ("model.LPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
      //the L Piece
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_THREE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_FOUR_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_FOUR_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      
      } else if ("model.OPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
        //the O Piece
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      } else if ("model.SPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
      //the S piece
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_THREE_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      } else if ("model.TPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
        //the T piece
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_THREE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      } else if ("model.ZPiece".equals(my_playing_board.getNextPiece().getClass().getName())) {
        //draws the Z Piece
        g2d.fill3DRect(LEVEL_ONE_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_ONE_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_TWO_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
        g2d.fill3DRect(LEVEL_THREE_VALUE, LEVEL_TWO_VALUE, SQUARE_SIZE, SQUARE_SIZE, false);
      }
    //System.out.println(my_playing_board.getNextPiece());
    //System.out.println(my_playing_board.getNextPiece().getClass().getName());
      g2d.drawString("NEXT PIECE", 10, SQUARE_SIZE);
    }
  }
}
