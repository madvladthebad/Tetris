/*
 * TCSS 305 - Spring 2013 Project Tetris
 */

package model;

import java.awt.Color;

/**
 * The different types of blocks that will be stored in a Board's grid.
 * 
 * @author Alan Fowler
 * @version Spring 2013
 */
public enum Block
{
  /** AN empty space in the grid. */
  EMPTY(" ", Color.BLACK),
  /** A Block from an IPiece. */
  I("I", MutablePiece.I),
  /** A Block from a JPiece. */
  J("J", MutablePiece.J),
  /** A Block from an LPiece. */
  L("L", MutablePiece.L),
  /** A Block from an OPiece. */
  O("O", MutablePiece.O),
  /** A Block from an SPiece. */
  S("S", MutablePiece.S),
  /** A Block from a TPiece. */
  T("T", MutablePiece.T),
  /** A Block from a ZPiece. */
  Z("Z", MutablePiece.Z);

  /**
   * The character corresponding to a particular value of the enumeration.
   */
  private String my_letter;

  /**
   * The Color corresponding to a particular value of the enumeration.
   */
  private Color my_color;

  // Constructor

  /**
   * Constructs a new Block with the specified letter.
   * 
   * @param the_letter The letter.
   * @param the_color The Color.
   */
  private Block(final String the_letter, final Color the_color)
  {
    my_letter = the_letter;
    my_color = the_color;
  }

  /**
   * Returns the Color of this Block.
   * 
   * @return the Color of this Block.
   */
  public Color getColor()
  {
    return my_color;
  }

  /**
   * Returns a String representation of this Block.
   * 
   * @return a String representation of this Block.
   */
  @Override
  public String toString()
  {
    return my_letter;
  }
}
