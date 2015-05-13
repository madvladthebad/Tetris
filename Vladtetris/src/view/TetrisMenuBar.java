/* 
* TCSS 305 – Spring 2013

* Assignment Tetris
*/
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;

import model.Board;
/**
 * 
 * @author Vladimir
 *@version TCSS 305 Spring 2013
 */
@SuppressWarnings("serial")
public class TetrisMenuBar extends JMenuBar {
  /**
   * the int in miliseconds delay for easy start.
   */
  private static final int EASY_START = 900;
  /**
   * the int in miliseconds delay for medium.
   */
  
  private static final int MEDIUM_START = 600;
  /**
   * the int in milisecods delay for hard.
   */
  
  private static final int HARD_START = 300;
  /**
   * the playing board to be played on.
   */
  
  private final Board my_playing_board;
  
  /**
   * the timer used to pause the game .
   */
  
  private final Timer my_move_timer;
  /**
   * the frame used to exit when the action is preformed.
   */
  
  private final JFrame my_frame;
  /**
   * the key listner to be altered when the game is ended.
   */
  
  private final MyKeyboardListener my_key_listner;
  /**
   * a boolean value to check if the game is paused or not.
   */
  
  private boolean my_game_paused;
  /**
   * a menu created for the game options.
   */
  
  private final JMenu my_game_menu = new JMenu("Game");
  /**
   * a menu item created for the difficulty.
   */
  
  private final JMenu my_options_menu = new JMenu("Options");
  /**
   * a help menu item to show what the game is about.
   */
  
  private final JMenu my_help_menu = new JMenu("Help");
  /**
   * 
   * @param the_move_timer the timer to be used.
   * @param the_board the board to be played.
   * @param the_frame the frame to be sued.
   * @param the_key_listner the key listner that listens to key events.
   */

  public TetrisMenuBar(final Timer the_move_timer, final Board the_board, 
                       final JFrame the_frame, final MyKeyboardListener the_key_listner) {
    super();
    my_frame = the_frame;
    my_playing_board = the_board;
    my_move_timer = the_move_timer;
    my_key_listner = the_key_listner;
    setUp();
  }
  /**
   * the methd that adds buttons to each menu and adds the action listners.
   */
  private void setUp() {
    
    
    final JMenuItem end_button = new JMenuItem("End Game");
    
    final JMenuItem new_game_button = new JMenuItem("New Game");
    
    final JMenuItem exit_button = new JMenuItem("Exit");
    
    final JMenuItem about_button = new JMenuItem("About...");
    
    final JRadioButtonMenuItem easy_setting = new JRadioButtonMenuItem("easy");
    /**
     * creates a thickness button to set the shape thickness in Jpanel when selected.
     */
    
    final JRadioButtonMenuItem medium_setting = new JRadioButtonMenuItem("medium");
    
    /**
     * creates a thickness button to set the shape thickness to 4 in Jpanel when selected.
     */
    
    final JRadioButtonMenuItem hard_setting = new JRadioButtonMenuItem("hard");
    
    easy_setting.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_move_timer.setDelay(EASY_START);
      }
    });
    medium_setting.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_move_timer.setDelay(MEDIUM_START);
      }
    });
    hard_setting.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_move_timer.setDelay(HARD_START);
      }
    });
    
    
    exit_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_frame.dispose();
      }
    });
    
    new_game_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_playing_board.newGame(10, 20, null);
        my_move_timer.setDelay(EASY_START);
        my_move_timer.start();
        my_key_listner.setPaused(false);
      }
    });
    final ButtonGroup group_difficulty = new ButtonGroup();
    
    group_difficulty.add(easy_setting);
    group_difficulty.add(medium_setting);
    group_difficulty.add(hard_setting);
    
    end_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        
        my_move_timer.stop();
        my_key_listner.setPaused(true);
        
      }
    });
    
    about_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        final JFrame pop_frame = new JFrame("Message");
        JOptionPane.showMessageDialog(pop_frame,
            "Tetris Made by Vladimir Gudzyuk, in TCSS 305 Spring 2013");
      }
    });
    
    final JMenu settings_menu = new JMenu("Difficulty");
    
    
    settings_menu.add(easy_setting);
    settings_menu.add(medium_setting);
    settings_menu.add(hard_setting);
    
    my_options_menu.add(settings_menu);
    
    my_help_menu.add(about_button);
    my_game_menu.add(end_button);
    my_game_menu.add(new_game_button);
    my_game_menu.add(exit_button);
    
    add(my_game_menu);
    add(my_options_menu);
    add(my_help_menu);
  }
}
