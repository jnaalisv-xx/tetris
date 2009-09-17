package tetris;

import java.util.Vector;

public class Tetrominoe {
	
	public static final Tetrominoe T_SHAPE = new Tetrominoe(new TPiece());
	public static final Tetrominoe I_SHAPE = new Tetrominoe(new IPiece());
	public static final Tetrominoe O_SHAPE = new Tetrominoe(new OPiece());
	
	public int x;
	public int y;
	
	private final Piece piece;
	
	private Tetrominoe(Piece piece) {
		this.piece = piece;		
	}
	
	public String toString() {
		return this.piece.toString();
	}

	public Tetrominoe rotateRight() {
		return new Tetrominoe(this.piece.rotateRight());
	}

	public Tetrominoe rotateLeft() {
		return new Tetrominoe(this.piece.rotateLeft());		
	}
	
	public Vector<Block> getBlocks() {
		return this.piece.vblocks;
	}
	
	public int getDistanceFromCenter() {
		return this.piece.distanceFromCenter;
	}

}


