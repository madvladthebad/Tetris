/*
 * TCSS 305 - Spring 2013 Project Tetris
 */

package model;

/**
 * Defines the Tetris ZPiece.
 * 
 * @author Alan Fowler
 * @version Spring 2013
 */
public final class ZPiece extends AbstractPiece
{

  /**
   * The x and y-coordinates for all rotations of a ZPiece.
   */
  private static final int[][][] MY_ROTATIONS = {{{2, 1}, {2, 2}, {3, 0}, {3, 1}},
                                                 {{1, 0}, {2, 0}, {2, 1}, {3, 1}},
                                                 {{1, 1}, {1, 2}, {2, 0}, {2, 1}},
                                                 {{1, 1}, {2, 1}, {2, 2}, {3, 2}}};

  /**
   * Creates a new Z piece at the given coordinates.
   * 
   * @param the_x The x coordinate of the Piece.
   * @param the_y The y coordinate of the piece
   */
  public ZPiece(final int the_x, final int the_y)
  {
    super(MY_ROTATIONS, the_x, the_y, Block.Z);
  }
}
