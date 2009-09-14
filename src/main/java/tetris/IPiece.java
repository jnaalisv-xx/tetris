package tetris;

public class IPiece extends Piece {
	
	public IPiece() {
		super("" +
       ".....\n" +
       ".....\n" +
       "IIII.\n" +
       ".....\n" +
       ".....\n");
	}
	
	private IPiece(Block[][] blocks)
	{
		super(blocks);
	}

	@Override
	public IPiece rotateRight() {
		int size = blocks.length;
		int maxIndex = size -1; // tää voi olla vähän huono nimi, en keksi parempaa
		Block[][] result = new Block[size][size];
		for(int row = 0; row < size; row++)
			for(int col = 0; col < size; col++)
				result[(maxIndex-col) % size][(maxIndex-row) % size] = blocks[row][col];
		return new IPiece(result);
	}	
	
	@Override
	public IPiece rotateLeft()
	{
		return this.rotateRight();
	}	
}
