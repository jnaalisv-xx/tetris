package tetris;

import java.util.Vector;

public class Tetrominoe {
	
	public static final Tetrominoe T_SHAPE = new Tetrominoe(new TPiece());
	public static final Tetrominoe I_SHAPE = new Tetrominoe(new IPiece());
	public static final Tetrominoe O_SHAPE = new Tetrominoe(new OPiece());
	
	public int x;
	public int y;
	
	private final Piece piece;
	
	// tän tarvii piece, piecen koordinaatit asetetaan kun palikka tiputetaan
	private Tetrominoe(Piece piece) {
		this.piece = piece;		
	}
	
	// tän tarvii käännöksiin
	private Tetrominoe(Piece piece, int x, int y) {
		this.piece = piece;		
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return this.piece.toString();
	}

	public Tetrominoe rotateRight() {
		return new Tetrominoe(this.piece.rotateRight(), this.x, this.y);
	}

	public Tetrominoe rotateLeft() {
		return new Tetrominoe(this.piece.rotateLeft(), this.x, this.y);		
	}
	
	public Vector<Block> getBlocks() {
		return this.piece.vblocks;
	}
	
	public int getDistanceFromCenter() {
		return this.piece.distanceFromCenter;
	}

	public void moveRight() {
		this.x++;		
	}
	
	public void moveLeft() {
		this.x--;		
	}	

}


