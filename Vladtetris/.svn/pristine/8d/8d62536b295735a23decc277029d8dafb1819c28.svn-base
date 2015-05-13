/*
 * TCSS 305 - Spring 2013 Project Tetris
 */

package model;

import java.awt.Color;

/**
 * This interface defines the required operations of mutable Tetris pieces.
 * 
 * @author Alan Fowler
 * @version Spring 2013
 */
public interface MutablePiece
{

  /** Default Color used for I-Pieces. */
  Color I = Color.CYAN;

  /** Default Color used for J-Pieces. */
  Color J = Color.BLUE;

  /** Default Color used for L-Pieces. */
  Color L = Color.ORANGE;

  /** Default Color used for S-Pieces. */
  Color S = Color.GREEN;

  /** Default Color used for Z-Pieces. */
  Color Z = Color.RED;

  /** Default Color used for O-Pieces. */
  Color O = Color.YELLOW;

  /** Default Color used for T-Pieces. */
  Color T = Color.MAGENTA;

  /** Shifts the piece one space to the left. */
  void moveLeft();

  /** Shifts the piece one space to the right. */
  void moveRight();

  /** Shifts the piece one space down. */
  void moveDown();

  /** Rotates the piece one quarter turn clockwise. */
  void rotate();

  /** @return the x coordinate of this Piece. */
  int getX();

  /** @return the y coordinate of this Piece. */
  int getY();
}
