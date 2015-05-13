/* 
* TCSS 305 – Spring 2013

* Assignment Tetris
*/
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


import model.Board;
/**
 * 
 * @author Vladimir
 *@version TCSS 305 Spring 2013
 */
@SuppressWarnings("serial")
public class TetrisGUI extends JPanel implements Observer {
  
  /**
   * the time between timer calls set by mili seconds.
   */
  
  private static final int TIMER_INTERVAL = 900;
  
  /**
   * the timer use to call update and move the piece down.
   */
  
  private final Timer my_move_timer;
  
  /**
   * the main JFrame to contain all other parts.
   */
  
  
  private final JFrame my_gui_frame;
  
  /**
   * the side Jpanel that will contian the key and next 
   * piece panels.
   */
  
  private final JPanel my_side_gui_frame;
  /**
   * the panel that animates the peices that fall down.
   */
  
  private final TetrisPanel my_tetris_panel;
  
  /**
   * the panel that displays the control keys.
   */
  
  private final KeyControlsPanel my_panelkey;
  /**
   * the panel that displays the next peice that will 
   * appear.
   */
  
  private final NextPiecePanel my_next_piece_panel;
  /**
   * the score panel that displays the level and score.
   */
  
  private final TetrisScorePanel my_score_panel;
  /**
   * the playing board that will be played on.
   */
  
  private final Board my_playing_board;
  /**
   * the key Action listner that listens to the 
   * keys pressed.
   */
  
  private final MyKeyboardListener my_key_listner;
  
  
  /**
   * the tetris GUI that sets the layout and creates the initial panels.
   */
  public TetrisGUI() {
    super();
    my_playing_board = new Board();

    my_gui_frame = new JFrame("Tetris");
    my_side_gui_frame = new JPanel(new BorderLayout());
   
    my_tetris_panel = new TetrisPanel(my_playing_board);
   
    my_panelkey = new KeyControlsPanel();
   
    my_next_piece_panel = new NextPiecePanel(my_playing_board);
    
   
    my_move_timer = new Timer(TIMER_INTERVAL, new TimeActionListener());
    
    my_score_panel = new TetrisScorePanel(my_move_timer);
    
    my_playing_board.addObserver(this);
    
    my_key_listner = new  MyKeyboardListener(my_playing_board);
    
    my_tetris_panel.addKeyListener(my_key_listner);
    
    final TetrisMenuBar tetris_menu = new TetrisMenuBar(my_move_timer, 
                                          my_playing_board, my_gui_frame, my_key_listner);
    start();
    my_gui_frame.setJMenuBar(tetris_menu);
  }
  /**
   * method that constructs the layout and sets the visibility.
   */
  private void start() {
    
    
    
    my_gui_frame.add(my_tetris_panel, BorderLayout.CENTER);
    my_side_gui_frame.add(my_next_piece_panel, BorderLayout.NORTH);
    my_side_gui_frame.add(my_panelkey, BorderLayout.SOUTH);
    my_side_gui_frame.add(my_score_panel, BorderLayout.CENTER);
    
    my_gui_frame.add(my_side_gui_frame, BorderLayout.EAST);
    my_gui_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    my_gui_frame.pack();
    my_gui_frame.setLocationRelativeTo(null);
    my_gui_frame.setVisible(true);
    my_move_timer.start();
    
    
  }
  

  @Override
  public void update(final Observable the_arg, final Object the_object) {
    my_next_piece_panel.repaint();
    my_tetris_panel.repaint();
    if (the_object instanceof Integer) {
      my_score_panel.addScore((int) the_object);
      my_score_panel.repaint();
    }

    
  }
  /**
   * 
   * @author Vladimir Gudzyuk
   * @version TCSS 305 Spring 2013
   */
  public class TimeActionListener implements  ActionListener {
    

    @Override
    public void actionPerformed(final ActionEvent the_event) {
      if (the_event.getSource().equals(my_move_timer)) {
        my_playing_board.step();
      }
    }


  }

}