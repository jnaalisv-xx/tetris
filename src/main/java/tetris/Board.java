package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private boolean hasFallingBlock;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFallingBlock = false;
    }
    
    public boolean hasFalling() {
    	return this.hasFallingBlock;
    }
    
    public void drop(Block block) {
    	this.hasFallingBlock = true;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += ".";
            }
            s += "\n";
        }
        return s;
    }
}

class Block {
	private final char c;
	
	public Block(char c) {
		this.c = c;
	}
}
