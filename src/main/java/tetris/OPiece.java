package tetris;

public class OPiece extends Piece {

	public OPiece() {
		super("" +
         ".OO\n" +
         ".OO\n" +
         "...\n");
	}

	@Override
	public OPiece rotateRight()
	{
		return new OPiece();
	}
	
	@Override
	public OPiece rotateLeft()
	{
		return new OPiece();
	}
}
