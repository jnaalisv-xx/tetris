package tetris;

//import java.util.Collections;
import java.util.Vector;

public class Piece {

	protected final Vector<Block> vblocks;
	protected final int size;
	protected final int distanceFromCenter;

	public Piece(String string) {
	
		String[] rows = string.split("\n");
		size = rows.length; // nyt jos parametrina annetaan suorakaiden niin homma ei toimi
		distanceFromCenter = size /2;
		this.vblocks = new Vector<Block>();	
		for(int row = 0; row < size; row++)
			for (int col = 0; col < size; col++) {
				if (rows[row].charAt(col) != '.')
					this.vblocks.add(
						new Block(rows[row].charAt(col), 
								col - distanceFromCenter, 
								row -distanceFromCenter));
			}
	}
	
	protected Piece(Vector<Block> vblocks, int size)
	{
		this.vblocks = vblocks;
		this.size = size;
		this.distanceFromCenter = size /2;
	}
	

	public String toString() {

		// TODO: nimeminen!!!
		Block[][] tmpBlocks = new Block[size][size];

		// Blokki taulukko johon isketn oikeisiin kohtiin palikat
        for( Block b : vblocks) 
        	tmpBlocks[b.dispY + distanceFromCenter][b.dispX + distanceFromCenter] = b;

        // yks vaihtoehto on ett meill on char array johon tkitn merkit ja joka tulostetaan
        // ja sitten tulostetaan, hmm ois parempi
		// koska tetrominoe on immutable
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
            	if (tmpBlocks[row][col] == null)
            		sb.append(".");
            	else
            		sb.append(tmpBlocks[row][col].toChar());
            }
            sb.append("\n");
        }
        return sb.toString();
	}

	public Piece rotateRight() {

		Vector<Block> resultVBlocks = new Vector<Block>();
			
		for(Block b : this.vblocks) 
			resultVBlocks.add(new Block(b.toChar(), -1*b.dispY, b.dispX));

		return new Piece(resultVBlocks, this.size);
	}

	public Piece rotateLeft() {
		Vector<Block> resultVBlocks = new Vector<Block>();
	
		for(Block b : this.vblocks) 
			resultVBlocks.add(new Block(b.toChar(), b.dispY, -1*b.dispX));

		return new Piece(resultVBlocks, this.size);		
	}

}


