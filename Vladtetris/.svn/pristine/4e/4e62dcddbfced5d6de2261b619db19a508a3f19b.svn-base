/*
 * TCSS 305 - Spring 2013 Project Tetris
 */

package model;

/**
 * Provides default behavior for Tetris Pieces.
 * 
 * @author Alan Fowler
 * @version Spring 2013
 */
public abstract class AbstractPiece implements MutablePiece, Cloneable {

  /**
   * The number of blocks in a piece.
   */
  private static final int BLOCKS = 4;

  /** The x coordinate of this Piece. */
  private int my_x;

  /** The y coordinate of this Piece. */
  private int my_y;

  /** The rotational states of this Piece. */
  private int[][][] my_rotations;

  /** The index of the current rotational state of this Piece. */
  private int my_current_rotation;

  /** The block type representing this piece. */
  private final Block my_block;

  /**
   * Creates a new piece at the given coordinates.
   * 
   * @param the_rotations the rotational states for this Piece.
   * @param the_x the initial x coordinate for this piece.
   * @param the_y the initial y coordinate for this piece.
   * @param the_block the type of block.
   */
  protected AbstractPiece(final int[][][] the_rotations,
                          final int the_x,
                          final int the_y,
                          final Block the_block) {
    my_rotations = the_rotations.clone();
    my_current_rotation = 0;
    my_x = the_x;
    my_y = the_y;
    my_block = the_block;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void moveLeft() {
    my_x--;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void moveRight() {
    my_x++;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void moveDown() {
    my_y--;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void rotate() {
    if (my_rotations.length > 1) {
      if (my_current_rotation <= 0) {
        my_current_rotation = my_rotations.length - ((Math.abs(my_current_rotation - 1)
                              % my_rotations.length));
      } else {
        my_current_rotation = (my_current_rotation - 1) % my_rotations.length;
      }
    }
  }

  /**
   * Returns the coordinates of this piece's current rotation.
   * 
   * @return The coordinates of this piece's current rotation.
   */
  public final int[][] getRotation() {
    return my_rotations[my_current_rotation].clone();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int getX() {
    return my_x;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int getY() {
    return my_y;
  }

  /**
   * @return the current state of this Piece translated to board coordinates.
   */
  public final int[][] getBoardCoordinates() {
    final int[][] result = new int[BLOCKS][2];

    for (int i = 0; i < BLOCKS; i++) {
      result[i][0] = my_rotations[my_current_rotation][i][1] + my_x;
      result[i][1] = my_rotations[my_current_rotation][i][0] + my_y;
    }
    return result;
  }

  /**
   * @return the block type of this piece
   */
  public final Block getBlock() {
    return my_block;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MutablePiece clone() throws CloneNotSupportedException {

    // clone this Piece
    final MutablePiece result = (MutablePiece) super.clone();

    // now separately clone the my_rotations 3D array since arrays are mutable
    final int[][][] new_array_3d = new int[my_rotations.length][my_rotations[0].length][];
    for (int array_2d = 0; array_2d < my_rotations.length; array_2d++) {
      for (int array_1d = 0; array_1d < my_rotations[0].length; array_1d++) {
        new_array_3d[array_2d][array_1d] = my_rotations[array_2d][array_1d].clone();
      }
    }
    ((AbstractPiece) result).my_rotations = new_array_3d;

    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {

    final int width = width();
    final int height = height();
    final StringBuilder sb = new StringBuilder();

    // Construct the string by walking through the piece top to bottom, left to
    // right.
    for (int j = height - 1; j >= 0; j--) {
      for (int i = 0; i < width; i++) {
        boolean found = false;
        for (int b = 0; b < BLOCKS; b++) {
          if (my_rotations[my_current_rotation][b][1] == i
              && my_rotations[my_current_rotation][b][0] == j) {
            // There is a block here, so print and move on
            sb.append("[]");
            found = true;
            break;
          }
        }
        if (!found) {
          // None of the blocks are here, so put in empty space
          sb.append("  ");
        }
      }
      // Move to the next line
      sb.append("\n");
    }
    return sb.toString();
  }

  /**
   * Returns the width of this piece.
   * 
   * @return The width of this piece
   */
  private int width() {
    int result = 0;
    for (int i = 0; i < BLOCKS; i++) {
      if (my_rotations[my_current_rotation][i][1] > result) {
        result = my_rotations[my_current_rotation][i][1];
      }
    }
    return result + 1;
  }

  /**
   * Returns the height of this piece.
   * 
   * @return The height of this piece
   */
  private int height() {
    int result = 0;
    for (int i = 0; i < BLOCKS; i++) {
      if (my_rotations[my_current_rotation][i][0] > result) {
        result = my_rotations[my_current_rotation][i][0];
      }
    }
    return result + 1;
  }
}
