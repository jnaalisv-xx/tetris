package tetris;

import java.util.Vector;

public class IPiece extends Piece {
	
	public IPiece() {
		super("" +
       ".....\n" +
       ".....\n" +
       "IIII.\n" +
       ".....\n" +
       ".....\n");
	}
	
	private IPiece(Vector<Block> vBlocks, int size)
	{
		super(vBlocks, size);
	}	

	@Override
	public IPiece rotateRight() {

		// TODO: Onko muita toteutusvaihtoehtoja?
		
		Vector<Block> resultVBlocks = new Vector<Block>();
			
		for(Block b : this.vblocks) 
			resultVBlocks.add(new Block(b.toChar(), -1*b.dispY, -1*b.dispX));

		return new IPiece(resultVBlocks, this.size);
	}	
	
	@Override
	public IPiece rotateLeft()
	{
		return this.rotateRight();
	}	
}
