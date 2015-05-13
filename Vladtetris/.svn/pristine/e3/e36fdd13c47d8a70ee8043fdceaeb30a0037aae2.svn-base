/*
 * TCSS 305 - Spring 2013 Project Tetris
 */

package model;

/**
 * Defines the Tetris JPiece.
 * 
 * @author Alan Fowler
 * @version Spring 2013
 */
public final class JPiece extends AbstractPiece
{

  /**
   * The x and y-coordinates for all rotations of a JPiece.
   */
  private static final int[][][] MY_ROTATIONS = {{{2, 0}, {2, 1}, {2, 2}, {3, 0}},
                                                 {{1, 0}, {1, 1}, {2, 1}, {3, 1}},
                                                 {{1, 2}, {2, 0}, {2, 1}, {2, 2}},
                                                 {{1, 1}, {2, 1}, {3, 1}, {3, 2}}};

  /**
   * Creates a new J piece at the given coordinates.
   * 
   * @param the_x The x coordinate of the Piece.
   * @param the_y The y coordinate of the piece
   */
  public JPiece(final int the_x, final int the_y)
  {
    super(MY_ROTATIONS, the_x, the_y, Block.J);
  }
}
