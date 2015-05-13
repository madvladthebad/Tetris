/* 
* TCSS 305 – Spring 2013

* Assignment Tetris
*/
package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Board;
/**
 * 
 * @author Vladimir
 *@version TCSS 305 Spring 2013
 */
public class MyKeyboardListener extends KeyAdapter  {
  
  /**
   * the playing board that is altered depending in the keys.
   */
  
  private final Board my_main_playing_board;
  /**
   * constructor sets key listners that alter the board.
   * @param the_playing_board the board played on.
   */
  
  private boolean my_game_paused;
  
  /**
   * 
   * @param the_playing_board the board the be played on.
   */
  public  MyKeyboardListener(final Board the_playing_board) {
    super();
    my_main_playing_board = the_playing_board;
  }
  /**
   * @param the_event the key pressed event.
   */
  public void keyPressed(final KeyEvent the_event) {
    if (!my_main_playing_board.gameIsOver() && !my_game_paused) {
      final int x = the_event.getKeyCode();
      if (x == KeyEvent.VK_RIGHT) {
        my_main_playing_board.moveRight();
      } else if (x == KeyEvent.VK_LEFT) {
        my_main_playing_board.moveLeft();
      } else if (x == KeyEvent.VK_UP) {
        my_main_playing_board.rotate();
      } else if (x == KeyEvent.VK_SPACE) {
        my_main_playing_board.hardDrop();
      } else if (x == KeyEvent.VK_DOWN) {
        my_main_playing_board.moveDown();
      }
    }
  }
  
  /**
   * 
   * @param the_pause_state sets the state of the board being paused.
   */
  public void setPaused(final boolean the_pause_state) {
    my_game_paused = the_pause_state;
  }
  /**
   * 
   * @return the boards paused state.
   */
  public boolean getPausedState() {
    return my_game_paused;
  }
}

