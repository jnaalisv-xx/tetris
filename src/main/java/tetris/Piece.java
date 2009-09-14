package tetris;

public class Piece {

	protected final Block[][] blocks;

	public Piece(String string) {
		String[] rows = string.split("\n");
		int size = rows.length; // nyt jos parametrina annetaan suorakaiden niin homma ei toimi
		blocks = new Block[size][size];
		for(int row = 0; row < size; row++)
			for (int col = 0; col < size; col++)
				blocks[row][col] = new Block(rows[row].charAt(col));		
	}
	
	protected Piece(Block[][] blocks) {
		this.blocks = blocks;
	}

	public String toString() {
        String s = "";
        int size = blocks.length; // rivien lkm, jos se on eri kuin sarakkeiden, niin we are fucked
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) 
            	s += blocks[row][col].toString();
            s += "\n";
        }
        return s;
	}

	public Piece rotateRight() {
		int size = blocks.length;
		Block[][] result = new Block[size][size];
		for(int row = 0; row < size; row++)
			for(int col = 0; col < size; col++)
				result[col][((size-1)-row) % size] = blocks[row][col];
		// jos suorakaide niin size == columns
		return new Piece(result);
	}

	public Piece rotateLeft() {
		int size = blocks.length; // rows...
		Block[][] result = new Block[size][size];
		for(int row = 0; row < size; row++)
			for(int col = 0; col < size; col++)
				result[((size-1)-col) % size][row] = blocks[row][col];
		// jos suorakaide niin size == rows
		return new Piece(result);
	}

}


