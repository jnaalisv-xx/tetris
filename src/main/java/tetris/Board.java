package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private boolean hasFallingBlock;
    private int fallingBlockX;
    private int fallingBlockY;
    private Block block;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFallingBlock = false;
        this.fallingBlockX = -1;
        this.fallingBlockY = -1;
    }
    
    public boolean hasFalling() {
    	return this.hasFallingBlock;
    }
    
    public void drop(Block block) {
    	this.hasFallingBlock = true;
    	this.fallingBlockX = this.columns / 2;
    	this.fallingBlockY = 0;
    	this.block = block;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
            	if (this.fallingBlockX == col && this.fallingBlockY == row)
            		s += this.block.toString();
            	else
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
	
	public String toString() {
		return Character.toString(this.c);
	}
}
